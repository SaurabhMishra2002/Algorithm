// import java.util.ArrayList;

class DSU{
    int []parent;
    int [] rank;

    DSU(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int u){
        if(parent[u] != u){
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }


    void union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv){
            return; // They are already in the same set
        }

        if(rank[pu] < rank[pv]){
            parent[pu] = pv;
        } else if(rank[pu] > rank[pv]){
            parent[pv] = pu;
        } else {
            parent[pu] = pv;
            rank[pv]++;
        }
    }
}

public class DetectCycleUsingDSU {

    public static boolean hasCycle(int n, int [][] edges){
        
        DSU dsu = new DSU(n);
        for(int []edge : edges){
            int u = edge[0];
            int v = edge[1];

            int pu = dsu.find(u);
            int pv = dsu.find(v);

            if(pu == pv){
                return true; // Cycle detected
            }
        }
        return false; // No cycle detected
        
    }

    public static void main(String[] args) {
        int n = 5;

        int[][] edges = {
            {0,1},
            {1,2},
            {2,3},
            {3,4}
            // {4,1}  // this creates cycle
        };


        if(hasCycle(n,edges)){
            System.out.println("Cycle detected in the graph.");
        } else {
            System.out.println("No cycle detected in the graph.");
        }
    }
}
