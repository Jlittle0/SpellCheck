public class TSTNode {
    private TSTNode[] nodes;
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

    public TSTNode findNode(char c) {
        if (c < letter)
            return nodes[0];
        else if (c == letter)
            return nodes[1];
        else if (c > letter)
            return nodes[2];
        else
            return null;
    }

    public int findNum(char c) {
        if (c < letter)
            return 0;
        else if (c == letter)
            return 1;
        else if (c > letter)
            return 2;
        else
            return -1;
    }

    public void setNode(boolean isFinalLetter, char c) {
        letter = c;
        if (!this.isFinalLetter)
            this.isFinalLetter = isFinalLetter;
    }

    public void setChildNode(int num, boolean isFinalLetter, char c) {
        nodes[num].setLetter(c);
        nodes[num].setFinalLetter(isFinalLetter);
    }

    public void addChildNode(int num) {
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
