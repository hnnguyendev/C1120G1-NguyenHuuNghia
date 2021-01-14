package ss10_set_stack_queue.exercise.ex01_chuyen_doi_tu_he_thap_phan_sang_he_nhi_phan;

import java.util.Iterator;
import java.util.Stack;

public class DecimalToBinary {

    public static Stack convertDecimalToBinary(int decimal) {
        int binary;
        int result = decimal;
        Stack<Integer> binaryStack = new Stack();
        while (result != 0) {
            binary = result % 2;
            binaryStack.push(binary);
            result = result / 2;
        }
        return binaryStack;
    }

    public static void main(String[] args) {
        Stack stack = convertDecimalToBinary(0);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

//        System.out.println(convertDecimalToBinary(20).toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(", ", ""));
//
//        for (Object element : convertDecimalToBinary(20)) {
//            System.out.print(element);
//        }
//
//        System.out.println();
//
//        Iterator<Integer> iterator = convertDecimalToBinary(128).iterator();
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next());
//        }

    }
}
