package exception;

public class AuthException extends Exception {

    public AuthException() {
        super("Usuario o contrase�a incorrectos.");
    }

    public AuthException(String message) {
        super(message);
    }
}
