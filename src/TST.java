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
        if (first) {
            root.setLetter(s.charAt(0));
            first = false;
        }
        TSTNode currentNode = root;
        TSTNode nextNode;
        int nextIndex;
        boolean isFinalLetter;
        for (int i = 0; i < s.length(); i++) {
            nextNode = currentNode.findNode(s.charAt(i));
            nextIndex = currentNode.findNum(s.charAt(i));
            isFinalLetter = i == s.length() -1 ? true : false;
            if (nextNode == null) {
                nextIndex = 1;
                currentNode.addChildNode(nextIndex);
                currentNode.setNode(isFinalLetter, s.charAt(i));
                currentNode = currentNode.getNode(nextIndex);
            }
            else {
                currentNode = currentNode.getNode(nextIndex);;
            }
        }
    }

    public boolean lookUp(String s) {
        TSTNode currentNode = root;
        TSTNode nextNode;
        int nextIndex;
        boolean isFinal;
        // Might need to change to just s.length() and not -1.
        for (int i = 0; i < s.length() - 1; i++) {
            isFinal = i == s.length() - 2 ? true : false;
            nextNode = currentNode.findNode(s.charAt(i));
            nextIndex = currentNode.findNum(s.charAt(i));
            if (nextNode == null)
                return false;
            if (isFinal) {
                return nextNode.isFinal();
            }
            else {
                currentNode = currentNode.getNode(nextIndex);
            }
        }
        return false;
    }

    public TSTNode getRoot() {
        return root;
    }
}
