import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

    class Node{
        private MilliPark key;

        public Node(MilliPark key) {
            this.key = key;
        }

        public MilliPark getData() {
            return key;
        }

        public void setData(MilliPark key) {
            this.key = key;
        }
    }

    private List<Node> heapList;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        this.heapList = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
    }


    // returning the position of parent
    public int parent(int pos){return (pos-1)/2;}
    //returning the position of left child
    public int leftChild(int pos){return (2*pos)+1;}
    // returning the position of right child
    public int rightChild(int pos){return (2*pos)+2;}

    // returning true if Heap is empty
    public Boolean isEmpty(){
        return size == 0;
    }

    public Boolean insert(MilliPark key){

        if(size == maxSize){
            return false;
        }
        heapList.add(new Node(key));
//        heapList.set(size,new Node(key));
        trickleUp(size++);
        return true;
    }

    public void trickleUp(int i){
        int parent = (i-1) / 2;
        Node bottom = heapList.get(i);
        while (i>0 && heapList.get(parent).getData().getmPHektar() < bottom.getData().getmPHektar()){
            heapList.set(i,heapList.get(parent));
            i = parent;
            parent = (parent-1)/2;
        }
        heapList.set(i,bottom);
    }

    public Node remove(){
        Node root = heapList.get(0);
        heapList.set(0,heapList.get(--size));
        trickleDown(0);
        return root;
    }

    public void trickleDown(int i){

        int largerChild;
        Node top = heapList.get(i);
        while (i < size/2){
            int leftChild = 2*i+1;
            int rightChild = leftChild+1;

            if(rightChild < size &&
                    heapList.get(leftChild).getData().getmPHektar() <
                            heapList.get(rightChild).getData().getmPHektar())

                largerChild = rightChild;
            else
                largerChild = leftChild;

            if(top.getData().getmPHektar() >= heapList.get(largerChild).getData().getmPHektar())
                break;

            heapList.set(i,heapList.get(largerChild));
            i = largerChild;
        }
        heapList.set(i,top);
    }

    public boolean swap(int i, MilliPark newVal){

        if(i<0 || i > size){
            return false;
        }
        MilliPark oldVal = heapList.get(i).getData();
        heapList.get(i).setData(newVal);

        if(oldVal.getmPHektar() < newVal.getmPHektar())
            trickleUp(i);
        else
            trickleDown(i);
        return true;
    }

    public int size(){
        return size;
    }

    public List<Node> displayHeapList(){

        return heapList;
    }


}

