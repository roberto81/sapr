package org.sapr.entity;

public class Drone {
	private String code;
	private String brand;
	private String model;
	private Integer numberRotors;
	private String enginePower;
	private Float weight;
	
	public Drone(){
		
	}

	public Drone(String code, String brand, String model, Integer numberRotors, String enginePower, Float weight) {
		super();
		this.code = code;
		this.brand = brand;
		this.model = model;
		this.numberRotors = numberRotors;
		this.enginePower = enginePower;
		this.weight = weight;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getNumberRotors() {
		return numberRotors;
	}

	public void setNumberRotors(Integer numberRotors) {
		this.numberRotors = numberRotors;
	}

	public String getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(String enginePower) {
		this.enginePower = enginePower;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}
	
	
}
