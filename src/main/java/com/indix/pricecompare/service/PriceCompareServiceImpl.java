package com.indix.pricecompare.service;

import java.util.List;

import com.indix.pricecompare.dao.PriceCompareDAO;
import com.indix.pricecompare.form.ComparePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PriceCompareServiceImpl implements PriceCompareService {

	@Autowired
	private PriceCompareDAO priceCompareDAO;
	


	@Transactional
	public List<ComparePrice> listPriceComparison() {
		return priceCompareDAO.listPriceComparison();
	}



    @Transactional
    public List getDistinctCompetitor() {
        return priceCompareDAO.getDistinctCompetitor();
    }
}
