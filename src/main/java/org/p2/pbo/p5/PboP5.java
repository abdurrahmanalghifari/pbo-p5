package org.p2.pbo.p5;


import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Math.abs;

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
            
        // System.out.print("Tipe: ");
        // tipe = sc.nextLine();

        // System.out.print("Gula: ");
        // gula = sc.nextLine();
                
        System.out.print("Harga: ");
        harga = sc.nextInt();
                
        do{
            System.out.print( "Qty: " );
            qty = sc.nextInt();
            ok = cekQty( qty ); //qty method
        }while(ok == false);

        p.add( new Pesan( nama, harga, qty ) );

        return p;

    }
    
    private static boolean cekNama (String n){
        boolean ok = false;
        if (n.equalsIgnoreCase("Americano")||n.equalsIgnoreCase("Latte")||n.equalsIgnoreCase("Arabica")){
            ok=true;
        } else {
            System.out.println("Hanya Tersedia : Americano, Latte, Arabica");
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
        } else {
            System.out.println("Maap duitnya kurang");
        }
        
        return ok;
    }
    
    private static ArrayList<Pesan> bayar( ArrayList<Pesan> p ){
        Scanner sc = new Scanner(System.in);
        String nama, tipe, gula;
        Integer harga, qty, total, jumlah, bayar; 
        Boolean ok;        
        total = 0;
        jumlah=0;
        //tampilkan data 
        System.out.println("Jumlah data: "+ p.size()); 
        System.out.println("-----------------------------------------------");
        System.out.printf("| %-3s | %-10s | %-7s | %-3s  | %-7s |", 
                "No",
                "Nama",
                "Harga",
                "Qty",
                "Jumlah");
        System.out.println();
        System.out.println("-----------------------------------------------");
        int n = 1;
        for(int i = 0; i < p.size(); i++ ){

            jumlah =  p.get( i ).getQty() * p.get(i).getHarga();

            System.out.printf("| %-3s | %-10s | %-7s | %-3s  | %-7s |", 
                n++,
                p.get(i).getNama(),
                p.get(i).getHarga(),
                p.get(i).getQty(),
                (p.get(i).getHarga() * p.get(i).getQty()));
            
            total += jumlah;
            System.out.println();
            }
            System.out.println("-----------------------------------------------");
            System.out.println("Total Bayar: "+ total);

            do{
                System.out.print("Bayar: ");
                bayar = sc.nextInt();
                ok = cekBayar( total, bayar );
            }while(ok == false);
    
            p.clear();
    
            System.out.println("Kembalian: "+ abs(jumlah - bayar) );
            System.out.println("Orderan selesai, Terimakasih!!!");
            sc.nextLine();
            

        System.out.println("Tekan enter untuk lanjut...");
        sc.nextLine();
    
        return p;
    }
}