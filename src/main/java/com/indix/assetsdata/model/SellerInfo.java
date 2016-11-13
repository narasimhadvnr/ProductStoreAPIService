package com.indix.assetsdata.model;

import java.util.HashSet;

/**
 * Created by venkat on 13/11/16.
 */
public class SellerInfo {

    private String sellerName;
    private double price;
    private long timestamp;

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


    public String toString(){
        return "{ seller: "+sellerName
                +", price: "+price+
                " }";
    }
}
