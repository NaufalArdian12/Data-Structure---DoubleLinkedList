class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    // mengecek apakah linked list kosong
    public boolean isEmpty() {
        return head == null;
    }

    // menambahkan pesanan ke dalam antrian
    public void tambahAntrian(Pesanan pesanan) {
        Node newNode = new Node(pesanan);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // mencetak antrian
    public void cetakAntrian() {
        Node current = head;
        while (current != null) {
            System.out.println("Kode Pesanan: " + current.data.KodePesanan + ", Nama Pembeli: " + current.data.pembeli.namaPembeli + 
                                ", No HP: " + current.data.pembeli.NoHp + ", Nama Pesanan: " + current.data.NamaPesanan );
            current = current.next;
        }
    }

    // menghapus antrian
    public void hapusAntrian() {
        if (head == null) {
            System.out.println("Antrian kosong");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // menghapus antrian berdasarkan nomor antrian
    public void hapusAntrian(int nomorAntrian) {
        if (head == null) {
            System.out.println("Antrian kosong");
        } else if (nomorAntrian < 1 || nomorAntrian > size()) {
            System.out.println("Nomor antrian tidak valid");
        } else {
            Node current = head;
            for (int i = 1; i < nomorAntrian; i++) {
                current = current.next;
            }
            if (current == head) {
                head = current.next;
                if (head != null) {
                    head.prev = null;
                }
            } else if (current == tail) {
                tail = current.prev;
                tail.next = null;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            System.out.println("Antrian nomor " + nomorAntrian + " berhasil dihapus");
        }
    }

    // mengembalikan jumlah elemen dalam antrian
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // membuat laporan pesanan dan menghitung total pendapatan
    public void laporanPesanan() {
        Node current = head;
        int totalPendapatan = 0;
        while (current != null) {
            System.out.println("Kode Pesanan: " + current.data.KodePesanan + ", Nama Pembeli: " + current.data.pembeli.namaPembeli + ", No HP: " + current.data.pembeli.NoHp +
                               ", Nama Pesanan: " + current.data.NamaPesanan + ", Harga: " + current.data.harga);
            totalPendapatan += current.data.harga;
            current = current.next;
        }
        System.out.println("Total Pendapatan: " + totalPendapatan);
    }
}
