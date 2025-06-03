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
    codigoErroneo("codigoErroneo.code", "codigoErroneo.message", "codigoErroneo.recomen"),

    carreramenorexiste3k("carreramenorexiste3k.code", "carreramenorexiste3k.message", "carreramenorexiste3k.recomen"),

    carreraadultoexiste3k("carreraadultoexiste3k.code", "carreraadultoexiste3k.message", "carreraadultoexiste3k.recomen"),

    carreracupos7kno("carreracupos7kno.code", "carreracupos7kno.message", "carreracupos7kno.recomen"),
    carreramenorexiste7k("carreramenorexiste7k.code", "carreramenorexiste7k.message", "carreramenorexiste7k.recomen"),


    regaloentrego("regaloentrego.code", "regaloentrego.message", "regaloentrego.recomen"),


    numero("numero.code", "numero.message", "numero.recomen"),

    HORARIO_NO_DISPONIBLE("HORARIO_NO_DISPONIBLE.code", "HORARIO_NO_DISPONIBLE.message", "HORARIO_NO_DISPONIBLE.recomen"),


    TALLA_NO_DISPONIBLE("TALLA_NO_DISPONIBLE.code", "TALLA_NO_DISPONIBLE.message", "TALLA_NO_DISPONIBLE.recomen");


    // USER_ALREADY_EXIST("UserAlreadyExists.code", "UserAlreadyExists.message", "UserAlreadyExists.recomen");

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
