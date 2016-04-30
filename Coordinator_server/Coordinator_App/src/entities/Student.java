package entities;

import java.io.Serializable;

public class Student extends Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String phoneNumber;
	private String pickUpAddress;
	private String dropOffAddress;
	private int numberOfClients;
	
	public Student(String name, String id, String phoneNumber ,String pickUpAddress, String dropOffAddress,int numberOfClients) {
		super(id, name);
		this.phoneNumber = phoneNumber;
		this.pickUpAddress = pickUpAddress;
		this.dropOffAddress = dropOffAddress;
		this.numberOfClients = numberOfClients;
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getDropOffAddress() {
		return dropOffAddress;
	}
	
	public String getPickUpAddress() {
		return pickUpAddress;
	}
	
	public int getNumberOfClients() {
		return numberOfClients;
	}
}
