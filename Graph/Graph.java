package Graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    int numVertices;
    LinkedList<Integer>[] adjacencyList;

    public Graph(int numVertices){
        this.numVertices = numVertices;
        adjacencyList = new LinkedList[numVertices];
        for(int i=0; i<numVertices; i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int from, int to){
        adjacencyList[from].add(to);
    }

    void dfsSCC(int vertex, boolean[] searched){
        searched[vertex] = true;
        System.out.print(vertex + " ");

        int next;
        Iterator<Integer> i = adjacencyList[vertex].iterator();
        while(i.hasNext()){
            next = i.next();
            if(!searched[next])
                dfsSCC(next, searched);
        }
    }

    void DFS(int vertex, int searchFor, boolean[] searched){
        searched[vertex] = true;
        System.out.print("Checking vertex: " + vertex + " ");
        if(vertex == searchFor){
            System.out.println("FOUND: " + searchFor);
            return;
        }

        int next;
        Iterator<Integer> i = adjacencyList[vertex].iterator();
        while(i.hasNext()) {
            next = i.next();
            if (next == searchFor) {
                System.out.print("Checking vertex: " + next + " ");
                System.out.println("FOUND: " + searchFor);
                break;
            }
                if (!searched[next])
                    DFS(next, searchFor, searched);
            }
    }

    void BFS(int vertex, int searchFor, boolean[] searched){
            LinkedList<Integer> queue = new LinkedList<Integer>();
            searched[vertex] = true;
            queue.add(vertex);

            while (queue.size() != 0) {
                vertex = queue.poll();
                System.out.print("Checking vertex: " + vertex + " ");
                if(vertex == searchFor){
                    System.out.print("Found: " + vertex);
                    return;
                }

                Iterator<Integer> i = adjacencyList[vertex].listIterator();
                while (i.hasNext()) {
                    int next = i.next();
                    if (!searched[next]) {
                        searched[next] = true;
                        queue.add(next);
                    }
                }
            }
    }

    void topSortHelper(int vertex, boolean[] searched, Stack stack){
        searched[vertex] = true;
        Integer i;

        Iterator<Integer> it = adjacencyList[vertex].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!searched[i])
                topSortHelper(i, searched, stack);
        }

        stack.push(new Integer(vertex));
    }

    void topSort(){
        Stack stack = new Stack();

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++)
            visited[i] = false;

        for (int i = 0; i < numVertices; i++)
            if (!visited[i])
                topSortHelper(i, visited, stack);

        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    Graph reverseGraph(){
        Graph reversedGraph = new Graph(numVertices);
        for(int vertex=0; vertex < numVertices; vertex++){
            Iterator<Integer> i = adjacencyList[vertex].listIterator();
            while(i.hasNext()){
                reversedGraph.adjacencyList[i.next()].add(vertex);
            }
        }
        return reversedGraph;
    }

    void fillStack(int vertex, boolean[] searched, Stack stack){
        searched[vertex] = true;

        Iterator<Integer> i = adjacencyList[vertex].iterator();
        while(i.hasNext()){
            int next = i.next();
            if(!searched[next])
                fillStack(next, searched, stack);
        }
        stack.push(new Integer(vertex));
    }

    void printStronglyConnectedComponents(){
        Stack stack = new Stack();

        boolean[] searched = new boolean[numVertices];
        for(int i=0; i<numVertices; i++){
            searched[i] = false;
        }

        for(int i=0; i<numVertices; i++){
            if(!searched[i]){
                fillStack(i, searched, stack);
            }
        }

        Graph reversedGraph = reverseGraph();

        for(int i=0; i<numVertices; i++){
            searched[i] = false;
        }

        while(!stack.empty()){
            int vertex = (int)stack.pop();
            if(!searched[vertex]){
                reversedGraph.dfsSCC(vertex, searched);
                System.out.println();
            }
        }
    }

    public static void main(String[] args){
        Graph G = new Graph(12);
        G.addEdge(0,11);
        G.addEdge(1,7);
        G.addEdge(2,3);
        G.addEdge(3,9);
        G.addEdge(4,3);
        G.addEdge(5,0);
        G.addEdge(5,7);
        G.addEdge(6,5);
        G.addEdge(6,7);
        G.addEdge(7,10);
        G.addEdge(10,8);
        G.addEdge(9,8);
        G.addEdge(9,11);
        boolean[] searched = new boolean[G.numVertices];

        System.out.println("Depth First Search on G, root = 7, searching for 8: ");
        G.DFS(7, 8, searched);
        Arrays.fill(searched, false);
        System.out.println("");

        System.out.println("Depth First Search on G, root = 6, searching for 5: ");
        G.DFS(6, 5, searched);
        Arrays.fill(searched, false);
        System.out.println("");

        System.out.println("Depth First Search on G, root = 2, searching for 1: ");
        G.DFS(2, 1, searched);
        Arrays.fill(searched, false);
        System.out.println("\n");


        System.out.println("Breadth First Search on G, root = 7, searching for 8: ");
        G.BFS(7, 8, searched);
        Arrays.fill(searched, false);
        System.out.println("\n");

        System.out.println("Breadth First Search on G, root = 6, searching for 5: ");
        G.BFS(6, 5, searched);
        Arrays.fill(searched, false);
        System.out.println("\n");

        System.out.println("Breadth First Search on G, root = 2, searching for 1: ");
        G.BFS(2, 1, searched);
        Arrays.fill(searched, false);
        System.out.println("\n");

        System.out.println("Top Sort on G, root = 0: ");
        G.topSort();
        System.out.println("\n");

        Graph F = new Graph(12);
        F.addEdge(0,1);
        F.addEdge(0,11);
        F.addEdge(2,1);
        F.addEdge(2,4);
        F.addEdge(3,2);
        F.addEdge(4,3);
        F.addEdge(5,6);
        F.addEdge(6,7);
        F.addEdge(6,0);
        F.addEdge(7,5);
        F.addEdge(8,10);
        F.addEdge(9,8);
        F.addEdge(10,9);
        F.addEdge(10,11);

        System.out.println("Strongly Connected Components of F: ");
        F.printStronglyConnectedComponents();


//        Graph myGraph = new Graph(5);
//        myGraph.addEdge(1,0);
//        myGraph.addEdge(0,2);
//        myGraph.addEdge(2,1);
//        myGraph.addEdge(0,3);
//        myGraph.addEdge(3,4);
//
//        System.out.println("Strongly Connected Components: ");
//        myGraph.printStronglyConnectedComponents();
//        boolean[] searched = new boolean[myGraph.numVertices];
//        myGraph.DFS(0, 3, searched);
//        for(int i=0; i<searched.length; i++)
//            searched[i] = false;
//        System.out.println();
//        myGraph.BFS(2,0, searched);
//        Arrays.fill(searched, false);
//        System.out.println();
//        myGraph.topSort();
    }


}
