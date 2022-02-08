package com.OnlineRationCard_SlotBooking_System.entity;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.MultiValueMap;

public class Myappoitments {

	private final List<SlotBookingEntity> slotdetails;

	public Myappoitments(List<SlotBookingEntity> slotdetails) {
		super();
		this.slotdetails = slotdetails;
	}

	public List<SlotBookingEntity> getSlotdetails() {
		return slotdetails;
	}
	  
	}
	   
	   
	 
 
