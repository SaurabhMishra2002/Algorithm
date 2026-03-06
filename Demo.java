import java.util.Scanner;

public class Demo {

    //ADD Edge in the graph
    public static void addEdge(int [][]matrix,int i,int j){
        matrix[i][j] = 1;
    }

    static void  printmatrix(int [][]matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int [][]matrix, int node, boolean []visited){
        visited[node] = true;
        System.out.println(node+" ");
        for(int i = 0; i < matrix[node].length; i++){
            if(matrix[node][i] == 1 && !visited[i]){
                dfs(matrix,i,visited);
            }
        }
    }


    public static void main(String[] args) {
       // System.out.println("Hello, World!");

       Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();

       int [][]matrix = new int[n][n];

        /*
          Drected Graph
            0 -- > 1
            0 -- > 2
            1 -- > 2
            1 -- > 3
       */

            boolean []visited = new boolean[n];

            addEdge(matrix,0,1);
            addEdge(matrix,0,2);
            addEdge(matrix,1,2);
            addEdge(matrix,1,3);


            printmatrix(matrix);

            dfs(matrix,0,visited);

    }
}
