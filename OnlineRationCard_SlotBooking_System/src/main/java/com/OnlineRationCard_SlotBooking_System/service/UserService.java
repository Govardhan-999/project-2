package com.OnlineRationCard_SlotBooking_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.OnlineRationCard_SlotBooking_System.dao.UserDAOInterface;
import com.OnlineRationCard_SlotBooking_System.dao.UserDAoSlotBookingOInterface;
import com.OnlineRationCard_SlotBooking_System.entity.RationUser;
import com.OnlineRationCard_SlotBooking_System.entity.SlotBookingEntity;

@Service
@Transactional
public class UserService implements UserServiceInterface {

	
	@Autowired
	private UserDAOInterface ad1;
	@Autowired
	private UserDAoSlotBookingOInterface ad2;
	@Override
	public RationUser userloginService(String tmp_EmailId, String tmp_Pass) {
		 
		return ad1.userlogindao(tmp_EmailId,tmp_Pass);
	}
	 
	@Override
	public int slotBookingService(SlotBookingEntity sbe) {
	      ad2.save(sbe);
		return 1;
	 
	//return ad1.slotBookingdao(sbe);
	}

	@Override
	public List<SlotBookingEntity> slotBookingService1(int areaCode) {
		 
		return  ad2.findByAreacode(areaCode);
	}

	@Override
	public void cancelSlotService(SlotBookingEntity de) {
	 ad2.delete(de);
		
	}

 

	 
}
