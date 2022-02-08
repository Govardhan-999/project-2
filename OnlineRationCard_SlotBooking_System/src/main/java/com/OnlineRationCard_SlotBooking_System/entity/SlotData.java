package com.OnlineRationCard_SlotBooking_System.entity;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.MultiValueMap;

public class SlotData  {

	
	private final List<SlotBookingEntity> topics;
	   private final List<AssignShopTODealerEntity> roles;
	public SlotData(List<SlotBookingEntity> topics, List<AssignShopTODealerEntity> roles) {
		super();
		this.topics = topics;
		this.roles = roles;
	}
	public List<SlotBookingEntity> getTopics() {
		return topics;
	}
	public List<AssignShopTODealerEntity> getRoles() {
		return roles;
	}
	
	
	 
}
