package codesa.micellaneus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
public class UserDto {

    @JsonProperty("id_usuario")
    private int idUsuario;
    private String nombre;
    private String identificacion;
        private String direccion;
    private String comuna;
    private String celular;
    private String correo;
    private String fecha_na;
    private String genero;
    private String institucion;
    private String evento;


}
