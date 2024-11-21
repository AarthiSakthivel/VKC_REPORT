package com.vkc_s4.master;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="company_master")
public class MasterCompanyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="company_code")
	private String companyCode;
	
	@Column(name="company_code_name")
	private String companyCodeName;
	
	@Column(name="created_by")
	private String createdBy;
	
	@CreationTimestamp
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@UpdateTimestamp
	@Column(name="updated_on")
	private Date updatedOn;
	

}