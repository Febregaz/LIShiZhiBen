package sort;

/**************************************************
 版本：V1.0
 创建时间：2020/12/29
 作者：LYZ
 修订记录：
 版本       日期       作者       修订内容

 V1.0    20201229     LYZ      实现插入排序与希尔排序
 V1.1    20201231     LYZ      重看代码，补充看不懂的代码的注释
 V1.2    20201231     LYZ      希尔排序优化；利用break及时跳出while循环
 *************************************************/
public class ShellSort {
    public static void main(String[] args) {
                           /*0 1  2  3  4  5  6  7  8  9 10 11*/
        int[] simpleArray = {4,66,42,76,22,5,44,33,67,21,1,2};
        ShellSort(simpleArray , 1);
    }

    //gap = 0,插入排序，其他值为希尔排序
    public static void ShellSort(int[] simpleArray , int insertOrShell){
        //0为插入排序，其他为希尔排序
        int gap = insertOrShell == 0 ? 1 : simpleArray.length / 2;
        //已排序好的队列的下标
        int sortedIndex = 0;
        //当前用于比较的元素下标
        int compIndex = 0;
        while (gap > 0){
            while (sortedIndex < simpleArray.length - gap){ //为了让compIndex不越界
                compIndex = sortedIndex + gap;//根据gap的大小得到要进行比较的元素下标
                int challenger = simpleArray[compIndex];//challenger为与已排序好的序列进行比较的最近一个元素
                //找出此最近的元素在已排序好的序列中的位置
                //simpleArray[compIndex - gap]为已排序好的队列中要与challenger进行比较的元素
                while ((compIndex - gap) >= 0 && simpleArray[compIndex - gap] > challenger){
                    simpleArray[compIndex] = simpleArray[compIndex - gap];
                    compIndex -= gap;//只有符合条件下，compIndex才会执行减一。
                                     //就像住酒店，先看房，如果觉得合适在交钱（减一）
                    //如果是希尔排序，则直接结束这一次循环
                    //不然当compIndex = 6时，减gap后为3，返回到while中(compIndex - gap) = 0，符合条件，有可能会继续执行交换操作
                    //但是这在希尔排序中是不允许的
                    if ( gap != 1 ){
                        break;
                    }
                }
                //放置好最近的元素
                simpleArray[compIndex] = challenger;
                sortedIndex += 1;//由于每一次循环都会新增一个元素进入有序队列，所以sortedIndex会在每次循环后+1
                                 //同时此举也是为了每次让有序队列中最先进行对比的是有序队列中最新的一个元素
            }
            gap /= 2;
            sortedIndex = 0;
        }
        ArrayTool.ArrayPrint(simpleArray , 0 , simpleArray.length - 1);
    }
}
