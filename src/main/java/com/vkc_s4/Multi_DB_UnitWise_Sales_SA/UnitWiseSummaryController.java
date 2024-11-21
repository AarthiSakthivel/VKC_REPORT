package com.vkc_s4.Multi_DB_UnitWise_Sales_SA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vkc/reports")
public class UnitWiseSummaryController {

    @Autowired
    private UnitWiseSummaryService unitWiseSummaryService;

    @GetMapping("/unitwise-summary")
    public String getUnitWiseSummary(Model model) throws Exception {
        // Fetch current date -1
        Date currentDate = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateString = sdf.format(currentDate);

        // Fetch the summary data
        List<UnitWiseSummaryDao> summaries = unitWiseSummaryService.getSummary(currentDateString);

        // Add the data to the model for use in the view (HTML page)
        model.addAttribute("summaries", summaries);
        return "unitwise_summary";  // This will return the HTML page with the data
    }
    
    @GetMapping("/unitwise-summaryItem") // API endpoint for AJAX
    @ResponseBody // Ensure this method returns JSON
    public List<UnitWiseSummaryDao> getUnitWiseSummaryApi() throws Exception {
        // Fetch current date -1
        Date currentDate = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateString = sdf.format(currentDate);

        // Fetch the summary data
        List<UnitWiseSummaryDao> summaries = unitWiseSummaryService.getSummary(currentDateString);
        
        return summaries; // Return summaries directly as JSON
    }
}
