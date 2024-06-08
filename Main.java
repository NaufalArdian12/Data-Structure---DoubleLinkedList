import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList antrian = new LinkedList();

        // Informasi pribadi saya
        String nama = "Muhammad Akbar Fakhriy Daffa";
        String nim = "2341720231";
        String absen = "21";

        // Mencetak informasi header
        System.out.println("======= QUIZ 2 PRAKTIKUM ASD TI 1G =======");
        System.out.println("dibuat oleh : " + nama);
        System.out.println("NIM : " + nim);
        System.out.println("Absen : " + absen);
        System.out.println("===============================================");
        System.out.println("Sistem Antrian Resto KOH\n");

        // Loop untuk menu
        int pilihan = 0;
        while (pilihan != 5) {
            // Menampilkan menu
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Pesanan");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian");
            System.out.println("4. Laporan Pesanan");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    // Tambah Pesanan
                    System.out.print("Masukkan nama pembeli: ");
                    String namaPembeli = scanner.nextLine();
                    System.out.print("Masukkan nomor HP pembeli: ");
                    String nomorHP = scanner.nextLine();
                    Pembeli pembeli = new Pembeli(namaPembeli, nomorHP);

                    System.out.print("Masukkan nama pesanan: ");
                    String namaPesanan = scanner.nextLine();
                    System.out.print("Masukkan harga pesanan: ");
                    int hargaPesanan = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan buffer

                    Pesanan pesanan = new Pesanan(antrian.size() + 1, namaPesanan, pembeli, hargaPesanan);
                    antrian.tambahAntrian(pesanan);
                    break;

                case 2:
                    // Cetak Antrian
                    antrian.cetakAntrian();
                    break;

                case 3:
                    // Hapus Antrian
                    if (!antrian.isEmpty()) {
                        System.out.print("Masukkan nomor antrian yang akan dihapus: ");
                        int nomorAntrian = scanner.nextInt();
                        scanner.nextLine();
                        antrian.hapusAntrian(nomorAntrian);
                    } else {
                        System.out.println("Antrian kosong");
                    }
                    break;

                case 4:
                    // Laporan Pesanan
                    antrian.laporanPesanan();
                    break;

                case 5:
                    // Keluar
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }
        }

        scanner.close(); // Menutup scanner setelah selesai
    }
}