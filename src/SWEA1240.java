import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1240 {
    static int[][] code = {
            {0,0,0,1,1,0,1}, //0
            {0,0,1,1,0,0,1}, //1
            {0,0,1,0,0,1,1}, //2
            {0,1,1,1,1,0,1}, //3
            {0,1,0,0,0,1,1}, //4
            {0,1,1,0,0,0,1}, //5
            {0,1,0,1,1,1,1}, //6
            {0,1,1,1,0,1,1}, //7
            {0,1,1,0,1,1,1}, //8
            {0,0,0,1,0,1,1}  //9
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[50][100];

        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for(int i = 0; i < r; i++) {
                String str = br.readLine();
                for(int j = 0; j < c; j++) {
                    arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                }
            }

            int[] codeLine = new int[56];
            boolean check = false;
            for(int i = 0; i < r; i++) {
                for(int j = c - 1; j >= 0; j--) {
                    if(arr[i][j] == 1) {
                        check = true;
                        for(int k = 0; k < 56; k++) {
                            codeLine[k] = arr[i][j - 55 + k];
                        }
                        break;
                    }
                }
                if(check)
                    break;
            }

            int[] codeNum = new int[8];
            boolean isSame;
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 10; j++) {
                    isSame = true;
                    for(int k = 0; k < 7; k++) {
                        if(codeLine[(i * 7) + k] != code[j][k]) {
                            isSame = false;
                            break;
                        }
                    }
                    if (isSame) {
                        codeNum[i] = j;
                        break;
                    }
                }
            }

            int sum = (codeNum[0] + codeNum[2] + codeNum[4] + codeNum[6]) * 3 + codeNum[1] + codeNum[3] + codeNum[5] + codeNum[7];

            int result = 0;
            if (sum % 10 == 0) {
                for (int i = 0; i < 8; i++) {
                    result += codeNum[i];
                }
            }

            System.out.printf("#%d %d\n", tc, result);

        }
    }
}
