public class Node {
    private boolean isFinalLetter;
    Node[] next;

    public Node (boolean isFinalLetter, Node[] next) {
        this.isFinalLetter = isFinalLetter;
        this.next = next;
    }

    public boolean isWord() {
        return isFinalLetter;
    }

    public void setFinalLetter() {
        isFinalLetter = true;
    }

    public Node[] getNodes() {
        return next;
    }

    public void setNodes(Node[] next) {
        this.next = next;
    }
}
