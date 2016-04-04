package com.indix.pricecompare.service;

import java.util.List;

import com.indix.pricecompare.form.ComparePrice;

public interface PriceCompareService {
	
	public List<ComparePrice> listPriceComparison();
    public List getDistinctCompetitor();
}
