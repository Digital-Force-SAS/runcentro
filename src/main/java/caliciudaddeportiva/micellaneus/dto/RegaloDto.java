package caliciudaddeportiva.micellaneus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegaloDto {

    @JsonProperty("idregalo ")
    private String idregalo ;
    private int codigoregalo;
    private String idadminfin;
    private int idusuariofin;

}
