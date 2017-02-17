import java.io.*;
import java.util.*;

//Problem statement at:
//http://usaco.org/index.php?page=viewproblem2&cpid=381

public class GoldWifiSetup {
	double cons;
	double var;
	public GoldWifiSetup() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("wifi.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wifi.out")));
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    int numCows = Integer.parseInt(st.nextToken());
	    cons = Double.parseDouble(st.nextToken());
	    var = Double.parseDouble(st.nextToken());
	    ArrayList<Router> routers = new ArrayList<Router>();
	    int[] temp = new int[numCows];
	    for (int i = 0; i < numCows; i++) {
	    	temp[i] = Integer.parseInt(f.readLine());
		}
	    Arrays.sort(temp);
	    for (int i = 0; i < temp.length; i++) {
	    	int cow = temp[i];
	    	int[] cowarray = {cow};
	    	routers.add(new Router(0, cowarray));
		}
	    boolean madeChange = true;
	    main:
	    while (madeChange) {
	    	madeChange = false;
	    	for (int i = 0; i < routers.size() - 1; i++) {
				if (cost(routers.get(i).range) + cost(routers.get(i + 1).range) 
						> cost((routers.get(i + 1).cowsCovered[routers.get(i + 1).cowsCovered.length - 1]
						- routers.get(i).cowsCovered[0]) / 2.0)) {
					temp = routers.get(i).cowsCovered;
					int[] temp2 = routers.get(i + 1).cowsCovered;
					int[] newCowsCovered = new int[temp.length + temp2.length];
					for (int j = 0; j < newCowsCovered.length; j++) {
						if (j < temp.length)
							newCowsCovered[j] = temp[j];
						else
							newCowsCovered[j] = temp2[j - temp.length];
					}
					double newRange = (newCowsCovered[newCowsCovered.length - 1] - newCowsCovered[0]) / 2.0;
					routers.remove(i + 1);
					routers.set(i, new Router(newRange, newCowsCovered));
					madeChange = true;
					continue main;
				}
			}
	    	
	    }
	    double sum = 0;
	    for (int i = 0; i < routers.size(); i++) {
			sum += cost(routers.get(i).range);
		}
	    
	    out.println(sum);
	    out.close();
	    f.close();
	}
	
	public static void main (String [] args) throws IOException {
    new GoldWifiSetup();
  }
	double cost(double range) {
		return (cons + range * var);
	}

}

class Router {
	double range;
	int[] cowsCovered;
	Router(double newRange, int[] newCowsCovered) {
		range = newRange;
		cowsCovered = newCowsCovered;
	}
}