package codesa.micellaneus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EntradaDto {

    @JsonProperty("identrada")
    private int identrada;
    private String codigo;
    private String estado;
    private String tipo;








}
