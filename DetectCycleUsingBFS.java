//Cycle Detection using BFS with Map   --- TOPOLOGICAL SORT

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class DetectCycleUsingBFS {
    public static boolean isCycle(int n, int [][] edges){
        Map<Integer, List<Integer>> gp = new HashMap<>();

        Queue<Integer> q = new LinkedList<>();

        int [] indegree = new int[n];

        for(int i = 0; i < n; i++){
            gp.put(i, new ArrayList<>());
        }

        //Build the Adjacency list
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];

            
            gp.get(u).add(v);

            indegree[v]++;

        }
        //Add all the nodes with indegree 0 to the queue
        int count = 0;
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                count++;
                q.add(i);
            }
        }

        //BFS

        while(!q.isEmpty()){
            int node = q.poll();

            for(int neighbour : gp.get(node)){
                indegree[neighbour]--;

                if(indegree[neighbour] == 0){
                    count++;
                    q.add(neighbour);
                }
            }
        }

        // if(count == n){
        //     return false; // No cycle detected
        // } 
        // return true; // Cycle detected  
        
        return count != n; // If count is not equal to n, it means there is a cycle
    }
    
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0,1}, {1,2}, {2,0}, {1,3}};
        
        if (isCycle(V, edges)) {
            System.out.println("Cycle detected in the graph.");
        } else {
            System.out.println("No cycle detected in the graph.");
        }
        
    }
}
