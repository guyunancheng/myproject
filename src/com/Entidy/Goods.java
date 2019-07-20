package com.Entidy;

public class Goods {
    private int id;
    private String goodsinfo_name;
    private String goodsinfo_pic;
    private String goodsinfo_price;
    private String goodsinfo_descri;//描述
    private int goodsinfo_stock;//库存

    public Goods() {
    }

    public Goods(int id) {
        this.id = id;
    }

    public Goods(String goodsinfo_name) {
        this.goodsinfo_name = goodsinfo_name;
    }

    public Goods(String goodsinfo_name, String goodsinfo_price, String goodsinfo_descri, int goodsinfo_stock) {
        this.goodsinfo_name = goodsinfo_name;
        this.goodsinfo_price = goodsinfo_price;
        this.goodsinfo_descri = goodsinfo_descri;
        this.goodsinfo_stock = goodsinfo_stock;
    }

    public Goods(String goodsinfo_name, String goodsinfo_pic, String goodsinfo_price, String goodsinfo_descri, int goodsinfo_stock) {
        this.goodsinfo_name = goodsinfo_name;
        this.goodsinfo_pic = goodsinfo_pic;
        this.goodsinfo_price = goodsinfo_price;
        this.goodsinfo_descri = goodsinfo_descri;
        this.goodsinfo_stock = goodsinfo_stock;
    }

    public Goods( String goodsinfo_name, String goodsinfo_price, String goodsinfo_descri, int goodsinfo_stock, int id) {
        this.id = id;
        this.goodsinfo_name = goodsinfo_name;
        this.goodsinfo_price = goodsinfo_price;
        this.goodsinfo_descri = goodsinfo_descri;
        this.goodsinfo_stock = goodsinfo_stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsinfo_name() {
        return goodsinfo_name;
    }

    public void setGoodsinfo_name(String goodsinfo_name) {
        this.goodsinfo_name = goodsinfo_name;
    }

    public String getGoodsinfo_pic() {
        return goodsinfo_pic;
    }

    public void setGoodsinfo_pic(String goodsinfo_pic) {
        this.goodsinfo_pic = goodsinfo_pic;
    }

    public String getGoodsinfo_price() {
        return goodsinfo_price;
    }

    public void setGoodsinfo_price(String goodsinfo_price) {
        this.goodsinfo_price = goodsinfo_price;
    }

    public String getGoodsinfo_descri() {
        return goodsinfo_descri;
    }

    public void setGoodsinfo_descri(String goodsinfo_descri) {
        this.goodsinfo_descri = goodsinfo_descri;
    }

    public int getGoodsinfo_stock() {
        return goodsinfo_stock;
    }

    public void setGoodsinfo_stock(int goodsinfo_stock) {
        this.goodsinfo_stock = goodsinfo_stock;
    }
}
