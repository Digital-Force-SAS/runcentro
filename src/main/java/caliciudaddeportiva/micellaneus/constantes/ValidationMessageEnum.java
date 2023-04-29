package caliciudaddeportiva.micellaneus.constantes;

public enum ValidationMessageEnum {

    USER_ALREADY_EXIST("UserAlreadyExists.code", "UserAlreadyExists.message", "UserAlreadyExists.recomen"),
    ERROR_CREATE_USER("ErrorCreateUser.code", "ErrorCreateUser.message", "ErrorCreateUser.recomen"),
    ERROR_DELETE_USER("ErrorDeleteeUser.code", "ErrorDeleteeUser.message", "ErrorDeleteeUser.recomen"),
    ERROR_UPDATE_USER("ErrorUpdateUser.code", "ErrorUpdateUser.message", "ErrorUpdateUser.recomen"),

    ERROR_UPDATE_ENTRADA("entradaexist.code", "ENTRADAEXIST.message", "ENTRADAALREADYEXIST.recomen"),
    errorcodigonoexiste("entradanotexist.code", "entradanotexist.message", "entradanotexist.recomen"),

    TALLAS("TALLAS.code", "TALLAS.message", "TALLAS.recomen"),



    ERROR_USUARION_PERSONA_ENTRADA("UserAlreadyExistspersona.code", "UserAlreadyExistspersona.message", "ENTRADAALREADYEXIST.recomen"),

    ERROR_PLACA_PERSONA_ENTRADA("PlacaAlreadyExistspersona.code", "PlacaAlreadyExistspersona.message", "PlacaAlreadyExistspersona.recomen"),
    ERROR_NATE_ENTRADA("entradanotexist.code", "ENTRADAnotEXIST.message", "ENTRADAALREADYEXIST.recomen"),

    Regalono("regalono.code", "regalono.message", "regalono.recomen"),

    Regalono1("regalono1.code", "regalono1.message", "regalono1.recomen"),


    Regalono2("regalono2.code", "regalono2.message", "regalono2.recomen"),


    nocupos("eventolleno.code", "eventolleno.message", "eventolleno.recomen"),

    regaloentrego("regaloentrego.code", "regaloentrego.message", "regaloentrego.recomen"),
    login("login.code", "login.message", "login.recomen"),
    numero("numero.code", "numero.message", "numero.recomen"),

    Validarmenor("validarmenor.code", "validarmenor.message", "validarmenor.recomen"),


    ERROR_GET_USERS("ErrorGetUser.code", "ErrorGetUser.message", "ErrorGetUser.recomen"),
    ERROR_GET_ALL_USERS("ErrorGetAllUser.code", "ErrorGetAllUser.message", "ErrorGetAllUser.recomen"),
    UnknownException("UnknownException.code", "UnknownException.message", "UnknownException.recomen");


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
