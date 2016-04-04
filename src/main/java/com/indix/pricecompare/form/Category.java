package com.indix.pricecompare.form;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: 370727
 * Date: 3/31/16
 * Time: 6:37 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="category")
public class Category {
    @Id
    @Column(name="category_id")
    @GeneratedValue
    private Integer id;

    @Column(name="description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
