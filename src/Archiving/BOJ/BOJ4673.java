package Archiving.BOJ;

public class BOJ4673 {

    private static int d(int n) {
        int sum = n;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[10001];

        for(int i = 1; i <= 10000; i++) {
            int n = i;
            while(true) {
                n = d(n);
                if(n > 10000 || arr[n] == 1)
                    break;
                arr[n] = 1;
            }
        }

        for(int i = 1; i <= 10000; i++)
            if(arr[i] == 0)
                System.out.println(i);
    }
}
