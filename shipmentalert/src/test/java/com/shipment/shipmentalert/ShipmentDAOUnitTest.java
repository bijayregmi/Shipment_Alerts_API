package com.shipment.shipmentalert;

import org.junit.Before;
import org.junit.Test;

import com.shipmentalert.dao.ShipmentAlertDAO;

public class ShipmentDAOUnitTest {

	ShipmentAlertDAO shipmentAlertDAO;

	@Before
	public void setUp() throws Exception {
		shipmentAlertDAO = new ShipmentAlertDAO();
	}

	@Test
	public void testGetWarningList() {

		System.out.println("++++++++++++++++++");
		System.out.println(shipmentAlertDAO.getWarningList());
		System.out.println("++++++++++++++++++");
	}

	@Test
	public void testGetDangerList() {
		System.out.println(shipmentAlertDAO.getDangerList());
		System.out.println("++++++++++++++++++");
	}

}
