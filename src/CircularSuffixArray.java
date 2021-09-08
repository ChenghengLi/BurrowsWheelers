import java.util.Arrays;

public class CircularSuffixArray {

    private final int len;
    private final Integer[] indexes;

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }

        this.len = s.length();
        this.indexes = new Integer[len];

        for (int i = 0; i < len; i++) {
            indexes[i] = i;
        }

        Arrays.sort(indexes, (Integer i, Integer j) -> {
            char x, y;
            for (int z = 0; z < len; z++) {
                x = s.charAt((i + z) % len);
                y = s.charAt((j + z) % len);

                if (x < y)
                    return -1;
                if (y < x)
                    return 1;
            }
            return i.compareTo(j);
        });

    }

    // length of s
    public int length() {
        return len;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i >= len)
            throw new IllegalArgumentException();
        return indexes[i];
    }

}
