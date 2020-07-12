package mj223vn_assign2.Exercise1;
/**
 * Help class to test LinkedQueue
 * @author marcus
 * @since 2019-02-06
 *
 */

public class Applicants {
	String firstName;
	String lastName;
	int age = 0;
	
	public Applicants() {
		
	}
	
	public Applicants(String first, String last, int age) {
		this.firstName = first;
		this.lastName = last;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setAge(int age) {
		this.age =age;
	}
	
	public void setFirstName(String first) {
		this.firstName = first;
	}
	
	public void setLastName(String last) {
		this.lastName = last;
	}
	
	public String toString() {
		return firstName + " " + lastName + ", Age: " + age + "\n";
	}

}
