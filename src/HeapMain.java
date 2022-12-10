import java.nio.file.Path;
import java.util.ArrayList;

public class HeapMain {

    public static void main(String[] args) {

        // milli parkları listeye aldık
        Path filePath = Path.of("milli.txt");
        MilliPark m1 = new MilliPark();
        ArrayList<MilliPark> mpList = m1.MilliParkListele(filePath);

        // milli parkları yüzölçümlerine göre heap e ekliyoruz
        Heap heapNP = new Heap(mpList.size());
        for(MilliPark mp:mpList){
            heapNP.insert(mp.getmPHektar());
        }


        int count = 1;
        while (!heapNP.isEmpty()){
            System.out.print(count++);
            System.out.println(": "+heapNP.remove().getData());
        }


        for(int i=0;i<3;i++){
            System.out.print(count++);
            System.out.println(": "+heapNP.remove().getData());
        }





//        Heap heap = new Heap(31); // make a Heap; max size 31
//
//        heap.insert(70); // insert 10 items
//        heap.insert(40);
//        heap.insert(50);
//        heap.insert(20);
//        heap.insert(60);
//        heap.insert(100);
//        heap.insert(80);
//        heap.insert(30);
//        heap.insert(10);
//        heap.insert(90);
//        heap.insert(900);
//        heap.insert(9);
//        heap.insert(1);
//        heap.insert(915);
//
//        while(!heap.isEmpty()){
//            System.out.println(heap.remove().getData());
//        }

//
//        while(true) // until [Ctrl]-[C]
//        {
//            System.out.print("Enter first letter of ");
//
//            System.out.print("show, insert, remove, change: ");
//            int choice = getChar();
//            switch(choice)
//            {
//                case "s": // show
//                    theHeap.display();
//                    break;
//                case "i": // insert
//                    System.out.print("Enter value to insert: ");
//                    value = getInt();
//                    success = theHeap.insert(value);
//                    if( !success )
//                        System.out.println("Can’t insert; heap full");
//                    break;
//                case "r": // remove
//                    if( !theHeap.isEmpty() )
//                        theHeap.remove();
//                    else
//                        System.out.println("Can’t remove; heap empty");
//                    break;
//                case "c": // change
//                    System.out.print("Enter current index of item: ");
//                    value = getInt();
//                    System.out.print("Enter new key: ");
//                    value2 = getInt();
//                    success = theHeap.swap(value, value2);
//                    if( !success )
//                        System.out.println("Invalid index");
//                    break;
//                default:
//                    System.out.println("Invalid entry\n");
//            } // end switch
//        } // end while
//    } // end main()
//    //-------------------------------------------------------------
//    public static String getString() throws IOException
//    {
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(isr);
//        String s = br.readLine();
//        return s;
//
//
//        }

    }
}