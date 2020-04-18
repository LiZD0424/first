import java.util.Scanner;

public class L151 {
    public static void main(String[] args) {
        String str = "adadsa asd ";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String s) {
        String arr[] = s.split(" ");
        StringBuilder sb = new StringBuilder("");
        for (int i=arr.length - 1;i>=0;i--){
            System.out.println(i+arr[i]);
            if("".equals(arr[i])){
                continue;
            }
            sb.append(arr[i]).append(" ");
        }
        String res = sb.toString();
        if("".equals(res)){
            return res;
        }
        return res.substring(0,res.length()-1);
    }
}
