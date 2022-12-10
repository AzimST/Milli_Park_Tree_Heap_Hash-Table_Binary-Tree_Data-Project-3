import java.util.ArrayList;
import java.util.List;

public class Heap{

    class Node{
        private int data;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    private List<Node> heapList;
    private int size;
    private int maxSize;

    public Heap(int maxSize) {
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

    public Boolean insert(int data){

        if(size == maxSize){
            return false;
        }
        heapList.add(new Node(data));
//        heapList.set(size,new Node(data));
        trickleUp(size++);
        return true;
    }

    public void trickleUp(int i){
        int parent = (i-1) / 2;
        Node bottom = heapList.get(i);
        while (i>0 && heapList.get(parent).getData() < bottom.getData()){
            heapList.set(i,heapList.get(parent));
            i = parent;
            parent = (parent-1)/2;
        }
        heapList.set(i,bottom);
    }

    public Node remove(){
        Node root = heapList.get(0);
        heapList.set(0,heapList.get(--size));
        trickeDown(0);
        return root;
    }

    public void trickeDown(int i){

        int largerChild;
        Node top = heapList.get(i);
        while (i < size/2){
            int leftChild = 2*i+1;
            int rightChild = leftChild+1;

            if(rightChild < size && heapList.get(leftChild).getData() < heapList.get(rightChild).getData())
                largerChild = rightChild;
            else
                largerChild = leftChild;

            if(top.getData() >= heapList.get(largerChild).getData())
                break;

            heapList.set(i,heapList.get(largerChild));
            i = largerChild;
        }
        heapList.set(i,top);
    }

    public boolean swap(int i, int newVal){

        if(i<0 || i > size){
            return false;
        }
        int oldVal = heapList.get(i).getData();
        heapList.get(i).setData(newVal); //TODO buradan emin değilim yeniden bak

        if(oldVal < newVal)
            trickleUp(i);
        else
            trickeDown(i);
        return true;

    }

    public void display(){
        for(int i = 0;i<size;i++){
            if(heapList.get(i) != null)
                System.out.println(heapList.get(i).getData()+" ");
            else
                System.out.println("** ");
        } System.out.println();

        int blanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "................................";
        System.out.println(dots+dots);

        while (size>0){
            if(column == 0){
                for (int k = 0; k<blanks;k++){
                    System.out.println(" ");
                }
            }
            System.out.println(heapList.get(j).getData());
            if(++j == size)
                break;

            if(++column  == itemsPerRow){
                blanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            }else
                for(int k=0;k<blanks*2-2;k++){
                    System.out.println(" ");
                }
        }
        System.out.println("\n"+dots+dots);
    }




}