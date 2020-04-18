import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L22 {
    public static ArrayList<String> list=new ArrayList<>();
    public static void main(String[] args) {
       int n=new Scanner(System.in).nextInt();
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        dfs(n,n,sb);
        return list;
    }
    public static void dfs(int l,int r,StringBuilder sb){
        if(l==0&&r==0){
            list.add(sb.toString());
            return;
        }
        if (l>0){
            dfs(l-1,r,sb.append('('));
            sb.deleteCharAt(sb.length()-1);
        }
        if (r>l){
            dfs(l,r-1,sb.append(')'));
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
