import java.util.LinkedList;
import java.util.Queue;

public class Lab4Task2 {
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
        int[] parent = new int[8];
        int[] distances = new int[8];

        bfs(graph, 0, visited, parent, distances);

        System.out.println("5.2");

        int finish = 7;
        String path = String.valueOf(finish);

        while (finish != 0) {
            finish = parent[finish];
            path = finish + " -> " + path;

        }

        System.out.println("а) Найкоротший шлях між 0 та 7: " + path);
        System.out.println("б) Мінімальна кількість доріг: " + distances[7]);

        System.out.println("5.3 (Таблиця)");
        for (int i = 0; i < 8; i++) {
            System.out.println("Район " + i + " | Відстань: " + distances[i] + " доріг");
        }
    }

    public static void bfs(int[][] graph, int startVertex, boolean[] visited, int[] parent, int[] distances) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = true;

        distances[startVertex] = 0;
        while(!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int neighbor : graph[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[ neighbor] = currentVertex;

                    distances[neighbor] = distances[currentVertex] + 1;
                     queue.add(neighbor);
                }
            }

        }
    }
}
