package exceptions;

public class RequiredInfoException extends Exception {

	private static final long serialVersionUID = 1L;

	public RequiredInfoException( String message ) {
		super( message );
	}
}
