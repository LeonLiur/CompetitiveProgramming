package Problems.CCC;

import java.util.*;

public class CCC03S3{

    static boolean[][] visited = new boolean[26][26];
    static int rows, columns, area;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flooring = sc.nextInt();

        rows = sc.nextInt();
        columns = sc.nextInt();

        for(int i = 0; i < rows; i++){
            String s = sc.next();
            for(int j = 0; j < columns; j++){
                visited[i][j] = s.charAt(j) == 'I';
            }
        }

        ArrayList<Integer> arrL = new ArrayList<Integer>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                dfs(i, j);
                if(area != 0){
                    arrL.add(area);
                }
                area = 0;
            }
        }

        Collections.sort(arrL);

        // System.out.println(arrL);

        int roomsFilled = 0;

        for(int i = arrL.size() - 1; i >= 0; i--){
            if(flooring - arrL.get(i) >= 0){
                flooring -= arrL.get(i);
                roomsFilled += 1;
            }else{
                break;
            }
        }

        if(roomsFilled == 1){
            System.out.println(roomsFilled + " room, " + flooring + " square mettre(s) left over");
        }else{
            System.out.println(roomsFilled + " rooms, " + flooring + " square mettre(s) left over");
        }
    }

    private static void dfs(int curX, int curY){
        if(visited[curX][curY]){
            return;
        }else{
            visited[curX][curY] = true;
        }
        
        area += 1;

        if(curX < rows - 1){
            dfs(curX + 1, curY);
        }
        if(curX > 0){
            dfs(curX - 1, curY);
        }
        if(curY < columns - 1){
            dfs(curX, curY + 1);
        }
        if(curY > 0){
            dfs(curX, curY - 1);
        }
    }
}