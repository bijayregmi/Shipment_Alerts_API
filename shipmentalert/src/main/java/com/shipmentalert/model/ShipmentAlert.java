package com.shipmentalert.model;

import java.io.Serializable;
import java.util.List;

public class ShipmentAlert implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Shipment> shipments;
	private String alert;

	public ShipmentAlert() {
	}

	public ShipmentAlert(List<Shipment> shipments, String alert) {

		this.shipments = shipments;
		this.alert = alert;
	}

	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	@Override
	public String toString() {
		return "Shipments: " + shipments + "Alert :" + alert;
	}

}
