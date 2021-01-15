package ss10_set_stack_queue.exercise.ex03_kiem_tra_dau_ngoac_trong_bieu_thuc_su_dung_stack;

import java.util.Stack;

public class Bracket {

    public static boolean checkBracket(String str) {
        Stack<Character> bStack = new Stack();

//        for (int i = 0; i < str.length(); i++)
//            if (str.charAt(i) == '(') {
//                bStack.push(str.charAt(i));
//            }
//
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == ')') {
//                if (bStack.isEmpty()) {
//                    return false;
//                } else {
//                    bStack.pop();
//                }
//            }
//        }
//
//        if (!bStack.isEmpty()) {
//            return false;
//        }
//        return true;

        for (int i = 0; i < str.length(); i++) {
            char sym = str.charAt(i);
            if (sym == '(') {
                bStack.push(str.charAt(i));
            } else if (sym == ')') {
                if (bStack.isEmpty()) {
                    return false;
                }
                char left = bStack.peek();
                if (left == '(') {
                    bStack.pop();
                } else {
                    return false;
                }
            }
        }
        return bStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(checkBracket("(– b + (b^2 – 4*a*c)^(0.5/ 2*a))"));
    }
}
