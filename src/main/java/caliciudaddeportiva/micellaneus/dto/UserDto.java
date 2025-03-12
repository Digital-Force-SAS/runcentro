package caliciudaddeportiva.micellaneus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class    UserDto {

    @JsonProperty("idusuario")
    private int idusuario;
    private String variable1; //num doc
    private String variable2;
    private String variable3; // NOmbre
    private String variable4; // apellido
    private String variable5; // edad y genero
    private String variable6; // numero telefono
    private String variable7; // correo
    private String variable8; // comuna
    private String variable9; // direccion
    private String variable10; // RH y eps
    private String variable11; //
    private String variable12;
    private String variable13;
    private String variable14;
    private String variable15; // codigo
    private String variable16;
    private String variable17;
    private String variable18;
    private String variable19;
    private String variable20;
    private String variable21;
    private String variable22;
    private String variable23;
    private String evento;

}
