package ss10_set_stack_queue.exercise.ex05_dem_so_lan_xuat_hien_cua_moi_tu_trong_mot_chuoi_su_dung_map;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CountWord {

    public static void countWord(String str) {
        Map<String, Integer> treeMap = new TreeMap<>();
        String[] arr = str.split(" ");
        for (String word : arr) {
            if (!treeMap.containsKey(word)) {
                treeMap.put(word, 1);
            } else {
                treeMap.put(word, treeMap.get(word) + 1);
            }
        }

        Set<String> keySet = treeMap.keySet();
        for (String key : keySet) {
            System.out.println("[" + key + "] - " + treeMap.get(key));
        }

    }

    public static void main(String[] args) {
        countWord("Nguyen Huu Nghia Huu nghia");
    }
}
