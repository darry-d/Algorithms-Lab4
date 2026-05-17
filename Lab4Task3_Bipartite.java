import java.util.LinkedList;
import java.util.Queue;

public class Lab4Task3_Bipartite {
    public static void main(String[] args) {
        int[][] graph1 = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        int[][] graph2 = {
                {1, 2},
                {0, 2},
                {0, 1}
        };
        System.out.println("Перевірка Графу 1 (Квадрат): " + isBipartite(graph1, 0));
        System.out.println("Перевірка Графу 2 (Трикутник): " + isBipartite(graph2, 0));
    }

    public static boolean isBipartite(int[][] graph, int startVertex) {
// 0 - ще не розфарбовано, 1 - Червоний, -1 - Синій
        int[] colors = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        // Фарбуємо першу кімнату в Червоний (1)
        colors[startVertex] = 1;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for(int neighbor : graph[current]) {

                if (colors[neighbor] == 0) {
                    // Фарбуємо його в ПРОТИЛЕЖНИЙ колір до поточного (множимо на -1)
                    colors[neighbor] = colors[current] * -1;
                    queue.add(neighbor);
                }
                else if (colors[neighbor] == colors[current]){
                    return false;
                }
            }
        }
        return true;
    }

}
