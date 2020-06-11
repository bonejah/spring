package hello;

public class Person {

	private String firstName;
	private String lastName;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String firstName, String lasstName) {
		super();
		this.firstName = firstName;
		this.lastName = lasstName;
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

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
