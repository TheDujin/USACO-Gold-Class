import java.io.*;
import java.util.*;

//Problem statement at:
//http://usaco.org/index.php?page=viewproblem2&cpid=381

public class GoldMoolympics {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("recording.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("recording.out")));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int i1 = Integer.parseInt(st.nextToken());
    int i2 = Integer.parseInt(st.nextToken());
    out.println(i1+i2);
    out.close();
  }
}