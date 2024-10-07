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
        TSTNode previousNode = currentNode;
        int nextIndex;
        boolean isFinalLetter;
        for (int i = 0; i < s.length() - 1; i++) {
             nextIndex = 1;
            while (currentNode != null && s.charAt(i) != currentNode.getLetter()) {
                previousNode = currentNode;
                nextIndex = currentNode.findNum(s.charAt(i));
                currentNode = currentNode.getNode(nextIndex);
            }
            if (currentNode == null) {
                for (int j = 0; j < s.length() - i; j++) {
                    isFinalLetter = i + j == s.length() -1 ? true : false;
                    previousNode.addChildNode(nextIndex);
                    previousNode.setChildNode(nextIndex, isFinalLetter, s.charAt(i + j));
                    previousNode = previousNode.getNode(nextIndex);
                    nextIndex = 1;
                }
                break;
            }
            else {
                previousNode = currentNode;
                currentNode = currentNode.getNode(1);
            }
        }
    }

    public boolean lookUp(String s) {
        TSTNode currentNode = root;
        TSTNode nextNode;
        int nextIndex;
        boolean isFinal;
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
