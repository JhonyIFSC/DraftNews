package exceptions;

public class RegisterException extends Exception {
	private static final long serialVersionUID = 1L;
	
	
	public RegisterException(){
		super("Usuario J� registrado.");
	}
}
