import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author soulListener
 * Created on 2020/2/7.
 * @description 公共工具类
 */
public class CommonUtils {

    /**
     * 通过读取文件 获取字典并存储到哈希表
     * @param filePath
     * @return
     * @throws IOException
     */
    public static HashMap<Long,String> readFile2HashMap(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String content = null;
        HashMap<Long,String> map = new HashMap<>();
        while((content = bufferedReader.readLine())!=null){
            map.put(CommonUtils.WordEncod(content),content);
        }
        bufferedReader.close();
        fileReader.close();
        return map;
    }

    /**
     * 通过读取文件 获取字典并存储到数组
     * @param filePath
     * @return
     * @throws IOException
     */
    public static ArrayList<MapStruct> readFile2Arrays(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String content = null;
        ArrayList arrayList = new ArrayList();
        while((content = bufferedReader.readLine())!=null){
            MapStruct mapStruct = new MapStruct();
            mapStruct.code = CommonUtils.WordEncod(content);
            mapStruct.content = content;
            arrayList.add(mapStruct);
        }
        bufferedReader.close();
        fileReader.close();
        return arrayList;
    }

    /**
     * 单词编码
     * @param content
     * @return
     */
    public static Long WordEncod(String content){
        StringBuilder stringBuilder = new StringBuilder();
        int length = content.length();
        for (int i = 0; i < length; i++) {
            switch (content.charAt(i)){
                case 'e':
                    stringBuilder.append("0");
                    break;

                case 'j':
                case 'n':
                case 'q':
                    stringBuilder.append("1");
                    break;

                case 'r':
                case 'w':
                case 'x':
                    stringBuilder.append("2");
                    break;

                case 'd':
                case 's':
                case 'y':
                    stringBuilder.append("3");
                    break;

                case 'f':
                case 't':
                    stringBuilder.append("4");
                    break;

                case 'a':
                case 'm':
                    stringBuilder.append("5");
                    break;

                case 'c':
                case 'i':
                case 'v':
                    stringBuilder.append("6");
                    break;

                case 'b':
                case 'k':
                case 'u':
                    stringBuilder.append("7");
                    break;

                case 'l':
                case 'o':
                case 'p':
                    stringBuilder.append("8");
                    break;

                case 'g':
                case 'h':
                case 'z':
                    stringBuilder.append("9");
                    break;
            }
        }
        return Long.valueOf(stringBuilder.toString());
    }
}
