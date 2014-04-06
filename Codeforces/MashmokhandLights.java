import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MashmokhandLights {
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		boolean lights[];
		String line[]=in.readLine().split(" ");
		int n=Integer.parseInt(line[0]),m=Integer.parseInt(line[1]);
		lights=new boolean[n];
		line=in.readLine().split(" ");
		int end[]=new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = Integer.parseInt(line[i])-1; j < n; j++) {
				if(lights[j]==false){
					lights[j]=true;
					end[j]=Integer.parseInt(line[i]);
				}
			}
		}
		for (int i = 0; i < end.length; i++) {
			System.out.print(end[i]);
			if(i+1!=end.length)System.out.print(" ");
		}
	}
}
