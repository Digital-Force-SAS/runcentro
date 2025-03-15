package caliciudaddeportiva.micellaneus.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequestDto {
    private String toEmail;
    private String toName;
    private String nameMenor;
    private String nameAdulto;
    private String lastNameMenor;
    private String lastNameAdulto;
    private String code;

    public String getFullNameMenor() {
        return nameMenor + " " + lastNameMenor;
    }

    public String getFullNameAdulto() {
        return nameAdulto + " " + lastNameAdulto;
    }
}