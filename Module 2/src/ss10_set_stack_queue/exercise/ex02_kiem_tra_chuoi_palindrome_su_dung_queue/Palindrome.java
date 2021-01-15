package ss10_set_stack_queue.exercise.ex02_kiem_tra_chuoi_palindrome_su_dung_queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {

    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        Stack<Character> stack = new Stack();
        Queue<Character> queue = new LinkedList();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            queue.add(str.charAt(i));
        }
        for (int i = 0; i < str.length() / 2; i++) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        if (isPalindrome("Able was I ere I saw Elba")) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is not palindrome");
        }
    }
}
