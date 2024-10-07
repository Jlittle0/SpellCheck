public class Trie {

    private Node root;

    public Trie(Node root) {
        this.root = root;
    }

    public void insert(String s) {
        Node currentNode = root;
        boolean isLast;
        // For every letter in the word...
        for (int i = 0; i < s.length(); i++) {
            // Find out whether or not it's the last latter of the word (learned how to do this
            // while working on TSTs since I needed to check this condition a lot and felt like
            // using three or four lines etc. was just a waste).
             isLast = i == s.length() -1 ? true : false;
             // If the node we want to access to input the current letter is null (or empty)
            // then we want to set it to a new node and move our current node to that space.
            if (currentNode.getNodes()[s.charAt(i)] == null) {
                currentNode.getNodes()[s.charAt(i)] = new Node(isLast, new Node[255]);
                currentNode = currentNode.getNodes()[s.charAt(i)];
            }
            // Otherwise if there's already something there and we're on the last letter of a word
            // set it to the end of a word.
            else if (currentNode.getNodes()[s.charAt(i)] != null && isLast) {
                currentNode.getNodes()[s.charAt(i)].setFinalLetter();
            }
            // Finally, if there's something there already and we aren't on the final letter of
            // a word, then just move to that location and repeat.
            else {
                currentNode = currentNode.getNodes()[s.charAt(i)];
            }
        }
    }

    public boolean lookUp(String s) {
        Node currentNode = root;
        // Search the tree and look for the instance of the word s
        for (int i = 0; i < s.length(); i++) {
            // If the space we want to go to to check for our current letter, that means
            // the word isn't present and we should return false.
            if (currentNode.getNodes()[s.charAt(i)] == null) {
                return false;
            }
            // otherwise, move to the location of the current letter and repeat in the for loop.
            currentNode = currentNode.getNodes()[s.charAt(i)];
        }
        // return the status of the final letter regarding whether or not it's the end of a word
        return currentNode.isWord();
    }
}
