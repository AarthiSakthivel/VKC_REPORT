package com.vkc_s4.utils;

import org.springframework.context.annotation.Description;

public class APIConstants {

	@Description(value = "Masters API")
	public static class masterReport {
		public static final String YY1VKCCompanyCode = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_VKCCOMPANYCODE_CDS/YY1_VKCCompanyCode";
		public static final String YY1VKCPlant = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_VKCPLANT_CDS/YY1_VKCPlant";
		public static final String YY1VKCProductType = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_VKCPRODUCTTYPE_CDS/YY1_VKCProductType";
		public static final String YY1VKCProductGroup = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_VKCPRODUCTGROUP_CDS/YY1_VKCProductGroup";
		public static final String YY1VKCStorageLocation = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_VKC_STORAGELOCATION_CDS/YY1_VKC_StorageLocation";
		public static final String YY1CUSTOMERWISEBILLIN = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEBILLIN_API_CDS/YY1_CUSTOMERWISEBILLIN_API";
		public static final String YY1VKCRegion = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_VKC_REGION_CDS/YY1_VKC_Region";
		public static final String YY1VKCCustomerGroup = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_VKC_CUSTOMER_GROUP_CDS/YY1_VKC_Customer_Group";

	}

	@Description(value = "Multi DB item wise Sales")
	public static class MultiDbItemWiseSalesMaster {

		public static final String MultiDbItemWiseSales = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_MULTIDBITEMWISECRAPI_CDS/YY1_MultiDBItemWiseCrAPI";
		public static final String YY1CUSTOMERWISEZHID = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEZHID_API_CDS/YY1_CUSTOMERWISEZHID_API";
		public static final String YY1CUSTOMERWISEZLHID = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEZLID_API_CDS/YY1_CUSTOMERWISEZLID_API";
		public static final String YY1CUSTOMERWISEYBHD = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEYBHD_API_CDS/YY1_CUSTOMERWISEYBHD_API";
		public static final String YY1CUSTOMERWISEZPRO = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEZPRO_API_CDS/YY1_CUSTOMERWISEZPRO_API";
		public static final String YY1RegionText = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_REGIONTEXTAPI_CDS/YY1_RegionTextAPI";
		public static final String YY1CUSTOMERWISEDRD1 = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEDRD1_API_CDS/YY1_CUSTOMERWISEDRD1_API";
		public static final String YY1CustomerAPI = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERAPI_CDS/YY1_CustomerAPI";
		
		
	}

	@Description(value = "Multi DB item wise Day Wise Sales")
	public static class CustomWiseBrandWise {
		public static final String CustItemApi = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTWISEBRANDWISEITEM_CDS/YY1_CUSTWISEBRANDWISEITEM";
		public static final String CustWiseBillInApi = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEBILLIN_API_CDS/YY1_CUSTOMERWISEBILLIN_API";
		public static final String CustWiseYbhdApi = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEYBHD_API_CDS/YY1_CUSTOMERWISEYBHD_API";
		public static final String CustWiseYbhdApi2 = "https://my409401-api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEDRD1_API_CDS/YY1_CUSTOMERWISEDRD1_API";
	}
	
	@Description(value="State And Brand Wise Sales")
	public static class StateAndBrandWiseSalesAPI {
		public static final String YY1STWISEBRWISECOAPI = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_ST_WISE_BR_WISE_CO_API_CDS/YY1_ST_WISE_BR_WISE_CO_API";
		
	}

	public static class SalesDataPreviousThreeMonths {
		public static final String SalesReportApi = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_SALESDATA3MONTH_CDS/YY1_SALESDATA3MONTH";
		public static final String RegionLineApi = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_REGIONTEXTAPI_CDS/YY1_RegionTextAPI";
	}

	public static class BrandwiseSales {
		public static final String BrandWiseSalesApi = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_MULTIUNITWISESALEAWDPS_CDS/YY1_MultiUnitwiseSaleAWDPS";
	}
	
	public static class bwSalesAPIs {

		public static final String YY1_BWSalesAPI = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_BWSALESAPI_CDS/YY1_BWSalesAPI";
		public static final String YY1_CustomerAPI = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERAPI_CDS/YY1_CustomerAPI";
		public static final String YY1_CUSTOMERWISEZPRO_API = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEZPRO_API_CDS/YY1_CUSTOMERWISEZPRO_API";
		public static final String YY1_CUSTOMERWISEYBHD_API = "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEYBHD_API_CDS/YY1_CUSTOMERWISEYBHD_API";

	}
	
	
}
