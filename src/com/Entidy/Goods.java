package com.Entidy;

public class Goods {
    private int id;
    private String goodsinfo_name;
    private String goodsinfo_pic;
    private String goodsinfo_price;
    private String goodsinfo_descri;//描述
    private String goodsinfo_stook;//库存

    public Goods() {
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

    public String getGoodsinfo_stook() {
        return goodsinfo_stook;
    }

    public void setGoodsinfo_stook(String goodsinfo_stook) {
        this.goodsinfo_stook = goodsinfo_stook;
    }

    public Goods(int id, String goodsinfo_name, String goodsinfo_pic, String goodsinfo_price, String goodsinfo_descri, String goodsinfo_stook) {
        this.id = id;
        this.goodsinfo_name = goodsinfo_name;
        this.goodsinfo_pic = goodsinfo_pic;
        this.goodsinfo_price = goodsinfo_price;
        this.goodsinfo_descri = goodsinfo_descri;
        this.goodsinfo_stook = goodsinfo_stook;
    }
}
