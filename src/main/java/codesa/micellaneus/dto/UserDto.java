package codesa.micellaneus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
public class UserDto {

    @JsonProperty("id_usuario")
    private int id_usuario;
    private String nombreA;
    private String identificacionA;
    private String edadA;
    private String generoA;
    private String etniaA;
    private String celularA;
    private String correoA;
    private String comunaA;
    private String nombreb;
    private String identificacionB;
    private String laborB;
    private String evento;
    private String variable1;
    private String variable2;
    private String variable3;
    private String variable4;
    private String variable5;
    private String codigo;





}
