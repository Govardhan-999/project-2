package com.OnlineRationCard_SlotBooking_System.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.OnlineRationCard_SlotBooking_System.entity.DealerEntity;
import com.OnlineRationCard_SlotBooking_System.entity.Myappoitments;
import com.OnlineRationCard_SlotBooking_System.entity.SlotBookingEntity;
import com.OnlineRationCard_SlotBooking_System.entity.SlotData1;
import com.OnlineRationCard_SlotBooking_System.service.DealerServiceInterface;
import com.OnlineRationCard_SlotBooking_System.service.UserServiceInterface;

@RestController
public class DealerController {
	
	@Autowired
	private DealerServiceInterface ds;
	@Autowired
	private UserServiceInterface us;
	private Logger log=Logger.getLogger("DealerController");
	 DealerEntity de;
	 @CrossOrigin("http://localhost:10012")
	@PostMapping("DealerLogin")
	//adminLogin
	public String dealerLogin(@RequestBody DealerEntity d) throws Exception
	{
		log.info("inside dealerLogin method at "+LocalDate.now());
		String tmp_EmailId=d.getMail_ID();
		String tmp_Pass=d.getDealer_name();

		if(tmp_EmailId !=null && tmp_Pass!=null)
		{
			de=ds.dealerLoginService(tmp_EmailId,tmp_Pass);
		}

		if(de!=null)
		{
			return "Dealer Signed In Successfully";
		}
		else
		{
			throw new Exception(" login failed due to invalid credentials... please Enter correct user id and passwordUserService.java");
		}
	}
	
	//show My Appoitments
	
	 @GetMapping("showMyAppoitments/{uid}")
		public ResponseEntity showSlotBookingDeatails1(@PathVariable(value="uid") int areaCode) throws Exception
	{
		 log.info("inside showMyAppoitments method at "+LocalDate.now());
		List<SlotBookingEntity> slotdetails =  us.slotBookingService1(areaCode);
		 
		 return new ResponseEntity( new Myappoitments(slotdetails), HttpStatus.OK );}
		 
	//logout
		@GetMapping("DealerLogOut")
		public String logout(){
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			session.invalidate(); 
			return "Dealer LogOut Successfully" ;
		}


}
