import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = scanner.nextLine();

        System.out.println("\n--- All Palindrome Partitions ---");

        String[] currentPartition = new String[s.length()];
        findAndPrintPartitions(s, 0, currentPartition, 0);

        scanner.close();
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static void findAndPrintPartitions(String s, int start, String[] currentPartition, int length) {
        if (start == s.length()) {
            System.out.print("[");
            for (int i = 0; i < length; i++) {
                System.out.print("\"" + currentPartition[i] + "\"");
                if (i < length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                currentPartition[length] = s.substring(start, end + 1);
                findAndPrintPartitions(s, end + 1, currentPartition, length + 1);
            }
        }
    }
}