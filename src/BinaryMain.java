public class BinaryMain {
    public static void main(String[] args){
        BinaryTree theTree = new BinaryTree();


        theTree.insert(50);
        theTree.insert(25);
        theTree.insert(75);
        theTree.insert(33);
        theTree.insert(45);
        theTree.insert(48);
        theTree.insert(30);
        theTree.insert(36);
        theTree.insert(41);
        theTree.insert(49);

        BinaryNode found = theTree.find(30);
        if(found!= null){System.out.println("Found the node ");}
        else{System.out.println("Not Found the node ");}
        theTree.inOrder(theTree.getRoot());
        String a = "Yozgat Çamlığı Milli Parkı";
        String b = "Karatepe - Aslantaş Milli Parkı";
        String c = "bot";
        String d = "yozgat";
        System.out.println("1111111111111111");
        System.out.println(d.substring(0,3).compareTo(c));

    }
}
