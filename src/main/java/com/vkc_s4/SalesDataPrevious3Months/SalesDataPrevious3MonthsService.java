package com.vkc_s4.SalesDataPrevious3Months;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.vkc_s4.utils.APIConstants;
import com.vkc_s4.utils.UtilsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalesDataPrevious3MonthsService {

	@Autowired
	UtilsService Utils;

	public List<SalesDataPrevious3MonthsSalesDAO> getSalesDetails() throws Exception {

		System.out.println(APIConstants.SalesDataPreviousThreeMonths.SalesReportApi);
		
		System.out.println("https://"+Utils.port+"-");
		
		HttpResponse<String> response = Utils.ApiCall("https://"+Utils.port+"-" + APIConstants.SalesDataPreviousThreeMonths.SalesReportApi, Utils.apiUserName,
				Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = Utils.XmlToJsonConversion(response.getBody().toString());
		List<SalesDataPrevious3MonthsSalesDAO> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<SalesDataPrevious3MonthsSalesHeaderDAO> entryNodes = mapper.reader().forType(mapper.getTypeFactory()
					.constructCollectionType(List.class, SalesDataPrevious3MonthsSalesHeaderDAO.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<SalesDataPrevious3MonthsSalesDAO> headerFilteredData = data;

		return headerFilteredData;
	}

	public List<SalesDataPrevious3MonthsRegionDAO> getLineAPIDetails() throws Exception {
		// Passing the Document Number & Fiscal year Dynamically
		HttpResponse<String> response = Utils.ApiCall("https://" + Utils.port + "-" + APIConstants.SalesDataPreviousThreeMonths.RegionLineApi,Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = Utils.XmlToJsonConversion(response.getBody().toString());
		List<SalesDataPrevious3MonthsRegionDAO> lineData = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<SalesDataPrevious3MonthsSalesHeaderLineDAO> entryNodes = mapper.reader()
					.forType(mapper.getTypeFactory().constructCollectionType(List.class,
							SalesDataPrevious3MonthsSalesHeaderLineDAO.class))
					.readValue(entryNodeArray.toString());
			lineData = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<SalesDataPrevious3MonthsRegionDAO> lineFilteredData = lineData;

		return lineFilteredData;
	}
}
