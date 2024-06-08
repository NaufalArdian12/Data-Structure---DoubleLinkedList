class Node {
    Pesanan data;
    Node prev;
    Node next;

    public Node(Pesanan data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}