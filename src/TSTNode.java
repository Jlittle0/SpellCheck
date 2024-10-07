public class TSTNode {
    private TSTNode[] nodes;
    private boolean isFinalLetter;
    private char letter;

    public TSTNode() {
        nodes = new TSTNode[3];
    }

    public int findNum(char c) {
        // Determines whether or not to move left, right, or straight down by comparing letters.
        if (c < letter)
            return 0;
        else if (c == letter)
            return 1;
        else if (c > letter)
            return 2;
        else
            return -1;
    }

    public void setChildNode(int num, boolean isFinalLetter, char c) {
        // Sets the status of isFinalLetter and the letter of node at the index num
        nodes[num].setLetter(c);
        nodes[num].setFinalLetter(isFinalLetter);
    }

    public void addChildNode(int num) {
        // When a child node is null but we need to move to it, creates a node to place there.
        nodes[num] = new TSTNode();
    }

    public TSTNode getNode(int num) {
        return nodes[num];
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char c) {
        this.letter = c;
    }

    public boolean isFinal() {
        return isFinalLetter;
    }

    public void setFinalLetter(boolean isFinal) {
        isFinalLetter = isFinal;
    }
}
