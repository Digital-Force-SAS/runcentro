package caliciudaddeportiva.micellaneus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CodigoDto {

    @JsonProperty("idcodigo ")
    private int idcodigo ;
    private String codigo;
    private String estado;

}
