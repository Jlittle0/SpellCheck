import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Josh Little
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
//        return checkWordsTrie(text, dictionary);
        return checkWordsTST(text, dictionary);
    }

    public String[] checkWordsTrie(String[] text, String[] dictionary) {
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

        return badWords.toArray(new String[badWords.size()]);
    }

    public String[] checkWordsTST(String[] text, String[] dictionary) {
        TST dictionaryTST = new TST();
        TST misspelledTST = new TST();

//        for (String word : dictionary) {
//            dictionaryTST.insert(word);
//        }
        dictionaryTST.insert("hello");
        dictionaryTST.insert("hippopotomus");
        System.out.println(dictionaryTST.lookUp("hello"));
        System.out.println(dictionaryTST.lookUp("hippopotomus"));
        System.out.println(dictionaryTST.lookUp("hippopotomu"));
        return null;
    }
}
