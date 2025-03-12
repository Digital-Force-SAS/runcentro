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
    private String name;
    private String lastName;
    private String code;

    public String getFullName() {
        return name + " " + lastName;
    }
}