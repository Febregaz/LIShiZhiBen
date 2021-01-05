package sort;

/**************************************************
 版本：V1.0
 创建时间：5/1/2021
 作者：Aragami
 修订记录：
 版本       日期       作者       修订内容
 V1.0    20201229     LYZ      实现合并排序
 ***************************************************/
public class MergeSort {
    public static void main(String[] args) {
        int[] simpleArray = ArrayTool.ArrayInit();
        Divide( simpleArray , 0 , simpleArray.length - 1 );
        ArrayTool.ArrayPrint( simpleArray , 0 , simpleArray.length - 1 );
    }

    //分
    public static void Divide( int[] simpleArray , int head , int tail ){
        //递归出口
        if ( head == tail ){
            return;
        }
        int middle = ( head + tail ) / 2;
        //左右两部分继续拆分
        Divide( simpleArray , head , middle );
        Divide( simpleArray , middle + 1 , tail );
        //拆到底后，左右两部分已有序，进行合并
        Merge( simpleArray , head , middle , tail );
    }

    //治，左右两个有序的合并元素
    public static void Merge( int[] simpleArray , int leftHead , int leftTail , int rightTail ){
        //copy数组时要用到leftHead的值
        int copyHead = leftHead;
        //有序的数组
        int[] sortedArr = new int[rightTail - leftHead + 1];
        //有序数组的下标，从0开始
        int sortedHead = 0;
        //右部分数组的头坐标由左部分数组的尾坐标决定
        int rightHead = leftTail + 1;
        //左右两部分分别从头坐标开始进行比较，哪个小就优先写入sortedArr中
        while ( leftHead <= leftTail && rightHead <= rightTail ){
            if ( simpleArray[leftHead] < simpleArray[rightHead] ){
                sortedArr[sortedHead ++] = simpleArray[leftHead ++];
            }
            else {
                sortedArr[sortedHead ++] = simpleArray[rightHead ++];
            }
        }
        //上面的循环结束后，可能会有一方有剩余，接着将剩余部分写入sortedArr
        while ( leftHead <= leftTail ){
            sortedArr[sortedHead ++] = simpleArray[leftHead ++];
        }
        while ( rightHead <= rightTail ){
            sortedArr[sortedHead ++] = simpleArray[rightHead ++];
        }
        //copy到simpleArray
        System.arraycopy( sortedArr , 0 , simpleArray , copyHead , sortedArr.length );
    }
}
