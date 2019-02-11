package chapter11;

public class Car {
	private String model;
	public String owner;
	
	public Car() {
	}
	private Car(String model, String owner) {
		super();
		this.model = model;
		this.owner = owner;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
}
