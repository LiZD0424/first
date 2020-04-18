import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DouDiZhu {
    public static void main(String[] args) {
        String[] huaSe = {"♠", "♥", "♣", "♦"};
        String[] paiMian = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        ArrayList<String> pai = new ArrayList<>();
        for (int i = 0; i < huaSe.length; i++) {
            for (int j = 0; j < paiMian.length; j++) {
                pai.add(huaSe[i] + paiMian[j]);
            }
        }
        //System.out.println(pai);
        HashMap<Integer, String> poker = new HashMap<>();
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < pai.size(); i++) {
            poker.put(i, pai.get(i));
            index.add(i);
        }
        poker.put(52, "大王");
        index.add(52);
        poker.put(53, "小王");
        index.add(53);
        //System.out.println(poker);
        Collections.shuffle(index);
        ArrayList<Integer> index1 = new ArrayList<>();
        ArrayList<Integer> index2 = new ArrayList<>();
        ArrayList<Integer> index3 = new ArrayList<>();
        ArrayList<Integer> index4 = new ArrayList<>();
        for (int i = 0; i < 51; i++) {
            if (i % 3 == 0) {
                index1.add(index.get(i));
            } else if (i % 3 == 1) {
                index2.add(index.get(i));
            } else
                index3.add(index.get(i));
        }
        index4.add(index.get(51));
        index4.add(index.get(52));
        index4.add(index.get(53));
        Collections.sort(index1);
        Collections.sort(index2);
        Collections.sort(index3);
        Collections.sort(index4);
        ArrayList<String>s1=new ArrayList<>();
        ArrayList<String>s2=new ArrayList<>();
        ArrayList<String>s3=new ArrayList<>();
        ArrayList<String>s4=new ArrayList<>();
        for (Integer integer : index1) {
           s1.add(poker.get(integer));
        }
        for (Integer integer : index2) {
            s2.add(poker.get(integer));
        }
        for (Integer integer : index3) {
            s3.add(poker.get(integer));
        }
        for (Integer integer : index4) {
            s4.add(poker.get(integer));
        }
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
}
