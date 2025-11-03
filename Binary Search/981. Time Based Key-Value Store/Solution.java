import java.util.*;

class KeyPack {
    public int time;
    public String val;
    public KeyPack(int time, String val) {
        this.time = time;
        this.val = val;
    }

}
// N : number of timestamp of a particlar key, M : number of keys
// Time Complexity: init() - O(1), set() - O(1), get - O(N)
// Space Complexity: O(M * N)
// class TimeMap {
//     private HashMap<String, List<KeyPack>> store;
//     public TimeMap() {
//         store = new HashMap<>();
//     }
    
//     public void set(String key, String value, int timestamp) {
//         List<KeyPack> temp = store.getOrDefault(key, new ArrayList<>());
//         temp.add(new KeyPack(timestamp, value));
//         store.put(key, temp);
//     }
    
//     public String get(String key, int timestamp) {
//         String res = "";
//         if (store.containsKey(key)) {
//             List<KeyPack> temp = store.get(key);
//             for (KeyPack keyPair: temp) {
//                 if (keyPair.time > timestamp) break;
//                 res = keyPair.val;
//             }
//         }
//         return res;
//     }
// }


// N : number of timestamp of a particlar key, M : number of keys
// Time Complexity: init() - O(1), set() - O(1), get - O(logN)
// Space Complexity: O(M * N)
class TimeMap {
    private HashMap<String, List<KeyPack>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<KeyPack> temp = store.getOrDefault(key, new ArrayList<>());
        temp.add(new KeyPack(timestamp, value));
        store.put(key, temp);
    }
    
    public String get(String key, int timestamp) {
        KeyPack res = new KeyPack(Integer.MAX_VALUE, "");
        if (store.containsKey(key)) {
            List<KeyPack> temp = store.get(key);
            int n = temp.size();
            int l = 0;
            int r = n - 1;
            while (l <= r) {
                int mid = (r + l) / 2;
                if (timestamp < temp.get(mid).time) r = mid - 1;
                else if (timestamp > temp.get(mid).time) l = mid + 1;
                else return temp.get(mid).val;
            }
            if (r >= 0) res = temp.get(r);
        }
        return (res.time < timestamp) ? res.val : "";
    }
}