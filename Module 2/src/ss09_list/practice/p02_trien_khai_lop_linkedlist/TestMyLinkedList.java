package ss09_list.practice.p02_trien_khai_lop_linkedlist;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList(10);
        linkedList.addFirst(11);
        linkedList.addFirst(12);
        linkedList.addFirst(13);

        linkedList.add(4, 15);
        linkedList.add(4, 9);
        linkedList.printList();
    }
}
