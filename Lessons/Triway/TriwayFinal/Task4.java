package Problems.TriwayFinal;

public class Task4 {
    public static void main(String[] args) {
        boolean[][] map = {{false, true, true, false, false},
                {false, false, true, true, true},
                {false, true, false, false, true},
                {false, true, true, false, false},
                {false, true, true, false, false}};
        for (int i = 0; i < map[3].length; i++) {
            if(map[3][i]){
                System.out.println("Found neighbour with vertex number: " + i);
            }
        }
    }
}
