import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Path filePath = Path.of("milli.txt");

        MilliPark m1 = new MilliPark();

        AlphaTree theTree = new AlphaTree();


        ArrayList<MilliPark> mpList = m1.MilliParkListele(filePath);


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

    }
}