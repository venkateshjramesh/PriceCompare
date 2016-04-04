package com.indix.pricecompare.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.indix.pricecompare.form.ComparePrice;
import com.indix.pricecompare.service.PriceCompareService;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PriceCompareController {

	@Autowired
	private PriceCompareService priceCompareService;

	@RequestMapping("/index")
	public String listPriceComparison(Map<String, Object> map) {
        List<ComparePrice> comparePrices = priceCompareService.listPriceComparison();
        map.put("competitor", priceCompareService.getDistinctCompetitor());
		return "contact";
	}

    @RequestMapping("/data")
    public  @ResponseBody
    String listData(Map<String, Object> map) throws IOException {
        List<ComparePrice> comparePrice = priceCompareService.listPriceComparison();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(comparePrice);
    }

    @RequestMapping("/competitor")
    public  @ResponseBody
    String listCompetitor(Map<String, Object> map) throws IOException {
        List<ComparePrice> competitor = priceCompareService.getDistinctCompetitor();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(competitor);
    }

}
