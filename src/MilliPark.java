import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MilliPark {
    private String mPIsim,mPNerede;
    private int mPYili,mPHektar;
    private String[] sentences;

    public MilliPark() {}
    public MilliPark(String mPIsim, String mPNerede, int mPYili, int mPHektar,String[] sentences) {
        this.mPIsim = mPIsim;
        this.mPNerede = mPNerede;
        this.mPYili = mPYili;
        this.mPHektar = mPHektar;
        this.sentences = sentences;
    }

    public ArrayList<MilliPark> MilliParkListele(Path filePath) {
        ArrayList<MilliPark> MilliParkList = new ArrayList<MilliPark>();

        String arr;
        try {
            arr = Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            arr = "Bos";
        }
        if (arr == "Bos") {
            System.out.println(arr);}
        String arr1=arr.strip();
        String[] rawData = arr1.split("\n");
        for (String line:rawData) {
            String[] lineData = line.split("; ");
            String[] pragraf = lineData[4].split("\\. ");
//            for(String s: pragraf)
//                System.out.println(s);
//
//            System.out.println(pragraf.length);
//mPIsim = lineData[0],mPNerede = lineData[1],
//                    mPYili = Integer.valueOf(lineData[2].strip()),
//                    mPHektar = Integer.valueOf(lineData[3].replace(".", "")),sentences= pragraf

            MilliPark mp = new MilliPark(mPIsim = lineData[0],mPNerede = lineData[1],mPYili = Integer.valueOf(lineData[2].strip()),mPHektar = Integer.valueOf(lineData[3].replace(".", "")),sentences= pragraf);


            MilliParkList.add(mp);
        }
        return  MilliParkList;
    }



    public String getmPIsim() {
        return mPIsim;
    }
    public void setmPIsim(String mPIsim) {
        this.mPIsim = mPIsim;
    }
    public String getmPNerede() {
        return mPNerede;
    }
    public void setmPNerede(String mPNerede) {
        this.mPNerede = mPNerede;
    }
    public int getmPYili() {
        return mPYili;
    }
    public void setmPYili(int mPYili) {
        this.mPYili = mPYili;
    }
    public int getmPHektar() {
        return mPHektar;
    }
    public void setmPHektar(int mPHektar) {
        this.mPHektar = mPHektar;
    }


    public void printToString() {
        System.out.println(this.mPIsim+" "+this.mPNerede+" "+this.mPYili+" "+this.mPHektar);
        AlphaTree wordTree = new AlphaTree();
        wordTree.treeBySentences(this.sentences);
    }

}
