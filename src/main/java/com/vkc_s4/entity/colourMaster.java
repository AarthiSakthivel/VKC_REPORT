//package com.vkc_s4.entity;
//
//import java.sql.Timestamp;
//import java.util.Date;
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
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "colour_master")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class colourMaster {
//
//	@Id
//	@GeneratedValue(strategy =GenerationType.IDENTITY)
//	private int id;
//
//	@Column(name = "colour_code")
//	private String colourcode;
//	
//	@Column(name = "colour_name")
//	private String colourname;
//
//	@Column(name = "remark")
//	private String remark;
//
//	@CreationTimestamp
//	private Timestamp date;
//
//	@Column(name = "is_delete")
//	private boolean isDelete = false;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getColourcode() {
//		return colourcode;
//	}
//
//	public void setColourcode(String colourcode) {
//		this.colourcode = colourcode;
//	}
//
//	public String getColourname() {
//		return colourname;
//	}
//
//	public void setColourname(String colourname) {
//		this.colourname = colourname;
//	}
//
//	public String getRemark() {
//		return remark;
//	}
//
//	public void setRemark(String remark) {
//		this.remark = remark;
//	}
//
//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = (Timestamp) date;
//	}
//
//	public boolean isDelete() {
//		return isDelete;
//	}
//
//	public void setDelete(boolean isDelete) {
//		this.isDelete = isDelete;
//	}
//
//	@Override
//	public String toString() {
//		return "colourMapping [id=" + id + ", colourcode=" + colourcode + ", colourname=" + colourname + ", remark="
//				+ remark + ", date=" + date + ", isDelete=" + isDelete + "]";
//	}
//
//}
