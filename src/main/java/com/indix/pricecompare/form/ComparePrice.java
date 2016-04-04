package com.indix.pricecompare.form;

import javax.persistence.*;

@Entity
@Table(name="price_aggregate")
public class ComparePrice {
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="category_id")
    private Category category;

	@Column(name="store")
	private String store;

	@Column(name="avg_price")
	private Float avgPrice;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Float getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Float avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
