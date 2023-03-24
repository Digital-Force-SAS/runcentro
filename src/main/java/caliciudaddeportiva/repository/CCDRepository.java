package caliciudaddeportiva.repository;

import caliciudaddeportiva.micellaneus.dto.AdminDto;
import caliciudaddeportiva.micellaneus.dto.CodigoDto;
import caliciudaddeportiva.micellaneus.dto.RegaloDto;
import caliciudaddeportiva.micellaneus.dto.UserDto;
import caliciudaddeportiva.micellaneus.util.MessageExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CCDRepository {

    @Autowired
    private JdbcTemplate template;

    @Autowired
    MessageExceptionUtil messageExceptionDtoUtil;

    public List<UserDto> getAllUsers() {
        String sql = "SELECT idusuario,variable1,variable2,variable3,variable4,variable5,variable6,variable7,variable8,variable9,variable10,variable11,variable12,variable13,variable14,variable15,variable16,evento " +
                "FROM usuarios " +

                "ORDER BY idusuario ";
        return template.query(sql, new Object[]{}, new BeanPropertyRowMapper(UserDto.class));
    }






    public List<UserDto> getAllCiudadela4s(UserDto userDto) {
        String sql = "SELECT variable1,variable2,variable3,variable4,variable9,variable10,variable13 " +
                "FROM usuarios "+
                "WHERE UPPER(variable1) = UPPER(?) AND evento = 'ciudadela4'  AND variable13 = 'pendiente'"+
                "LIMIT 1 ";
        return template.query(sql, new Object[]{'%' + userDto.getVariable1() + '%'}, new BeanPropertyRowMapper(UserDto.class));
    }


    public List<UserDto> getUserByVariable(UserDto userDto) {
        String sql = "SELECT idusuario,variable1,variable2,variable3,variable4,variable5,variable6,variable7,variable8,variable9,variable10,variable11,variable12,variable13,evento " +
                "FROM usuarios "+
                "WHERE UPPER(variable1) LIKE UPPER(?) " +
                "ORDER BY u.idusuario ";
        return template.query(sql, new Object[]{'%' + userDto.getVariable1() + '%'}, new BeanPropertyRowMapper(UserDto.class));
    }






    public int updateUsuario(UserDto userDto) {
        String sql = "update usuarios " +
                " set variable13 = 'pendiente'" +
                " WHERE variable1= ? ";
        return template.update(sql, new Object[]{userDto.getVariable1()});
    }

    public int updateUsuarioadulto(UserDto userDto) {
        String sql = "update usuarios " +
                " set variable13 = 'pendiente'" +
                " WHERE variable10= ? ";
        return template.update(sql, new Object[]{userDto.getVariable10()});
    }


    public int updateUsuarioregaloentregar(UserDto userDto) {
        String sql = "update usuarios " +
                " set variable12 = ? , variable13 = 'entregado'" +
                " WHERE variable1= ? ";
        return template.update(sql, new Object[]{ userDto.getVariable12(),userDto.getVariable1()});
    }









    public int deleteUser(int idUsuario) {
        String sql = "DELETE FROM usuario " +
                "WHERE idUsuario= ?";
        return template.update(sql, new Object[]{idUsuario});
    }




    public int createUser(UserDto userDto) {
        String sql = "INSERT INTO usuarios (idusuario,variable1,variable2,variable3,variable4,variable5,variable6,variable7,variable8,variable9,variable10,variable11,variable12,variable13,evento ) " +
                "VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return template.update(sql, new Object[]{userDto.getVariable1(), userDto.getVariable2(), userDto.getVariable3(),userDto.getVariable4(),userDto.getVariable5(), userDto.getVariable6(),userDto.getVariable7(),userDto.getVariable8(),userDto.getVariable9(),userDto.getVariable10(),userDto.getVariable11(),userDto.getVariable12(),userDto.getVariable13(),userDto.getEvento()});
    }

    public int createregalo(RegaloDto regaloDto) {
        String sql = "INSERT INTO regalos (idregalo,codigoregalo,idadminfin,idusuariofin ) " +
                "VALUES (DEFAULT,?,?,?)";
        return template.update(sql, new Object[]{regaloDto.getCodigoregalo(),regaloDto.getIdadminfin(),regaloDto.getIdusuariofin()});
    }



    public List<RegaloDto> buscarultimoregistroregalo(RegaloDto regaloDto) {
        String sql = "SELECT idregalo " +
                "FROM regalos " +
                "WHERE UPPER(idadminfin) = UPPER(?) ";

        return template.query(sql, new Object[]{ regaloDto.getIdadminfin() }, new BeanPropertyRowMapper(RegaloDto.class));
    }


    public int getcupos(UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios "
               ;

        return template.queryForObject(sql,Integer.class);
    }

    public int getUserByName(UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) AND UPPER(evento) = 'ciudadela4'";

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }

    public int validarmenor(UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) AND evento = 'ciudadela4' "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }



    public int getRegalopen(UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) AND evento = 'ciudadela4'  AND variable13 = 'pendiente'"
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }

    public int validarcodigo(CodigoDto codigoDto) {
        String sql = "SELECT COUNT(idcodigo) " +
                "FROM codigos " +
                "WHERE UPPER(codigo) = UPPER(?) AND estado = 'inactivo' "
                ;

        return template.queryForObject(sql, new Object[]{codigoDto.getCodigo()}, Integer.class);
    }

    public int validarpersonafinal(RegaloDto regaloDto) {
        String sql = "SELECT COUNT(idusuario) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?)  AND evento = 'carreramujerbene'  AND variable16 = 'pendiente' AND   variable9!='preregistro' "
                ;

        return template.queryForObject(sql, new Object[]{regaloDto.getIdusuariofin()}, Integer.class);
    }

    public int createregaloferia(RegaloDto regaloDto) {
        String sql = "INSERT INTO regalos (idregalo,codigoregalo,idadminfin,idusuariofin ) " +
                "VALUES (DEFAULT,?,?,?)";
        return template.update(sql, new Object[]{regaloDto.getCodigoregalo(),regaloDto.getIdadminfin(),regaloDto.getIdusuariofin()});
    }




    public int createUsercodigo(UserDto userDto) {
        String sql = "INSERT INTO usuarios (idusuario,variable1,variable2,variable3,variable4,variable5,variable6,variable7,variable8,variable9,variable10,variable11,variable12,variable13,variable14,variable15,variable16,evento ) " +
                "VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return template.update(sql, new Object[]{userDto.getVariable1(), userDto.getVariable2(), userDto.getVariable3(),userDto.getVariable4(),userDto.getVariable5(), userDto.getVariable6(),userDto.getVariable7(),userDto.getVariable8(),userDto.getVariable9(),userDto.getVariable10(),userDto.getVariable11(),userDto.getVariable12(),userDto.getVariable13(),userDto.getVariable14(),userDto.getVariable15(),userDto.getVariable16(),userDto.getEvento()});
    }

    public int  buscarcluster (UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) and evento='carreramujerbene' "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }

    public int  buscarclustersincamisa (UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE   evento='carreramujerbene' and variable9='registrado' "
                ;

        return template.queryForObject(sql, new Object[]{}, Integer.class);
    }
    public int  buscarXS (UserDto userDto) {String sql = "SELECT COUNT(variable1) FROM usuarios   WHERE   evento='carreramujerbene' and variable9!='preregistro'  and variable10='XS'"; return template.queryForObject(sql, new Object[]{userDto.getVariable10()}, Integer.class);}
    public int  buscarS (UserDto userDto) {String sql = "SELECT COUNT(variable1) FROM usuarios   WHERE   evento='carreramujerbene' and variable9!='preregistro'  and variable10='S'"; return template.queryForObject(sql, new Object[]{}, Integer.class);}
    public int  buscarM (UserDto userDto) {String sql = "SELECT COUNT(variable1) FROM usuarios   WHERE   evento='carreramujerbene' and variable9!='preregistro'  and variable10='M'"; return template.queryForObject(sql, new Object[]{}, Integer.class);}
    public int  buscarL (UserDto userDto) {String sql = "SELECT COUNT(variable1) FROM usuarios   WHERE   evento='carreramujerbene' and variable9!='preregistro'  and variable10='L'"; return template.queryForObject(sql, new Object[]{}, Integer.class);}
    public int  buscarXL (UserDto userDto) {String sql = "SELECT COUNT(variable1) FROM usuarios   WHERE   evento='carreramujerbene' and variable9!='preregistro'  and variable10='XL'"; return template.queryForObject(sql, new Object[]{}, Integer.class);}

    public int  buscarXXL (UserDto userDto) {String sql = "SELECT COUNT(variable1) FROM usuarios   WHERE   evento='carreramujerbene' and variable9!='preregistro'  and variable10='XXL'"; return template.queryForObject(sql, new Object[]{}, Integer.class);}




    public int  buscarcluster1 (UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) AND evento='carreramujerbene'  and variable9!='preregistro' "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }

    public int  validarpersonaferia (UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) AND evento='feria'  "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }

    public int  tallaS (UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) and variable6='S' "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }
    public int  tallaM(UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) and variable6='M' "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }
    public int  tallaL (UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) and variable6='L' "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }
    public int  tallaXL (UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) and variable6='XL' "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }
    public int  tallaXXL (UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) and variable6='XXL' "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }

    public int  buscarclusterferia (UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) and evento='feria' "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }

    public int  buscarclustersinquit (UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) and evento='carrerasquit' "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }


    public int  buscarclustervalidados2 (UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) and evento='carreramujerbene' and variable9!='preregistro' "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }
    public int updatecodigo(UserDto userDto) {
        String sql = "update codigos " +
                " SET  estado = 'activo'" +
                " WHERE codigo= ?   ";
        return template.update(sql, new Object[]{ userDto.getVariable9()});
    }

    public int updatecarrera(UserDto userDto) {
        String sql = "update usuarios " +
                " SET  variable9 = 'registrado'" +
                " WHERE variable1= ?   ";
        return template.update(sql, new Object[]{ userDto.getVariable1()});
    }

    public int  buscarcodigo (UserDto userDto) {
        String sql = "SELECT COUNT(idcodigo) " +
                "FROM codigos " +
                "WHERE UPPER(codigo) = UPPER(?) and  UPPER(estado)='invalido' "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable9()}, Integer.class);
    }

    public int  buscarcodigoval (UserDto userDto) {
        String sql = "SELECT COUNT(idcodigo) " +
                "FROM codigos " +
                "WHERE UPPER(codigo) = UPPER(?) and  UPPER(estado)='inactivo' "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable9()}, Integer.class);
    }




    public int loginadmin(AdminDto adminDto) {
        String sql = "SELECT COUNT(idadministrador) " +
                "FROM administradores  " +
                "WHERE UPPER(usuarioadmin) = ? AND  UPPER(contrasenaadmin) = ?  AND tipo = 'admin'"
                ;

        return template.queryForObject(sql, new Object[]{adminDto.getUsuarioadmin(),adminDto.getContrasenaadmin()}, Integer.class);
    }

    public int getRegalo(UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) AND evento = 'carreramujerbene'  AND variable16 = 'pendiente' AND   variable9!='preregistro'"
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }

    public int getpersonaregalo(UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) AND evento = 'carreramujer' ";

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }

    public int validarnumero(RegaloDto regaloDto) {
        String sql = "SELECT COUNT(idregalo) " +
                "FROM regalos " +
                "WHERE UPPER(numero) = UPPER(?) AND codigoregalo   = 'inactivo' ";

        return template.queryForObject(sql, new Object[]{regaloDto.getNumero()}, Integer.class);
    }

    public int actualizarkit(RegaloDto regaloDto ) {
        String sql = "update regalos " +
                " set idadminfin = ? ,  idusuariofin = ?  ,  codigoregalo='activo'" +


                " WHERE UPPER(numero) = ? ";
        return template.update(sql, new Object[]{regaloDto.getIdadminfin(),regaloDto.getIdusuariofin(),regaloDto.getNumero()});
    }
    public int actualizausuregalo(RegaloDto regaloDto ) {
        String sql = "update usuarios " +
                " set variable16 = 'reclamado'" +


                " WHERE variable1 = ? ";
        return template.update(sql, new Object[]{regaloDto.getIdusuariofin()});
    }


    public int getRegaloadulto(UserDto userDto) {
        String sql = "SELECT COUNT(variable10) " +
                "FROM usuarios " +
                "WHERE UPPER(variable10) = UPPER(?) AND evento = 'ciudadela4'  AND variable13 = 'pendiente'"
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable10()}, Integer.class);
    }



    public int getpersonaregalodulto(UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable10) = UPPER(?) AND evento = 'ciudadela4' ";

        return template.queryForObject(sql, new Object[]{userDto.getVariable10()}, Integer.class);
    }

    public int getRegalomenor(UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) AND evento = 'ciudadela4'  AND variable13 = 'entregado'"
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }

    public int getpersonaregalomenor(UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) AND evento = 'carreramujerbene'  AND variable16 = 'pendiente' AND   variable9!='preregistro'  ";

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }

    public List<UserDto> GetRegalopersona(UserDto userDto) {
        String sql = "SELECT idusuario, variable1,variable2,variable3,variable4,variable9,variable10,variable13 " +
                "FROM usuarios "+
                "WHERE UPPER(variable10) = UPPER(?) AND evento = 'ciudadela4'  AND variable13 = 'pendiente'"
                ;
        return template.query(sql, new Object[]{userDto.getVariable10()}, new BeanPropertyRowMapper(UserDto.class));
    }




    public List<UserDto> GetRegalopersonamenor(UserDto userDto) {
        String sql = "SELECT idusuario,variable1,variable2,variable3,variable4,variable5,variable6,variable7,variable8,variable9,variable10,variable11,variable12,variable13,variable14,variable15,variable16,evento " +
                "FROM usuarios "+
                "WHERE UPPER(variable1) = UPPER(?) "+
                "LIMIT 1"
                ;
        return template.query(sql, new Object[]{userDto.getVariable1()}, new BeanPropertyRowMapper(UserDto.class));
    }


    public List<UserDto> Getkit(RegaloDto regaloDto) {
        String sql = "SELECT idusuario, variable1,variable2,variable3,variable4,variable9,variable10,variable13 " +
                "FROM usuarios "+
                "WHERE UPPER(variable1) = UPPER(?) AND evento = 'ciudadela4'  AND variable13 = 'pendiente'"+
                "LIMIT 1"
                ;
        return template.query(sql, new Object[]{regaloDto.getIdusuariofin()}, new BeanPropertyRowMapper(UserDto.class));
    }

/**

    public List<UserDto> GetRegalopersona(UserDto userDto) {
        String sql = "SELECT NombreA,identificacionA,edadA,generoA,nombreb,variable5 " +
                "FROM usuario "+
                "WHERE UPPER(identificacionA) = UPPER(?) AND evento = 'ciudadela4'  AND variable5 = 'Pendiente'"+
                "LIMIT 1 ";
        return template.query(sql, new Object[]{'%' + userDto.getIdentificacionA() + '%'}, new BeanPropertyRowMapper(UserDto.class));
    }



    public int getcupos(UserDto userDto) {
        String sql = "SELECT COUNT(laborB) " +
                "FROM usuario "+
                "WHERE UPPER(laborB) = UPPER(?) AND UPPER (variable5) = 'true' ";

        return template.queryForObject(sql,new Object[]{userDto.getLaborB()},Integer.class);
    }





    public int getUsermayor(UserDto userDto) {
        String sql = "SELECT COUNT(identificacionA) " +
                "FROM usuario " +
                "WHERE UPPER(identificacionA) = UPPER(?) AND UPPER(evento) = UPPER(?)";

        return template.queryForObject(sql, new Object[]{userDto.getIdentificacionA(),userDto.getEvento()}, Integer.class);
    }





    public int getTotal(UserDto userDto) {
        String sql = "SELECT COUNT(id_usuario) " +
                "FROM usuario " ;

        return template.queryForObject(sql, new Object[]{}, Integer.class);
    }
 */
}
