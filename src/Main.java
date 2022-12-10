import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Path filePath = Path.of("milli.txt");

        MilliPark m1 = new MilliPark();

        AlphaTree theTree = new AlphaTree();

        ArrayList<MilliPark> mpList = m1.MilliParkListele(filePath);

        Hashtable<String, MilliPark> ht = new Hashtable<>();


        for(MilliPark mp: mpList){
            mp.printToString();

            theTree.insert(mp);
        }
        System.out.println("PostORder");
        theTree.postOrder(theTree.getRoot());

        int a = theTree.depthofThree(theTree.getRoot());
        System.out.println(a);
        theTree.blancedTree(mpList);

        AlphaNode aNode = theTree.findNodebyThreeLetters("Mal");
        aNode.getMp().printToString();

        // milli parkları hash table a isme göre ekledik, sonra da print ettik
        ht = new Hashtable<>();
        for(MilliPark np: mpList){
            ht.put(np.getmPIsim(),np);
        }

        System.out.println(ht);


        // milli parkların yıllarını klavyeden alınan input a göre hash table üzerinde güncelledik
        Scanner scanner = new Scanner(System.in);
        for(MilliPark np:mpList){
            int newDate = scanner.nextInt();
            np.setmPYili(newDate);
            ht.put(np.getmPIsim(), np);
        }


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