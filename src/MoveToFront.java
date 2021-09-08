
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {

    private static final int R = 256;

    // apply move-to-front encoding, reading from standard input and writing to
    // standard output
    public static void encode() {
        char[] letters = new char[R];

        for (int i = 0; i < R; i++) {
            letters[i] = (char) i;
        }

        String str = BinaryStdIn.readString();

        for (int i = 0; i < str.length(); i++) {
            encoderHelper(letters, str.charAt(i));
        }
        BinaryStdOut.close();
    }

    private static void encoderHelper(char[] letters, char letter) {
        
        char last = letters[0], temp;
        for (int i = 0; i < R; i++) {
            if (letters[i] == letter) {
                letters[0] = letter;
                letters[i] = last;
                BinaryStdOut.write((char) i);
                break;
            }
            temp = letters[i];
            letters[i] = last;
            last = temp;
        }

    }

    // apply move-to-front decoding, reading from standard input and writing to
    // standard output
    public static void decode() {
        char[] letters = new char[R];
        for (int i = 0; i < R; i++) {
            letters[i] = (char) i;
        }

        while (!BinaryStdIn.isEmpty()) {
            int character = BinaryStdIn.readInt(8);
            BinaryStdOut.write(letters[character]);
            decoderHelper(letters, letters[character]);
        }
        BinaryStdOut.close();
    }

    private static void decoderHelper(char[] letters, char letter) {
        char last = letters[0], temp;
        for (int i = 0; i < R; i++) {
            if (letters[i] == letter) {
                letters[i] = last;
                letters[0] = letter;
                break;
            }
            temp = letters[i];
            letters[i] = last;
            last = temp;
        }
    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0].equals("-"))
            encode();
        if (args[0].equals("+"))
            decode();
    }

}
