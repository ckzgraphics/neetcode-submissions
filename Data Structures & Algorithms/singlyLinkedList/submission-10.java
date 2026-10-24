

class LinkedList {

    class Node {
        int nodeValue = -1;
        Node nextNode = null;
        Node lastNode = null;

        public Node(int value) {
            nodeValue = value;
        }

    }

    Node node = null;
    boolean firstNodeFilled = false;

    public LinkedList() {
        if (Objects.isNull(node)) {
            node = new Node(-1);
        }
    }

    public int get(int index) {
        int value = -1;
        if (firstNodeFilled == false) {
            return value;
        } else {
            Node currentNode = node;
            for (int idx = 0; idx <= index; idx++) {
                if (idx == index) {
                    value = currentNode.nodeValue;
                    break;
                }
                if (currentNode.nextNode == null) {
                    break;
                }
                currentNode = currentNode.nextNode;
            }
        }
        return value;
    }

    // CASES:
    // 1st NODE EMPTY
    // 1st NODE PRESENT
    public void insertHead(int val) {
        // System.out.println("\n-----> firstNodeFilled: " + firstNodeFilled + ": " + val + " | node.nodeValu: " + node.nodeValue);
        if (firstNodeFilled == false) { // 1st NODE EMPTY
            node.nodeValue = val;
            node.lastNode = node;
            firstNodeFilled = true;
        } else { // 1st NODE PRESENT
            Node newNode = new Node(val);
            newNode.lastNode = node.lastNode;
            newNode.nextNode = node;
            node = newNode;
        }
    }

    // CASES:
    // 1st NODE IS LAST NODE
    // 1st NODE HAS NEXT NODE
    public void insertTail(int val) {
        if (firstNodeFilled == false) {
            node.nodeValue = val;
            node.lastNode = node;
            firstNodeFilled = true;
        } else {
            Node newNode = new Node(val);
            Node lastNode = node.lastNode;
            lastNode.nextNode = newNode;
            node.lastNode = newNode;
        }

    }

    /*
     * CASES
     * INVALID INDEX
     * 1st NODE
     * LAST NODE
     * MIDDLE NODE
     */

    public boolean remove(int index) {
        Node currNode = node;
        Node prevNode = null;
        boolean isRemoved = false;
        for (int idx = 0; idx <= index; idx++) {

            if (idx == index) {
                // System.out.println("\n-----> currNode.nextNode: " + currNode.nextNode + " : " + firstNodeFilled + "\n");
                if (idx == 0) { // REMOVE NODE 0
                    if (firstNodeFilled == false) { // REMOVE NODE 0 | LINKEDLIST EMPTY
                        isRemoved = false;
                        break;
                    } else if (firstNodeFilled == true && currNode.nextNode == null) { // 1 ELEMENT ONLY
                        node.nodeValue = -1;
                        node.lastNode = node;
                        firstNodeFilled = false;
                        isRemoved = true;
                        break;
                    } else if (firstNodeFilled == true && currNode.nextNode != null) { // HAS ELEMENTS
                        // System.out.println("REMOVE: " + node.nodeValue);
                        node = node.nextNode;
                        // node.lastNode = node;
                        isRemoved = true;
                        break;
                    }
                } else if (currNode == null) {
                    break;
                } else if (currNode.nextNode == null) { // LAST NODE
                    prevNode.nextNode = null;
                    node.lastNode = prevNode;
                    isRemoved = true;
                    break;
                } else if (currNode.nextNode != null) { // MIDDLE NODE
                    prevNode.nextNode = currNode.nextNode;
                    isRemoved = true;
                    break;
                }

            }
            if (currNode != null) {
                prevNode = currNode;
                currNode = currNode.nextNode;
            } else {
                break;
            }

        } // FOR END

        return isRemoved;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> linkedListValues = new ArrayList<Integer>();
        Node currentNode = node;
        if (firstNodeFilled == false) {
            return linkedListValues;
        } else {
            while (currentNode != null) {
                linkedListValues.add(currentNode.nodeValue);
                currentNode = currentNode.nextNode;
            }
            return linkedListValues;
        }
    }

}
