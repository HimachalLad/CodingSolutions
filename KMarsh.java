package dynamic_programming;

import java.util.*;
import java.io.*;

public class KMarsh
{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = ip(st.nextToken());
        int n = ip(st.nextToken());


        char land[][] = new char[m][n];
        int down[][] = new int[m][n];
        int right[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            char array[] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                land[i][j] = array[j];
            }
        }


        for (int i = 0; i < m; i++) {
            right[i][0] = land[i][0] == '.' ? 0 : -1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                right[i][j] = land[i][j] == '.' ? (right[i][j - 1] + 1) : -1;
            }
        }


        for (int j = 0; j < n; j++) {
            down[0][j] = land[0][j] == '.' ? 0 : -1;
        }

        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                down[i][j] = land[i][j] == '.' ? (down[i - 1][j] + 1) : -1;
            }
        }



        int max = 0;
        for(int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int d = down[i][j];

                System.out.println(i+" "+j);
                for (int k = 1; k <= d; k++) {
                    int min = Math.min(right[i][j], right[i-k][j]);
                    int shift = j - min;
       //             int r = shift;
                   //System.out.println(shift);
                    for(int r = shift; r < j; r++)
                    {
                    if (down[i][r] >= k && (j - r) > 0)
                    {
                        max = Math.max(max, 2*(k + j - r));
                        break;
                    }
                    //System.out.println(j-r);
                    }

                }
            }
        }
        if(max >= 4)
        System.out.println(max);
        else
            System.out.println("impossible");


    }

    public static int ip(String s)
    {
        return Integer.parseInt(s);
    }

}

