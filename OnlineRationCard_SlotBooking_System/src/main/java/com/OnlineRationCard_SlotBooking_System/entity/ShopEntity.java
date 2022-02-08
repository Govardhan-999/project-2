package com.OnlineRationCard_SlotBooking_System.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="ShopEntityTable")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class ShopEntity {

	@Id
	@Column(name="areaCode")
	private Integer areaCode;
	private String region;
	private int shop_id;
	private String shop_name;
	private long contactNumber;
	
	//@OneToOne(targetEntity = DealerEntity.class,cascade = CascadeType.ALL)
	//@JoinColumn(name="areaCode",referencedColumnName = "areaCode")
	//private DealerEntity dealer;
	
	//public DealerEntity getDealer() {
	//	return dealer;
	//}
	//public void setDealer(DealerEntity dealer) {
	//	this.dealer = dealer;
//	}
	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
 
}
