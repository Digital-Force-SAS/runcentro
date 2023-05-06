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
        String sql = "SELECT idusuario,variable1,variable2,variable3,variable4,variable5,variable6,variable7,variable8,variable9,variable10,variable11,variable12,variable13,variable14,variable15,variable16,evento " +
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
    public int logincarrera(AdminDto adminDto) {
        String sql = "SELECT COUNT(idadministrador) " +
                "FROM administradores  " +
                "WHERE UPPER(usuarioadmin) = ? AND  UPPER(contrasenaadmin) = ?  AND tipo = 'carrera'"
                ;
        return template.queryForObject(sql, new Object[]{adminDto.getUsuarioadmin(),adminDto.getContrasenaadmin()}, Integer.class);
    }
    //CIUDADELA************************************************************************************************************************

    public int  buscarMenorCiudadela (UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) and evento='ciudadela0705' "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }


    public int createUserCiudadela(UserDto userDto) {
        String sql = "INSERT INTO usuarios (idusuario,variable1,variable2,variable3,variable4,variable5,variable6,variable7,variable8,variable9,variable10,variable11,variable12,variable13,variable14,variable15,variable16,evento ) " +
                "VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return template.update(sql, new Object[]{userDto.getVariable1(), userDto.getVariable2(), userDto.getVariable3(),userDto.getVariable4(),userDto.getVariable5(), userDto.getVariable6(),userDto.getVariable7(),userDto.getVariable8(),userDto.getVariable9(),userDto.getVariable10(),userDto.getVariable11(),userDto.getVariable12(),userDto.getVariable13(),userDto.getVariable14(),userDto.getVariable15(),userDto.getVariable16(),userDto.getEvento()});
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
                "WHERE UPPER(variable1) = UPPER(?) AND evento = 'ciudadela0705' "
                ;

        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }
    //CARRERA************************************************************************************************************************


    //FUTBOL FAM ************************************************************************************************************************


}
