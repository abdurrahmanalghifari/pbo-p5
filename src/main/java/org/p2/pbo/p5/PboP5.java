package org.p2.pbo.p5;


import java.util.ArrayList;
import java.util.Scanner;

public class PboP5 {

    public static void main(String[] args) {
        ArrayList<Pesan> p = new ArrayList();
        Scanner sc = new Scanner(System.in);
        Integer pilihan = 0;
        
        
       do{
           /*
           jika pilih 1, maka input data, 
           jika 2, maka tampilkan data
           jika 3 maka keluar sistem
           */
           
            System.out.println("----------------------------");
            System.out.println("--- BINTANG BUCK COFFEE ----");
            System.out.println("----------------------------");
            System.out.println("  1. Pembelian");
            System.out.println("  2. Bayar");
            System.out.println("  3. Keluar sistem");
            System.out.println("----------------------------");
            System.out.print("  Pilihanmu: ");
            pilihan = sc.nextInt();
            
           if(pilihan == 1 ){
               p = beli( p );
           }else if(pilihan == 2){
                p = bayar( p );
           }
       }while (pilihan != 3);
       p.clear();
        
    }
    
    private static ArrayList<Pesan> beli( ArrayList<Pesan> p ){ 
        Scanner sc = new Scanner(System.in);
        String nama, tipe, gula;
        Integer harga, qty;
        Boolean ok;

        do{
            System.out.print( "Nama : " );
            nama = sc.nextLine();
            ok = cekNama( nama );
            
        }while(ok == false);
            
        System.out.print("Tipe: ");
        tipe = sc.nextLine();

        System.out.print("Gula: ");
        gula = sc.nextLine();
                
        System.out.print("Harga: ");
        harga = sc.nextInt();
                
        do{
            System.out.print( "Qty: " );
            qty = sc.nextInt();
            ok = cekQty( qty ); //qty method
        }while(ok == false);

        p.add( new Pesan( nama, tipe, gula, harga, qty ) );

        return p;

    }
    
    public static boolean cekNama (String n){
        boolean ok = false;
        if (n.equalsIgnoreCase("Americano")||n.equalsIgnoreCase("Latte")||n.equalsIgnoreCase("Arabica")){
            ok=true;
        } else {
            System.out.println("Hanya Tersedia : Americano, Latte, Arabika");
        }
        return ok;
    }

    private static boolean cekQty (int QtyTotal) {
        boolean ok = false; 
        int minQty = 1;
        if ( QtyTotal >= minQty ){
            ok = true;
        } else {
            System.out.println("Minimal Order QTY : 1");
        }
        return ok;
    }

    private static boolean cekBayar(int total, int bayar) {
        boolean ok = false; 
        
        if ( bayar >= total ){
            ok = true;
        }
        
        return ok;
    }
    
    private static ArrayList<Pesan> bayar( ArrayList<Pesan> p ){
        Scanner sc = new Scanner(System.in);
        String nama, tipe, gula;
        Integer harga, qty, total, jumlah;         
        
        total=0;
        //tampilkan data 
        System.out.println("Jumlah data: "+ p.size()); 
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("| %-3s | %-10s | %-10s | %-5s | %-7s | %-3s  | %-7s |", 
                "No",
                "Nama",
                "Tipe",
                "Gula",
                "Harga",
                "Qty",
                "Jumlah");
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        
        for(int i = 0; i < p.size(); i++ ){
            System.out.printf("| %-3s | %-10s | %-10s | %-5s | %-7s | %-3s  | %-7s |", 
                i + 1,
                p.get(i).getNama(),
                p.get(i).getTipe(),
                p.get(i).getGula(),
                p.get(i).getHarga(),
                p.get(i).getQty(),
                (p.get(i).getHarga() * p.get(i).getQty()));
            System.out.println();
            System.out.println("--------------------------------------------------------------------");
        
        }
        
        System.out.println("Tekan enter untuk lanjut...");
        sc.nextLine();
        
        return p;
    }
}