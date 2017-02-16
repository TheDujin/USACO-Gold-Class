import java.io.*;
import java.util.*;

//Problem statement at:
//http://usaco.org/index.php?page=viewproblem2&cpid=381

public class GoldWifiSetup {
	int cons;
	int var;
	public GoldWifiSetup() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("wifi.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wifi.out")));
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    int numCows = Integer.parseInt(st.nextToken());
	    cons = Integer.parseInt(st.nextToken());
	    var = Integer.parseInt(st.nextToken());
	    ArrayList<Router> routers = new ArrayList<Router>();
	    int[] temp = new int[numCows];
	    for (int i = 0; i < numCows; i++) {
	    	temp[i] = Integer.parseInt(f.readLine());
		}
	    Arrays.sort(temp);
	    for (int i = 0; i < temp.length; i++) {
	    	int cow = temp[i];
	    	int[] cowarray = {cow};
	    	routers.add(new Router(cow, 0, cowarray));
		}
	    boolean madeChange = true;
	    while (madeChange) {
	    	madeChange = false;
	    	
	    }
	    
	    //out.println(i1+i2);
	    out.close();
	    f.close();
	}
	
	public static void main (String [] args) throws IOException {
    new GoldWifiSetup();
  }
	int cost(int range) {
		return (cons + range * var);
	}

}

class Router {
	int center;
	int range;
	int[] cowsCovered;
	Router(int newCenter, int newRange, int[] newCowsCovered) {
		center = newCenter;
		range = newRange;
		cowsCovered = newCowsCovered;
	}
}