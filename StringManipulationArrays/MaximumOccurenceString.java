package StringManipulationArrays;

public class MaximumOccurenceString {

    public static int count(String s) {
        int k = 0; // Count of '('
        int m = 0; // Count of ')'

        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) { // Fix loop condition
            if (ss[i] == '(') { // Fix character comparison
                k++;
            } else {
                m++;
            }
        }

        return Math.max(k, m); // Return the maximum count
    }

    public static void main(String[] args) {
        System.out.print(MaximumOccurenceString.count(")()())")); // Fix missing parenthesis
    }
}
