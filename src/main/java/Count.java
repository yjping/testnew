import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanjiaping
 * @create 2018-10-18 17:19
 * @description TODO
 **/
public class Count {
    public static void main(String[] args) {
        String str = "选择你所喜欢的，喜欢你所选择的。";
        Map<Character,Integer> map = count(str);
        System.out.println(map);
    }

    public static Map<Character,Integer> count(String str){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                int count = map.get(ch) + 1;
                map.put(ch,count);
            }else{
                map.put(ch,1);
            }
        }
        return map;
    }
}
