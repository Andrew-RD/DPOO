package exception;

public class FormatException extends Exception{

	public FormatException() {
		super("Los datos ingresados no son v�lidos.");
	}
	
    public FormatException(String message) {
        super(message);
    }

}
