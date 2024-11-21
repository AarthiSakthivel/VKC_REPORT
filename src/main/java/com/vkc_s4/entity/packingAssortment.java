//package com.vkc_s4.entity;
//
//import java.sql.Timestamp;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.CreationTimestamp;
//
//@Entity
//@Table(name="packing_assortment")
//public class packingAssortment {
//
//	@Id
//	@GeneratedValue(strategy =GenerationType.IDENTITY)
////	size_combination_id
//	@Column(name = "packing_assortment_id")
//	private int packing_assortment_id;
//
//	@Column(name = "packing_assortment_code")
//	private String packing_assortment_code;
//	
//	@Column(name = "packing_assortment_name")
//	private String packing_assortment_name;
//
//	@Column(name = "packing_assortment_remark")
//	private String packing_assortment_remark;
//
//	@CreationTimestamp
//	@Column(name = "packing_assortment_date")
//	private Timestamp packing_assortment_date;
//
//	@Column(name = "packing_assortment_isdelete")
//	private boolean packing_assortment_isdelete = false;
//
//	public int getPacking_assortment_id() {
//		return packing_assortment_id;
//	}
//
//	public void setPacking_assortment_id(int packing_assortment_id) {
//		this.packing_assortment_id = packing_assortment_id;
//	}
//
//	public String getPacking_assortment_code() {
//		return packing_assortment_code;
//	}
//
//	public void setPacking_assortment_code(String packing_assortment_code) {
//		this.packing_assortment_code = packing_assortment_code;
//	}
//
//	public String getPacking_assortment_name() {
//		return packing_assortment_name;
//	}
//
//	public void setPacking_assortment_name(String packing_assortment_name) {
//		this.packing_assortment_name = packing_assortment_name;
//	}
//
//	public String getPacking_assortment_remark() {
//		return packing_assortment_remark;
//	}
//
//	public void setPacking_assortment_remark(String packing_assortment_remark) {
//		this.packing_assortment_remark = packing_assortment_remark;
//	}
//
//	public Timestamp getPacking_assortment_date() {
//		return packing_assortment_date;
//	}
//
//	public void setPacking_assortment_date(Timestamp packing_assortment_date) {
//		this.packing_assortment_date = packing_assortment_date;
//	}
//
//	public boolean isPacking_assortment_isdelete() {
//		return packing_assortment_isdelete;
//	}
//
//	public void setPacking_assortment_isdelete(boolean packing_assortment_isdelete) {
//		this.packing_assortment_isdelete = packing_assortment_isdelete;
//	}
//
//	@Override
//	public String toString() {
//		return "packingAssortment [packing_assortment_id=" + packing_assortment_id + ", packing_assortment_code="
//				+ packing_assortment_code + ", packing_assortment_name=" + packing_assortment_name
//				+ ", packing_assortment_remark=" + packing_assortment_remark + ", packing_assortment_date="
//				+ packing_assortment_date + ", packing_assortment_isdelete=" + packing_assortment_isdelete + "]";
//	}
//
//	
//}
