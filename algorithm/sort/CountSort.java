package sort;

/**************************************************
 版本：V1.0
 创建时间：6/1/2021
 作者：Aragami
 说明：本代码实现初级版本和优化版本（稳定排序，空间优化）
 修订记录：
 版本       日期       作者       修订内容
 V1.0    20210106     LYZ      实现计数排序
 V1.1    20210106     LYZ      补充注释，修正V1.0的日期
 ***************************************************/
public class CountSort {
    public static void main(String[] args) {
        int[] simpleArray = ArrayTool.ArrayInit();
//        int[] sortArr = Junior_CountSort( simpleArray , simpleArray.length );
        int[] sortArr = Optimized_CountSort( simpleArray , simpleArray.length );
        ArrayTool.ArrayPrint( sortArr , 0 , sortArr.length - 1 );
    }

    //初级版本
    public static int[] Junior_CountSort( int[] simpleArr , int arrLen ){
        //simpleArr的索引
        int keyMax = 0;
        int maxVal = 0;
        //找出最大值
        for ( ;keyMax <= arrLen - 1;keyMax ++ ){
            if ( simpleArr[keyMax] > maxVal ){
                maxVal = simpleArr[keyMax];
            }
        }
        //创建一个长度取最大值+1的统计数组
        int[] countArr = new int[maxVal + 1];
        int countLen = countArr.length;
        //simpleArr的索引
        int keySim;
        for ( keySim = 0;keySim < arrLen;keySim ++ ){
            countArr[simpleArr[keySim]] ++;
        }
        //用于接收排序好的元素的数组
        int[] sortArr = new int[arrLen];
        //sortArr的索引
        int keySort = 0;
        //countArr的索引
        int keyCount;
        //遍历整个统计数组，元素为几时，则输出元素下标几次到sortArr
        for ( keyCount = 0;keyCount < countLen;keyCount ++ ){
            while ( countArr[keyCount] > 0 ){
                sortArr[keySort++] = keyCount;
                countArr[keyCount] -= 1;
            }
        }
        return sortArr;
    }

    //优化版本
    //减少countArr统计数组的空间开销
    public static int[] Optimized_CountSort( int[] simpleArr , int arrLen ){
        int maxVal = simpleArr[0];
        int minVal = simpleArr[0];
        //simpleArr的索引
        int keySim = 0;
        //找出最小值和最大值，以此确定统计数组的大小，以90最小值，95最大值来理解
        for ( ;keySim < arrLen;keySim ++ ){
            if ( simpleArr[keySim] > maxVal ){
                maxVal = simpleArr[keySim];
            }
            if ( simpleArr[keySim] < minVal ){
                minVal = simpleArr[keySim];
            }
        }
        //创建统计数组
        int[] countArr = new int[maxVal - minVal + 1];
        for ( keySim = 0;keySim < arrLen;keySim ++ ){
            //注意-minVal
            countArr[simpleArr[keySim] - minVal] += 1;
        }
        //求统计数组中各个元素的前缀和，以便得出各个元素在排序后的数组中的位置
        //countArr的索引
        int keyCount = 0;
        //当前的前缀和，这里可以看出是稳定排序
        int sumCount = 0;
        for ( keyCount = 0;keyCount < countArr.length;keyCount ++ ){
            sumCount += countArr[keyCount];
            countArr[keyCount] = sumCount;
        }
        //用于接收排序好的元素的数组
        int[] sortArr = new int[arrLen];
        for ( keySim = 0;keySim < arrLen;keySim ++ ){
            sortArr[countArr[simpleArr[keySim] - minVal] - 1] = simpleArr[keySim];
        }
        return sortArr;
    }
}
