public class AlphaNode {
    private MilliPark mp;
    private String word;
    private int mpCount;
    public AlphaNode leftChild;
    public AlphaNode rightchild;




    public AlphaNode(String word){
        this.word = word;
        this.mpCount=1;
    }
    public AlphaNode(MilliPark mp) {
        this.mp = mp;
    }

    public int getMpCount() {
        return mpCount;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void countadd(){this.mpCount++;}

    @Override
    public String toString() {
        return "AlphaNode{" +
                "kelime='" + word + '\'' +
                ", tekrar=" + mpCount +
                '}';
    }

    public MilliPark getMp() {return mp;}
    public void setMp(MilliPark mp) {this.mp = mp;}
    public AlphaNode getLeftChild() {return leftChild;}
    public void setLeftChild(AlphaNode leftChild) {this.leftChild = leftChild;}
    public AlphaNode getRightchild() {return rightchild;}
    public void setRightchild(AlphaNode rightchild) {this.rightchild = rightchild;}

}
