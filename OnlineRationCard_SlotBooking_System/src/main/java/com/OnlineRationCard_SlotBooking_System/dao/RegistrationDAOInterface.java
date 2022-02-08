package com.OnlineRationCard_SlotBooking_System.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OnlineRationCard_SlotBooking_System.entity.RationUser;

 

@Repository
public interface RegistrationDAOInterface extends JpaRepository<RationUser, String>{

}
