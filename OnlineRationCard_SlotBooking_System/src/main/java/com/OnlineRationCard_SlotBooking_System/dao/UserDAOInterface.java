package com.OnlineRationCard_SlotBooking_System.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.OnlineRationCard_SlotBooking_System.entity.RationUser;
import com.OnlineRationCard_SlotBooking_System.entity.SlotBookingEntity;
@Repository
public interface UserDAOInterface extends JpaRepository<RationUser, String> {

	@Query("from  RationUser r where r.email=:em and r.password=:pw") 
	RationUser userlogindao(@Param("em") String tmp_EmailId,@Param("em")String tmp_Pass);

	//@Query("select c from SlotBookingEntity c join AssignShopTODealerEntity r on c.areacode = r.assignedCode")
	//int slotBookingdao(SlotBookingEntity sbe) ;

	//pd.save(as);void save(SlotBookingEntity sbe);
 
	 
	}


