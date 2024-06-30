package cs320.Contact;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactService {
	//create a hash map
    public static Map<String, Contact> contactRepository = new ConcurrentHashMap<String, Contact>();

    public ContactService() {}
    
	//create a contact if it is not already in the hash map //this makes sure all ids are unique
	public static boolean create(Contact contact) {
		if (contactRepository.containsKey(contact.getID())) return false;
		else{contactRepository.putIfAbsent(contact.getID(), contact);
		return true;}
	}

	//deletes a contact given the id, if it is not an id in the hash map it returns id does not exist
	public static void deleteById(String id){
		Contact existing = contactRepository.get(id);
        if(existing == null) {
            throw new IllegalArgumentException(String.format("Contact does not exist for deletion."));
        }
        else {contactRepository.remove(id);}
	} 
	
	//update a contact using this function with the existing id
	public static boolean update(String id, Contact updated) {
		Contact existing = contactRepository.get(id);
		
		if (existing == null) return false;
		
		existing.setFirstName(updated.getFirstName());
		existing.setLastName(updated.getLastName());
		existing.setPhone(updated.getPhoneNum());
		existing.setAddress(updated.getAddress());
		
		return true;
	}	
	
}