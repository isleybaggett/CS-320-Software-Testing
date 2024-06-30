package cs320.Test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import cs320.Contact.Contact;

public class ContactTest {

	//test to make sure that a contact can be created
	@Test
	public void testContact() {
		Contact contact = new Contact("13Jkx405Ty", "Isley", 
				"Baggett", "5555555555", "123 Patriot St");
		
		assertTrue(contact.getID().equals("13Jkx405Ty"));
		assertTrue(contact.getFirstName().equals("Isley"));
		assertTrue(contact.getLastName().equals("Baggett"));
		assertTrue(contact.getPhoneNum().equals("5555555555"));
		assertTrue(contact.getAddress().equals("123 Patriot St"));
	}
	
	//test to check that the id is to long
	@Test
	public void testIDToLong() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("13Jkx405Ty1", "Isley", "Baggett", "5555555555", "123 Patriot St");
		});
	}
	
	//test to check if name is to long
	@Test
	public void testFistNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("13Jkx405Ty", "Isley123456", "Baggett", "5555555555", "123 Patriot St");
		});
	}
	
	//test to check if name is to long
	@Test
	public void testLastNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("13Jkx405Ty", "Isley", "Baggett1234", "5555555555", "123 Patriot St");
		});
	}
	
	//test to check if phone number is to long
	@Test
	public void testPhoneNumToLong() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("13Jkx405Ty", "Isley", "Baggett", "55555555555", "123 Patriot St");
		});
	}
	
	//test to check if address is to long
	@Test
	public void testAddressToLong() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("13Jkx405Ty", "Isley", "Baggett", "5555555555", 
					"123 Patriot Street, North Carolina, United States, 12345");
		});
	}
	
	//test to check if phone number to short 
	@Test
	public void testPhoneNumToShort() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("13Jkx405Ty", "Isley", "Baggett", "555555555", "123 Patriot St");
		});
	}
	
	//test to check if phone number contains something other than number
	@Test
	public void testPhoneNumNotNums() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("13Jkx405Ty", "Isley", "Baggett", "5!55@#55aZ", "123 Patriot St");
		});
	}
	
	//the below test make sure that no input is null for the contact
	@Test
	public void testIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact(null, "Isley", "Baggett", "5555555555", "123 Patriot St");
		});
	}
	
	@Test
	public void testFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("13Jkx405Ty", null, "Baggett", "5555555555", "123 Patriot St");
		});
	}
	
	@Test
	public void testLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("13Jkx405Ty", "Isley", null, "5555555555", "123 Patriot St");
		});
	}
	
	@Test
	public void testPhoneNumNull() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("13Jkx405Ty", "Isley", "Baggett", null, "123 Patriot St");
		});
	}
	
	@Test
	public void testAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("13Jkx405Ty", "Isley", "Baggett", "5555555555", null);
		});
	}

}
