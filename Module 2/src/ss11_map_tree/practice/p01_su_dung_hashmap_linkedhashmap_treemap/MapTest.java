package ss11_map_tree.practice.p01_su_dung_hashmap_linkedhashmap_treemap;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<>();
        students.put("Peter", 19);
        students.put("Mary", 15);
        students.put("John", 29);
        students.put("William", 24);
        students.put("Alexa", 20);
        System.out.println("Display entries in HashMap");
        System.out.println(students);

        Set<String> keySet = students.keySet();
        for (String key : keySet) {
            System.out.println(key + "=" + students.get(key));
        }

        Map<String, Integer> treeMap = new TreeMap<>(students);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Peter", 19);
        linkedHashMap.put("Mary", 15);
        linkedHashMap.put("John", 29);
        linkedHashMap.put("William", 24);
        linkedHashMap.put("Alexa", 20);
        System.out.println("\nThe age for " + "Peter is " + linkedHashMap.get("Peter"));
        System.out.println(linkedHashMap);
    }
}
