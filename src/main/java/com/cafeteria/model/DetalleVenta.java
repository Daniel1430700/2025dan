package com.cafeteria.model;

public class DetalleVenta {
    private int id;
    private int ventaId;
    private int productId;
    private int cantidad;
    private double precioUnit;
    private double subtotal;

    public DetalleVenta(){}
    // getters/setters
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public int getVentaId(){return ventaId;} public void setVentaId(int vid){this.ventaId=vid;}
    public int getProductId(){return productId;} public void setProductId(int pid){this.productId=pid;}
    public int getCantidad(){return cantidad;} public void setCantidad(int c){this.cantidad=c;}
    public double getPrecioUnit(){return precioUnit;} public void setPrecioUnit(double p){this.precioUnit=p;}
    public double getSubtotal(){return subtotal;} public void setSubtotal(double s){this.subtotal=s;}
}
