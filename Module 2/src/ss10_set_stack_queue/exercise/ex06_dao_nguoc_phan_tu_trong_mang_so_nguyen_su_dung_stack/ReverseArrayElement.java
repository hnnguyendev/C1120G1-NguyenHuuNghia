package ss10_set_stack_queue.exercise.ex06_dao_nguoc_phan_tu_trong_mang_so_nguyen_su_dung_stack;

import java.util.Arrays;
import java.util.Stack;

public class ReverseArrayElement<T> {
    public T[] arr;

    public static String[] splitString(String str) {
        return str.split(" ");
    }

    public void reverse(T[] arr) {
        Stack<T> stack = new Stack<>();
        for (T value : arr) {
            stack.push(value);
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            this.arr[i] = stack.pop();
        }
        System.out.println(Arrays.toString(this.arr));
    }

    public static void main(String[] args) {

        ReverseArrayElement<Integer> integerArr = new ReverseArrayElement<>();
        integerArr.arr = new Integer[]{1, 2, 3, 4, 5};
        integerArr.reverse(integerArr.arr);

        ReverseArrayElement<String> stringArr = new ReverseArrayElement<>();
        stringArr.arr = splitString("Da Nang Viet Nam");
        stringArr.reverse(stringArr.arr);
    }
}
