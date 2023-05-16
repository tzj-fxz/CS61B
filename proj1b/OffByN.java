public class OffByN implements CharacterComparator {
    private int n;

    public OffByN(int n0) {
        n = n0;
    }

    public boolean equalChars(char x, char y) {
        return Math.abs((int)x - y) == n;
    }
}
