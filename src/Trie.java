public class Trie {

    private Node root;

    public Trie(Node root) {
        this.root = root;
    }

    public void insert(String s) {
        Node currentNode = root;
        boolean isLast;
        for (int i = 0; i < s.length(); i++) {
            // Felt old version was very bulky so found out how to do this in one line
             isLast = i == s.length() -1 ? true : false;
            if (currentNode.getNodes()[s.charAt(i)] == null) {
                currentNode.getNodes()[s.charAt(i)] = new Node(isLast, new Node[255]);
                currentNode = currentNode.getNodes()[s.charAt(i)];
            }
            else if (currentNode.getNodes()[s.charAt(i)] != null && i == s.length() - 1) {
                currentNode.getNodes()[s.charAt(i)].setFinalLetter();
            }
            else {
                currentNode = currentNode.getNodes()[s.charAt(i)];
            }
        }
    }

    public boolean lookUp(String s) {
        Node currentNode = root;
        // Search the tree and look for the instance of the word s
        for (int i = 0; i < s.length(); i++) {
            if (currentNode.getNodes()[s.charAt(i)] == null) {
                return false;
            }
            currentNode = currentNode.getNodes()[s.charAt(i)];
        }
        return currentNode.isWord();
    }
}
