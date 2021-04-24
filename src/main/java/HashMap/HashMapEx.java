package HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx {
    public static void main(String[] args) {
        //Hash map in unsynchronized
        // Use Collections.synchronizedMap ( new HashMap ) to nake it synchronized

        // From Java 8 ownwards , java uses Self Balancing BST ( worst case time of O(logN) )
        // instead of linked list for chaining

        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);

        System.out.println(map);
        System.out.println(map.size());

        //Check if key is present and print value
        if ( map.containsKey("B")){
            int value = map.get("B");
            System.out.println(value);
        }

        // Map Traversal
        for(Map.Entry<String, Integer> e: map.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
