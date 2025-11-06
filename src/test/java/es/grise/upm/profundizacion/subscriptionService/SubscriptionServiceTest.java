package es.grise.upm.profundizacion.subscriptionService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;


public class SubscriptionServiceTest {
	
	
	@Test 
	void addUserNotNull() throws NullUserException, ExistingUserException, 
	LocalEmailNotNullException {
		SubscriptionService service = new SubscriptionService();
		User u = mock(User.class);
		
		service.addSubscriber(u);
		
		assert service.getSubscribers().contains(u);
		
	}
	
	@Test
	void addUserNull() {
		SubscriptionService service = new SubscriptionService();
		assertThrows(NullUserException.class, () -> service.addSubscriber(null));
	
	}
	
	@Test
	void addExistingUser() throws NullUserException, ExistingUserException, 
	LocalEmailNotNullException {
		SubscriptionService service = new SubscriptionService();
		User u = mock(User.class);
		
		service.addSubscriber(u);
		assertThrows(ExistingUserException.class, () -> service.addSubscriber(u));
			
	}
	
	@Test
	void LocalAndEmailNotNull() throws NullUserException, ExistingUserException, 
	LocalEmailNotNullException {
		SubscriptionService service = new SubscriptionService();

		User local = mock(User.class);
		when(local.getDelivery()).thenReturn(Delivery.LOCAL);
		when(local.getEmail()).thenReturn("no-deberia@tener.email");
		
		assertThrows(LocalEmailNotNullException.class, () -> service.addSubscriber(local));

	
	}
	
	@Test
	void LocalAndEmailNull() throws NullUserException, ExistingUserException, 
	LocalEmailNotNullException {
		SubscriptionService service = new SubscriptionService();

		User local = mock(User.class);
		when(local.getDelivery()).thenReturn(Delivery.LOCAL);
		when(local.getEmail()).thenReturn(null);
		
		service.addSubscriber(local);
		assert service.getSubscribers().contains(local);
	
	}
	
	@Test
	void GetSuscribers() throws NullUserException, ExistingUserException, LocalEmailNotNullException {
		SubscriptionService service = new SubscriptionService();

		User u1 = mock(User.class);
		User u2 = mock(User.class);
		User u3 = mock(User.class);
		
		service.addSubscriber(u1);
		service.addSubscriber(u2);
		service.addSubscriber(u3);
		
		assertTrue(service.getSubscribers().contains(u1));
		assertTrue(service.getSubscribers().contains(u2));
		assertTrue(service.getSubscribers().contains(u3));
		
	}
	
	
}
