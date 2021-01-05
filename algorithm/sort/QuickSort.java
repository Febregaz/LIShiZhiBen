package sort;

/**************************************************
 版本：V1.0
 创建时间：5/1/2021
 作者：Aragami
 修订记录：
 版本       日期       作者       修订内容
 V1.0    20201229     LYZ      实现快速排序
 ***************************************************/
public class QuickSort {
    public static void main(String[] args) {
                           /*0 1  2  3  4  5  6  7  8  9 10 11*/
        int[] simpleArray = {4,66,42,76,22,5,44,33,67,21,1,2};
        QuickSort( simpleArray , 0 , simpleArray.length - 1 );
        ArrayTool.ArrayPrint( simpleArray , 0 , simpleArray.length - 1 );
    }

    public static void QuickSort( int[]simpleArray , int head , int tail ){
        //递归出口；只有一个元素，则退出递归
        if ( tail <= head ){
            return;
        }
        //基准值取头元素
        int datum = simpleArray[head];
        //左右哨兵
        int sentinelL = head;
        int sentinelR = tail;
        while ( sentinelL != sentinelR ){
            //右哨兵向左移动
            while ( true ){
                while ( sentinelL != sentinelR ){
                    //若找到比基准值小的数或者两个哨兵相遇，则停下来
                    if ( simpleArray[sentinelR] < datum || sentinelL == sentinelR ){
                        break;
                    }
                    //否则一直向左移动
                    sentinelR --;
                }
                break;
            }
            //左哨兵向右移动
            while ( true ){
                //先判断左右哨兵是否相遇
                while ( sentinelL != sentinelR ){
                    //避开基准值
                    sentinelL ++;
                    //若找到比基准值大的数或者两个哨兵相遇，则停下来
                    if ( simpleArray[sentinelL] > datum || sentinelL == sentinelR ){
                        break;
                    }
                }
                break;
            }
            //左右哨兵未相遇时发生的数值交换
            if ( sentinelL != sentinelR ){
                ArrayTool.ArrayValSwit( simpleArray , sentinelL , sentinelR );
                //右哨兵循环中如果符合条件则没有执行sentinelR --操作，所以这里补上
                sentinelR --;
            }
        }
        //将基准值放到左右哨兵相遇的位置
        ArrayTool.ArrayValSwit( simpleArray , head , sentinelL );
        //基准值左右两部分进入递归
        QuickSort( simpleArray , head , sentinelL - 1 );
        QuickSort( simpleArray , sentinelR + 1 , tail );
    }
}
