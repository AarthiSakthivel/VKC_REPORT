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
//@Table(name="numberofpairs")
//public class numberOfPairs {
//
//	@Id
//	@GeneratedValue(strategy =GenerationType.IDENTITY)
////	size_combination_id
//	@Column(name = "numberofpairs_id")
//	private int numberofpairs_id;
//
//	@Column(name = "numberofpairs_code")
//	private String numberofpairs_code;
//	
//	@Column(name = "numberofpairs_name")
//	private String numberofpairs_name;
//
//	@Column(name = "numberofpairs_remark")
//	private String numberofpairs_remark;
//
//	@CreationTimestamp
//	@Column(name = "numberofpairs_date")
//	private Timestamp numberofpairs_date;
//
//	@Column(name = "numberofpairs_isdelete")
//	private boolean numberofpairs_isdelete = false;
//
//	public int getNumberofpairs_id() {
//		return numberofpairs_id;
//	}
//
//	public void setNumberofpairs_id(int numberofpairs_id) {
//		this.numberofpairs_id = numberofpairs_id;
//	}
//
//	public String getNumberofpairs_code() {
//		return numberofpairs_code;
//	}
//
//	public void setNumberofpairs_code(String numberofpairs_code) {
//		this.numberofpairs_code = numberofpairs_code;
//	}
//
//	public String getNumberofpairs_name() {
//		return numberofpairs_name;
//	}
//
//	public void setNumberofpairs_name(String numberofpairs_name) {
//		this.numberofpairs_name = numberofpairs_name;
//	}
//
//	public String getNumberofpairs_remark() {
//		return numberofpairs_remark;
//	}
//
//	public void setNumberofpairs_remark(String numberofpairs_remark) {
//		this.numberofpairs_remark = numberofpairs_remark;
//	}
//
//	public Timestamp getNumberofpairs_date() {
//		return numberofpairs_date;
//	}
//
//	public void setNumberofpairs_date(Timestamp numberofpairs_date) {
//		this.numberofpairs_date = numberofpairs_date;
//	}
//
//	public boolean isNumberofpairs_isdelete() {
//		return numberofpairs_isdelete;
//	}
//
//	public void setNumberofpairs_isdelete(boolean numberofpairs_isdelete) {
//		this.numberofpairs_isdelete = numberofpairs_isdelete;
//	}
//
//	@Override
//	public String toString() {
//		return "numberOfPairs [numberofpairs_id=" + numberofpairs_id + ", numberofpairs_code=" + numberofpairs_code
//				+ ", numberofpairs_name=" + numberofpairs_name + ", numberofpairs_remark=" + numberofpairs_remark
//				+ ", numberofpairs_date=" + numberofpairs_date + ", numberofpairs_isdelete=" + numberofpairs_isdelete
//				+ "]";
//	}
//
//	
//	
//}
