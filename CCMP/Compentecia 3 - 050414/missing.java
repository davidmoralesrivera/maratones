import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class missing {
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		
		while(!(line=in.readLine()).equals("0")){
			int n,p;
			String vec[]=line.split(" ");
			n=Integer.parseInt(vec[0]);
			p=Integer.parseInt(vec[1]);
				
			int mat[][]=new int [n/2][2];
			
			for (int i = 0; i < n/2; i++) {
				mat[i][0]=i+1;
			}
			
			for (int i = 0; i < n/2; i++) {
				mat[(n-1)/2-i][1]=i+1+n/2;
			}
			int[]fin=new int[3];
			
			if(p>n/2){
				for (int i = 0; i < mat.length; i++) {
					if(mat[i][1]==p){
						if(i%2==1){
							fin[0]=mat[i-1][1];
							fin[1]=mat[i-1][0];
							fin[2]=mat[i][0];
						}else{
							fin[0]=mat[i+1][1];
							fin[1]=mat[i+1][0];
							fin[2]=mat[i][0];
						}
					}
				}
			}else{
				for (int i = 0; i < mat.length; i++) {
					if(mat[i][0]==p){
						if(i%2==1){
							fin[0]=mat[i-1][1];
							fin[1]=mat[i-1][0];
							fin[2]=mat[i][1];
						}else{
							fin[0]=mat[i+1][1];
							fin[1]=mat[i+1][0];
							fin[2]=mat[i][1];
						}
					}
				}
			}
			
			Arrays.sort(fin);
			
			for (int i = 0; i < fin.length; i++) {
				System.out.print(fin[i]);
				if(i+1!=fin.length) System.out.print(" ");
			}
			System.out.println();
		}
	}
}
