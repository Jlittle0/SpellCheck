public class Node {
    private boolean isFinalLetter;
    public Node[] next;

    public Node (boolean isFinalLetter, Node[] next) {
        this.isFinalLetter = isFinalLetter;
        this.next = next;
    }

    // Returns whether the current node is the end of a word or not.
    public boolean isWord() {
        return isFinalLetter;
    }

    // Sets the status of a node to be the end of a word.
    public void setFinalLetter() {
        isFinalLetter = true;
    }

    // Returns the array of nodes it stores as "children" nodes.
    public Node[] getNodes() {
        return next;
    }

    // Sets the array of nodes it stores to the given array
    public void setNodes(Node[] next) {
        this.next = next;
    }
}
