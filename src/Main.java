import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    static AlphaTree theWordTree = new AlphaTree();
    public static void main(String[] args) {

        Path filePath = Path.of("milli.txt");

        MilliPark m1 = new MilliPark();

        AlphaTree theTree = new AlphaTree();


        ArrayList<MilliPark> mpList = m1.MilliParkListele(filePath);

        Hashtable<String, MilliPark> ht = new Hashtable<>();

        // listededeki milli parklar ağaca sırayla eklenir
        for(MilliPark mp: mpList){
            theTree.insert(mp);
        }

        System.out.println("PostORder");
        theTree.postOrder(theTree.getRoot(),theWordTree);
        // agacın derinliğinin bulunur
        int a = theTree.depthofThree(theTree.getRoot());
        System.out.println(a);
        theTree.blancedTree(mpList);

        AlphaNode aNode = theTree.findNodebyThreeLetters("Mal");
        System.out.println(aNode.getMp());

        theWordTree.postOrderWord(theWordTree.getRoot());
        int dep=theWordTree.depthofThree(theWordTree.getRoot());
        System.out.println(dep);
//
//        // milli parkları hash table a isme göre ekledik, sonra da print ettik
//        ht = new Hashtable<>();
//        for(MilliPark np: mpList){
//            ht.put(np.getmPIsim(),np);
//        }
//
//        System.out.println(ht);
//
//
//        // milli parkların yıllarını klavyeden alınan input a göre hash table üzerinde güncelledik
//        Scanner scanner = new Scanner(System.in);
//        for(MilliPark np:mpList){
//            int newDate = scanner.nextInt();
//            np.setmPYili(newDate);
//            ht.put(np.getmPIsim(), np);
//        }

    }

    public void addToHashTable(ArrayList<MilliPark> mpList, Hashtable<String, MilliPark> ht){

        for(MilliPark np: mpList){
            ht.put(np.getmPIsim(),np);
        }

        System.out.println(ht);
    }

    public void updateOnHashTable(ArrayList<MilliPark> mpList, Hashtable<String, MilliPark> ht){
        Scanner scanner = new Scanner(System.in);
        for(MilliPark np:mpList){
            int newDate = scanner.nextInt();
            np.setmPYili(newDate);
            ht.put(np.getmPIsim(), np);
        }
    }

}