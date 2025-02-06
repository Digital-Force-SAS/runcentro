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

    //USUARIOS************************************************************************************************************************
    public List<UserDto> getAllUsers() {
        String sql = "SELECT idusuario,variable1,variable2,variable3,variable4,variable5,variable6,variable7,variable8,variable9,variable10,variable11,variable12,variable13,variable14,variable15,variable16,variable17,variable18,variable19,variable20,variable21,variable22,variable23,evento " +
                "FROM usuarios " +

                "ORDER BY idusuario ";
        return template.query(sql, new Object[]{}, new BeanPropertyRowMapper(UserDto.class));
    }


    public int loginadmin(AdminDto adminDto) {
        String sql = "SELECT COUNT(idadministrador) " +
                "FROM administradores  " +
                "WHERE UPPER(usuarioadmin) = ? AND  UPPER(contrasenaadmin) = ?  AND tipo = 'administrador'"
                ;
        return template.queryForObject(sql, new Object[]{adminDto.getUsuarioadmin(),adminDto.getContrasenaadmin()}, Integer.class);
    }

    public int loginciudadela(AdminDto adminDto) {
        String sql = "SELECT COUNT(idadministrador) " +
                "FROM administradores  " +
                "WHERE UPPER(usuarioadmin) = ? AND  UPPER(contrasenaadmin) = ?  AND tipo = 'ciudadela'"
                ;
        return template.queryForObject(sql, new Object[]{adminDto.getUsuarioadmin(),adminDto.getContrasenaadmin()}, Integer.class);
    }

    //CIUDADELA************************************************************************************************************************

    public int  buscarMenorCiudadela (UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) and (evento='ciudadela' or evento='ciudadelacodigo') "
                ;
        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }


    public int createUserCiudadela(UserDto userDto) {
        String sql = "INSERT INTO usuarios (idusuario,variable1,variable2,variable3,variable4,variable5,variable6,variable7,variable8,variable9,variable10,variable11,variable12,variable13,variable14,variable15,variable16,variable17,variable18,variable19,variable20,variable21,variable22,variable23,evento ) " +
                "VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return template.update(sql, new Object[]{userDto.getVariable1(), userDto.getVariable2(), userDto.getVariable3(),userDto.getVariable4(),userDto.getVariable5(), userDto.getVariable6(),userDto.getVariable7(),userDto.getVariable8(),userDto.getVariable9(),userDto.getVariable10(),userDto.getVariable11(),userDto.getVariable12(),userDto.getVariable13(),userDto.getVariable14(),userDto.getVariable15(),userDto.getVariable16(),userDto.getVariable17(),userDto.getVariable18(),userDto.getVariable19(),userDto.getVariable20(),userDto.getVariable21(),userDto.getVariable22(),userDto.getVariable23(),userDto.getEvento()});
    }


    public int  ContarUserCiudadela (UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE   evento='ciudadela0705' "
                ;

        return template.queryForObject(sql, new Object[]{}, Integer.class);
    }

    public int validarmenor(UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?)  "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }

    public int ValidarCupo(UserDto userDto) {
        String sql = "SELECT COUNT(codigo) " +
                "FROM codigos " +
                "WHERE UPPER(codigo) = UPPER(?) AND UPPER(estado) = 'inactivo' "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable23()}, Integer.class);
    }

    public int getpersonaregalomenor(UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) AND (evento='ciudadela' or evento='ciudadelacodigo') ";

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }

    public int getRegalomenor(UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) AND (evento='ciudadela' or evento='ciudadelacodigo')  AND variable21 = 'entregado'"
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }
    public List<UserDto> GetRegalopersonamenor(UserDto userDto) {
        String sql = "SELECT idusuario, variable1,variable2,variable5,variable9,variable12,variable21,variable20 " +
                "FROM usuarios "+
                "WHERE UPPER(variable1) = UPPER(?) AND (evento='ciudadela' or evento='ciudadelacodigo')  AND variable21 = 'pendiente'"+
                "LIMIT 1"
                ;
        return template.query(sql, new Object[]{userDto.getVariable1()}, new BeanPropertyRowMapper(UserDto.class));
    }

    public int updateUsuarioregaloentregar(UserDto userDto) {
        String sql = "update usuarios " +
                " set  variable21 = 'entregado'" +
                " WHERE variable1= ? ";
        return template.update(sql, new Object[]{ userDto.getVariable1()});
    }

    public int createregalo(RegaloDto regaloDto) {
        String sql = "INSERT INTO regalos (idregalo,codigoregalo,idadminfin,idusuariofin,numero ) " +
                "VALUES (DEFAULT,?,?,?,?)";
        return template.update(sql, new Object[]{regaloDto.getCodigoregalo(),regaloDto.getIdadminfin(),regaloDto.getIdusuariofin(),regaloDto.getNumero()});
    }

    public int getpersonaregalodulto(UserDto userDto) {
        String sql = "SELECT COUNT(variable12) " +
                "FROM usuarios " +
                "WHERE UPPER(variable12) = UPPER(?) AND (evento='ciudadela' or evento='ciudadelacodigo') ";

        return template.queryForObject(sql, new Object[]{userDto.getVariable12()}, Integer.class);
    }

    public int getRegaloadulto(UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable12) = UPPER(?) AND (evento='ciudadela' or evento='ciudadelacodigo')  AND variable21 = 'pendiente'"
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable12()}, Integer.class);
    }


    public List<UserDto> GetRegalopersona(UserDto userDto) {
        String sql = "SELECT idusuario, variable1,variable2,variable5,variable9,variable12,variable21,variable20 " +
                "FROM usuarios "+
                "WHERE UPPER(variable12) = UPPER(?) AND evento = 'ciudadela'  AND variable21 = 'pendiente'"
                ;
        return template.query(sql, new Object[]{userDto.getVariable12()}, new BeanPropertyRowMapper(UserDto.class));
    }



    public int ActualizarCodigo( UserDto userDto ) {
        String sql = "update codigos " +
                " set estado = 'activo' " +


                " WHERE UPPER(codigo) = ? ";
        return template.update(sql, new Object[]{userDto.getVariable23()});
    }





    public int  buscarcupos (UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE evento='ciudadela'  "
                ;

        return template.queryForObject(sql, new Object[]{}, Integer.class);
    }

    public int  buscarcuposCodigo (UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE evento='ciudadelacodigo' "
                ;

        return template.queryForObject(sql, new Object[]{}, Integer.class);
    }

}
