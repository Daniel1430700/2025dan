
package com.cafeteria.model;

public class Sale {
    private int id;
    private int productId;
    private int qty;
    private double total;
    private String client;
    private String date;
    public Sale(int id, int productId, int qty, double total, String client, String date) {
        this.id = id; this.productId = productId; this.qty = qty; this.total = total; this.client = client; this.date = date;
    }
    // getters...
}
