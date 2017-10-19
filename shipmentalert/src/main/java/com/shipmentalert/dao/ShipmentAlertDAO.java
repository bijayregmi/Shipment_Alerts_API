package com.shipmentalert.dao;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.shipmentalert.model.Address;
import com.shipmentalert.model.Carrier;
import com.shipmentalert.model.Shipment;

@Repository
public class ShipmentAlertDAO {

	List<Shipment> shipments;

	public ShipmentAlertDAO() {
		shipments = new ArrayList<>();

		// this data does not have carrier(Carrier.NULL) and satisfied Danger
		// condition
		shipments.add(new Shipment(0, LocalDateTime.of(2017, Month.OCTOBER, 17, 23, 30, 30),
				LocalDateTime.of(2017, Month.OCTOBER, 18, 10, 10, 30),
				new Address("1000 N 4th Street", "IOWA", "Fairfield", 57568),
				new Address("1000 N 4th Street", "New Jersey", "New Jersey", 57568), Carrier.NULL, "Paper Documents",
				0.1));

		// this data has carrier FedEx (Carrier.FedEx)
		shipments.add(new Shipment(1, LocalDateTime.of(2017, Month.OCTOBER, 28, 1, 00, 30),
				LocalDateTime.of(2017, Month.OCTOBER, 19, 11, 52, 30),
				new Address("1000 N 4th Street", "IOWA", "Fairfield", 57568),
				new Address("1000 N 4th Street", "New Jersey", "New Jersey", 57568), Carrier.FedEx, "Mobile", 0.3));

		// this data does not have carrier(Carrier.NULL) and satisfied Warning
		// condition
		shipments.add(new Shipment(2, LocalDateTime.of(2017, Month.OCTOBER, 18, 23, 30, 30),
				LocalDateTime.of(2017, Month.OCTOBER, 18, 10, 10, 30),
				new Address("1000 N 4th Street", "IOWA", "Fairfield", 57568),
				new Address("1000 N 4th Street", "New Jersey", "New Jersey", 57568), Carrier.NULL, "Laptop", 2));

		// this data has carrier UPS(Carrier.UPS)
		shipments.add(new Shipment(3, LocalDateTime.of(2017, Month.OCTOBER, 19, 23, 30, 30),
				LocalDateTime.of(2017, Month.OCTOBER, 19, 11, 52, 30),
				new Address("1000 N 4th Street", "IOWA", "Fairfield", 57568),
				new Address("1000 N 4th Street", "New Jersey", "New Jersey", 57568), Carrier.UPS, "Mattress", 45));
	}

	public List<Shipment> getWarningList() {

		List<Shipment> result = new ArrayList<>();
		for (Shipment shipment : getNonBookedShipments()) {

			LocalDateTime pickUpDateTime = shipment.getPickUpDate();
			if (checkTimeDiffernce(24, pickUpDateTime)) {
				result.add(shipment);
			}

		}

		return result.size() > 0 ? result : null;
	}

	public List<Shipment> getDangerList() {
		List<Shipment> result = new ArrayList<>();
		for (Shipment shipment : getNonBookedShipments()) {

			LocalDateTime pickUpDateTime = shipment.getPickUpDate();
			if (checkTimeDiffernce(2, pickUpDateTime)) {
				result.add(shipment);
			}

		}

		return result.size() > 0 ? result : null;
	}

	// method to provide list of shipments that do not have carriers booked on
	// them.
	private List<Shipment> getNonBookedShipments() {

		List<Shipment> result = new ArrayList<>();
		for (Shipment shipment : shipments) {

			if (shipment.getCarrier() == Carrier.NULL)
				result.add(shipment);

		}

		return result;

	}

	private boolean checkTimeDiffernce(int diff, LocalDateTime pickUpDateTime) {

		LocalDateTime fromDateTime = LocalDateTime.of(2017, Month.OCTOBER, 17, 23, 30, 30);// this
																							// is
																							// current
																							// date
																							// ,
																							// LocalDateTime.now();
		LocalDateTime toDateTime = pickUpDateTime;

		LocalDateTime tempDateTime = LocalDateTime.from(fromDateTime);

		long years = tempDateTime.until(toDateTime, ChronoUnit.YEARS);
		tempDateTime = tempDateTime.plusYears(years);

		long months = tempDateTime.until(toDateTime, ChronoUnit.MONTHS);
		tempDateTime = tempDateTime.plusMonths(months);

		long days = tempDateTime.until(toDateTime, ChronoUnit.DAYS);
		tempDateTime = tempDateTime.plusDays(days);

		long hours = tempDateTime.until(toDateTime, ChronoUnit.HOURS);
		tempDateTime = tempDateTime.plusHours(hours);

		long minutes = tempDateTime.until(toDateTime, ChronoUnit.MINUTES);
		tempDateTime = tempDateTime.plusMinutes(minutes);

		long seconds = tempDateTime.until(toDateTime, ChronoUnit.SECONDS);

		if (diff == 2) {

			if (years == 0 && months == 0 && days == 0 && hours < 2)
				return true;
		}

		if (diff == 24) {
			if (days == 1 && years == 0 && months == 0 && hours == 0 && minutes == 0 && seconds == 0)
				return true;
		}
		return false;
	}

}
