package com.OnlineRationCard_SlotBooking_System.service;

import java.util.List;

import com.OnlineRationCard_SlotBooking_System.entity.AdminEntity;
import com.OnlineRationCard_SlotBooking_System.entity.AssignShopTODealerEntity;
import com.OnlineRationCard_SlotBooking_System.entity.DealerEntity;
import com.OnlineRationCard_SlotBooking_System.entity.RationUser;
import com.OnlineRationCard_SlotBooking_System.entity.ShopEntity;

public interface AdminServiceInterface {

	 
	AdminEntity loginService(String tmp_EmailId, String tmp_Pass);
	
	int AddDealerService(DealerEntity de);

	List<DealerEntity> showDealersService();

	int updateDealerService(DealerEntity fb);

	void deleteDealerService(DealerEntity de);

	int AddShopService(ShopEntity se);

	List<ShopEntity> showShopsService();

	int updateShopService(ShopEntity sdd);

	void deleteShopService(ShopEntity se);

	int assginDealerToShopService(AssignShopTODealerEntity as);

	List<AssignShopTODealerEntity> showAssginedDealerToShopsService();

	void deleteAssginedDealerToShopService(AssignShopTODealerEntity se);

	List<AssignShopTODealerEntity> showAssginedDealerToShopsService1(int areaCode);

	List<DealerEntity> dealerService1(int areaCode);

 

	 
	 

	

	

}
