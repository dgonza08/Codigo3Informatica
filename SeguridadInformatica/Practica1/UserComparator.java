import java.util.Comparator;
import java.util.Map;

class UserComparator implements Comparator<Object> {
    Map<Character, Float> map;

    public UserComparator(Map<Character, Float> map) {
        this.map = map;
    }

    public int compare(Object o1, Object o2) {
        if (map.get(o2) == map.get(o1)) {
            return 1;
        } else {
            return (map.get(o1)).compareTo(map.get(o2));
        }
    }
}