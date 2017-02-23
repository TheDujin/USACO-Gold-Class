import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Knapsack01 {

	public Knapsack01() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("knap.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("knap.out")));
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    int numItems = Integer.parseInt(st.nextToken());
	    int[][] items = new int[numItems][2];
	    for (int i = 0; i < numItems; i++) {
			st = new StringTokenizer(f.readLine());
			items[numItems][0] = Integer.parseInt(st.nextToken());
			items[numItems][1] = Integer.parseInt(st.nextToken());
		}
	    
	    out.close();
	}

	public static void main(String[] args) throws IOException {
		new Knapsack01();

	}

}
