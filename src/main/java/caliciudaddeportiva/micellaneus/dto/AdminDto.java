package caliciudaddeportiva.micellaneus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AdminDto {

    @JsonProperty("idadministrador ")
    private int idadministrador ;
    private String usuarioadmin;
    private String contrasenaadmin;
    private String tipo;

}
