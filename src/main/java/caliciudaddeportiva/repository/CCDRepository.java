package caliciudaddeportiva.repository;

import caliciudaddeportiva.micellaneus.dto.*;
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
                "WHERE UPPER(variable1) = UPPER(?) and (evento='ciudadela' or evento='ciudadela') "
                ;
        return template.queryForObject(sql, new Object[]{userDto.getVariable1()}, Integer.class);
    }

    public int  buscarMenorCiudadelaentregado (UserDto userDto) {
        String sql = "SELECT COUNT(variable1) " +
                "FROM usuarios " +
                "WHERE UPPER(variable1) = UPPER(?) and evento='ciudadela' and variable21='entregado'"
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

        return template.queryForObject(sql, new Object[]{userDto.getVariable2()}, Integer.class);
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
                "WHERE (evento='ciudadela' OR evento='ciudadelacodigo') " +
                "AND variable16 = 'pendiente' " +
                "AND variable1 = ?";

        return template.queryForObject(sql, new Object[]{Integer.parseInt(userDto.getVariable1())}, Integer.class);
    }


    public List<UserDto> GetRegalopersona(UserDto userDto) {
        String sql = "SELECT idusuario, variable1, variable2, variable3, variable4, " +
                "variable5, variable6, variable7, variable9, variable11, variable12, " +
                "variable20, variable21 " +
                "FROM usuarios " +
                "WHERE variable1 = ? AND (evento='ciudadela' or evento='ciudadelacodigo') " +
                "AND variable16 = 'pendiente'";

        return template.query(sql, new Object[]{Integer.parseInt(userDto.getVariable1())}, (rs, rowNum) -> {
            UserDto dto = new UserDto();
            dto.setIdusuario(rs.getInt("idusuario"));
            dto.setVariable1(rs.getString("variable1"));
            dto.setVariable2(rs.getString("variable2"));
            dto.setVariable3(rs.getString("variable3"));
            dto.setVariable4(rs.getString("variable4"));
            dto.setVariable5(rs.getString("variable5"));
            dto.setVariable6(rs.getString("variable6"));
            dto.setVariable7(rs.getString("variable7"));
            dto.setVariable9(rs.getString("variable9"));
            dto.setVariable11(rs.getString("variable11"));
            dto.setVariable12(rs.getString("variable12"));
            dto.setVariable20(rs.getString("variable20"));
            dto.setVariable21(rs.getString("variable21"));
            return dto;
        });
    }



    public int ActualizarCodigo( UserDto userDto ) {
        String sql = "update codigos " +
                " set estado = 'activo' " +


                " WHERE UPPER(codigo) = ? ";
        return template.update(sql, new Object[]{userDto.getVariable2()});
    }


    public int validarnumero(RegaloDto regaloDto) {
        String sql = "SELECT COUNT(idregalo) " +
                "FROM regalos " +
                "WHERE numero = ? AND codigoregalo   = 'inactivo' ";

        return template.queryForObject(sql, new Object[]{regaloDto.getNumero()}, Integer.class);
    }

    public int actualizarkit(RegaloDto regaloDto ) {
        String sql = "update regalos " +
                " set idadminfin = ? ,  idusuariofin = ?  ,  codigoregalo= ?" +


                " WHERE UPPER(numero) = ? ";
        return template.update(sql, new Object[]{regaloDto.getIdadminfin(),regaloDto.getIdusuariofin(),regaloDto.getCodigoregalo(),regaloDto.getNumero()});
    }
    public int actualizausuregalo(RegaloDto regaloDto ) {
        String sql = "UPDATE usuarios " +
                "SET variable17 = ? ,variable16 = 'entregado' " +
                "WHERE variable1 = ?";

        return template.update(sql, new Object[]{
                regaloDto.getNumero(),  // El número del regalo se guarda en variable17
                regaloDto.getIdusuariofin() // Se usa idusuariofin como condición
        });
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


    // Tallas
    // Actualiza el número de tallas disponibles según se registren
    public int actualizarTalla(String talla, int cantidad) {
        String sql = "UPDATE tallas SET cantidad_disponible = cantidad_disponible - ? WHERE UPPER(nombre) = UPPER(?) AND cantidad_disponible >= ?";
        return template.update(sql, new Object[]{cantidad, talla, cantidad});
    }

    // Obtiene todas las tallas disponibles para el frontend
    public List<TallaDto> obtenerTallasDisponibles() {
        String sql = "SELECT nombre, cantidad_disponible FROM tallas WHERE cantidad_disponible > 0 ORDER BY nombre";
        return template.query(sql, new BeanPropertyRowMapper<>(TallaDto.class));
    }

    // Valida si una talla específica está disponible
    public boolean validarTallaDisponible(String talla) {
        String sql = "SELECT COUNT(*) FROM tallas WHERE UPPER(nombre) = UPPER(?) AND cantidad_disponible > 0";
        Integer count = template.queryForObject(sql, new Object[]{talla}, Integer.class);
        return count != null && count > 0;
    }

    // Horarios
    // Actualiza el número de horarios disponibles según se registren
    public int actualizarHorario(String horario, int cantidad) {
        String sql = "UPDATE horarios SET cantidad_disponible = cantidad_disponible - ? WHERE UPPER(nombre) = UPPER(?) AND cantidad_disponible >= ?";
        return template.update(sql, new Object[]{cantidad, horario, cantidad});
    }
    // Obtiene todas los horarios disponibles para el frontend
    public List<HorarioDto> obtenerHorariosDisponibles() {
        String sql = "SELECT nombre, cantidad_disponible FROM horarios WHERE cantidad_disponible > 0 ORDER BY nombre";
        return template.query(sql, new BeanPropertyRowMapper<>(HorarioDto.class));
    }

    // Valida si un horario específico está disponible
    public boolean validarHorarioDisponible(String horario) {
        String sql = "SELECT COUNT(*) FROM horarios WHERE UPPER(nombre) = UPPER(?) AND cantidad_disponible > 0";
        Integer count = template.queryForObject(sql, new Object[]{horario}, Integer.class);
        return count != null && count > 0;
    }

}
