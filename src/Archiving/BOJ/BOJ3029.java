package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ3029 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arrayHideTime = br.readLine().split(":");
        String[] arrayThrowTime = br.readLine().split(":");

        int[] hideTime = new int[3];
        int[] throwTime = new int[3];

        for(int i = 0; i < arrayHideTime.length; i++) {
            hideTime[i] = Integer.parseInt(arrayHideTime[i]);
            throwTime[i] = Integer.parseInt(arrayThrowTime[i]);
        }

        int h, m, s;

        s = throwTime[2] - hideTime[2];
        if(s < 0) {
            s += 60;
            if(throwTime[1] == 0 && throwTime[0] == 0) {
                throwTime[1] = 59;
                throwTime[0] = 23;
            }
            else if(throwTime[1] == 0) {
                throwTime[1] = 59;
                throwTime[0]--;
            }
            else
                throwTime[1]--;
        }

        m = throwTime[1] - hideTime[1];
        if(m < 0) {
            m += 60;
            if(throwTime[0] == 0) {
                throwTime[0] = 23;
            }
            else
                throwTime[0]--;
        }

        h = throwTime[0] - hideTime[0];
        if(h < 0)
            h += 24;

        if(h == 0 && m == 0 && s == 0)
            System.out.printf("24:00:00");
        else
            System.out.printf("%02d:%02d:%02d", h, m, s);

    }
}
