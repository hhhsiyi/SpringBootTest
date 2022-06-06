package sparseArray;

import cn.hutool.core.io.file.FileWriter;

/**
 * 2022/3/24
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class SparseArray {
    private static final int defaultFlag = 0;

    public static void main(String[] args) {

        //创建原始的二维数组
        //0表示没棋,1黑2白
        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[1][3] = 1;
        chessArray1[2][4] = 2;
        for (int[] row : chessArray1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //原始棋盘已经完成
        //先遍历二维数组,得到有效数据的个数.
        int sum = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                if (chessArray1[i][j] != defaultFlag) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
        //创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = chessArray1.length;//多少行
        sparseArray[0][1] = chessArray1[0].length;//多少列
        sparseArray[0][2] = sum;//有效数据的个数
        //转化了,遍历二维数组,将非0的值存放到稀疏数组中去.
        int count = 0;//用于记录是第几个非0
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                if (chessArray1[i][j] != defaultFlag) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray1[i][j];
                }
            }
        }

        for (int[] row : sparseArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //将稀疏数组恢复成二维数组.
        /**
         * 先读取第一行,根据第一行的数据创建二维数组,
         * 读取之后几行的数据,并赋值给原来的数组
         */
        int chessArray2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        //输出恢复后的二维数组.
        System.out.println("输出恢复后的二维数组");
        for (int[] row : chessArray2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        FileWriter fileWriter = new FileWriter("D:\\javaFile.txt");
        fileWriter.append("hewen");
        for (int[] row : chessArray1) {
            for (int data : row) {
                fileWriter.append(Integer.toString(data));
//                System.out.printf("%d\t", data);
            }
            fileWriter.write("\n");
        }
    }
}
