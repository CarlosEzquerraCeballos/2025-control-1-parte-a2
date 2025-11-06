package es.grise.upm.profundizacion.subscriptionService;

public class LocalEmailNotNullException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LocalEmailNotNullException() {
		super("Si el delivery de un usuario es de tipo local, el email debe de ser null");
	}

}
