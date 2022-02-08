package com.OnlineRationCard_SlotBooking_System.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.OnlineRationCard_SlotBooking_System.entity.ShopEntity;
import com.OnlineRationCard_SlotBooking_System.entity.DealerEntity;


@Repository
public interface Admin_AddShop_DAOInterface extends JpaRepository<ShopEntity, Integer>{
	//@Query("select ShopEntityTable from ShopEntity,DealerEntity  where ShopEntity.areaCode=DealerEntity.areaCode")
	@Query("SELECT A.shop_id,A.shop_name,A.areaCode,A.region from ShopEntity A LEFT JOIN DealerEntity B on A.areaCode=B.areaCode")
	List<ShopEntity> assginDealerToShopDao();
   
	//@Query("SELECT a,b FROM a ShopEntity , b DealerEntity where a.areaCode==b.areaCode")
		//public ShopEntity assginDealerToShopDao(@Param("a") int areacode ); db=:

}



