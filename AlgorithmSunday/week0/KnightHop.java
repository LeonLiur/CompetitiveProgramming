package AlgorithmSunday.week0;

import java.util.ArrayList;
import java.util.Scanner;

public class KnightHop {
    private static ArrayList<String> legalMoves(int xCord, int yCord) {
        ArrayList<Integer> border = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            border.add(i + 1);
        }

        ArrayList<String> moves = new ArrayList<>();
        int[][] shifts = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, -1}, {-2, 1}};

        for (int[] smallShift : shifts
        ) {
            if (border.contains(xCord + smallShift[0]) && border.contains(yCord + smallShift[1])) {
                moves.add((xCord + smallShift[0]) + " " + (yCord + smallShift[1]));
            }
        }

        return moves;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] origin = sc.nextLine().split(" ");
        String destStr = sc.nextLine();
        String[] destination = destStr.split(" ");

        int originX = Integer.parseInt(origin[0]);
        int originY = Integer.parseInt(origin[1]);

        boolean up = originX != Integer.parseInt(destination[0]) || originY != Integer.parseInt(destination[1]);

        if (!up) {
            System.out.println(0);
            System.exit(0);
        }

        ArrayList<String> checked = new ArrayList<>();
        ArrayList<String> unchecked = new ArrayList<>(legalMoves(originX, originY));

        checked.add(originX + "" + originY);
        int counter = 0;
        while (up) {
            ArrayList<String> remove = new ArrayList<>();
            ArrayList<String> temporary = new ArrayList<>();
            if (unchecked.contains(destStr)) {
                System.out.println(++counter);
                break;
            }

            for (String move : unchecked) {
                remove.add(move);
                checked.add(move);
                int moveX = Integer.parseInt(move.split(" ")[0]);
                int moveY = Integer.parseInt(move.split(" ")[1]);
                temporary.addAll(legalMoves(moveX, moveY));
            }
            checked.removeAll(remove);
            for (String createdMove : temporary
            ) {
                if (!checked.contains(createdMove) && !unchecked.contains(createdMove)) {
                    unchecked.add(createdMove);
                }
            }
            counter++;
        }

    }

}
