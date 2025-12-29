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




         Set s = new HashSet();
        List<Integer> lst2 =lst.stream().filter(a -> !s.add(a)).toList();
        System.out.println(lst2);

        List<String> names = List.of("APPLE", "BANANA", "APPLE", "CARROT", "BANANA", "STARBERRY", "Mango");

        Map<String, Long> counts =  names.stream().collect(Collectors.groupingBy(name -> name, Collectors.counting()));
        System.out.println(counts);

        Optional<Integer> op = lst.stream().sorted().limit(2).findAny();

        if(op.isPresent()){
            System.out.println(op.get());
        }

        // max number
        lst.stream().sorted().max(Comparator.naturalOrder()).get();

        // second largest number
        lst.stream().sorted().sorted(Comparator.reverseOrder()).skip(1).findFirst();

         // common elements from the list
        List<Integer> lst3 = List.of(10,15,8,49,25,98,98,32,15);
        lst1.stream().filter(lst3::contains).toList();
    }
    
       
//  Find Intersection of Two Arrays A = [1, 2, 2, 1] B = [2, 2] Output = [2]
    
		int arr1[] = { 1, 2, 2, 1 };
		int arr2[] = { 2, 2 };

		Set<Integer> set = new HashSet<>();
		Set<Integer> resultSet = new HashSet<>();

		for (int n : arr1) {
			set.add(n);
		}

		for (int n : arr2) {
			if (!set.add(n)) {
				resultSet.add(n);
			}
		}
		System.out.println(resultSet);



}
