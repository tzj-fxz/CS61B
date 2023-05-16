import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne offbyone = new OffByOne();
    static OffByN offby5 = new OffByN(5);

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("    "));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("Aa"));
        assertFalse(palindrome.isPalindrome("ABCDDDD"));
        assertFalse(palindrome.isPalindrome("asfasfdvskanscvold"));
    }

    @Test
    public void testisPalindrome2() {
        assertTrue(palindrome.isPalindrome("flake", offbyone));
        assertTrue(palindrome.isPalindrome("&%", offbyone));
        assertTrue(palindrome.isPalindrome("", offbyone));
        assertFalse(palindrome.isPalindrome("aaaa", offbyone));
    }

    @Test
    public void testisPalindrome3() {
        assertTrue(palindrome.isPalindrome("aaff", offby5));
        assertTrue(palindrome.isPalindrome("", offby5));
        assertFalse(palindrome.isPalindrome("aaaa", offby5));
    }
}
