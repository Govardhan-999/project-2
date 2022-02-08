package com.OnlineRationCard_SlotBooking_System.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.OnlineRationCard_SlotBooking_System.entity.DealerEntity;
 
@Repository
public interface Admin_AddDealer_DAOInterface extends JpaRepository<DealerEntity, String>{
	 @Query("from  DealerEntity ff where ff.areaCode=:cc")
	List<DealerEntity> findByAreacode(@Param("cc") int areaCode);

}



