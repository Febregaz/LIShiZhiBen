package sort;

/**************************************************
 版本：V1.0
 创建时间：2020/12/29
 作者：LYZ
 修订记录：
 版本       日期       作者       修订内容
 V1.0    20201229     LYZ      实现可以公用的数组功能
 ***************************************************/
public class ArrayTool {

    public static void ArrayPrint( int[] simpleArray , int head , int tail ){
        while (head <= tail){
            System.out.print(simpleArray[head] + " ");
            head += 1;
        }
        System.out.println("");
    }

    public static void ArrayValSwit( int[] simpleArray , int head , int tail ){
        int puppet = simpleArray[head];
        simpleArray[head] = simpleArray[tail];
        simpleArray[tail] = puppet;
    }

}
