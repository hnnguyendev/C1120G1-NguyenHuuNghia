package ss10_set_stack_queue.exercise.ex01_chuyen_doi_tu_he_thap_phan_sang_he_nhi_phan;

import java.util.ArrayList;

public class BinaryToDecimal {
    public static int convertBinaryToDecimal(String binary) {
        int decimal = 0;
        ArrayList<Character> characters = new ArrayList();
        for (int i = 0; i < binary.length(); i++) {
            characters.add(binary.charAt(i));
            if (characters.get(i).equals('1')) {
                decimal += Math.pow(2, binary.length() - 1 - i);
            }
        }
        return decimal;
    }

    public static void main(String[] args) {
        System.out.println(convertBinaryToDecimal("10000000"));
    }
}







