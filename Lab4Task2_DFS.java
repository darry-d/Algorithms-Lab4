public class Lab4Task2_DFS {
    public static void main(String[] args) {
        int[][] graph = {
                {1, 3},
                {0, 2, 4},
                {1, 5},
                {0, 4},
                {1, 3, 6},
                {2, 7},
                {4, 7},
                {5, 6}
        };
        boolean[] visited = new boolean[8];

        System.out.println("Шлях DFS від 0 до 7: ");

        dfsSearch(graph, 0, 7, visited);

    }
    public static boolean dfsSearch(int[][] graph, int currentVertex, int targetVertex, boolean[] visited) {
       visited[currentVertex] = true;

        System.out.println(currentVertex);

        if (currentVertex == targetVertex){
            System.out.println(" -> Дійшли до фінішу!");
            return true;

        }

        System.out.println(" -> ");

        for(int neighbor : graph[currentVertex]){
            if (!visited[neighbor]) {
                if (dfsSearch(graph, neighbor, targetVertex, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
