import java.util.ArrayList;
import java.util.List;


public class GraphColoring {
    private static List<Integer> listColor; // Pada laporan/dokumen dilambangkan dengan X;
    private static int nodeCount;

    public static int getNodeCount() {
        return nodeCount;
    }

    public static List<Integer> solve(int k, List<List<Boolean>> adjacencyMatrix, int m) {
        listColor  = new ArrayList<>();
        nodeCount = 0;
        for (int i = 0; i < adjacencyMatrix.size(); i++) {
            listColor.add(0);
        }

        return ColorGraph(k, adjacencyMatrix, m);
    }

    private static List<Integer> ColorGraph(int k, List<List<Boolean>> adjacencyMatrix, int m) {
        // Pada laporan/dokumen adjacencyMatrix dilambangkan dengan G

        boolean stop;        

        stop = false;
        while (!stop) {
            ColorNode(k, listColor, m, adjacencyMatrix);
            if (listColor.get(k) == 0) {
                stop = true;
            } else {
                if (k == adjacencyMatrix.size() - 1) {
                    return listColor;
                } else {
                    return ColorGraph(k + 1, adjacencyMatrix, m);
                }
            }
        }

        return null;
    }

    private static void ColorNode(int k, List<Integer> listColor, int m, List<List<Boolean>> adjacencyMatrix) {
        boolean stop;
        int j;

        stop = false;

        while (!stop) {
            listColor.set(k, (listColor.get(k) + 1) % (m + 1));
            nodeCount++;

            if (listColor.get(k) == 0) {
                stop = true;
            } else {
                for (j = 0; j < listColor.size(); j++) {
                    if (adjacencyMatrix.get(k).get(j) && listColor.get(k) == listColor.get(j)) {
                        break;
                    }
                }

                if (j == listColor.size()) {
                    stop = true;
                }
            }

        }
    }
    
}