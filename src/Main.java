import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Boolean>> adjacencyMatrix = new ArrayList<>() {
            @Override
            public String toString() {
                String ret = "";
                for (int i = 0; i < this.size(); i++) {
                    ret += this.get(i).toString();
                    if (i != this.size() - 1) {
                        ret += "\n";
                    }
                }
                return ret;
            }
        };

        // a = 0
        // b = 1
        // c = 2
        // d = 3
        // e = 4
        // f = 5

        List<Boolean> row1 = new ArrayList<>();
        row1.add(false); row1.add(true); row1.add(true); row1.add(true); row1.add(false); row1.add(false);

        List<Boolean> row2 = new ArrayList<>();
        row2.add(true); row2.add(false); row2.add(true); row2.add(true); row2.add(true); row2.add(true);

        List<Boolean> row3 = new ArrayList<>();
        row3.add(true); row3.add(true); row3.add(false); row3.add(true); row3.add(true); row3.add(true);

        List<Boolean> row4 = new ArrayList<>();
        row4.add(true); row4.add(true); row4.add(true); row4.add(false); row4.add(true); row4.add(true);

        List<Boolean> row5 = new ArrayList<>();
        row5.add(false); row5.add(true); row5.add(true); row5.add(true); row5.add(false); row5.add(false);

        List<Boolean> row6 = new ArrayList<>();
        row6.add(false); row6.add(true); row6.add(true); row6.add(true); row6.add(false); row6.add(false);

        adjacencyMatrix.add(row1);
        adjacencyMatrix.add(row2);
        adjacencyMatrix.add(row3);
        adjacencyMatrix.add(row4);
        adjacencyMatrix.add(row5);
        adjacencyMatrix.add(row6);

        System.out.println("Adjacency Matrix:");
        System.out.println(adjacencyMatrix);
        
        System.out.print("\nColor List: ");
        List<Integer> colorList = GraphColoring.solve(0, adjacencyMatrix, 4);

        if (colorList.equals(null)) {
            System.out.println("\nSOLUTION NOT FOUND.");
        } else {
            System.out.println(colorList);
        }

        System.out.println("Count of generated nodes during algorithm run: " + GraphColoring.getNodeCount());
        System.out.println("NOTE: GENERATED NODES ARE NOT THE SAME AS NODES THAT ARE REPRESENTED IN THE ADJACENCY MATRIX.");
    }
}
