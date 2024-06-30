package cs320.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cs320.Contact.Contact;
import cs320.Contact.ContactService;

public class ContactServiceTest {
	
	@BeforeEach
	public void init() {
		ContactService.contactRepository.clear();
	}
	
	//checks to make sure a contact is created and stored
	@Test 
	public void add() {
		Contact contact = new Contact("13Jkx405Ty", "Isley", 
				"Baggett", "5555555555", "123 Patriot St");
		ContactService.create(contact);
		assertEquals((ContactService.contactRepository).containsKey("13Jkx405Ty"), true);
	}

	//checks to see if a contact already has the id to avoid duplicating
	@Test
    public void addExistingID() {
        final Contact contact = new Contact("13Jkx405Ty", "Isley", 
				"Baggett", "5555555555", "123 Patriot St");
        assertThat(ContactService.create(contact)).isTrue();
        assertThat(ContactService.create(contact)).isFalse();
        
    }
	
	//checks that a contact was updated with new information 
	//FIX ME: unable to look to see if number is updated
	@Test
	public void update() {
		ContactService.create(new Contact("13Jkx405Ty", "Isley", 
				"Baggett", "5555555555", "123 Patriot St"));
		
		Contact updated = new Contact("13Jkx405Ty", "Isley", 
				"Baggett", "5555555556", "123 Patriot St");
		assertTrue(ContactService.update("13Jkx405Ty", updated));
		assertThat(ContactService.contactRepository.get("13Jkx405Ty"))
		.hasFieldOrPropertyWithValue("phoneNum", "5555555556");
	}
	
	//checks that you cannot update a non existing key
	@Test
	public void updateNonExistent() {
		ContactService.create(new Contact("13Jkx405Ty", "Isley", 
				"Baggett", "5555555555", "123 Patriot St"));
		Contact updated = new Contact("13Jkx405Ty", "Isley", 
				"Baggett", "5555555556", "123 Patriot St");
		assertFalse(ContactService.update("13Jkx405Iy", updated));
	}
	
	//checks that a deleted contact was in fact deleted 
	@Test
	public void delete() {
		ContactService.create(new Contact("13Jkx405Ty", "Isley", 
				"Baggett", "5555555555", "123 Patriot St"));
		ContactService.deleteById("13Jkx405Ty");
		assertFalse((ContactService.contactRepository).containsKey("13Jkx405Ty"));
	}
	
	@Test
	public void deleteNonExistingID() {
		ContactService.create(new Contact("13Jkx405Ty", "Isley", 
				"Baggett", "5555555555", "123 Patriot St"));
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			ContactService.deleteById("13Jkx405Tx");	
		});
	}
}

