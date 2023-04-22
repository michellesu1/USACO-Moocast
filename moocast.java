import java.util.*;
import java.io.*;

class moocast {
    public static ArrayList<Integer>[] adj;
    public static boolean[] visited;
    public static int numVisited;
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(new File("moocast.in"));
        PrintWriter output = new PrintWriter(new File("moocast.out"));
        

        int N = input.nextInt();
        // x[cow_index] and y[cow_index] store location, power[cow_index] stores radius
        int[] x = new int[N];
        int[] y = new int[N];
        int[] power = new int[N];

        for (int i = 0; i < N; i++) {
            x[i] = input.nextInt();
            y[i] = input.nextInt();
            power[i] = input.nextInt();
        }

        // create adjacency list for each cow by determining which cows it can reach within its radius
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<Integer>();
            for (int j = 0; j < N; j++) {
                if ( Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]))<=power[i] && i!=j) {
                    adj[i].add(j);
                }
            }
        }

        // simulate the number of cows that each cow can reach
        int maxVisited = 0;
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[j] = false;
            }
            numVisited = 0;

            dfs(i);
            maxVisited= Math.max(maxVisited, numVisited);
        }

        output.println(maxVisited);
        output.close();

	}

    public static void dfs(int start) {
        // depth first search
        visited[start] = true;
        numVisited++;
        for (int i : adj[start]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}