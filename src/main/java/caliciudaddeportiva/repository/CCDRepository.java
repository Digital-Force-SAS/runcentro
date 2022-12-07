package caliciudaddeportiva.repository;

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
        String sql = "SELECT idusuario,variable1,variable2,variable3,variable4,variable5,variable6,variable7,variable8,variable9,variable10,variable11,variable12,variable13,evento " +
                "FROM usuarios " +
                "where evento = 'ciudadela4' "+
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


    public int getRegalopen(UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) AND evento = 'ciudadela4'  AND variable13 = 'pendiente'"
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }

    public int getRegalo(UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) AND evento = 'ciudadela4'  AND variable13 = 'entregado'"
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }

    public int getpersonaregalo(UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) AND evento = 'ciudadela4' ";

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
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
                "WHERE UPPER(variable1) = UPPER(?) AND evento = 'ciudadela4' ";

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
        String sql = "SELECT idusuario, variable1,variable2,variable3,variable4,variable9,variable10,variable13 " +
                "FROM usuarios "+
                "WHERE UPPER(variable1) = UPPER(?) AND evento = 'ciudadela4'  AND variable13 = 'pendiente'"+
                "LIMIT 1"
                ;
        return template.query(sql, new Object[]{userDto.getVariable1()}, new BeanPropertyRowMapper(UserDto.class));
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
