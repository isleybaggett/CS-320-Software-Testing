package cs320.Contact;


public class Contact {
	String id;
	String firstName;
	String lastName;
	String phoneNum;
	String address;
	
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phone;
		this.address = address;
		
		checker();
	}
	
	//Checks to make sure all required information meets the laid out requirements
	public void checker() {
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("ID cannot equal null and must be 10 or less characters.");
		}
		
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First Name cannot equal null and must be 10 or less characters.");
		}
		
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Last name cannot equal null and must be 10 or less characters.");
		}
		
		if(phoneNum == null || phoneNum.length() != 10) {
			throw new IllegalArgumentException("Phone number must be 10 digits.");
		}
		
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address cannot exceed 30 characters.");
		}
		
		for (int i = 0; i < phoneNum.length(); i++) {

            //If we find a non-digit character we return false.
            if (!Character.isDigit(phoneNum.charAt(i)))
            	throw new IllegalArgumentException("Invalid input");
        }

	}
	
	//getters and setters 
	//no setter for ID so that it cannot be modified 
	public String getID() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhone(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
		
}
