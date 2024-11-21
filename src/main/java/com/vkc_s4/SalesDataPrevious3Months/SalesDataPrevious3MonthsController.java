package com.vkc_s4.SalesDataPrevious3Months;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = "/vkc/reports")
@RequiredArgsConstructor 
public class SalesDataPrevious3MonthsController {

    private final SalesDataPrevious3MonthsService salesDataPrevious3MonthsService;

    @GetMapping(value = { "/sales-threemonths" })
    public String getReport(Model model) throws Exception {
        model.addAttribute("reportAccess", null);
        return "SalesDataPrevious3Months.html";
    }

    @GetMapping(value = { "/sales-threemonths/filter" })
    public String getSalesDetails(Model model) throws Exception {

        List<SalesDataPrevious3MonthsSalesDAO> data = null;
        List<SalesDataPrevious3MonthsRegionDAO> lineData = null;
        try {
            // Fetching the Sales Details
            data = salesDataPrevious3MonthsService.getSalesDetails();
            lineData = salesDataPrevious3MonthsService.getLineAPIDetails();
            
            List<SalesDataPrevious3MonthsDto> getResponse = new ArrayList<>();
            
            data.stream().forEach(f -> {
                SalesDataPrevious3MonthsDto response = new SalesDataPrevious3MonthsDto();
                response.setModel(f.getDYY1_Model_PRD());
                response.setColor(f.getDYY1_Color_PRD());
                response.setSizeChat(f.getDYY1_Sizecategory_PRD());
                response.setBrand(f.getDProductGroup());
                response.setBrandCode(f.getDProductGroup());
                response.setPreviousFirstMonthSale("3");
                response.setPreviousSecondMonthSale("9");
                response.setPreviousThirdMonthSale("10");
                response.setStateCode("KL");
                response.setStateName("Kerala");
                getResponse.add(response);
            });

            model.addAttribute("data", getResponse);
            model.addAttribute("reportAccess", "yes");
            return "SalesDataPrevious3Months.html"; 
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "SalesDataPrevious3Months.html";
        }
    }
}
