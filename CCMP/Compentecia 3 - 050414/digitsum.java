
import java.util.Arrays;
import java.util.Scanner;

public class digitsum {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, n1, n2, cont;
        int[] ns;
        while((n=in.nextInt())!=0) {
            ns = new int[n];
            n1 = n2 = cont = 0;
            for(int i=0;i<n;++i) {
                ns[i] = in.nextInt();
            } 
            Arrays.sort(ns);
            for(int i=1;i<=n;++i) {
                if(ns[i-1]!=0) {
                    if(n1!=0 && n2!=0) {
                        while(cont>0) {
                            if(cont%2==0) {
                                n2*=10;
                            }else{
                                n1*=10;
                            }
                            cont--;
                        }
                    }
                    if(i%2!=0) {
                        n1+=ns[i-1];
                        if(i<n-1) {
                            n1*=10;
                        }
                    }else{
                        n2+=ns[i-1];
                        if(i<n-1) {
                            n2*=10;
                        }
                    }
                }else{
                    cont++;
                }
            }
            while(cont>0) {
                if(cont%2==0) {
                    n1*=10;
                }else{
                    n2*=10;
                }
                cont--;
            }
            System.out.println(n1+n2);
        }
    }
}
