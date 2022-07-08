package codesa.micellaneus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {

    @JsonProperty("id_usuario")
    private int idUsuario;
    private String nombre;
    private String identificacion;
    private String celular;
    private String correo;
    private String comuna;
    private String genero;

}
