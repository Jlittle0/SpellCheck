public class TST {
    private Node root;

    public TST() {
        root = null;
    }

    public void insert(String s) {
        Node currentNode = root;
        for (int i = 0; i < s.length(); i++) {
            currentNode.setNode(findNode(s));
        }
        // Stuff
    }

    public boolean loopUp(String s) {
        //Stuff
        return false;
    }
}
