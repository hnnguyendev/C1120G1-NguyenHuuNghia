package ss09_list.practice.p01_trien_lop_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);
        myList.add(10);

        System.out.println(myList.get(0));
        System.out.println(myList.get(9));
        System.out.println(myList.get(10));
    }
}
