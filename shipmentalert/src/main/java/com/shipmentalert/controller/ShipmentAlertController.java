package com.shipmentalert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shipmentalert.model.ShipmentAlert;
import com.shipmentalert.service.ShipmentAlertService;

@RestController
public class ShipmentAlertController {

	@Autowired
	ShipmentAlertService shipmentAlertService;

	@GetMapping("/shipments")
	public List<ShipmentAlert> getShipments() {
		return shipmentAlertService.getShipmentAlert();

	}

}
