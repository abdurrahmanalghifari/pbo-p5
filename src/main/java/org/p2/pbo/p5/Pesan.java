package org.p2.pbo.p5;

public class Pesan {
    String nama, tipe, gula;
    Integer harga, qty;

    public Pesan(String nama, Integer harga, Integer qty) {
        this.nama = nama;
        this.harga = harga;
        this.qty = qty;
    }

    public String getNama() {
        return nama;
    }

    public String getTipe() {
        return tipe;
    }

    public String getGula() {
        return gula;
    }

    public Integer getHarga() {
        return harga;
    }

    public Integer getQty() {
        return qty;
    }

    
}


