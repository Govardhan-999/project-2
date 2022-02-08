package com.OnlineRationCard_SlotBooking_System.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.OnlineRationCard_SlotBooking_System.entity.AdminEntity;

@Repository
public interface AdminDAOInterface extends JpaRepository<AdminEntity, String>{

    @Query("from  AdminEntity a where a.email=:em and a.password=:pw") 
	public AdminEntity logindao(@Param("em") String tmp_EmailId,@Param("pw") String tmp_Pass);


}



