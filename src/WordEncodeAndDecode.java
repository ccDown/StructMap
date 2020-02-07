import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WordEncodeAndDecode {

    public static void main(String[] args) throws IOException {

        String filePath = "E:\\JavaProject\\StructMap\\src\\words.txt";
        int repeatTime = 100;
        long number = 783;
        //提前准备好数据
        HashMap<Long, String> hashMap = CommonUtils.readFile2HashMap(filePath);
        ArrayList<MapStruct> arrayList = CommonUtils.readFile2Arrays(filePath);

        startHashMapSerch(number, hashMap,repeatTime);
        startArrayListSerch(number, arrayList,repeatTime);
    }

    /**
     * 哈希表查询
     *
     * @param number
     * @param hashMap
     * @param repeatTime  重复查询次数    因数据量小无法比较出来哈希表与其他数据结构的区别
     */
    public static void startHashMapSerch(long number, HashMap<Long, String> hashMap,int repeatTime) {
        System.out.println("开始哈希表查询！");
        long startTime = System.currentTimeMillis();
        String hashMapResult = "";
        for (int i = 0; i < repeatTime; i++) {
            hashMapResult = hashMap.get(number);
        }
        if (hashMapResult == null) {
            System.out.println("未查询到数字" + hashMapResult + " 对应的单词");
        } else {
            System.out.println("查询到数字" + number + " 对应的单词为" + hashMapResult);
        }
        long endTime = System.currentTimeMillis();
        long usedTime = (endTime - startTime);
        System.out.println("结束哈希表查询！用时" + usedTime + "ms");
    }

    /**
     * 数组查询
     *
     * @param number
     * @param arrayList
     * @param repeatTime  重复查询次数    因数据量小无法比较出来哈希表与其他数据结构的区别
     */
    public static void startArrayListSerch(long number, ArrayList<MapStruct> arrayList,int repeatTime) {
        System.out.println("开始数组查询！");
        long startTime = System.currentTimeMillis();
        String arrayListResult = null;

        for (int i = 0; i < repeatTime; i++) {
            for (MapStruct mapStruct : arrayList) {
                if (mapStruct.code == number) {
                    arrayListResult = mapStruct.content;
                    break;
                }
            }
        }

        if (arrayListResult == null) {
            System.out.println("未查询到数字" + arrayListResult + " 对应的单词");
        } else {
            System.out.println("查询到数字" + number + " 对应的单词为" + arrayListResult);
        }
        long endTime = System.currentTimeMillis();
        long usedTime = (endTime - startTime);
        System.out.println("结束数组查询！用时" + usedTime + "ms");
    }
}
