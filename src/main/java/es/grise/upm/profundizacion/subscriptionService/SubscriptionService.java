package es.grise.upm.profundizacion.subscriptionService;

import java.util.Collection;
import java.util.LinkedList;

public class SubscriptionService {

	private Collection <User> subscribers;
	
	/*
	 * Constructor
	 */
	public SubscriptionService() {
		this.subscribers = new LinkedList<User>();
		
	}

	/*
	 * Method to code
	 */
	public void addSubscriber(User user) throws NullUserException, 
	ExistingUserException, LocalEmailNotNullException{
		// Si el usuario es nulo se lanza una excepcion
		if (user == null) {
			throw new NullUserException();
		}
		
		// Si el usuario ya está suscrito se genera una excepción
		for (User u: this.subscribers) {
			if (u.equals(user)) {
				throw new ExistingUserException();
			}
		}
		
		// Si el delivery de un user es de tipo LOCAL, el email debe ser null
		if (user.getDelivery() == Delivery.LOCAL) {
			if (user.getEmail() != null) {
				throw new LocalEmailNotNullException();
			}
			
		}
		
		// En caso correcto, se añade el usuario a la lista
		this.subscribers.add(user);
	}
	
	
	
	/*
	 * Other setters & getters
	 */
	public Collection <User> getSubscribers() {
		
		return subscribers;
		
	}

}
