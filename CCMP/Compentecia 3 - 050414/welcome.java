import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class welcome {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Character, HashSet<Character>> names;
        HashSet<Character> used;
        char f, l;        
        Character[] last;
        int n, low, groupsCount, setsCount;
        while((n=in.nextInt())!=0) {
            names = new HashMap<Character, HashSet<Character>>();
            low = Integer.MAX_VALUE;
            for(int i=0;i<n;++i) {
                f = in.next().charAt(0);
                l = in.next().charAt(0);
                if(!names.containsKey(l)) {
                    names.put(l, new HashSet<Character>());                    
                }
                names.get(l).add(f);
            }
            last = names.keySet().toArray(new Character[0]);
            setsCount = (int)Math.pow(2, last.length);
            for(int i=0;i<setsCount;++i) {
                groupsCount = 0;
                used = new HashSet<Character>();
                for(int j=0;j<last.length;++j) {
                    if((i & (1<<j))==0) {
                        used.addAll(names.get(last[j]));
                    }else{
                        groupsCount++;
                    }
                }
                groupsCount += used.size();
                low = Math.min(groupsCount, low);
            }
            System.out.println(low);
        }        
    }
}
