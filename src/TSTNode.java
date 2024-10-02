public class TSTNode {
    private Node[] nodes;
    private boolean isFinalLetter;
    private char letter;

    public TSTNode() {
        nodes = new Node[3];
    }

    public TSTNode(boolean isFinalLetter, char letter) {
        this.isFinalLetter = isFinalLetter;
        this.letter = letter;
        nodes = new Node[3];
    }

    public int findNode(char c) {
        if (c < letter)
            return 0;
        else if (c == letter)
            return 1;
        else
            return 2;
    }

    public int setNode(int num, boolean isFinalLetter, char c) {
        nodes[num].setFinalLetter(isFinalLetter);
        nodes[num].setLetter(c);
    }
}
