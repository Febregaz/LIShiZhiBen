package sort;

/**************************************************
 版本：V1.0
 创建时间：4/1/2021
 作者：Aragami
 说明：本代码堆排序使用最小堆
      数组下标与完全二叉树节点的对应关系
      leftTree = index * 2 + 1
      rightTree = index * 2 + 2
      parentTree = ( index - 1 ) / 2
      堆中最后一个根结点的下标为 N / 2 - 1 ，其中N为数组的长度
      0～ N / 2 - 1 都是非叶子节点，即堆中所有三节点树中的根结点
 修订记录：
 版本       日期       作者       修订内容
 V1.0    20201229     LYZ      实现堆排序与选择排序，因为两者有相似之处
 ***************************************************/
public class HeapSort {
    public static void main(String[] args) {
                           /*0 1  2  3  4  5  6  7  8  9 10 11*/
        int[] simpleArray = {4,66,42,76,22,5,44,33,67,21,1,2};
        //调用选择排序
        SelectSort( simpleArray , simpleArray.length );
        ArrayTool.ArrayPrint( simpleArray , 0 , simpleArray.length - 1 );
        //调用堆排序
        HeapSort( simpleArray , simpleArray.length );
    }

    //选择排序实现
    public static void SelectSort( int[] simpleArray , int arrLen ){
        //擂台王比赛
        int king = 0;
        //金牌
        int gold;
        //擂台挑战者
        int challenger;
        while ( king < arrLen - 1 ){
            //代表本届擂台赛的金牌
            gold = king;
            challenger = gold + 1;
            while ( challenger < arrLen ){
                //挑战成功
                if ( simpleArray[challenger] < simpleArray[gold] ){
                    //金牌易主了
                    gold = challenger;
                }
                challenger += 1;
            }
            //若金牌易主了，则交换两者的值
            if ( gold != king ){
                //真正的擂台王诞生
                ArrayTool.ArrayValSwit( simpleArray , king , gold );
            }
            //下一届比赛开始，本届的擂台王无法参加
            king += 1;
        }
    }

    //堆排序实现
    public static void HeapSort( int[] simpleArray , int arrLen ){
        //堆中最后一个根结点的下标为 N / 2 - 1 ，其中N为数组的长度
        //0～ N / 2 - 1 都是非叶子节点，即堆中所有三节点树中的根结点
        while ( arrLen > 0 ){
            int lastRootNode = arrLen / 2 - 1;
            while ( lastRootNode >= 0 ){
                MinHeapAdj( simpleArray , lastRootNode , arrLen );
                lastRootNode -= 1;
            }
            //调整完最小堆后，交换堆顶和最后一个元素的值
            ArrayTool.ArrayValSwit( simpleArray , 0 , arrLen - 1 );
            //输出最后一个元素
            System.out.print( simpleArray[arrLen - 1] + " " );
            //达到逻辑删除最后一个元素
            arrLen -= 1;
        }
    }

    //最小堆调整
    public static void MinHeapAdj( int[] simpleArray , int RootNode , int arrLen ){
        //假设当前根结点的值最小
        int minVal = RootNode;
        //根据根结点推算出左右子树
        int leftNode = RootNode * 2 + 1;
        int rightNode = RootNode * 2 + 2;
        if ( leftNode < arrLen && simpleArray[leftNode] < simpleArray[minVal] ){
            minVal = leftNode;
        }
        if ( rightNode < arrLen && simpleArray[rightNode] < simpleArray[minVal] ){
            minVal = rightNode;
        }
        //若找出了比根结点更小的子节点，则交换两者的值
        if ( minVal != RootNode ){
            ArrayTool.ArrayValSwit( simpleArray , minVal , RootNode );
        }
    }
}
