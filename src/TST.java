public class TST {
    private TSTNode root;

    public TST() {
        root = null;
    }

    public void insert(String s) {
        TSTNode currentNode = root;
        boolean isFinalLetter = false;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1)
                isFinalLetter = true;
            currentNode.setNode(currentNode.findNode(s.charAt(i)), isFinalLetter, s.charAt(i));
            currentNode = currentNode.getNode(currentNode.findNode(s.charAt(i)));
        }
    }

    public boolean lookUp(String s) {
        // Not sure if this fully works yet, need to check how lookUps actually work and whether
        // I just need to be checking if the new currentNode is a final letter at the end,
        // whether it's null, or what.
        TSTNode currentNode = root;
        int value;
        for (int i = 0; i < s.length(); i++) {
            value = s.charAt(i);
            // If the letter is less than the currentNode letter, go left
            if (value < currentNode.getLetter())
                currentNode = currentNode.getNode(0);
            // If the letters are equal, go down
            else if (value == currentNode.getLetter())
                currentNode = currentNode.getNode(1);
            // If the letter is greater than currentNode letter, go right.
            else if (value > currentNode.getLetter())
                currentNode = currentNode.getNode(2);
            else
                System.out.println("An error has occured looking up a value");
            if (currentNode == null)
                return false;
        }
        return currentNode.isFinal();
    }
}
