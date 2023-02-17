package Sudoku_9x9;
import java.util.*;
import java.io.*;

public class Main {
    public static int[][] table = new int[10][9];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0;i<9;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int l=0;l<9;l++){
                table[i][l] = Integer.parseInt(st.nextToken());
            }
        }
        Sudoku(0, 0);
    }
    
    public static void Sudoku(int x, int y){
        if(x == 9){
            Sudoku(0, y + 1);
        }
        if(y == 9){
            for(int i=0;i<9;i++){
                for(int l=0;l<9;l++){
                    sb.append(table[i][l]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        
        if(table[y][x] == 0){
            for(int i=1;i<=9;i++){
                if(Search(x, y, i)){
                    table[y][x] = i;
                    Sudoku(x + 1, y);
                }
            }
            table[y][x] = 0;
            return;
        }
        Sudoku(x + 1, y);
    }

    public static boolean Search(int x, int y, int value){
        for(int i=0;i<9;i++){
            if(table[i][x] == value){
                return false;
            }

            if(table[y][i] == value){
                return false;
            }
        }

        int set_x = (x / 3) * 3;
        int set_y = (y / 3) * 3;

        for(int i=set_y;i<set_y+3;i++){
            for(int l=set_x;l<set_x+3;l++){
                if(table[i][l] == value){
                    return false;
                }
            }
        }
        return true;
    }
}
