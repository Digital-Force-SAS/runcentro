package caliciudaddeportiva.micellaneus.constantes;

public enum ValidationMessageEnum {


    CIUDADELALLENA("CIUDADELALLENA.code", "CIUDADELALLENA.message", "CIUDADELALLENA.recomen"),

    MENOREXISTE("MENOREXISTE.code", "MENOREXISTE.message", "MENOREXISTE.recomen"),
    MENORNOEXISTE("MENORNOEXISTE.code", "MENORNOEXISTE.message", "MENORNOEXISTE.recomen"),

    administradornoexiste("administradornoexiste.code", "administradornoexiste.message", "administradornoexiste.recomen"),
    ciudadelvalidaranoexiste("ciudadelvalidaranoexiste.code", "ciudadelvalidaranoexiste.message", "ciudadelvalidaranoexiste.recomen"),
    carreravalidarnoexiste("carreravalidarnoexiste.code", "carreravalidarnoexiste.message", "carreravalidarnoexiste.recomen"),
    REGALOENTREGADOMENOR("REGALOENTREGADOMENOR.code", "REGALOENTREGADOMENOR.message", "REGALOENTREGADOMENOR.recomen"),
    ADULTOEXISTE("ADULTOEXISTE.code", "ADULTOEXISTE.message", "ADULTOEXISTE.recomen"),

    REGALOENTREGADOADULTO("REGALOENTREGADOADULTO.code", "REGALOENTREGADOADULTO.message", "REGALOENTREGADOADULTO.recomen"),
    carreracupos3kno("carreracupos3kno.code", "carreracupos3kno.message", "carreracupos3kno.recomen"),

    carreramenorexiste3k("carreramenorexiste3k.code", "carreramenorexiste3k.message", "carreramenorexiste3k.recomen"),

    carreraadultoexiste3k("carreraadultoexiste3k.code", "carreraadultoexiste3k.message", "carreraadultoexiste3k.recomen"),











    USER_ALREADY_EXIST("UserAlreadyExists.code", "UserAlreadyExists.message", "UserAlreadyExists.recomen");

    private final String code;
    private final String message;
    private final String recomen;

    private ValidationMessageEnum(String code, String message, String recomen) {
        this.code = code;
        this.message = message;
        this.recomen = recomen;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getRecomen() {
        return recomen;
    }
}
