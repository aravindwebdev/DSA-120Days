import java.util.*;
import java.util.stream.Collectors;
class CountString{
    public static void main(String[] args){
        List<String> fruits = Arrays.asList("mango","pineapple","apple","apple","mango","pineapple");

        Map<String,Integer> hMap = new HashMap<>();

        for(String fruit : fruits){
            hMap.put(fruit, hMap.getOrDefault(fruit,0)+1);
        }

        //Using streams
        Map<String, Long> newHashMap = fruits.stream().collect(Collectors.groupingBy(x->x, Collectors.counting()));

        for(Map.Entry<String,Long> newMap : newHashMap.entrySet()){
            System.out.println(newMap.getKey() + ":" + newMap.getValue());
        }
    }
}