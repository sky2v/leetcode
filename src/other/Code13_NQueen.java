package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯算法思想
 *
 * N皇后问题
 * 问题：在n×n格的棋盘上放置彼此不受攻击的n个皇后。按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * N皇后问题等价于在n×n格的棋盘上放置n个皇后，任何2个皇后不放在同一行或同一列或同一斜线上。（n=1或n>=4才有解）
 * <p>
 * 分析：从n×n个格子中选择n个格子摆放皇后。可见回溯法解空间树为子集树。数组queen中的第i个元素表示第i个皇后，其坐标是(i,queen(i))。约束条件有两个：
 *      1.所有任意两个皇后不能在同一列，因此任意两个queen[i]和queen[j]的值不能相同（i != j）；
 *      2.所有任意两个皇后不能再对角线上，把棋盘的方格变成一个二维数组，假设有两个皇后分别放在(i,j)和(m,n)，当(m-i) == (n-j)时两者在对角线上。使用isMatch(int k)方法判断是否冲突。
 */
public class Code13_NQueen {
    /**
     * 皇后数组
     * 下标对于棋盘行数，值表示列数，即位置为(i,a(i)).
     */
    private int[] queen;

    /**
     * 求解n皇后问题
     *
     * @param n
     */
    public List<int[]> backMethod(int n) {
        List<int[]> res = new ArrayList<>();
        //初始化数组
        queen = new int[n];
        //初始化皇后起点
        Arrays.fill(queen, -1);
        //从第一个皇后开始
        int k = 0;
        while (true) {
            //第k个皇后要后移一个
            queen[k]++;//一开始由-1增加
            //判断是否应该回到上一行搜索
            if (queen[k] >= n) {
                //皇后越界,此行没有位置可以放置皇后
                if (k > 0) {//把须修改后的数组位置改为-1
                    queen[k] = -1;
                    k--;//回到没越界处 回溯
                    continue;//跳出下面判断
                } else break;
            }

            if (!isMatch(k)) {//不与之前的皇后冲突
                k++;
                if (k >= n) {//越界
                    //存储答案
                    res.add(queen);
                    k--;//回到上一个皇后 回溯
                }
            }
        }
        return res;
    }

    /**
     * 判断我们第k个皇后是否与之前的皇后冲突
     *
     * @param k
     * @return true表示冲突
     */
    private boolean isMatch(int k) {
        for (int i = k - 1; i > -1; i--) {
            if (queen[k] == queen[i] || Math.abs(queen[k] - queen[i]) == Math.abs(k - i))
                //Math.abs(queen[k]-queen[i]) == Math.abs(k-i) 表示在一条对角线上
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Code13_NQueen code13NQueen = new Code13_NQueen();



    }
}
