package com.touraj.pim.domain;

import javax.persistence.*;

/**
 * Created by toraj on 08/10/2018.
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    private String zamroid;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    @Lob
    @Column(name="description", length=512)
    private String description;

    private int minorderquantity;
    private String unitofmeasure;
    private double purchaseprice;
    private boolean available;

    public Product() {
    }

    public Product(String zamroid, String name, Category category, String description, int minorderquantity, String unitofmeasure, double purchaseprice, boolean available) {

        this.zamroid = zamroid;
        this.name = name;
        this.category = category;
        this.description = description;
        this.minorderquantity = minorderquantity;
        this.unitofmeasure = unitofmeasure;
        this.purchaseprice = purchaseprice;
        this.available = available;
    }

    public String getZamroid() {

        return zamroid;
    }

    public void setZamroid(String zamroid) {
        this.zamroid = zamroid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinorderquantity() {
        return minorderquantity;
    }

    public void setMinorderquantity(int minorderquantity) {
        this.minorderquantity = minorderquantity;
    }

    public String getUnitofmeasure() {
        return unitofmeasure;
    }

    public void setUnitofmeasure(String unitofmeasure) {
        this.unitofmeasure = unitofmeasure;
    }

    public double getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(double purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Product{" +
                "zamroid=" + zamroid +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", minorderquantity=" + minorderquantity +
                ", unitofmeasure='" + unitofmeasure + '\'' +
                ", purchaseprice=" + purchaseprice +
                ", available=" + available +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return zamroid != null ? zamroid.equals(product.zamroid) : product.zamroid == null;
    }

    @Override
    public int hashCode() {
        return zamroid != null ? zamroid.hashCode() : 0;
    }
}
