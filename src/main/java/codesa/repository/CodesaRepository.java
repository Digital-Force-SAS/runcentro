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
        String sql = "SELECT id_usuario,nombre,identificacion,direccion,comuna,celular,correo,fecha_na,genero,institucion,evento " +
                "FROM usuarios " +
                "ORDER BY id_usuario ";
        return template.query(sql, new Object[]{}, new BeanPropertyRowMapper(UserDto.class));
    }


    public List<UserDto> getUserByText(UserDto userDto) {
        String sql = "SELECT id_usuario,nombre,identificacion,celular,correo,comuna,genero,evento " +
                "FROM usuarios "+
                "WHERE UPPER(cedula) LIKE UPPER(?) " +
                "ORDER BY u.id_usuario ";
        return template.query(sql, new Object[]{'%' + userDto.getNombre() + '%'}, new BeanPropertyRowMapper(UserDto.class));
    }

    public int updateUsuario(UserDto userDto) {
        String sql = "update usuarios " +
                " set nombre = ?, activo = ?, id_rol = ? " +
                " WHERE id_usuario=?";
        return template.update(sql, new Object[]{userDto.getNombre(), userDto.getIdUsuario()});
    }

    public int deleteUser(int idUsuario) {
        String sql = "DELETE FROM usuario " +
                "WHERE id_usuarios= ?";
        return template.update(sql, new Object[]{idUsuario});
    }

    public int createUser(UserDto userDto) {
        String sql = "INSERT INTO usuarios (id_usuario,nombre,identificacion,direccion,comuna,celular,correo,fecha_na,genero,institucion,evento ) " +
                "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?)";
        return template.update(sql, new Object[]{userDto.getNombre(), userDto.getIdentificacion(), userDto.getDireccion(),userDto.getComuna(),userDto.getCelular(), userDto.getCorreo(),userDto.getFecha_na(),userDto.getGenero(),userDto.getInstitucion(),userDto.getEvento()});
    }

    public int getUserByName(UserDto userDto) {
        String sql = "SELECT COUNT(celular) " +
                "FROM usuarios " +
                "WHERE UPPER(celular) = UPPER(?) AND  UPPER(evento) = UPPER(?)";

        return template.queryForObject(sql, new Object[]{userDto.getCelular(),userDto.getEvento()}, Integer.class);
    }

    public int getTotal(UserDto userDto) {
        String sql = "SELECT COUNT(id_usuario) " +
                "FROM usuarios " ;

        return template.queryForObject(sql, new Object[]{}, Integer.class);
    }

}
