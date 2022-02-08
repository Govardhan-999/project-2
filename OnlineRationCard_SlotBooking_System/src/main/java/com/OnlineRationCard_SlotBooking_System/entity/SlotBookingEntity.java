package com.OnlineRationCard_SlotBooking_System.entity;

 
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name ="SlotBookingEntity33")
@NoArgsConstructor

public class SlotBookingEntity {

	private @Id @GeneratedValue Long id;
	private String name;
	private Integer areaCode; 
	private String slot_timing;
	private LocalDate visitingDate;
	//@OneToOne(targetEntity = AssignShopTODealerEntity.class,cascade = CascadeType.ALL)
	//@JoinColumn(foreignKey ="areacode" )
	//private AssignShopTODealerEntity assignShopTODealer;
 
   //public AssignShopTODealerEntity getAssignShopTODealer() {
	//	return assignShopTODealer;
	//}
	
	public Integer getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 
	public LocalDate getVisitingDate() {
		return visitingDate;
	}
	public void setVisitingDate(LocalDate visitingDate) {
		this.visitingDate = visitingDate;
	}
	public String getSlot_timing() {
		return slot_timing;
	}
	public void setSlot_timing(String slot_timing) {
		this.slot_timing = slot_timing;
	}
	 
 
 
}
