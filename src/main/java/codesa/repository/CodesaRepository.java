package codesa.repository;

import codesa.micellaneus.dto.UserDto;
import codesa.micellaneus.util.MessageExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CodesaRepository {

    @Autowired
    private JdbcTemplate template;

    @Autowired
    MessageExceptionUtil messageExceptionDtoUtil;

    public List<UserDto> getAllUsers() {
        String sql = "SELECT id_usuario,nombreA,identificacionA,edadA,generoA,etniaA,celularA,correoA,comunaA,nombreb,identificacionB,laborB  " +
                "FROM usuario " +
                "ORDER BY id_usuario ";
        return template.query(sql, new Object[]{}, new BeanPropertyRowMapper(UserDto.class));
    }


    public List<UserDto> getUserByText(UserDto userDto) {
        String sql = "SELECT id_usuario,nombre,identificacion,celular,correo,comuna,genero,evento " +
                "FROM usuario "+
                "WHERE UPPER(cedula) LIKE UPPER(?) " +
                "ORDER BY u.id_usuario ";
        return template.query(sql, new Object[]{'%' + userDto.getNombreA() + '%'}, new BeanPropertyRowMapper(UserDto.class));
    }

    public int updateUsuario(UserDto userDto) {
        String sql = "update usuarios " +
                " set nombre = ?, activo = ?, id_rol = ? " +
                " WHERE id_usuario=?";
        return template.update(sql, new Object[]{userDto.getNombreA(), userDto.getId_usuario()});
    }

    public int deleteUser(int idUsuario) {
        String sql = "DELETE FROM usuario " +
                "WHERE id_usuarios= ?";
        return template.update(sql, new Object[]{idUsuario});
    }


    public int createUser(UserDto userDto) {
        String sql = "INSERT INTO usuario (id_usuario,nombreA,identificacionA,edadA,generoA,etniaA,celularA,correoA,comunaA,nombreb,identificacionB,laborB ) " +
                "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?,?)";
        return template.update(sql, new Object[]{userDto.getNombreA(), userDto.getIdentificacionA(), userDto.getEdadA(),userDto.getGeneroA(),userDto.getEtniaA(), userDto.getCelularA(),userDto.getCorreoA(),userDto.getComunaA(),userDto.getNombreb(),userDto.getIdentificacionB(),userDto.getLaborB()});
    }


    public int getUserByName(UserDto userDto) {
        String sql = "SELECT COUNT(identificacionA) " +
                "FROM usuario " +
                "WHERE UPPER(identificacionA) = UPPER(?)";

        return template.queryForObject(sql, new Object[]{userDto.getIdentificacionA()}, Integer.class);
    }

    public int getTotal(UserDto userDto) {
        String sql = "SELECT COUNT(id_usuario) " +
                "FROM usuario " ;

        return template.queryForObject(sql, new Object[]{}, Integer.class);
    }

}
