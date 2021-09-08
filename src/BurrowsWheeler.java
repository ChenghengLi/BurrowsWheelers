import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {

    private static final int R = 256;

    public static void transform() {
        String str = BinaryStdIn.readString();

        CircularSuffixArray csa = new CircularSuffixArray(str);

        int len = csa.length();

        int start = 0;

        for (int i = 0; i < len; i++) {
            if (csa.index(i) == 0)
                start = i;
        }

        BinaryStdOut.write(start);

        int last = 0;
        for (int i = 0; i < len; i++) {
            last = (csa.index(i) - 1 + len) % len;
            BinaryStdOut.write(str.charAt(last));
        }

        BinaryStdOut.close();
    }

    public static void inverseTransform() {
        int pointer = BinaryStdIn.readInt();

        int [] counter = new int[R + 1];

        String str = BinaryStdIn.readString();
        int len = str.length();

        for (int i = 0; i < len; i++) {
            counter[str.charAt(i) + 1]++;
        }

        for (int r = 0; r < R; r++) {
            counter[r + 1] += counter[r];
        }

        char[] aux = new char[len];
        int[] next = new int[len];

        for (int i = 0; i < len; i++) {
            int character = counter[str.charAt(i)]++;
            aux[character] = str.charAt(i);
            next[character] = i;
        }

        for (int i = 0; i < len; i++) {
            BinaryStdOut.write(aux[pointer]);
            pointer = next[pointer];
        }

        BinaryStdOut.close();

    }

    public static void main(String[] args) {
        if ("-".equals(args[0])) {
            transform();
        }
        if ("+".equals(args[0])) {
            inverseTransform();
        }
    }
}
