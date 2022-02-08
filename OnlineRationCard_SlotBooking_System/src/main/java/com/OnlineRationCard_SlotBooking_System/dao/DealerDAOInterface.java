package com.OnlineRationCard_SlotBooking_System.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.OnlineRationCard_SlotBooking_System.entity.DealerEntity;
 
@Repository
public interface DealerDAOInterface extends JpaRepository<DealerEntity, String> {
	@Query("from  DealerEntity  d where d.mail_ID=:em and d.dealer_name=:pw") 
	DealerEntity dealerlogindao(@Param("em") String tmp_EmailId,@Param("pw") String tmp_Pass);

}
