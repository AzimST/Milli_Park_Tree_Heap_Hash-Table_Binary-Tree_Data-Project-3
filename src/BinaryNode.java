public class BinaryNode {
    private int iData;
    private BinaryNode leftChild;
    private BinaryNode rightChild;


    // constructor
    public BinaryNode(int iData) {
        this.iData = iData;
    }
















    public BinaryNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryNode rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryNode leftChild) {
        this.leftChild = leftChild;
    }

    public int getiData() {
        return iData;
    }

    public void setiData(int iData) {
        this.iData = iData;
    }
}
