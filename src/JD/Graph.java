package JD;

import java.util.*;

public class Graph {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int boys = in.nextInt();
        int nums = in.nextInt();
        int len = 2 * boys + 1;
        boolean[][] graph = new boolean[len][len];
        int[] node = new int[len];
        boolean[] state = new boolean[len];
        while (nums > 0) {
            nums--;
            int x = in.nextInt();
            int y = in.nextInt();
            graph[x][y] = true;
//            graph[y][x] = true;
        }
        int result = 0;
        for (int x = 1; x < len; x++) {
            Arrays.fill(state, false);
            if (find(x, len, graph, node, state)) {
                result++;
            }
        }

        List<Integer> deleteVertex = minVertexCover(node, graph, len);
        Arrays.sort(deleteVertex.toArray());
        System.out.println(result);
        System.out.println(deleteVertex);
    }


    public static boolean find(int x, int len, boolean[][] graph, int[] node, boolean[] state) {
        for (int y = 1; y < len; y++) {
            if (graph[x][y] && !state[y]) {
                state[y] = true;
                if (node[y] == 0 || find(node[y], len, graph, node, state)) {
                    node[y] = x;
                    return true;
                }
            }
        }
        return false;
    }

    public static List<Integer> minVertexCover(int[] node, boolean[][] graph, int len) {
        List<Integer> result = new ArrayList<>();
        int boyslen = (len - 1) / 2;
        for (int i = 1; i <= boyslen; i++) {
            result.add(i);
        }
        for (int i = 1; i < len; i++) {
            if (node[i] != 0) {
                int tmp = node[i];
                node[tmp] = i;
            }
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i <= boyslen; i++) {
            if (node[i] == 0) {
                stack.push(i);
            }
        }
//        boolean[] state = new boolean[len];
        HashSet minCover = new HashSet(result);
        HashSet visited = new HashSet();
        while (!stack.isEmpty()) {
            int v = stack.pop();
            visited.add(v);

            if (v > 0 && v < boyslen + 1) {
                minCover.remove(v);
                for (int g = boyslen + 1; g < len; g++) {
                    if (graph[v][g] && !visited.contains(g)) {
                        visited.add(g);
                        minCover.add(g);
                        if (!visited.contains(node[g])) {
                            stack.push(node[g]);
                        }
                    }
                }
            }
        }
        result.clear();
        result.addAll(minCover);
        return result;
    }
}
