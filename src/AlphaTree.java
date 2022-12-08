public class AlphaTree {

    private AlphaNode root;



    public void insert(MilliPark mp){
        AlphaNode newNode = new AlphaNode(mp);
        AlphaNode current = root;
        if(root == null){root = newNode;}
        else{
            AlphaNode parent;
            while(true){
                parent = current;
                if(mp.getmPIsim().compareTo(current.getMp().getmPIsim())==0){
                    current.countadd(); // if mp.name and current node mp.name equals add count
                    return;
                }else if(mp.getmPIsim().compareTo(current.getMp().getmPIsim())>0){ // if mp.name>currentName go to right child
                    current = current.getRightchild();
                    if(current == null) {
                        parent.setRightchild(newNode);
                        return;
                    }
                } // end go to right
                else if (mp.getmPIsim().compareTo(current.getMp().getmPIsim())<0){ // go to left child
                    current = current.getLeftChild();
                    if(current == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                }// end left go
            }// end while
        }// end else no root
    }// end insert


    public void inOrder(AlphaNode localRoot){
            if(localRoot!=null){
                inOrder(localRoot.getLeftChild());
                localRoot.getMp().printToString();
                inOrder(localRoot.getRightchild());

            }
    }

    public void preOrder(AlphaNode localRoot){
        if(localRoot != null){
            localRoot.getMp().printToString();
            preOrder(localRoot.getLeftChild());
            preOrder(localRoot.getRightchild());
        }
    }

    public void postOrder(AlphaNode localRoot){
        if(localRoot != null){
            postOrder(localRoot.getLeftChild());
            postOrder(localRoot.getRightchild());
            localRoot.getMp().printToString();

        }

    }


    public int depthofThree(AlphaNode root){
        if(root == null){return 0;}
        else if(root.getRightchild() == null && root.getLeftChild() == null){return 1;}
        else if (root.getLeftChild()==null){return depthofThree(root.getRightchild())+1;}
        else if (root.getRightchild() == null){return depthofThree(root.getLeftChild())+1;}


        return Math.max(depthofThree(root.getLeftChild()),
                depthofThree(root.getRightchild())) + 1;

    }












    public AlphaNode getRoot() {return root;}
    public void setRoot(AlphaNode root) {this.root = root;}
}
