import java.util.ArrayList;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 * */

public class SpellCheck {

    int PREFIX_LENGTH = 4;


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {

        // Array that stores the indicies of the first occurence of each prefix with the
        // corresponding two digit letters with a mapping to 01 and z being 26.
        long[] prefixes = new long[26262626];
        ArrayList<String> notRealWords = new ArrayList<>();


//      For every word in the dictionary
        for (int i = 0; i < dictionary.length; i++) {
            int num = 0;
            // Take each of their letters, assign an integer value, then convert into a series of
            // integers that represents its location in the map.
            if (dictionary[i].length() > PREFIX_LENGTH)
                num = obtainIndex(prefixes, PREFIX_LENGTH, dictionary[i]);
            else
                num = obtainIndex(prefixes, dictionary[i].length(), dictionary[i]);
            // If this is the first instant of this specific prefix, place the index of the word in
            // the dictionary, into the prefix array to mark it as such.
            if (prefixes[num] != 0)
                prefixes[num] = i;
        }

        for (String word : text) {
            int value = 0;
            int temp = 0;
            boolean located = false;
            if (word.length() > PREFIX_LENGTH) {
                value = obtainIndex(prefixes, PREFIX_LENGTH, word);
                while (temp == 0) {

                }
            }
            else {
                value = obtainIndex(prefixes, word.length(), word);
                if (prefixes[value] == 0 && notRealWords.indexOf(word) == -1)
                    notRealWords.add(word);
            }
        }

        String[] mispelledWords = new String[notRealWords.size()];
        return notRealWords.toArray(mispelledWords);
    }

    public int obtainIndex(long[] prefixes, int length, String word) {
        String temp = "";
        for (int i = 0; i < length; i++) {
            if ((word.charAt(i) - 96) < 10)
                temp += "0" + (word.charAt(i) - 96);
            else
                temp += word.charAt(i) - 96;
        }
        return (int)Long.parseLong(temp);
    }
}
