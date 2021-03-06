package com.example.tradenotediplomwork;

import javafx.scene.control.TableView;

public class CryptoTable {

    private int id;
    private String name;
    private Double quantity;
    private Double sum_of_buy;
    private Double desired_price;
    private Double current_price;
    private Double current_course;
    public TableView<CryptoTable> tableViewCrypto;

    public CryptoTable(int id, String name, Double quantity, Double sum_of_buy, Double desired_price, Double current_price, Double current_course) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.sum_of_buy = sum_of_buy;
        this.desired_price = desired_price;
        this.current_price = current_price;
        this.current_course = current_course;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getSum_of_buy() {
        return sum_of_buy;
    }

    public void setSum_of_buy(Double sum_of_buy) {
        this.sum_of_buy = sum_of_buy;
    }

    public Double getDesired_price() {
        return desired_price;
    }

    public void setDesired_price(Double desired_price) {
        this.desired_price = desired_price;
    }

    public Double getCurrent_price() {return current_price;
    }

    public void setCurrent_price(Double current_price) {this.current_price = current_price;}

    public Double getCurrent_course() {return current_course;}

    public void setCurrent_course(Double current_course) {this.current_course = current_course;}
}




