package com.indix.pricecompare.dao;

import java.util.List;

import com.indix.pricecompare.form.ComparePrice;

public interface PriceCompareDAO {
	
	public List<ComparePrice> listPriceComparison();
    public List getDistinctCompetitor();
}
