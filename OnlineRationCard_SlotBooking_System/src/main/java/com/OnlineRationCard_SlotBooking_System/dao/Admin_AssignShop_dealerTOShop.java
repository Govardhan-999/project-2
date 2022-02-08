package com.OnlineRationCard_SlotBooking_System.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.OnlineRationCard_SlotBooking_System.entity.ShopEntity;
import com.OnlineRationCard_SlotBooking_System.entity.AssignShopTODealerEntity;
import com.OnlineRationCard_SlotBooking_System.entity.DealerEntity;


@Repository
public interface Admin_AssignShop_dealerTOShop extends JpaRepository<AssignShopTODealerEntity, String>{
	 @Query("from  AssignShopTODealerEntity ff where ff.areaCode=:cc")
   List<AssignShopTODealerEntity> findByAreacode(@Param("cc") int areaCode);
	
}



