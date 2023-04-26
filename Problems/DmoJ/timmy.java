package Problems.DmoJ;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class timmy {
    public static int roomNum, tileNum;
    public static ArrayList<Integer> roomCounter = new ArrayList<Integer>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int flooring = sc.nextInt();
        int length = sc.nextInt();
        int width = sc.nextInt();

        boolean grid[][] = new boolean[length][width];

        for (int i = 0; i < length; i++) {
            String input = sc.next();
            for(int j = 0; j < width; j++) {
                grid[i][j] = input.charAt(j) == 'I' ? true : false;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!grid[i][j]) {
                    tileNum = 0;
                    check(grid, i, j);
                    grid[i][j] = true;
                    roomCounter.add(tileNum);
                }
            }
        }

        Collections.sort(roomCounter);

        for (int i = roomCounter.size() - 1; i >= 0 && flooring > 0; i--) {
            if (flooring - roomCounter.get(i) >= 0) {
                flooring -= roomCounter.get(i);
                roomNum++;
            } else {
                i = -1;
            }
        }

        System.out.print(roomNum + (roomNum != 1 ? " rooms, " : " room, ") + flooring + " square metre(s) left over");

    }
    public static void check(boolean grid[][], int row, int column){
        if (((row < 0 || row > grid.length - 1) || (column < 0 || column > grid[row].length - 1))) return;
        if(grid[row][column])   return;

        tileNum++;
        grid[row][column] = true;

        check(grid, row + 1, column);
        check(grid, row + -1, column);
        check(grid, row, column + 1);
        check(grid, row, column - 1);
    }
}