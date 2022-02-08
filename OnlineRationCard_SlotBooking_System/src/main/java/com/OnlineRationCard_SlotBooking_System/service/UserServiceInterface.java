package com.OnlineRationCard_SlotBooking_System.service;

 
import java.util.List;

import com.OnlineRationCard_SlotBooking_System.entity.RationUser;
import com.OnlineRationCard_SlotBooking_System.entity.SlotBookingEntity;

public interface UserServiceInterface {

	RationUser userloginService(String tmp_EmailId, String tmp_Pass);

 

	int slotBookingService(SlotBookingEntity sbe);



	List<SlotBookingEntity> slotBookingService1(int areaCode);



	void cancelSlotService(SlotBookingEntity de);



 

}
