package sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**************************************************
 版本：V1.0
 创建时间：7/1/2021
 作者：Aragami
 说明：元素具体落在哪个桶：（（当前元素）-（最小值））/ 桶容量
      桶排序不是稳定排序，因为每个桶内的元素都会进行一次排序
 修订记录：
 版本       日期       作者       修订内容
 V1.0    20210107     LYZ      实现桶排序
 V1.1    20210108     LYZ      添加说明
 ***************************************************/
public class BucketSort {
    public static void main(String[] args) {
        int[] simArr = ArrayTool.ArrayInit();
        int[] sortArr = BucketSort( simArr , simArr.length );
        ArrayTool.ArrayPrint( sortArr , 0 , sortArr.length - 1 );
    }

    public static int[] BucketSort( int[] simArr , int arrLen ){
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        int keySim;
        //求出数组中的最大值和最小值
        for ( keySim = 0;keySim < simArr.length; keySim ++ ){
            if ( simArr[keySim] > maxVal ){
                maxVal = simArr[keySim];
            }
            if ( simArr[keySim] < minVal ){
                minVal = simArr[keySim];
            }
        }
        //计算桶容量
        int bkSize = ( maxVal - minVal ) / ( arrLen - 1 );
        //计算桶个数
        int bkNum = ( maxVal - minVal ) / bkSize + 1;
        //桶数组
        ArrayList< LinkedList > bucket = new ArrayList<>(bkNum);
        //ArrayList的索引
        int keyBk;
        //为每个桶赋予容量
        for ( keyBk = 0;keyBk < bkNum;keyBk ++ ){
            bucket.add( new LinkedList() );
        }
        for ( keySim = 0;keySim < arrLen;keySim ++ ){
            //求每个元素应该放在哪个桶
            int valPos = ( simArr[keySim] - minVal ) / bkSize;
            bucket.get( valPos ).add( simArr[keySim] );
        }
        for ( keyBk = 0;keyBk < bkNum;keyBk ++ ){
            //对每个桶内对元素进行排序
            Collections.sort( bucket.get( keyBk ) );
        }
        //已排序的数组
        int[] sortArr = new int[arrLen];
        int keySort = 0;
        //程序世界与现实世界的区别：现实中桶本来就有空间来存放物品，但是在程序中必须要赋予桶这个能力，而不能理所当然的靠常识。
        //bucketlist就是这个能力
        //第一个是桶容量，第二个是桶
        for ( LinkedList bucketlist : bucket ){
            //第一个是桶里面的元素，第二个是桶容量
            for ( Object val : bucketlist ){
                sortArr[keySort ++] = ( int ) val;
            }
        }
        return sortArr;
    }
}
