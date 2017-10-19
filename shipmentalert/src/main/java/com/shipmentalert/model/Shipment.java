package com.shipmentalert.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Shipment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int shipmentId;
	private LocalDateTime pickUpDate;
	private LocalDateTime deliberyDtae;
	private Address origin;
	private Address destination;
	private Carrier carrier;
	private String commodity;
	private double weight;

	public Shipment() {
	}

	public Shipment(int shipmentId, LocalDateTime pickUpDate, LocalDateTime deliberyDtae, Address origin,
			Address destination, Carrier carrier, String commodity, double weight) {

		this.shipmentId = shipmentId;
		this.pickUpDate = pickUpDate;
		this.deliberyDtae = deliberyDtae;
		this.origin = origin;
		this.destination = destination;
		this.carrier = carrier;
		this.commodity = commodity;
		this.weight = weight;
	}

	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public LocalDateTime getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(LocalDateTime pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public LocalDateTime getDeliberyDtae() {
		return deliberyDtae;
	}

	public void setDeliberyDtae(LocalDateTime deliberyDtae) {
		this.deliberyDtae = deliberyDtae;
	}

	public Address getOrigin() {
		return origin;
	}

	public void setOrigin(Address origin) {
		this.origin = origin;
	}

	public Address getDestination() {
		return destination;
	}

	public void setDestination(Address destination) {
		this.destination = destination;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ID: " + shipmentId + " pickUpDate: " + pickUpDate + " DeliveryDate:" + deliberyDtae + " Origin: "
				+ origin + " Destination: " + destination + " Carrier: " + carrier + " Commodity: " + commodity
				+ " Weight: " + weight;
	}

}
