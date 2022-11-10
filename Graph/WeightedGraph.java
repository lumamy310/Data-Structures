package Graph;


import java.util.LinkedList;

public class WeightedGraph {

    int numVertices;
    int[][] adjMatrix;

    public WeightedGraph(int numVertices){
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    void addEdge(int row, int col, int weight){
        adjMatrix[row][col] = weight;
    }

    boolean bfs(int[][] residualGraph, int source, int sink, int[] parent){
        boolean[] searched = new boolean[numVertices];
        for (int i = 0; i < numVertices; ++i)
            searched[i] = false;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        searched[source] = true;
        parent[source] = -1;

        while (queue.size() != 0){
            int u = queue.poll();

            for (int v = 0; v < numVertices; v++){
                if (!searched[v] && residualGraph[u][v] > 0) {

                    if (v == sink) {
                        parent[v] = u;
                        return true;
                    }
                    queue.add(v);
                    parent[v] = u;
                    searched[v] = true;
                }
            }
        }
        return false;
    }

    int fordFulkerson(int[][] graph, int source, int sink){
        int max_flow = 0;
        int[] parent = new int[numVertices];
        int u;
        int v;

        int[][] residualGraph = new int[numVertices][numVertices];

        for (u = 0; u < numVertices; u++)
            for (v = 0; v < numVertices; v++)
                residualGraph[u][v] = graph[u][v];
        
        while (bfs(residualGraph, source, sink, parent)) {
            int path_flow = Integer.MAX_VALUE;
            for (v = sink; v != source; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, residualGraph[u][v]);
            }

            for (v = sink; v != source; v = parent[v]) {
                u = parent[v];
                residualGraph[u][v] -= path_flow;
                residualGraph[v][u] += path_flow;
            }
            max_flow += path_flow;
        }
        return max_flow;
    }

    public static void main(String[] args){
        WeightedGraph G = new WeightedGraph(12);
        G.addEdge(0,1,1);
        G.addEdge(0,2,2);
        G.addEdge(0,3,4);
        G.addEdge(1,3,2);
        G.addEdge(2,5,3);
        G.addEdge(3,5,3);
        G.addEdge(4,0,4);
        G.addEdge(4,1,2);
        G.fordFulkerson(G.adjMatrix,4,5);
        System.out.println("The maximum flow is " + G.fordFulkerson(G.adjMatrix, 0, 5));
    }


}
