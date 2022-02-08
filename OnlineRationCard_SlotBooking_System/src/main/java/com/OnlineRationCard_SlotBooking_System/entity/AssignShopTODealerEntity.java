package com.OnlineRationCard_SlotBooking_System.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="AssignShopTODealerEntity9")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class AssignShopTODealerEntity {

	@Id
	@Column(name="areaCode")
	private Integer areaCode;
	 
	@OneToOne(targetEntity = DealerEntity.class,cascade = CascadeType.ALL)
	//@JoinColumn(foreignKey ="areaCode")
	@ ForeignKey(name = "areaCode")
	//@JoinColumn(name="dealer_name",referencedColumnName = "dealer_name")
	 
	private DealerEntity dealer;
	
	@OneToOne(targetEntity = ShopEntity.class,cascade = CascadeType.ALL)
	//@JoinColumn(name="areaCode",referencedColumnName = "ShopAreaCode")
	@ ForeignKey(name = "areaCode")
	private ShopEntity shop;
	
	public DealerEntity getDealer() {
		return dealer;
	}
	 
	public Integer getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}

	public void setDealer(DealerEntity dealer) {
		this.dealer = dealer;
	}
	public ShopEntity getShop() {
		return shop;
	}
	public void setShop(ShopEntity shop) {
		this.shop = shop;
	}
	 
	 
 
}
