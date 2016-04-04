package com.indix.pricecompare.dao;

import java.util.List;

import com.indix.pricecompare.form.ComparePrice;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PriceCompareDAOImpl implements PriceCompareDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<ComparePrice> listPriceComparison() {

		return sessionFactory.getCurrentSession().createQuery("from ComparePrice c order by c.category,c,store")
				.list();
	}


    public List getDistinctCompetitor() {
        return sessionFactory.getCurrentSession().createQuery("select distinct c.store from ComparePrice c order by  c.store ")
                .list();
    }
}
