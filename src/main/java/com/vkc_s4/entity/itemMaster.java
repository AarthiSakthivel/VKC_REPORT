//package com.vkc_s4.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import lombok.Data;
//
//@Entity
//@Data
//@Table(name = "item_master")
//public class itemMaster {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	
//	@Column(name="material_type")
//	private String MaterialType;
//	@Column(name="material_number")
//	private String MaterialNumber;
//	@Column(name="material_type_classification")
//	private String MaterialTypeClassification;
//	@Column(name="articlenumber")
//	private String Articlenumber;
//	@Column(name="colourcode")
//	private String Colourcode;
//	@Column(name="size_category")
//	private String sizeCategory;
//	@Column(name="mrpindicator")
//	private String MRPindicator;
//	@Column(name="domestic_export_indication")
//	private String domesticExportIndication;
//	@Column(name="size_combination")
//	private String sizeCombination;
//	@Column(name="packingassortment")
//	private String packingassortment;
//	@Column(name="numberofpairs")
//	private String Numberofpairs;
//	@Column(name="item_master_is_delete")
//	private boolean isDelete=false;
//	
//	@Column(name="status")
//	private String Status="Pending";
//	@Column(name="sync_status")
//	private String syncStatus="Pending";
//	@Column(name="sync_error")
//	private String syncError="";
//	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getMaterialType() {
//		return MaterialType;
//	}
//	public void setMaterialType(String materialType) {
//		MaterialType = materialType;
//	}
//	public String getMaterialNumber() {
//		return MaterialNumber;
//	}
//	public void setMaterialNumber(String materialNumber) {
//		MaterialNumber = materialNumber;
//	}
//	public String getMaterialTypeClassification() {
//		return MaterialTypeClassification;
//	}
//	public void setMaterialTypeClassification(String materialTypeClassification) {
//		MaterialTypeClassification = materialTypeClassification;
//	}
//	public String getArticlenumber() {
//		return Articlenumber;
//	}
//	public void setArticlenumber(String articlenumber) {
//		Articlenumber = articlenumber;
//	}
//	public String getColourcode() {
//		return Colourcode;
//	}
//	public void setColourcode(String colourcode) {
//		Colourcode = colourcode;
//	}
//	public String getSizeCategory() {
//		return sizeCategory;
//	}
//	public void setSizeCategory(String sizeCategory) {
//		this.sizeCategory = sizeCategory;
//	}
//	public String getMRPindicator() {
//		return MRPindicator;
//	}
//	public void setMRPindicator(String mRPindicator) {
//		MRPindicator = mRPindicator;
//	}
//	public String getDomesticExportIndication() {
//		return domesticExportIndication;
//	}
//	public void setDomesticExportIndication(String domesticExportIndication) {
//		this.domesticExportIndication = domesticExportIndication;
//	}
//	public String getSizeCombination() {
//		return sizeCombination;
//	}
//	public void setSizeCombination(String sizeCombination) {
//		this.sizeCombination = sizeCombination;
//	}
//	public String getPackingassortment() {
//		return packingassortment;
//	}
//	public void setPackingassortment(String packingassortment) {
//		this.packingassortment = packingassortment;
//	}
//	public String getNumberofpairs() {
//		return Numberofpairs;
//	}
//	public void setNumberofpairs(String numberofpairs) {
//		Numberofpairs = numberofpairs;
//	}
//	@Override
//	public String toString() {
//		return "itemMaster [id=" + id + ", MaterialType=" + MaterialType + ", MaterialNumber=" + MaterialNumber
//				+ ", MaterialTypeClassification=" + MaterialTypeClassification + ", Articlenumber=" + Articlenumber
//				+ ", Colourcode=" + Colourcode + ", sizeCategory=" + sizeCategory + ", MRPindicator=" + MRPindicator
//				+ ", domesticExportIndication=" + domesticExportIndication + ", sizeCombination=" + sizeCombination
//				+ ", packingassortment=" + packingassortment + ", Numberofpairs=" + Numberofpairs + ", isDelete="
//				+ isDelete + ", Status=" + Status + ", syncStatus=" + syncStatus + ", syncError=" + syncError + "]";
//	}
//	
//	
//	
//}
