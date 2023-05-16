public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> cur = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); ++i) {
            cur.addLast(word.charAt(i));
        }
        return cur;
    }

    public boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        } else {
            String reverse = "";
            Deque<Character> cur = wordToDeque(word);
            for (int i = 0; i < word.length(); ++i) {
                reverse += cur.removeLast();
            }
            return reverse.equals(word);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() <= 1) {
            return true;
        } else {
            boolean flag = true;
            for (int i = 0; i < word.length() / 2; ++i) {
                if (!cc.equalChars(word.charAt(i), word.charAt(word.length() - 1 - i))) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
    }
}
