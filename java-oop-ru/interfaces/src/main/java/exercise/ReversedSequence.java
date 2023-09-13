package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private final char[] chars;

    public ReversedSequence(String str) {
        var result = str.toCharArray();
        for (int i = 0, j = result.length - 1; j > i; i++, j--) {
            char temp = result[j];
            result[j] = result[i];
            result[i] = temp;
        }
        this.chars = result;
    }

    @Override
    public int length() {
        return chars.length;
    }

    @Override
    public char charAt(int index) {
        return chars[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        StringBuilder subString = new StringBuilder();
        for (var i = start; i < end; i++) {
            subString.append(chars[i]);
        }
        return subString.toString();
    }

    @Override
    public String toString() {
        return new String(chars);
    }
}
// END
