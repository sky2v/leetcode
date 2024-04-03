package other;


import java.util.ArrayList;
import java.util.List;

/**
 * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
 * 为了使桶排序更加高效，我们需要做到这两点：
 *      1.在额外空间充足的情况下，尽量增大桶的数量
 *      2.使用的映射函数能够将输入的 N 个数据均匀的分配到 K 个桶中
 * 桶排序的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行。
 * 算法步骤
 *      1.设置一个 BucketSize，作为每个桶所能放置多少个不同数值；
 *      2.遍历输入数据，并且把数据依次映射到对应的桶里去；
 *      3.对每个非空的桶进行排序，可以使用其它排序方法，也可以递归使用桶排序；
 *      4.从非空桶里把排好序的数据拼接起来。
 */
public class Code07_BucketSort {

    public static void main(String[] args) {
        int[] a = {1,8,7,44,42,46,38,34,33,17,15,16,27,28,24};
        List[] buckets=new ArrayList[5];

        for(int i=0;i<buckets.length;i++)//初始化
        {
            buckets[i]=new ArrayList<Integer>();
        }

        //将待排序序列放入对应桶中
        for (int k : a) {
            int index = k / 10;//对应的桶号
            buckets[index].add(k);
        }

        //每个桶内进行排序(使用系统自带快排)
        for (List bucket : buckets) {
            bucket.sort(null);
            for (int j = 0; j < bucket.size(); j++)//顺便打印输出
            {
                System.out.print(bucket.get(j) + " ");
            }
        }
    }


}
