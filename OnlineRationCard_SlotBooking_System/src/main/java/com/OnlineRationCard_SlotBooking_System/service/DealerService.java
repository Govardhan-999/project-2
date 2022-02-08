package com.OnlineRationCard_SlotBooking_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.OnlineRationCard_SlotBooking_System.dao.DealerDAOInterface;
import com.OnlineRationCard_SlotBooking_System.entity.DealerEntity;

@Service
@Transactional
public class DealerService implements DealerServiceInterface {

	@Autowired
	private DealerDAOInterface d1;
	@Override
	public DealerEntity dealerLoginService(String tmp_EmailId, String tmp_Pass) {
	 
		return d1.dealerlogindao(tmp_EmailId,tmp_Pass);
	}

}
