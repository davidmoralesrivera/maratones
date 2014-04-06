import java.util.ArrayList;
import java.util.Scanner;

public class round {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> turns;
        int n, t, index;
        boolean end;
        n = in.nextInt();
        while(n!=0) {
            t = in.nextInt();
            index = -1;
            turns = new ArrayList<Integer>(n);            
            for(int i=0;i<n;++i) turns.add(0);             
            while(true) {
                end = true;
                for(int i=0;i<t;++i) {
                    index = (index+1)%n;
                    turns.set(index, turns.get(index)+1);
                }
                turns.remove(index);
                n--;     
                index--;
                if(n==1) break;
                for(int i=1;i<n;++i) {
                    if(turns.get(0)!=turns.get(i)) end=false;
                }
                if(end) break;
            }            
            System.out.println(n+" "+turns.get(0));
            n = in.nextInt();
        }
    }
}
