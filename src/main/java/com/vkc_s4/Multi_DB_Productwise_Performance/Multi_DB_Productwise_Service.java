package com.vkc_s4.Multi_DB_Productwise_Performance;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.vkc_s4.utils.UtilsService;
import com.vkc_s4.utils.methodsUtilsService;

@Service
public class Multi_DB_Productwise_Service {

	@Autowired
	methodsUtilsService altrocksUtils;

	@Autowired
	UtilsService Utils;
	
	public List<Multi_DB_Productwise_MaterialDocDao> getMaterialDocApiDetails() throws Exception {
		String MaterialDocApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_MATERIAL_DOC_CDS/YY1_MATERIAL_DOC";

		HttpResponse<String> response = altrocksUtils.ApiCall(MaterialDocApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<Multi_DB_Productwise_MaterialDocDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<Multi_DB_Productwise_MaterialDocHeaderDao> entryNodes = mapper.reader().forType(mapper.getTypeFactory()
					.constructCollectionType(List.class, Multi_DB_Productwise_MaterialDocHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<Multi_DB_Productwise_MaterialDocDao> getMaterialDoc = data;

		return getMaterialDoc;
	}
	
	public List<Multi_DB_Productwise_ProductDao> getProductDaoApiDetails() throws Exception {
		String ProductDaoApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_PRODUCT_API_CDS/YY1_PRODUCT_API";

		HttpResponse<String> response = altrocksUtils.ApiCall(ProductDaoApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<Multi_DB_Productwise_ProductDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<Multi_DB_Productwise_ProductHeaderDao> entryNodes = mapper.reader().forType(mapper.getTypeFactory()
					.constructCollectionType(List.class, Multi_DB_Productwise_ProductHeaderDao.class))
					.readValue(entryNodeArray.toString()); 
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<Multi_DB_Productwise_ProductDao> getProductDoc = data;

		return getProductDoc;
	}
	
	public List<Multi_DB_Productwise_SaleOrderItemDao> getSaleOrderItemApiDetails() throws Exception {
		String SaleOrderItemApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_SALE_ORDER_ITEM_CDS/YY1_SALE_ORDER_ITEM";

		HttpResponse<String> response = altrocksUtils.ApiCall(SaleOrderItemApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<Multi_DB_Productwise_SaleOrderItemDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<Multi_DB_Productwise_SaleOrderItemHeaderDao> entryNodes = mapper.reader().forType(mapper.getTypeFactory()
					.constructCollectionType(List.class, Multi_DB_Productwise_SaleOrderItemHeaderDao.class))
					.readValue(entryNodeArray.toString()); 
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<Multi_DB_Productwise_SaleOrderItemDao> getSaleOrderItem = data;

		return getSaleOrderItem; 
	}
	
	public List<Multi_DB_Productwise_MgfOrderDao> getMgfOrderApiDetails() throws Exception {
		String MgfOrderApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_MFG_ORDER_CDS/YY1_MFG_ORDER";

		HttpResponse<String> response = altrocksUtils.ApiCall(MgfOrderApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<Multi_DB_Productwise_MgfOrderDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<Multi_DB_Productwise_MgfOrderHeaderDao> entryNodes = mapper.reader().forType(mapper.getTypeFactory()
					.constructCollectionType(List.class, Multi_DB_Productwise_MgfOrderHeaderDao.class))
					.readValue(entryNodeArray.toString()); 
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<Multi_DB_Productwise_MgfOrderDao> getMgfOrderItem = data;

		return getMgfOrderItem; 
	}
  
	
	public List<Multi_DB_Productwise_PurchaseOrderDao> getPurchaseOrderApiDetails() throws Exception {
		String purchaseOrderApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_PURCHASE_ORDER_CDS/YY1_PURCHASE_ORDER";

		HttpResponse<String> response = altrocksUtils.ApiCall(purchaseOrderApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<Multi_DB_Productwise_PurchaseOrderDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<Multi_DB_Productwise_PurchaseOrderHeaderDao> entryNodes = mapper.reader().forType(mapper.getTypeFactory()
					.constructCollectionType(List.class, Multi_DB_Productwise_PurchaseOrderHeaderDao.class))
					.readValue(entryNodeArray.toString()); 
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<Multi_DB_Productwise_PurchaseOrderDao> getPurchaseOrderItem = data;

		return getPurchaseOrderItem; 
	} 

	
}
