import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 * */

public class SpellCheck {

    public static final int SIZE = 255;


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {

        Trie dictionaryTrie = new Trie(new Node(false, new Node[SIZE]));
        Trie misspelledTrie = new Trie(new Node(false, new Node[SIZE]));
        ArrayList<String> badWords = new ArrayList<>();

//      For every word in the dictionary
        for (String word : dictionary) {
            dictionaryTrie.insert(word);
        }

        for (String word : text) {
            if (!dictionaryTrie.lookUp(word) && !misspelledTrie.lookUp(word)) {
                misspelledTrie.insert(word);
                badWords.add(word);
            }
        }

        badWords.sort(Comparator.naturalOrder());
        String previousWord = "";
        int count = 0;
        for (String word : badWords) {
            if (word.equals(previousWord)) {
                System.out.print(word + "., ");
                count++;
            }
            previousWord = word;
        }
        System.out.println();
        System.out.println(badWords.size() - count);
        for (String word : badWords)
        System.out.print(word + ", ");
        System.out.println();
        return badWords.toArray(new String[badWords.size()]);
    }
}
