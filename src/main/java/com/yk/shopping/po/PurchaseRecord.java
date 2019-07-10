package com.yk.shopping.po;

import java.util.Date;

public class PurchaseRecord {
    /**  **/
    private Integer id;

    /** 用户编号 **/
    private Integer userId;

    /** 产品编号 **/
    private Integer productId;

    /** 单价 **/
    private Double price;

    /** 数量 **/
    private Integer quantity;

    /** 总价 **/
    private Double sum;

    /** 购买日期 **/
    private Date purchaseDate;

    /** 备注 **/
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}