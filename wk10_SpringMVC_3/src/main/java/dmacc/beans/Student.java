package dmacc.beans;

public class Student {
	private long id;
	private String firstname;
	private String lastname;
	private String make;
	private String model;
	private String color;
	private String platenumber;
	
	
	public Student() {
		super();
	}
	
	
	public Student(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}


	public Student(String firstname, String lastname, String make, String model, String color, String platenumber) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.make = make;
		this.model = model;
		this.color = color;
		this.platenumber = platenumber;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getPlatenumber() {
		return platenumber;
	}


	public void setPlatenumber(String platenumber) {
		this.platenumber = platenumber;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", make=" + make
				+ ", model=" + model + ", color=" + color + ", platenumber=" + platenumber + "]";
	}
	

}
