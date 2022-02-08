package com.OnlineRationCard_SlotBooking_System.entity;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.MultiValueMap;

public class SlotData1 {

	private final List<SlotBookingEntity> slotdetails;
	   private final List<DealerEntity> dealerdeatails;
	public SlotData1(List<SlotBookingEntity> slotdetails, List<DealerEntity> dealerdeatails) {
		super();
		this.slotdetails = slotdetails;
		this.dealerdeatails = dealerdeatails;
	}
	public List<SlotBookingEntity> getSlotdetails() {
		return slotdetails;
	}
	public List<DealerEntity> getDealerdeatails() {
		return dealerdeatails;
	}
	   
	   
	 
 
}
