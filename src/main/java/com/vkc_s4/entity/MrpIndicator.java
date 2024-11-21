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
//@Table(name="mrp_indicator")
//@Entity
//public class MrpIndicator {
//
//	@Id
//	@GeneratedValue(strategy =GenerationType.IDENTITY)
//	private Integer id;
//
//	@Column(name = "mrp_indicator_code")
//	private String mrp_indicator_code;
//	
//	@Column(name = "mrp_indicator_name")
//	private String mrp_indicator_name;
//
//	@Column(name = "mrp_indicator_remark")
//	private String mrp_indicator_remark;
//
//	@CreationTimestamp
//	@Column(name="mrp_indicatorl_date")
//	private Timestamp mrp_indicatorl_date;
//
//	@Column(name = "mrp_indicator_isdelete")
//	private boolean mrp_indicator_isdelete = false;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getMrp_indicator_code() {
//		return mrp_indicator_code;
//	}
//
//	public void setMrp_indicator_code(String mrp_indicator_code) {
//		this.mrp_indicator_code = mrp_indicator_code;
//	}
//
//	public String getMrp_indicator_name() {
//		return mrp_indicator_name;
//	}
//
//	public void setMrp_indicator_name(String mrp_indicator_name) {
//		this.mrp_indicator_name = mrp_indicator_name;
//	}
//
//	public String getMrp_indicator_remark() {
//		return mrp_indicator_remark;
//	}
//
//	public void setMrp_indicator_remark(String mrp_indicator_remark) {
//		this.mrp_indicator_remark = mrp_indicator_remark;
//	}
//
//	public Timestamp getMrp_indicatorl_date() {
//		return mrp_indicatorl_date;
//	}
//
//	public void setMrp_indicatorl_date(Timestamp mrp_indicatorl_date) {
//		this.mrp_indicatorl_date = mrp_indicatorl_date;
//	}
//
//	public boolean isMrp_indicator_isdelete() {
//		return mrp_indicator_isdelete;
//	}
//
//	public void setMrp_indicator_isdelete(boolean mrp_indicator_isdelete) {
//		this.mrp_indicator_isdelete = mrp_indicator_isdelete;
//	}
//
//	@Override
//	public String toString() {
//		return "MrpIndicator [id=" + id + ", mrp_indicator_code=" + mrp_indicator_code + ", mrp_indicator_name="
//				+ mrp_indicator_name + ", mrp_indicator_remark=" + mrp_indicator_remark + ", mrp_indicatorl_date="
//				+ mrp_indicatorl_date + ", mrp_indicator_isdelete=" + mrp_indicator_isdelete + "]";
//	}
//
//	
//	
//}
