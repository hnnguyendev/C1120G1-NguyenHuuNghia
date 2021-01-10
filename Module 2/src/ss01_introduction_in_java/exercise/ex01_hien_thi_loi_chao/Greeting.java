package ss01_introduction_in_java.exercise.ex01_hien_thi_loi_chao;

import java.util.Scanner;

public class Greeting {

    static String name;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        name = scanner.nextLine();
    }

    static void showGreeting() {
        input();
        System.out.println("Hello: " + name);
    }

    public static void main(String[] args) {
        showGreeting();
    }

}
