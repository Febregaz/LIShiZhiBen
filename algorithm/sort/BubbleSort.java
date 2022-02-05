package sort;

/**************************************************
 版本：V1.0
 创建时间：5/1/2021
 作者：Aragami
 修订记录：
 版本       日期       作者       修订内容
 V1.0    20201229     LYZ      实现冒泡排序，从小到大
 ***************************************************/
public class BubbleSort {
    public static void main(String[] args) {
        int[] simpleArray = ArrayTool.ArrayInit();
        BubbleSort( simpleArray , simpleArray.length );
        ArrayTool.ArrayPrint( simpleArray , 0 , simpleArray.length - 1 );
    }

    public static void BubbleSort( int[] simpleArray , int arrLen ){
        //用于从头坐标开始遍历整个数组
        int patrol = 0;
        //用于外部循环
        int round = 1;
        while ( round <= arrLen - 1 ){ //最后一个元素没有比较对象了，所以少一次循环
            while ( patrol <= arrLen - 1 - round ){ //-round是因为每次循环会找出最大的元素到最右边，下一次循环可以忽略它们
                if ( simpleArray[patrol] > simpleArray[patrol + 1] ){
                    ArrayTool.ArrayValSwit( simpleArray , patrol , patrol + 1 );
                }
                patrol += 1;
            }
            round += 1;
            patrol = 0;
        }
    }
}
