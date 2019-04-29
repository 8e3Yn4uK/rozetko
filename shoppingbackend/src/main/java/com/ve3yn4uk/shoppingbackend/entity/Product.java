package com.ve3yn4uk.shoppingbackend.entity;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by 8e3Yn4uK on 29.04.2019
 */

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;
    private String brand;
    private String descroption;
    @Column(name = "unit_price")
    private double unitPrice;
    private int quantity;
    @Column(name = "is_active")
    private boolean active;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "supplier_id")
    private int supplierId;
    private int purchases;
    private int views;

    /**
     * default constructor to generate unique product id for each new product
     */
    public Product() {

        this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescroption() {
        return descroption;
    }

    public void setDescroption(String descroption) {
        this.descroption = descroption;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", descroption='" + descroption + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", active=" + active +
                ", categoryId=" + categoryId +
                ", supplierId=" + supplierId +
                ", purchases=" + purchases +
                ", views=" + views +
                '}';
    }
}