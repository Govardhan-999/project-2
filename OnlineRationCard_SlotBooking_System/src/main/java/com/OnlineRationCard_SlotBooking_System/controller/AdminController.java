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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.OnlineRationCard_SlotBooking_System.entity.AdminEntity;
import com.OnlineRationCard_SlotBooking_System.entity.AssignShopTODealerEntity;
import com.OnlineRationCard_SlotBooking_System.entity.DealerEntity;
import com.OnlineRationCard_SlotBooking_System.entity.ShopEntity;
import com.OnlineRationCard_SlotBooking_System.service.AdminServiceInterface;

@RestController 
public class AdminController {

	@Autowired
	private  AdminServiceInterface rs;
	
	private Logger log=Logger.getLogger("AdminController");

	AdminEntity au;
	DealerEntity du;
	@CrossOrigin("http://localhost:10012")
	@PostMapping("adminLogin")
	//adminLogin
	public String adminLogin(@RequestBody AdminEntity rd) throws Exception
	{
		log.info("inside adminLogin method at "+LocalDate.now());
		String tmp_EmailId=rd.getEmail();
		String tmp_Pass=rd.getPassword();

		if(tmp_EmailId !=null && tmp_Pass!=null)
		{
			au=rs.loginService(tmp_EmailId,tmp_Pass);
		}

		if(au!=null)
		{
			return "Admin Signed In Successfully";
		}
		else
		{
			throw new Exception(" login failed due to invalid credentials... please Enter correct user id and password");
		}
	}

	// Add Dealer
	@PostMapping("AddDealer")
	public String AddDealer(@RequestBody DealerEntity de) {
		log.info("inside AddDealer method at "+LocalDate.now());

		int i=rs.AddDealerService(de);
		if(i>0) {
			return " Dealer Added Successfully";
		}
		else {
			return "could not Add Dealer";
		}
	}

	//Show Dealer
	@GetMapping("ShowDealers")
	public List<DealerEntity> showDealers(){
		log.info("inside ShowDealers method at "+LocalDate.now());
		List<DealerEntity> ll=rs.showDealersService();
		return ll;
	}

	//Update Dealer
	@PutMapping("UpdateDealer/{uid}")
	public String updateDealer(@PathVariable("uid") Integer userid,@RequestBody DealerEntity fb) {
		log.info("inside UpdateDealer method at "+LocalDate.now());
		fb.setAreaCode(userid);
		int i=rs.updateDealerService(fb);
		return "Updated Dealer Details";
	}

	//Delete Dealer
	@DeleteMapping("deleteDealer/{uid}")
	public String deleteDealer(@PathVariable("uid") int userid) {
		log.info("inside deleteDealer method at "+LocalDate.now());
		DealerEntity de=new DealerEntity();
		de.setAreaCode(userid);
		rs.deleteDealerService(de);
		return "Dealer deleted";
	}



	//Add Shop
	@PostMapping("AddShop")
	public String AddShop(@RequestBody ShopEntity se) {
		log.info("inside AddShop method at "+LocalDate.now());
		int i=rs.AddShopService(se);
		if(i>0) {
			return " Shop Added Successfully";
		}
		else {
			return "could not Add Shop";
		}
	}

	//Show Shops
	@GetMapping("ShowShops")
	public List<ShopEntity> showShops(){
		log.info("inside ShowShops method at "+LocalDate.now());
		List<ShopEntity> ll=rs.showShopsService();
		return ll;
	}

	//Update Shop Deatils
	@PutMapping("UpdateShop/{uid}")
	public String updateShop(@PathVariable("uid") int userid,@RequestBody ShopEntity sdd) {
		log.info("inside  updateShop method at "+LocalDate.now());
		sdd.setAreaCode(userid);
		int i=rs.updateShopService(sdd);
		return "Updated Shop Deatils";
	}

	//Delete Shop
	@DeleteMapping("deleteShop/{uid}")
	public String deleteShop(@PathVariable("uid") int userid) {
		log.info("inside   deleteShop method at "+LocalDate.now());
		ShopEntity se=new ShopEntity();
		se.setAreaCode(userid);
		rs.deleteShopService(se);
		return "Shop deleted";
	}

	//AssginDealerToShop
	@PostMapping("AssginDealerToShop")
	public String assginDealerToShop(@RequestBody AssignShopTODealerEntity as) throws Exception
	{
		log.info("inside  AssginDealerToShop method at "+LocalDate.now());
		int su=rs.assginDealerToShopService(as);

		if(su!=0)
		{
			return "Assigned Dealer to shop Successfully";
		}
		else
		{
			throw new Exception("assigned failed");
		}
	}

	//AssginDealerToShop
	@GetMapping("ShowAssginedDealerToShop")
	public List<AssignShopTODealerEntity> showAssginedDealerToShops(){
		log.info("inside ShowAssginedDealerToShop method at "+LocalDate.now());
		List<AssignShopTODealerEntity> ll=rs.showAssginedDealerToShopsService();
		return ll;
	}

	//DeleteAssginedDealerToShop
	@DeleteMapping("deleteAssginedDealerToShop/{uid}")
	public String deleteAssginedDealerToShop(@PathVariable("uid") int assignedCode) {
		log.info("inside deleteAssginedDealerToShop method at "+LocalDate.now());
		AssignShopTODealerEntity se=new AssignShopTODealerEntity();
		se.setAreaCode(assignedCode);
		rs.deleteAssginedDealerToShopService(se);
		return "Deleted Assgined Dealer To Shop";
	}

	//logout
	@GetMapping("AdminLogOut")
	public String logout(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		session.invalidate(); 
		return "Admin LogOut Successfully" ;
	}

}