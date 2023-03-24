package caliciudaddeportiva.micellaneus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegaloDto {

    @JsonProperty("idregalo ")
    private int idregalo ;
    private String codigoregalo;
    private String idadminfin;
    private String idusuariofin;
    private String numero;


}
