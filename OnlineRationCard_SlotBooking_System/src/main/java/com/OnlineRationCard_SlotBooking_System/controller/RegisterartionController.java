package com.OnlineRationCard_SlotBooking_System.controller;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineRationCard_SlotBooking_System.entity.RationUser;
import com.OnlineRationCard_SlotBooking_System.service.RegistrationServiceInterface;
 
@RestController
public class RegisterartionController {

	@Autowired
	private RegistrationServiceInterface rs;


	private Logger log=Logger.getLogger("RegisterartionController");
	@CrossOrigin("http://localhost:10012")
	@PostMapping("createUser")
	public String createProfile(@RequestBody RationUser ru) {

		log.info("inside create profile method at "+LocalDate.now());

		int i=rs.createProfileService(ru);
		if(i>0) {
			return "profile created";
		}
		else {
			return "could not create profile";
		}

	}

}
