package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA13469
{
    private final static int CMD_INIT       = 100;
    private final static int CMD_INSERT     = 200;
    private final static int CMD_MOVECURSOR = 300;
    private final static int CMD_COUNT      = 400;

    private final static UserSolution13469 usersolution = new UserSolution13469();

    private static void String2Char(char[] buf, String str, int maxLen)
    {
        for (int k = 0; k < str.length(); k++)
            buf[k] = str.charAt(k);

        for (int k = str.length(); k <= maxLen; k++)
            buf[k] = '\0';
    }

    private static char[] mStr = new char[90001];

    private static boolean run(BufferedReader br) throws Exception
    {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int queryCnt = Integer.parseInt(st.nextToken());
        boolean correct = false;

        for (int q = 0; q < queryCnt; q++)
        {
            st = new StringTokenizer(br.readLine(), " ");

            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == CMD_INIT)
            {
                int H = Integer.parseInt(st.nextToken());
                int W = Integer.parseInt(st.nextToken());

                String2Char(mStr, st.nextToken(), 90000);

                usersolution.init(H, W, mStr);
                correct = true;
            }
            else if (cmd == CMD_INSERT)
            {
                char mChar = st.nextToken().charAt(0);

                usersolution.insert(mChar);
            }
            else if (cmd == CMD_MOVECURSOR)
            {
                int mRow = Integer.parseInt(st.nextToken());
                int mCol = Integer.parseInt(st.nextToken());

                char ret = usersolution.moveCursor(mRow, mCol);

                char ans = st.nextToken().charAt(0);
                if (ret != ans)
                {
                    correct = false;
                }
            }
            else if (cmd == CMD_COUNT)
            {
                char mChar = st.nextToken().charAt(0);

                int ret = usersolution.countCharacter(mChar);

                int ans = Integer.parseInt(st.nextToken());
                if (ret != ans)
                {
                    correct = false;
                }
            }
        }
        return correct;
    }

    public static void main(String[] args) throws Exception
    {
        int TC, MARK;

        //System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        TC = Integer.parseInt(st.nextToken());
        MARK = Integer.parseInt(st.nextToken());

        for (int testcase = 1; testcase <= TC; ++testcase)
        {
            int score = run(br) ? MARK : 0;

            System.out.println("#" + testcase + " " + score);
        }

        br.close();
    }
}

class UserSolution13469
{
    static int w, h;
    static int cursor;
    static int lastIdx;
    static char[] arr;

    void init(int H, int W, char mStr[])
    {
        w = W;
        h = H;
        cursor = 0;
        lastIdx = 0;
        arr = new char[90001];

        for(int i = 0; i < mStr.length; i++) {
            if(mStr[i] == '\0')
                break;

            lastIdx++;
            arr[i] = mStr[i];
        }
    }

    void insert(char mChar)
    {
        System.arraycopy(arr, cursor, arr, cursor+1, lastIdx - cursor);
        arr[cursor] = mChar;
        lastIdx++;
        cursor++;
    }

    char moveCursor(int mRow, int mCol)
    {
        int index = (mRow * w) - (w - mCol) - 1;

        if(index >= lastIdx) {
            cursor = lastIdx;
            return '$';
        } else {
            cursor = index;
            return arr[index];
        }
    }

    int countCharacter(char mChar)
    {
        if(cursor == lastIdx)
            return 0;

        int result = 0;

        for(int i = cursor; i < lastIdx; i++) {
            if(arr[i] == mChar)
                result++;
        }

        return result;
    }
}