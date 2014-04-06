
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;



public class sortme {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int year =1;
        while(n!=0){
            String alph= sc.next();
            String buf="";
            String aux="";
            HashMap<String, String> v=new HashMap<String,String>();
            String vec[]=new String[n];
            for (int i = 0; i < n; i++) {
                buf=sc.next();
                aux="";
                for (int j = 0; j < buf.length(); j++) {
                    aux+=(char)(65+alph.indexOf(buf.charAt(j)+""));
                }
                v.put(aux,buf);
                vec[i]=aux;
            }
            
            Arrays.sort(vec);
            
            System.out.println("year "+(year++));
            
            for (int i = 0; i < n; i++) {
                System.out.println(v.get(vec[i]));
            }
            
            
            n = sc.nextInt();
        }
    }
}
