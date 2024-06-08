public class Pesanan {
    int KodePesanan;
    String NamaPesanan;
    Pembeli pembeli;
    int harga;

    public Pesanan(int KodePesanan, String NamaPesanan, Pembeli pembeli, int harga){
        this.KodePesanan = KodePesanan;
        this.NamaPesanan = NamaPesanan;
        this.pembeli = pembeli;
        this.harga = harga;
    }

    public void denda(int a, String b, int d){
        System.out.println("Pesanan dengan kode : " + a + " dan nama : " + b + " dikenakan denda : " + d);
    }
}