package caliciudaddeportiva.micellaneus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class    UserDto {

    @JsonProperty("idusuario")
    private int idusuario;
    private String variable1;
    private String variable2; // nombre menor
    private String variable3; // apellido menor
    private String variable4;
    private String variable5;
    private String variable6;
    private String variable7;
    private String variable8;
    private String variable9; // nombre adulto
    private String variable10; // apellido adulto
    private String variable11;
    private String variable12;
    private String variable13;
    private String variable14;
    private String variable15;
    private String variable16;
    private String variable17;
    private String variable18; // correo
    private String variable19;
    private String variable20; // codigo unico
    private String variable21;
    private String variable22;
    private String variable23;
    private String evento;

}
