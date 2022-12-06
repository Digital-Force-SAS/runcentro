package caliciudaddeportiva.micellaneus.exeption;

public class ExceptionHelper {

    public static void procesar(Exception e, String messageException) {
        if (e instanceof BusinessCCDException) {
            throw (RuntimeException) e;
        }

        throw new BusinessCCDException(
                messageException, e);
    }
}
