import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Path filePath = Path.of("milli.txt");
        AlphaTree theWordTree = new AlphaTree();
        MilliPark m1 = new MilliPark();

        AlphaTree theTree = new AlphaTree();


        ArrayList<MilliPark> mpList = m1.MilliParkListele(filePath);

        // listededeki milli parklar ağaca sırayla eklenir
        for(MilliPark mp: mpList){
            theTree.insert(mp);
        }

        System.out.println("PostORder");
        theTree.postOrder(theTree.getRoot(), theWordTree);
        // agacın derinliğinin bulunur
        int depthTree = theTree.depthofTree(theTree.getRoot());
        int blanceddepthTree =theTree.blancedTree();
        int nodeCount=theTree.countNode(theTree.getRoot());
        System.out.println("Milli Park ağacımız "+depthTree+" derinliğe "+nodeCount+" tane milli parka sahip. Eğer "+nodeCount+
                " tane milli park ile dengeli bir ağaç olsaydı "+blanceddepthTree+" derinliğe sahip olurdu");

        String MilliParksehri = theTree.findNodebyThreeLetters("Mal");
        System.out.println("Aradığınız milli park "+MilliParksehri+" ilinde");
        // KELİME AGACINI EKRANA YAZDIRIR

        theWordTree.postOrderWord(theWordTree.getRoot());


//**********************************************************************************************************************
        // 2. KISIM - HASHTABLE
//**********************************************************************************************************************

        // hashtable tanımladık
        Hashtable<String, MilliPark> ht = new Hashtable<>();

        // 2.a - MILLI PARKLARI HASH TABLE A EKLEDIK
        for(MilliPark np: mpList){
            ht.put(np.getmPIsim(),np);
        }

        // HASHTABLE DAKI MILLI PARKLARI EKRANA BASTIRIR
        for(MilliPark mp:ht.values()){
            System.out.println(mp);
        }

        // 2.b - MILLI PARKLARIN YILLARINI KLAVYEDEN ALINAN INPUT A GORE HASH TABLE UZERINDE GUNCELLEDIK
        Scanner scanner = new Scanner(System.in);
        System.out.print("yüzölçümünü güncellemek istediğiniz milli park ın ismini giriniz: ");
        String input = scanner.nextLine();
        while (!input.equals("q")){
            System.out.println("enter the new area value: ");
            int newDate = scanner.nextInt();
            scanner.nextLine();
            MilliPark milliPark = findNP(input,mpList); // ISMI GIRILEN MILLI PARK I DONER
            milliPark.setmPHektar(newDate);
            ht.put(milliPark.getmPIsim(), milliPark);
            System.out.println(ht.get(milliPark.getmPIsim()));
            System.out.println("yüzölçümünü güncellemek istediğiniz milli park ın ismini giriniz: ");
            input = scanner.nextLine();

        }



//**********************************************************************************************************************
        // 3. KISIM - HEAP/MAX HEAP
//**********************************************************************************************************************

        // 3.b - MILLI PARKLARI YUZOLCUMLERINE GORE HEAP E EKLIYORUZ
        MaxHeap maxHeapNP = new MaxHeap(mpList.size());
        for(MilliPark mp:mpList){
            maxHeapNP.insert(mp);
        }

        //3.c - YUZOLCUMU EN BUYUK 3 MILLI PARK I HEAP TEN CEKIP EKRANA BASTIRIYORUZ
        int count = 1;
        for(int i=0;i<3;i++){
            System.out.print(count++);
            System.out.println(": "+ maxHeapNP.remove().getData());
        }
//**********************************************************************************************************************

    }

    // PROJENIN 2. KISMI ICIN YAZILMIS METHOD, ISMI PARAMETRE OLARAK GIRILEN MILLI PARKI DONDURUR
    // BULAMAZSA NULL DONER
   static MilliPark findNP(String name, ArrayList<MilliPark> mpList){
        for(MilliPark mp : mpList){
            if(mp.getmPIsim().equals(name)){
                return mp;
            }
        }return null;
    }



}