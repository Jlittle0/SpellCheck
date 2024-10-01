public class Trie {

    private Node root;

    public Trie(Node root) {
        this.root = root;
    }

    public void insert(String s) {
        Node currentNode = root;
        for (int i = 0; i < s.length(); i++) {
            if (currentNode.getNodes()[s.charAt(i)] == null && i != s.length() - 1) {
                currentNode.getNodes()[s.charAt(i)] = new Node(false, new Node[255]);
                currentNode = currentNode.getNodes()[s.charAt(i)];
            }
            else if (currentNode.getNodes()[s.charAt(i)] == null && i == s.length() - 1) {
                currentNode.getNodes()[s.charAt(i)] = new Node(true, new Node[255]);
            }
            else if (currentNode.getNodes()[s.charAt(i)] != null && i == s.length() - 1) {
                currentNode.getNodes()[s.charAt(i)] = new Node(true, new Node[255]);
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
        if (s.equals("dinah'll")) {
            System.out.println("test04");
            System.out.println(currentNode.isWord());
        }
        return currentNode.isWord();
    }
}
