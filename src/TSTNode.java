public class TSTNode {
    public TSTNode[] nodes;
    private boolean isFinalLetter;
    private char letter;

    public TSTNode() {
        nodes = new TSTNode[3];
    }

    public TSTNode(boolean isFinalLetter, char letter) {
        this.isFinalLetter = isFinalLetter;
        this.letter = letter;
        nodes = new TSTNode[3];
    }

    public int findNode(char c) {
        if (c < letter)
            return 0;
        else if (c == letter)
            return 1;
        else
            return 2;
    }

    public void setNode(int num, boolean isFinalLetter, char c) {
        nodes[num] = new TSTNode(isFinalLetter, c);
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
}
