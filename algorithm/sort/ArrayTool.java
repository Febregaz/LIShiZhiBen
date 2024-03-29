package sort;

/**************************************************
 版本：V1.0
 创建时间：2020/12/29
 作者：LYZ
 修订记录：
 版本       日期       作者       修订内容
 V1.0    20201229     LYZ      实现可以公用的数组功能
 V1.1    20210105     LYZ      添加数组初始化函数
 V1.2    20210106     LYZ      添加数组初始化函数中数组的坐标注释
 V1.3    20210108     LYZ      添加初始化字符串数组函数
 V1.4    20210108     LYZ      添加输出字符串数组函数
 ***************************************************/
public class ArrayTool {

    public static void ArrayPrint( int[] simpleArray , int head , int tail ){
        while (head <= tail){
            System.out.print(simpleArray[head] + " ");
            head += 1;
        }
        System.out.println("");
    }

    public static void  ArrayPrintStr( String[] simpleArray , int head , int tail ){
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

    /*
    作用：初始化一个默认数组
     */
    public static int[] ArrayInit(){
                           /*0 1  2  3  4  5  6  7  8  9 10 11*/
        int[] simpleArray = {4,66,42,76,22,5,44,33,67,21,1,2};
        return simpleArray;
    }

    public static String[] ArrayInitStr(){
        String[] simpleArray = {"qd","abc", "qwe","hhh","a","cws", "ope"};
        return simpleArray;
    }

    public void test(){
        try {

        }catch ( Exception e ){
            String i = "dfsd";
            if ( 1 == 2 ){
                
            }
        }
    }



}
