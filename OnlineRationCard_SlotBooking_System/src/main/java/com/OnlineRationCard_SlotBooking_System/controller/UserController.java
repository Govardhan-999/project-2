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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.OnlineRationCard_SlotBooking_System.entity.AdminEntity;
import com.OnlineRationCard_SlotBooking_System.entity.AssignShopTODealerEntity;
import com.OnlineRationCard_SlotBooking_System.entity.DealerEntity;
import com.OnlineRationCard_SlotBooking_System.entity.RationUser;
import com.OnlineRationCard_SlotBooking_System.entity.SlotBookingEntity;
import com.OnlineRationCard_SlotBooking_System.entity.SlotData;
import com.OnlineRationCard_SlotBooking_System.entity.SlotData1;
import com.OnlineRationCard_SlotBooking_System.service.AdminServiceInterface;
import com.OnlineRationCard_SlotBooking_System.service.UserServiceInterface;

@RestController 
public class UserController {

	@Autowired
	private UserServiceInterface us;
	@Autowired
	private AdminServiceInterface as;
	private Logger log=Logger.getLogger("UserController");
	RationUser au;
	SlotBookingEntity s1;
	@CrossOrigin("http://localhost:10012")
	@PostMapping("userLogin")
	//UserLogin
	public String userLogin(@RequestBody RationUser ru) throws Exception
	{
		log.info("inside userLogin method at "+LocalDate.now());
		String tmp_EmailId=ru.getEmail();
		String tmp_Pass=ru.getPassword();

		if(tmp_EmailId !=null && tmp_Pass!=null)
		{
			au=us.userloginService(tmp_EmailId,tmp_Pass);
		}

		if(au!=null)
		{
			return "User Signed In Successfully";
		}
		else
		{
			throw new Exception(" login failed due to invalid credentials... please Enter correct user id and password");
		}
	}

	//Slot booking 
	@PostMapping("SlotBooking")
	public String slotBooking(@RequestBody  SlotBookingEntity sbe) throws Exception
	{ 
		log.info("inside SlotBooking method at "+LocalDate.now());
		int i=us.slotBookingService(sbe); 

		if(i!=0)
		{
			return "Slot confirmed";
		}
		else
		{
			throw new Exception("Slot not confirmed");
		}
	}

	//showSlotBookingDeatails
	@GetMapping("showSlotBookingDeatails/{uid}")
	public ResponseEntity showSlotBookingDeatails(@PathVariable(value="uid") int areaCode) throws Exception
	{
		
		log.info("inside showSlotBooking method at "+LocalDate.now());
		List<SlotBookingEntity> topics =  us.slotBookingService1(areaCode);
		//String assignedCode=areaCode;
		List<AssignShopTODealerEntity> roles =as.showAssginedDealerToShopsService1(areaCode);
		return new ResponseEntity( new SlotData( topics, roles ), HttpStatus.OK );
		
		}


	//
	@GetMapping("showSlotBookingDeatails1/{uid}")
	public ResponseEntity showSlotBookingDeatails1(@PathVariable(value="uid") int areaCode) throws Exception
	{
		log.info("inside showSlotBookingDeatails-1 method at "+LocalDate.now());
		List<SlotBookingEntity> slotdetails =  us.slotBookingService1(areaCode);
		//String assignedCode=areaCode;
		List<DealerEntity> dealerdeatails =as.dealerService1(areaCode);
		return new ResponseEntity( new SlotData1( slotdetails,dealerdeatails), HttpStatus.OK );


	}

	@DeleteMapping("cancelSlot/{uid}")
	public String cancelSlot(@PathVariable("uid") Long Booking_id) {
		log.info("inside cancelSlot method at "+LocalDate.now());
		SlotBookingEntity de=new SlotBookingEntity();
		de.setId(Booking_id);
		//rs.deleteDealerService(de);
		us.cancelSlotService(de);
		return "Slot cancelled successfully....";
	}
	
	
	
	//UserLogout
	@GetMapping("UserLogOut")
	public String logout(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		session.invalidate(); 
		return "User LogOut Successfully" ;
	}


}
