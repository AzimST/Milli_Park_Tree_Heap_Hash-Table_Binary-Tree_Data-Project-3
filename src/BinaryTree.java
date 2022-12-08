public class BinaryTree {

    private BinaryNode root;

    public BinaryNode find(int key) {
        BinaryNode current = root;
        while (current.getiData() != key) {
            if (key < current.getiData()) {current = current.getLeftChild();}
            else {current = current.getRightChild();}
            if (current == null) {return null;}
        }
        return current;
    }
    public void insert(int id){
        BinaryNode newNode = new BinaryNode(id);
        BinaryNode current = root;
        if(root==null){root = newNode;}
        else{
            BinaryNode parent;
            while(true){
                parent = current;
                if(id< current.getiData()){ //go left
                    current = current.getLeftChild();
                    if(current == null){
                        parent.setLeftChild(newNode);
                        return;
                    }
                } // end go left
                else{
                    current = current.getRightChild();
                    if(current == null){
                        parent.setRightChild(newNode);
                        return;
                    }
                } // end also go right
            } // end while
        } // end else not root
    } // end insert


    public void inOrder(BinaryNode localRoot){

        if(localRoot != null){
            inOrder(localRoot.getLeftChild());

            System.out.println(localRoot.getiData()+" ");

            inOrder(localRoot.getRightChild());
        }
    }

    public void preOrder(BinaryNode localRoot){

    }


    public void delete(int id){}


    public BinaryNode getRoot() {
        return root;
    }


}
