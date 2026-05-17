public class Lab4Task1 {
    public static void main(String[] args) {
        int[][] graphWithCycle = {
                {1, 3},
                {0, 2},
                {1, 3, 4},
                {2, 0},
                {2}
        };
        boolean[] visited1 = new boolean[5];

        boolean hasCycle1 = hasCycle_DFS(graphWithCycle, 0, visited1, -1);
        System.out.println("" + hasCycle1);

        int[][] graphTree = {
                {1, 2},
                {0, 3, 4},
                {0, 5, 6},
                {1},
                {1},
                {2},
                {2}
        };
        boolean[] visited2 = new boolean[7];

        boolean hasCycle2 = hasCycle_DFS(graphTree, 0, visited2, -1);
        System.out.println("" + hasCycle2);
    }

        public static boolean hasCycle_DFS(int[][] graph, int currentVertex, boolean[] visited, int parent){
            visited[currentVertex] = true;
            for(int neighbor : graph[currentVertex]) {
                if (!visited[neighbor]) {
                    if (hasCycle_DFS( graph, neighbor, visited, currentVertex)){
                        return true;

                    }
                }
                else if (neighbor != parent){
                    return true;
                }
            }
            return false;
        }

    }


