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
        // Uncomment whichever test you want to run, both work :D
//        return checkWordsTrie(text, dictionary);
        return checkWordsTST(text, dictionary);
    }

    public String[] checkWordsTrie(String[] text, String[] dictionary) {
        // Create two Tries, one for the dictionary and the other to hold misspelled words.
        Trie dictionaryTrie = new Trie(new Node(false, new Node[SIZE]));
        Trie misspelledTrie = new Trie(new Node(false, new Node[SIZE]));
        // Create an arraylist that also holds a copy of the misspelled words to eventually
        // convert into an array of strings.
        ArrayList<String> badWords = new ArrayList<>();

//      For every word in the dictionary
        for (String word : dictionary) {
            // Insert it into the dictionary trie.
            dictionaryTrie.insert(word);
        }

        // For every word in the text
        for (String word : text) {
            // Check if it's in the dictionary or misspelled word trie and if not, add to misspelled
            if (!dictionaryTrie.lookUp(word) && !misspelledTrie.lookUp(word)) {
                misspelledTrie.insert(word);
                badWords.add(word);
            }
        }

        // Return an array version of the badWords arraylist that holds a copy of all misspelled
        return badWords.toArray(new String[badWords.size()]);
    }

    public String[] checkWordsTST(String[] text, String[] dictionary) {
        // Create two TSTs and an arraylist to store dictionary and misspelled words
        TST dictionaryTST = new TST();
        TST misspelledTST = new TST();
        ArrayList<String> temp = new ArrayList<>();

        // For every word in the dictionary, insert it into the dictionary TST.
        for (String word : dictionary) {
            dictionaryTST.insert(word);
        }

        // For every word in the given text, check if it's in the dictionary or misspelled TST
        // and if it is, insert it into the misspelled TST as well as the arraylist of words.
        for (String word : text) {
            if (!dictionaryTST.lookUp(word) && !misspelledTST.lookUp(word)) {
                misspelledTST.insert(word);
                temp.add(word);
            }
        }

        // Return an array of strings of all the misspelled words by reading from an arraylist.
        return temp.toArray(new String[temp.size()]);
    }
}
