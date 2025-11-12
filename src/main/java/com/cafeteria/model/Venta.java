package com.cafeteria.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private int id;
    private String cliente;
    private LocalDateTime fecha;
    private String vendedor;
    private double total;
    private boolean impreso;
    private String impresora;
    private List<DetalleVenta> detalles = new ArrayList<>();

    public Venta(){}

    // getters/setters...
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public String getCliente(){return cliente;} public void setCliente(String c){this.cliente=c;}
    public LocalDateTime getFecha(){return fecha;} public void setFecha(LocalDateTime f){this.fecha=f;}
    public String getVendedor(){return vendedor;} public void setVendedor(String v){this.vendedor=v;}
    public double getTotal(){return total;} public void setTotal(double t){this.total=t;}
    public boolean isImpreso(){return impreso;} public void setImpreso(boolean b){this.impreso=b;}
    public String getImpresora(){return impresora;} public void setImpresora(String s){this.impresora=s;}
    public List<DetalleVenta> getDetalles(){return detalles;} public void setDetalles(List<DetalleVenta> d){this.detalles=d;}
}
