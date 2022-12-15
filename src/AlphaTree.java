import java.util.ArrayList;

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

    public void insertWord(String s){
        String w = s.replace(".", "");
        String a = w.replace(",","");
        // \r kendisinden önce gelen string ifadeyi sildiği ve bu hatanın önüne geçemediğim için \r ile "" yer değiştirdim
        String b =a.toLowerCase().replace("\"","");
        String c =b.toLowerCase().replace("(","");
        String d =c.toLowerCase().replace(")","");
        String r =d.toLowerCase().replace("%","");
        String word =r.toLowerCase().replace("\r","");
        try {
            int foo = Integer.parseInt(word.substring(0,1));
        }
        catch (Exception e) {
            if(!word.equals(" ")){
                AlphaNode newNode = new AlphaNode(word);
                if(root == null){root = newNode;}

                else {
                    AlphaNode current = root;
                    AlphaNode parent;
                    while (true) {
                        parent = current;
                    //    System.out.println(newNode.getWord()+"--"+current.getWord()+"--"+newNode.getWord().compareTo(current.getWord()));
                        if (newNode.getWord().compareTo(current.getWord())==0) {
                            current.countadd(); // if mp.name and current node mp.name equals add count
                            return;
                        } else if (newNode.getWord().compareTo(current.getWord()) > 0) { // if mp.word>current.word go to right child
                            current = current.rightchild;
                            if (current == null) {
                                parent.rightchild = newNode;
                                return;
                            }
                        } // end go to right
                        else if (newNode.getWord().compareTo(current.getWord()) < 0) { // go to left child
                            current = current.leftChild;
                            if (current == null) {
                                parent.leftChild = newNode;
                                return;
                            }
                        }// end left go
                    }// end while
                }// end else no root
            }
    }
    }// end insert

// BU METHOD GIRILEN ILK 3 HARFI GIRILEN MILLI PARKI BULAN METHOD
    public AlphaNode findNodebyThreeLetters(String letter){
        AlphaNode current = root;

        while(current.getMp().getmPIsim().substring(0,3).toLowerCase().compareTo(letter.toLowerCase()) != 0){

            if(current.getMp().getmPIsim().substring(0,3).toLowerCase().compareTo(letter.toLowerCase()) > 0){
                current = current.getLeftChild();
            }
            else if(current.getMp().getmPIsim().substring(0,3).toLowerCase().compareTo(letter.toLowerCase()) < 0){
                current = current.getRightchild();
            }
            if(current == null){return null;}
        }
        return current;
    }

    // POSTORDER ŞEKLİNDE EKRANA BASTIRIR
    public void postOrder(AlphaNode localRoot,AlphaTree wordTree){
        if(localRoot != null) {
            if (localRoot.getMp() != null){
//                System.out.println(localRoot.getMp());
                for(String sentence:localRoot.getMp().getSentences()){
                    String[] words = sentence.split(" ");
                    for(String word: words){
                        wordTree.insertWord(word);
                    }
                }
            }
            postOrder(localRoot.getLeftChild(),wordTree);
            postOrder(localRoot.getRightchild(),wordTree);
            // eğer alpha nodeun MilliPArkı null ise kelimeleri yazdırıyor

        }
    }

    public void postOrderWord(AlphaNode localRoot){
        if(localRoot != null) {
            postOrderWord(localRoot.getLeftChild());
            postOrderWord(localRoot.getRightchild());
            // eğer getword null degil ise ekrana bastırır
            if (localRoot.getWord() != null){
                System.out.println(localRoot);
            }
        }
    }


//    // cumleleri kelime kelime insert worde yollayan method
//    public void treeBySentences(String[] sentences) {
//    AlphaTree theWordTree = new AlphaTree();
//        for (String s : sentences){
//            String[] sentence = s.split(" ");
//            for (String word : sentence){
//                // kelimeyi agaca ekliyoruz
//                theWordTree.insertWord(word);
//            }
//        }
//        theWordTree.postOrder(theWordTree.getRoot());
//    }

    // ROOT'UNU ALDIGI AGACIN DERNILIGINI DONDUREN METHOD
    public int depthofThree(AlphaNode root){
        if(root == null){return 0;}
        else if(root.getRightchild() == null && root.getLeftChild() == null){return 1;}
        else if (root.getLeftChild()==null){return depthofThree(root.getRightchild())+1;}
        else if (root.getRightchild() == null){return depthofThree(root.getLeftChild())+1;}


        return Math.max(depthofThree(root.getLeftChild()),
                depthofThree(root.getRightchild())) + 1;

    }

    // bu kod blogu listedki eleman sayısında dengeli bir tree olsaydı kaç derinligine sahip olduğunu ekrana yazdırır
    public void blancedTree(ArrayList mpList){
        int listSize = mpList.size();
        double depth =  Math.log(listSize)/Math.log(2);
        System.out.println((int) depth+1);

    }

    public AlphaNode getRoot() {return root;}
    public void setRoot(AlphaNode root) {this.root = root;}
}
