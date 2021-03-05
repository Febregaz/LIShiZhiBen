package sort;

/**************************************************
 版本：V1.0
 创建时间：8/1/2021
 作者：Aragami
 说明：基数排序除了解决元素是字符串的排序问题，同时它对所有字符串的每一位都能保证进行了稳定排序
 即基数排序就是多次保证稳定的计数排序
      因为都是英文字母的字符串，所以本次直接用0～127的ASCII码共128位作为统计数组的长度
 修订记录：
 版本       日期       作者       修订内容
 V1.0    20210108     LYZ      实现基数排序
 ***************************************************/
public class RadixSort {
    public static void main(String[] args) {
        String[] simpleArr = ArrayTool.ArrayInitStr();
        RadixSort( simpleArr , simpleArr.length , 3 );
        ArrayTool.ArrayPrintStr( simpleArr , 0 , simpleArr.length - 1 );
    }

    //循环最大长度次的计数排序（基数排序的精髓）
    public static void RadixSort( String[] simpleArr , int arrLen , int maxLen ){
        int keyMain;
        //simpleArr的索引
        int keySim;
        //大循环，取决于数组中最大的字符串长度
        for ( keyMain = maxLen;keyMain > 0;keyMain -- ){
            //ASCIII码表的128位作为统计数组的长度
            int[] countArr = new int[ 128 ];
            for ( keySim = 0;keySim < arrLen;keySim ++ ){
                countArr[getCharASC( simpleArr[keySim] , keyMain )] ++;
            }
            //求前缀和
            int keyCount;
            int preSum = 0;
            for ( keyCount = 0;keyCount < countArr.length;keyCount ++ ){
                preSum += countArr[keyCount];
                countArr[keyCount] = preSum;
            }
            String[] sortArr = new String[arrLen];
            int keySort = 0;
            for ( keySim = arrLen - 1;keySim >= 0;keySim -- ){
                //过程：
                //    1.计算出当前元素的第keyMain位的ASCII
                //    2.通过countArr找出该ASCII的前缀和
                //    3.根据结果将元素放置在sortArr中合适的位置
                sortArr[countArr[getCharASC( simpleArr[keySim] , keyMain )] - 1] = simpleArr[keySim];
                countArr[getCharASC( simpleArr[keySim] , keyMain )] --;
            }
            //每轮排序好的结果复制给原数组
            System.arraycopy( sortArr , 0 , simpleArr , 0 , arrLen );
        }
    }

    //从最低位开始，即若有三位，最低位即第三位
    public static int getCharASC( String str , int digit ){
        //如果字符串长度小于digit，证明该字符串只有digit-1位甚至更低
        if ( str.length() < digit ){
            //默认0排序最前
            return 0;
        }
        //返回当前字符的ASCII
        return str.charAt( digit - 1 );
    }
}
