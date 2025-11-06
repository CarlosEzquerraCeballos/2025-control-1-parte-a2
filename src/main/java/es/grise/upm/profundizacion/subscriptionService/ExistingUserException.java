package es.grise.upm.profundizacion.subscriptionService;

public class ExistingUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExistingUserException() {
		super("El usuario ya está suscrito");
	}

}
