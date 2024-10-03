public class TST {
    private TSTNode root;

    public TST(TSTNode node) {
        root = node;
    }

    public TST() {
        root = new TSTNode();
    }

    public void insert(String s) {
        if (root == null) {
            if (s.length() == 1)
                root = new TSTNode(true, s.charAt(0));
            else
                root = new TSTNode(false, s.charAt(0));
        }
        TSTNode currentNode = root;
        boolean isFinalLetter = false;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1)
                isFinalLetter = true;
            if (currentNode == null) {
                System.out.println("char2: " + s.charAt(i));
                currentNode = new TSTNode(isFinalLetter, s.charAt(i));
                System.out.println("num: " + currentNode.findNode(s.charAt(i)));
                currentNode = currentNode.getNode(currentNode.findNode(s.charAt(i)));
            }
            else {
//                currentNode.setNode(currentNode.findNode(s.charAt(i)), isFinalLetter, s.charAt(i));
                System.out.println("char: " + s.charAt(i));
                System.out.println("num: " + currentNode.findNode(s.charAt(i)));
                currentNode = currentNode.getNode(currentNode.findNode(s.charAt(i)));
            }
        }
    }

    public void insertTest(String s) {
        boolean isFinalLetter = false;
        TSTNode currentNode = root;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1)
                isFinalLetter = true;
            if (currentNode == null) {
                currentNode.setValue(isFinalLetter, s.charAt(i));
                System.out.println("current: " + currentNode.getLetter());
                System.out.println("root: " + root.getLetter());
                currentNode = currentNode.getNode(currentNode.findNode(s.charAt(i)));
            }
            else {
//                currentNode.setNode(currentNode.findNode(s.charAt(i)), isFinalLetter, s.charAt(i));
                currentNode = currentNode.getNode(currentNode.findNode(s.charAt(i)));
            }
        }
    }

    public boolean lookUp(String s) {
        // Not sure if this fully works yet, need to check how lookUps actually work and whether
        // I just need to be checking if the new currentNode is a final letter at the end,
        // whether it's null, or what.
        TSTNode currentNode = root;
        int value;
        boolean letterFound;
        // Might need to change to just s.length() and not -1.
        for (int i = 0; i < s.length() - 1; i++) {
            System.out.println("second: " + s.charAt(i));
            letterFound = false;
            value = s.charAt(i);
            while (!letterFound) {
                // If the letter is less than the currentNode letter, go left
                if (currentNode == null)
                    return false;
                else if (value < currentNode.getLetter())
                    currentNode = currentNode.getNode(0);
                    // If the letters are equal, go down
                else if (value == currentNode.getLetter()) {
                    currentNode = currentNode.getNode(1);
                    letterFound = true;
                 }
                    // If the letter is greater than currentNode letter, go right.
                else if (value > currentNode.getLetter())
                    currentNode = currentNode.getNode(2);
                else
                    System.out.println("An error has occured looking up a value");
            }
        }
        return currentNode.isFinal();
    }

    public TSTNode getRoot() {
        return root;
    }
}
