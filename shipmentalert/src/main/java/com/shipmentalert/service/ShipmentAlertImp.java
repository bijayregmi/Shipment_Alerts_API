package com.shipmentalert.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipmentalert.dao.ShipmentAlertDAO;
import com.shipmentalert.model.Shipment;
import com.shipmentalert.model.ShipmentAlert;

@Service
public class ShipmentAlertImp implements ShipmentAlertService {

	@Autowired
	ShipmentAlertDAO shipmentAlertDAO;

	@Override
	public List<ShipmentAlert> getShipmentAlert() {

		List<ShipmentAlert> result = new ArrayList<>();

		if (getWarningList() != null)
			result.add(new ShipmentAlert(getWarningList(), "Warning"));
		if (getDangerList() != null)
			result.add(new ShipmentAlert(getDangerList(), "Danger"));

		return result;
	}

	private List<Shipment> getWarningList() {
		return shipmentAlertDAO.getWarningList();
	}

	private List<Shipment> getDangerList() {
		return shipmentAlertDAO.getDangerList();
	}

}
