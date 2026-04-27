public class Prims {
    static void primMST(int graph[][]) {
        int V = graph.length;
        int parent[] = new int[V];
        int key[] = new int[V];
        Boolean mstSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int minKey = Integer.MAX_VALUE, minIndex = -1;

            for (int v = 0; v < V; v++) {
                if (!mstSet[v] && key[v] < minKey) {
                    minKey = key[v];
                    minIndex = v;
                }
            }

            mstSet[minIndex] = true;

            for (int v = 0; v < V; v++) {
                if (graph[minIndex][v] != 0 && !mstSet[v] && graph[minIndex][v] < key[v]) {
                    parent[v] = minIndex;
                    key[v] = graph[minIndex][v];
                }
            }
        }

        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[parent[i]][i]);
        }
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };
        primMST(graph);
    }
}
