package src.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        // 1 . Find duplicate elements in List

        List<Integer> lst = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> s = new HashSet();
        List<Integer> lst1 = lst.stream().filter(a -> !s.add(a)).collect(Collectors.toList());
        System.out.println(lst1);

        // 2 . Remove duplicate elements in List
        List<Integer> lst2 = lst.stream().distinct().collect(Collectors.toList());
        System.out.println(lst2);

        //  3. count each element using java 8
        List<String> names = Arrays.asList("APPLE", "BANANA", "APPLE", "CARROT", "BANANA", "STARBERRY", "Mango");
        Map<String, Long> namecount =  names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(namecount);
        //  3. count each element with out java 8
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        int i=1;
        for(String name :names ){
            if(map.get(name) == null){
                map.put(name , i);
            } else {
                map.put(name , map.get(name)+1);
            }
        }
        System.out.println("map->"+map);


        // 4. Find first Repeating word above

       String repeatedword =  map.entrySet().stream().filter(entry -> entry.getValue() > 1).findFirst().get().toString();

       System.out.println("repeatedword->"+repeatedword);

        // 5. Find first Non Repeating word above

        String nonrepeatedword = map.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().get().toString();
        System.out.println("nonrepeatedword->"+nonrepeatedword);

        Sum s1 = (a , b) -> a+b;
        int result = s1.add(2,3);
        System.out.println("result ----> " +result);

        Sum s2 = (a , b) -> {
            return a+b;
        };

        int result2 = s2.add(2,32);
        System.out.println("result2 ----> " +result2);
    }




}
