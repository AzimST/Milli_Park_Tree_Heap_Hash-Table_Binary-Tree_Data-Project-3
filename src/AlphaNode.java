public class AlphaNode {
    private MilliPark mp;
    private int mpCount;
    private AlphaNode leftChild;
    private AlphaNode rightchild;


    public AlphaNode(MilliPark mp) {
        this.mp = mp;
        this.mpCount = 0;
    }

    public void countadd(){this.mpCount++;}















    public MilliPark getMp() {return mp;}
    public void setMp(MilliPark mp) {this.mp = mp;}
    public AlphaNode getLeftChild() {return leftChild;}
    public void setLeftChild(AlphaNode leftChild) {this.leftChild = leftChild;}
    public AlphaNode getRightchild() {return rightchild;}
    public void setRightchild(AlphaNode rightchild) {this.rightchild = rightchild;}
}
