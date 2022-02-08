package com.OnlineRationCard_SlotBooking_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.OnlineRationCard_SlotBooking_System.dao.RegistrationDAOInterface;
import com.OnlineRationCard_SlotBooking_System.entity.RationUser;


@Service
@Transactional
public class RegistrationService implements RegistrationServiceInterface {
	@Autowired
	private RegistrationDAOInterface rd;
	@Override
	public int createProfileService(RationUser ru) {
		rd.save(ru);
		return 1;
	}

}
