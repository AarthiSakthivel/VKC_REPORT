package com.vkc_s4.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vkc_s4.master.MasterCompanyCodePropertiesDAO;
import com.vkc_s4.master.MasterCompanyEntity;
import com.vkc_s4.master.MasterCompanyRepository;
import com.vkc_s4.master.MasterCustomerGroupEntity;
import com.vkc_s4.master.MasterCustomerGroupPropertiesDAO;
import com.vkc_s4.master.MasterCustomerGroupRepository;
import com.vkc_s4.master.MasterMaterialGroupEntity;
import com.vkc_s4.master.MasterMaterialGroupPropertiesDAO;
import com.vkc_s4.master.MasterMaterialGroupRepository;
import com.vkc_s4.master.MasterMaterialTypeEntity;
import com.vkc_s4.master.MasterMaterialTypePropertiesDAO;
import com.vkc_s4.master.MasterMaterialTypeRepository;
import com.vkc_s4.master.MasterPlantEntity;
import com.vkc_s4.master.MasterPlantPropertiesDAO;
import com.vkc_s4.master.MasterPlantRepository;
import com.vkc_s4.master.MasterRegionEntity;
import com.vkc_s4.master.MasterRegionRepository;
import com.vkc_s4.master.MasterService;
import com.vkc_s4.master.MasterStorageLocationEntity;
import com.vkc_s4.master.MasterStorageLocationPropertiesDAO;
import com.vkc_s4.master.MasterStorageLocationRepository;
import com.vkc_s4.master.RegionPropertiesDAO;

@Service
public class MasterSyncService {

	@Autowired
	MasterService masterService;

	@Autowired(required=true)
	MasterCompanyRepository masterCompanyRepository;

	@Autowired
	MasterPlantRepository masterPlantRepository;

	@Autowired 
	MasterMaterialTypeRepository materialTypeRepository;

	@Autowired
	MasterMaterialGroupRepository materialGroupRepository;

	@Autowired
	MasterRegionRepository regionRepository;

	@Autowired
	MasterStorageLocationRepository storageLocationRepository;
	
	@Autowired
	ThirdPartyApiCall thirdPartyApiCall;
	
	@Autowired
	MasterCustomerGroupRepository masterCustomerGroupRepository;

	/*
	 * 0 - at the 0th second - every minute - every hour - every day of the month -
	 * every month - every day of the week
	 */

	// ---------------------------------------------------------------------------------------------
	// Every One minute once schedule run
	@Scheduled(cron = "0 * * * * *")
	/*
	 * Seconds: 0 - The task will run at the start of the minute. Minutes: 0 - The
	 * task will run at the start of the hour. Hours: 10 - The task will run at 10
	 * AM. Day of Month: * - The task can run on any day of the month. Month: * -
	 * The task can run in any month. Day of Week: 1,2,3,4,5,6,7 - The task will run
	 * on every day of the week (1=Monday, 2=Tuesday, ..., 7=Sunday).
	 */

	// @Scheduled(cron = "0 0 10 * * 1,2,3,4,5,6,7")
	public void syncMasterData() throws JsonMappingException, JsonProcessingException, UnirestException {
		saveCompany();
		savePlant();
		saveMaterialType();
		saveMaterialGroup();
		saveRegion();
		saveStorageLocation();
		saveCustomerGroup();
	}

	// Step 1: Master companyCode
	// ---------------------------------------------------------------------------------------------
	private void saveCompany() throws JsonMappingException, JsonProcessingException, UnirestException {

		List<MasterCompanyCodePropertiesDAO> companyCodeList = masterService.getCompanyCode();

		List<MasterCompanyEntity> masterEntityList = new ArrayList<>();

		//System.out.println("Company Save Test :");

		if (companyCodeList.size() > 0 && companyCodeList != null) {

			for (MasterCompanyCodePropertiesDAO companyObj : companyCodeList) {

				if (!masterCompanyRepository.existsByCompanyCode(companyObj.getDCompanyCode())) {
					MasterCompanyEntity masterEntity = new MasterCompanyEntity();

					masterEntity.setCompanyCode(companyObj.getDCompanyCode());
					masterEntity.setCompanyCodeName(companyObj.getDCompanyCodeName());

					masterEntityList.add(masterEntity);
				}
			}

			masterCompanyRepository.saveAll(masterEntityList);
		}
	}

	// ---------------------------------------------------------------------------------------------

	private void savePlant() throws JsonMappingException, JsonProcessingException, UnirestException {

		List<MasterPlantPropertiesDAO> plantList = masterService.getPlant();

		//System.out.println("Plant Save Test :");

		List<MasterPlantEntity> masterEntityList = new ArrayList<>();

		if (plantList.size() > 0 && plantList != null) {

			for (MasterPlantPropertiesDAO plantObj : plantList) {

				if (!masterPlantRepository.existsByPlant(plantObj.getDPlant())) {
					MasterPlantEntity masterEntity = new MasterPlantEntity();

					masterEntity.setPlant(plantObj.getDPlant());
					masterEntity.setPlantName(plantObj.getDPlantName());
					masterEntity.setCompanyCode(plantObj.getDCompanyCode());

					masterEntityList.add(masterEntity);
				}
			}

			masterPlantRepository.saveAll(masterEntityList);
		}
	}

	// ---------------------------------------------------------------------------------------------
	private void saveMaterialType() throws JsonMappingException, JsonProcessingException, UnirestException {

		List<MasterMaterialTypePropertiesDAO> materialTypeList = masterService.getMaterialType();

		//System.out.println("Material Type Save Test :");

		List<MasterMaterialTypeEntity> masterEntityList = new ArrayList<>();
//
		if (materialTypeList.size() > 0 && materialTypeList != null) {

			for (MasterMaterialTypePropertiesDAO materialObj : materialTypeList) {

				if (!materialTypeRepository.existsByProductType(materialObj.getDProductType())) {
					MasterMaterialTypeEntity masterEntity = new MasterMaterialTypeEntity();

					masterEntity.setProductType(materialObj.getDProductType());
					masterEntity.setMaterialTypeName(materialObj.getDMaterialTypeName());

					masterEntityList.add(masterEntity);
				}
			}

			materialTypeRepository.saveAll(masterEntityList);
		}
	}

	// ---------------------------------------------------------------------------------------------

	private void saveMaterialGroup() throws JsonMappingException, JsonProcessingException, UnirestException {

		List<MasterMaterialGroupPropertiesDAO> materialGroupList = masterService.getMaterialGroup();

		//System.out.println("Material Group Save Test :");

		List<MasterMaterialGroupEntity> masterEntityList = new ArrayList<>();

		if (materialGroupList.size() > 0 && materialGroupList != null) {
			for (MasterMaterialGroupPropertiesDAO materialObj : materialGroupList) {

				if (!materialGroupRepository.existsByMaterialGroup(materialObj.getDMaterialGroup())) {
					MasterMaterialGroupEntity masterEntity = new MasterMaterialGroupEntity();

					masterEntity.setMaterialGroup(materialObj.getDMaterialGroup());
					masterEntity.setMaterialGroupName(materialObj.getDMaterialGroupName());
					masterEntity.setMaterialGroupText(materialObj.getDMaterialGroupText());

					masterEntityList.add(masterEntity);
				}
			}

			materialGroupRepository.saveAll(masterEntityList);
		}
	}

	// ---------------------------------------------------------------------------------------------
	private void saveStorageLocation() throws JsonMappingException, JsonProcessingException, UnirestException {

		List<MasterStorageLocationPropertiesDAO> storageLocationList = masterService.getStorageLocation();

		List<MasterStorageLocationEntity> masterEntityList = new ArrayList<>();

		//System.out.println("Storage Location Save Test :");

		if (storageLocationList.size() > 0 && storageLocationList != null) {

			for (MasterStorageLocationPropertiesDAO locationObj : storageLocationList) {

				if (!storageLocationRepository.existsByStorageLocation(locationObj.getDStorageLocation())) {
					MasterStorageLocationEntity masterEntity = new MasterStorageLocationEntity();

					masterEntity.setPlant(locationObj.getDPlant());
					masterEntity.setStorageLocation(locationObj.getDStorageLocation());
					masterEntity.setStorageLocationName(locationObj.getDStorageLocationName());

					masterEntityList.add(masterEntity);
				}
			}

			storageLocationRepository.saveAll(masterEntityList);
		}

	}

	// ---------------------------------------------------------------------------------------------

	private void saveRegion() throws JsonMappingException, JsonProcessingException, UnirestException {

		List<RegionPropertiesDAO> regionList = masterService.regionConsume();

		// long begin = System.currentTimeMillis();
		// System.out.println("One :" + "\\033[0;32m" + System.currentTimeMillis());

		List<RegionPropertiesDAO> filterCountryList = regionList.stream()
				.filter(e -> e.getCountry().equalsIgnoreCase("IN")).collect(Collectors.toList());

		// long end = System.currentTimeMillis();
		// long time = end-begin;
		// System.out.println("One :" + time);

//		long begin1 = System.currentTimeMillis();
//		List<RegionPropertiesDAO> filterCountryList1 = regionList.parallelStream().filter(e->e.getCountry().equalsIgnoreCase("IN")).collect(Collectors.toList());
//		long end1 = System.currentTimeMillis();
//		 long time1 = end1-begin1;
//		System.out.println("Two :"+ time1);

		// System.out.println("Size :"+filterCountryList.size());
		// System.out.println("Invalid Region Name :" +
		// filterCountryList.stream().map(e->e.getRegionName()).collect(Collectors.toList()));
		// System.out.println("Region List Save Test :");

		List<MasterRegionEntity> masterEntityList = new ArrayList<>();

		if (regionList.size() > 0 && regionList != null) {

			for (RegionPropertiesDAO customerObj : filterCountryList) {

				if (!regionRepository.existsByRegion(customerObj.getRegion())) {
					try {
						MasterRegionEntity masterEntity = new MasterRegionEntity();

						masterEntity.setRegion(customerObj.getRegion());
						// System.err.println("Object :"+customerObj);
						// System.err.println("Before Replce :"+customerObj.getRegionName());
						// System.err.println("After Replace :"+sanitizedRegionName);
						masterEntity.setRegionName(customerObj.getRegionName());
						masterEntity.setCountry(customerObj.getCountry());

						masterEntityList.add(masterEntity);
					} catch (Exception e) {
						System.err.println("Custom Object Id :" + customerObj.getRegionName());
						e.printStackTrace();
					}

				}
			}

			regionRepository.saveAll(masterEntityList);
		}

	}
	// ---------------------------------------------------------------------------------------------

	private void saveCustomerGroup() throws JsonMappingException, JsonProcessingException, UnirestException {
		
		List<MasterCustomerGroupPropertiesDAO> masterCustomerGroup = masterService.customerGroupConsume();
		
		//System.out.println("Customer Group Save Test :");
		
		List<MasterCustomerGroupEntity> masterEntityList = new ArrayList<>();
		
		if (masterCustomerGroup.size() > 0 && masterCustomerGroup != null) {

			for (MasterCustomerGroupPropertiesDAO customerGroupObj : masterCustomerGroup) {

				if (!masterCustomerGroupRepository.existsByCustomerGroup(customerGroupObj.getCustomerGroup())) {
					try {
						MasterCustomerGroupEntity masterEntity = new MasterCustomerGroupEntity();

						masterEntity.setCustomerGroup(customerGroupObj.getCustomerGroup());
						masterEntity.setCustomerGroupName(customerGroupObj.getCustomerGroupName());
						masterEntity.setLanguage(customerGroupObj.getLanguage());
						
						masterEntityList.add(masterEntity);
					} catch (Exception e) {
						//System.err.println("Custom Object Id :" + customerGroupObj.getAccountGroupName());
						e.printStackTrace();
					}

				}
			}

			masterCustomerGroupRepository.saveAll(masterEntityList);
		}

		
	}
	// ---------------------------------------------------------------------------------------------
	
	
	
	
	
	// ---------------------------------------------------------------------------------------------
//Get All Masters List

	@Description(value = "Fetch Company Master Data")
	public List<MasterCompanyEntity> fetchCompanyCode() {
		return masterCompanyRepository.findAll();
	}

	@Description(value = "Fetch Plant Master Data")
	public List<MasterPlantEntity> fetchPlant() {
		return masterPlantRepository.findAll();
	}

	@Description(value = "Fetch Material Type Master Data")
	public List<MasterMaterialTypeEntity> fetchMaterialType() {
		return materialTypeRepository.findAll();
	}

	@Description(value = "Fetch Material Group Master Data")
	public List<MasterMaterialGroupEntity> fetchMaterialGroup() {
		return materialGroupRepository.findAll();
	}

	@Description(value = "Fetch Region Master Data")
	public List<MasterRegionEntity> fetchRegion() {
		return regionRepository.findAll();
	}
	
	@Description(value = "Fetch Storage Location Master Data")
	public List<MasterStorageLocationEntity> fetchStorageLocation() {
		return storageLocationRepository.findAll();
	}
	
	@Description(value = "Fetch Customer Group Master Data")
	public List<MasterCustomerGroupEntity> fetchCustomerGroup() {
		
		List<MasterCustomerGroupEntity> customerGroupList = masterCustomerGroupRepository.findAll();
		
		return customerGroupList.stream().filter(e->e.getCustomerGroup()!=null && e.getCustomerGroupName()!=null).collect(Collectors.toList());
	}

}
