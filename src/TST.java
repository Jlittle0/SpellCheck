public class TST {
    private TSTNode root;
    private boolean first = true;

    public TST(TSTNode node) {
        root = node;
    }

    public TST() {
        root = new TSTNode();
    }

    public void insert(String s) {
        // If this is the first instance of a word being inserted, set the root to the first
        // character and set status of whether or not it's the end of a word appropriately.
        if (first) {
            root.setLetter(s.charAt(0));
            root.setFinalLetter(false);
            if (s.length() == 1)
                root.setFinalLetter(true);

            first = false;
        }
        // Create tracker nodes for the current node and previous one to allow you to use
        // methods etc. on something that isn't null (the previousNode) while checking the
        // current one.
        TSTNode currentNode = root;
        TSTNode previousNode = currentNode;
        int nextIndex;
        boolean isFinalLetter;
        for (int i = 0; i < s.length(); i++) {
            // For every letter in the word, check whether or not it's the last letter
            // Might be able to simplify this to remove the ? true : false part but not sure yet.
            isFinalLetter = i == s.length() -1 ? true : false;
             nextIndex = 1;
             // Then find the first instance where we need to accept the current node where it's
            // either a null value, and we input our own new value, or it's equal to desired letter.
            while (currentNode != null && s.charAt(i) != currentNode.getLetter()) {
                previousNode = currentNode;
                nextIndex = currentNode.findNum(s.charAt(i));
                currentNode = currentNode.getNode(nextIndex);
            }
            // If the node we accept is a null node, then replace it with the current letter and
            // status of isFinal etc. and just go straight down since there's no more need to
            // check whether to move right or left since there's nothing there and we just
            // want to put the rest of our own word there.
            if (currentNode == null) {
                // This allows for the rest of the word to be placed under new node in TST.
                for (int j = 0; j < s.length() - i; j++) {
                    isFinalLetter = i + j == s.length() -1 ? true : false;
                    previousNode.addChildNode(nextIndex);
                    previousNode.setChildNode(nextIndex, isFinalLetter, s.charAt(i + j));
                    previousNode = previousNode.getNode(nextIndex);
                    nextIndex = 1;
                }
                break;
            }
            // Otherwise, if there's a node at our acceptec location and it's the last letter then
            // set the value as such
            else if (isFinalLetter){
                currentNode.setFinalLetter(true);
            }
            // Finally if we've accepted the node, there's a value there, and it's not the end of a
            // word, then set the previousNode to the curent, and move down one step since
            // now previousNode is known to not be null and will work in all above cases.
            else {
                previousNode = currentNode;
                currentNode = currentNode.getNode(1);
            }
        }
    }

    public boolean lookUp(String s) {
        TSTNode currentNode = root;
        TSTNode previousNode = currentNode;
        int nextIndex;
        boolean isFinal;
        // Very similar to insertion, for every letter in the word
        for (int i = 0; i < s.length(); i++) {
            // Check if it's the final letter
            isFinal = i == s.length() - 1 ? true : false;
            // And then continue moving through the TST until we either find the node we want
            // or realize that it's an empty node and what we want doesn't exist in the TST.
            while (currentNode != null && s.charAt(i) != currentNode.getLetter()) {
                previousNode = currentNode;
                nextIndex = currentNode.findNum(s.charAt(i));
                currentNode = currentNode.getNode(nextIndex);
            }
            // If it's the last node of a word and there's a value there, return the isFinal status
            // of said node to check if it's an actual word or not.
            if (isFinal && currentNode != null) {
                return currentNode.isFinal();
            }
            // Otherwise, if the current node is null then that means our word doesn't exist.
            else if (currentNode == null) {
                    return false;
            }
            //  And finally if we just accept the node and there's a value there, move down.
            else {
                previousNode = currentNode;
                currentNode = currentNode.getNode(1);
            }
        }
        return false;
    }

    public TSTNode getRoot() {
        return root;
    }
}
