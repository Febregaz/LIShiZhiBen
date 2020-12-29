package sort;

/**************************************************
 版本：V1.0
 创建时间：2020/12/29
 作者：LYZ
 修订记录：
 版本       日期       作者       修订内容
 V1.0    20201229     LYZ      实现插入排序与希尔排序
 *************************************************/
public class ShellSort {
    public static void main(String[] args) {
                           /*0 1  2  3  4  5  6  7  8  9 10 11*/
        int[] simpleArray = {4,66,42,76,22,5,44,33,67,21,1,2};
        ShellSort(simpleArray , 1);
    }

    //gap = 1,插入排序，其他值为希尔排序
    public static void ShellSort(int[] simpleArray , int insertOrShell){
        //0为插入排序，其他为希尔排序
        int gap = insertOrShell == 0 ? 1 : simpleArray.length / 2;
        int sortedIndex = 0;
        int compIndex = 0;
        while (gap > 0){
            while (sortedIndex < simpleArray.length - gap){
                compIndex = sortedIndex + gap;
                int challenger = simpleArray[compIndex];//challenger为与已排序好的序列进行比较的最近一个元素
                //找出此最近的元素在已排序好的序列中的位置
                while ((compIndex - gap) >= 0 && simpleArray[compIndex - gap] > challenger){
                    simpleArray[compIndex] = simpleArray[compIndex - gap];
                    compIndex -= gap;
                }
                //放置好最近的元素
                simpleArray[compIndex] = challenger;
                sortedIndex += 1;
            }
            gap /= 2;
            sortedIndex = 0;
        }
        ArrayTool.ArrayPrint(simpleArray , 0 , simpleArray.length - 1);
    }
}
