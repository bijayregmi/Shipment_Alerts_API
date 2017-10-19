package com.shipmentalert.model;

import java.io.Serializable;

public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String street;
	private String state;
	private String city;
	private int zip;

	public Address() {

	}

	public Address(String street, String state, String city, int zip) {
		this.street = street;
		this.state = state;
		this.city = city;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Strret: " + street + "City: " + city + "State: " + state + "Zip: " + zip;
	}

}
