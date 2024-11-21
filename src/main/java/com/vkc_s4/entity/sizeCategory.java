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
//@Entity
//@Table(name="size_category")
//public class sizeCategory {
//	
//	@Id
//	@GeneratedValue(strategy =GenerationType.IDENTITY)
//	private int id;
//
//	@Column(name = "size_category_code")
//	private String size_category_code;
//	
//	@Column(name = "size_category_name")
//	private String size_category_name;
//
//	@Column(name = "size_category_remark")
//	private String size_category_remark;
//
//	@CreationTimestamp
//	@Column(name = "size_category_date")
//	private Timestamp size_category_date;
//
//	@Column(name = "size_category_is_delete")
//	private boolean size_category_is_delete = false;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getSize_category_code() {
//		return size_category_code;
//	}
//
//	public void setSize_category_code(String size_category_code) {
//		this.size_category_code = size_category_code;
//	}
//
//	public String getSize_category_name() {
//		return size_category_name;
//	}
//
//	public void setSize_category_name(String size_category_name) {
//		this.size_category_name = size_category_name;
//	}
//
//	public String getSize_category_remark() {
//		return size_category_remark;
//	}
//
//	public void setSize_category_remark(String size_category_remark) {
//		this.size_category_remark = size_category_remark;
//	}
//
//	public Timestamp getSize_category_date() {
//		return size_category_date;
//	}
//
//	public void setSize_category_date(Timestamp size_category_date) {
//		this.size_category_date = size_category_date;
//	}
//
//	public boolean isSize_category_is_delete() {
//		return size_category_is_delete;
//	}
//
//	public void setSize_category_is_delete(boolean size_category_is_delete) {
//		this.size_category_is_delete = size_category_is_delete;
//	}
//
//	@Override
//	public String toString() {
//		return "sizeCategory [id=" + id + ", size_category_code=" + size_category_code + ", size_category_name="
//				+ size_category_name + ", size_category_remark=" + size_category_remark + ", size_category_date="
//				+ size_category_date + ", size_category_is_delete=" + size_category_is_delete + "]";
//	}
//
//	
//	
//	
//	
//
//}
