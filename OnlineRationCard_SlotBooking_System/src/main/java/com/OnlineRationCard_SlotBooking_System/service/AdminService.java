package com.OnlineRationCard_SlotBooking_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.OnlineRationCard_SlotBooking_System.dao.AdminDAOInterface;
import com.OnlineRationCard_SlotBooking_System.dao.Admin_AddDealer_DAOInterface;
import com.OnlineRationCard_SlotBooking_System.dao.Admin_AddShop_DAOInterface;
import com.OnlineRationCard_SlotBooking_System.dao.Admin_AssignShop_dealerTOShop;
import com.OnlineRationCard_SlotBooking_System.entity.AdminEntity;
import com.OnlineRationCard_SlotBooking_System.entity.AssignShopTODealerEntity;
import com.OnlineRationCard_SlotBooking_System.entity.DealerEntity;
import com.OnlineRationCard_SlotBooking_System.entity.ShopEntity;

@Service
@Transactional
public class AdminService implements AdminServiceInterface {
	
	@Autowired
	private Admin_AddDealer_DAOInterface add;
	@Autowired
	private Admin_AddShop_DAOInterface sd;
	@Autowired
	private Admin_AssignShop_dealerTOShop pd;
	@Autowired
	private AdminDAOInterface ad1;

	@Override
	public AdminEntity loginService(String tmp_EmailId, String tmp_Pass) {

		return ad1.logindao(tmp_EmailId,tmp_Pass);
	} 

	@Override
	public int AddDealerService(DealerEntity de) {
		add.save(de);
		return 1;
	}

	@Override
	public List<DealerEntity> showDealersService() {

		return add.findAll();
	}
	@Override
	public int updateDealerService(DealerEntity fb) {
		add.saveAndFlush(fb);
		return 1;
	}
	@Override
	public void deleteDealerService(DealerEntity de) {
		add.delete(de);
	}

	@Override
	public int AddShopService(ShopEntity se) {
		sd.save(se);
		return 1;
	}
	@Override
	public List<ShopEntity> showShopsService() {

		return sd.findAll();
	}
	@Override
	public int updateShopService(ShopEntity sdd) {
		sd.saveAndFlush(sdd);
		return 1;
	}
	@Override
	public void deleteShopService(ShopEntity se) {
		sd.delete(se);

	}

	@Override
	public int assginDealerToShopService(AssignShopTODealerEntity as) {
		pd.save(as);
		return 1 ;
			
	}

	@Override
	public List<AssignShopTODealerEntity> showAssginedDealerToShopsService() {
	 
		return pd.findAll();
	}

	@Override
	public void deleteAssginedDealerToShopService(AssignShopTODealerEntity se) {
		pd.delete(se);
	}

	@Override
	public List<AssignShopTODealerEntity> showAssginedDealerToShopsService1(int areaCode) {
		 
		return pd.findByAreacode(areaCode);
	}

	@Override
	public List<DealerEntity> dealerService1(int areaCode) {
		 
		return  add.findByAreacode(areaCode);
	}

	 
}
