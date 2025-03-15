package StringManipulationArrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTestMaxWords {

    public static void main(String[] args) {
        String[] words = { "BMW", "RollsRoy", "TATA", "Mahindra" };
        List<String> list = new ArrayList<String>();
        for (String word : words) {
            list.add(word);
        }
        String shortest = list.get(0);
        String longest = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (shortest.length() > list.get(i).length()) {
                shortest = list.get(i);
            }
            if (longest.length() < list.get(i).length()) {
                longest = list.get(i);
                ;
            }

        }
        System.out.println("Shortest word in the array: " + shortest);
        System.out.println("Longest word in the array: " + longest);
    }

}

