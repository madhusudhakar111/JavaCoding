
public class Main {
    public static void main(String[] args) {

// Tricky Java 8 coding questions.
        
		
		// 1 Flatten a Nested List  Ex Input: [[1,2], [3,4], [5]] : Output: [1,2,3,4,5]

		List<List<Integer>> lst1 = List.of(List.of(1,2),List.of(3,4),List.of(5));
		List<Integer> lst1_1 = lst1.stream().flatMap(e -> e.stream()).toList();
		
			//System.out.print(lst1_1);
		
		//2.  Find the Second Highest Number Input: [10, 5, 8, 20, 20, 3] Output: 10
		
		List<Integer> lst2 = List.of(10, 5, 8, 20, 20, 3);
		
		Optional<Integer> result2 = lst2.stream().distinct().sorted(Collections.reverseOrder()).skip(1).findFirst();
		if(result2.isPresent()) {
			//System.out.print(result2.get());
		}
		

		//3 Print Duplicate Characters in a String  Input: "programming"  Output: r g m

		String str3 = "programming";
		Map<Character , Long> map3 = str3.chars().mapToObj( c -> (char)c)
												.collect(Collectors.groupingBy(e -> e, Collectors.counting()));		
		List<Character> lst3 = map3.entrySet().stream().filter(e -> e.getValue() >1 ).map(e -> e.getKey()).toList();
		//System.out.print(lst3);
		
		
		// 4. Frequency of Each Element Input: [10, 20, 10, 30]  Output: {10=2, 20=1, 30=1}
		
		List<Integer> lst4 = List.of(10, 20, 10, 30);
		Map<Integer, Long>  map4 = lst4.stream().collect(Collectors.groupingBy( e -> e, LinkedHashMap::new , Collectors.counting()));
		//System.out.println(map4);
		
		
		// 5. Reverse Each Word in a Sentence  Input: "Java Stream API" Output: "avaJ maertS IPA"
		String str5 = "Java Stream API";
		
		List lst5 = Arrays.stream(str5.split(" ")).map(e -> new StringBuilder(e).reverse().toString()).collect(Collectors.toList());
		//System.out.println(lst5);
		
	   //  6.  Sort a Map by Value
	    
	    Map<String, Integer> map = new HashMap<>();
		map.put("apple", 50);
		map.put("banana", 10);
		map.put("orange", 30);
		
		map.entrySet().stream().sorted(Map.Entry.comparingByValue());
		
		//System.out.print(map);
		
		//7. Find Longest String in List  Input: ["aa", "bbb", "c"]  Output: "bbb"
		List<String> lst7 = List.of("aa", "bbb", "c");
		Optional<String> op7 = lst7.stream().max(Comparator.comparing(String::length));
		if(op7.isPresent()) {
			//System.out.println(op7.get());
		}
		
		Optional<String> op7_7 =lst7.stream().max((s1, s2)-> Integer.compare(s1.length(), s2.length()));
		if(op7_7.isPresent()) {
			//System.out.println(op7_7.get());
		}
		
		// 8. Remove Null Values From List Input: [1, null, 2, null, 3] Output: [1,2,3]
		List<Integer> lst8 = Arrays.asList(1, null, 2, null, 3);
		List<Integer> lst8_8 = lst8.stream().filter(Objects::nonNull).toList();
		//System.out.println(lst8_8);
		
		
		// 9. Sum of Even Numbers Input: [10, 3, 4, 7, 8] Output: 22
		
		List<Integer> lst9 = List.of(10, 3, 4, 7, 8);
		Integer result9 =lst9.stream().filter(e -> e%2==0).mapToInt(e-> (Integer)e).sum();
		//System.out.println(result9);
		
		// 10 Check if Two Strings Are Anagrams** Input: "listen", "silent"  Output: true
		
		
		String str10 = "listen";
		String str10_1 = "silent";
		
		Boolean result10 = str10.chars().sorted().mapToObj(c -> (char)c).toList().equals(str10_1.chars().sorted().mapToObj(c -> (char)c).toList());
		//System.out.println(result10);
		
		//  11 Find First Non-Repeating Character Input: "swiss" Output: 'w'
		
		
		String str11 = "swiss";
		Map<Character, Long> map11 = str11.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()));
		Optional<Character> result11 = map11.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).findFirst();
		
		if(result11.isPresent()) {
			//System.out.println(result11.get());
		}
		
		//12  Convert List to Comma-Separated String Input: [1,2,3]  Output: "1,2,3"
		
		List<Integer> lst12 = List.of(1,2,3);
		
		//String result12 = lst12.stream().map( e -> e.toString()).collect(Collectors.joining(","));  
		String result12 = lst12.stream().map(String::valueOf).collect(Collectors.joining(","));
 
		//System.out.println(result12);
		
		
		//13 Find Max Repeated Character Input: "aaabbccccdde" Output: 'c'
		
		String str13 =  "aaabbccccdde";
		Map<Character, Long> map13 = str13.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		Optional<Character> result13 = map13.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).map(e -> e.getKey()).skip(1).findFirst();
		
		if(result13.isPresent()){
			//System.out.println(result13.get());
		}
		
		// 14  Sum of Salaries (List<Employee>)

		
		
		//15.Convert Map Keys to Uppercase  Given:  Map<String, String> map;
		
		Map<String, String> map15 = Map.of("apple", "red", 
									      "banana", "yellow");
		
		Map<String, String> result15 = map15.entrySet().stream().collect(Collectors.toMap( e -> e.getKey().toUpperCase(), e-> e.getValue()));
		//System.out.println(result15);
		

		//16. Find Common Elements Between Two Lists  Input: [10, 20, 30] [20, 40, 30]  Output: [20, 30]
		
		List<Integer> lst16_1 = List.of(10, 20, 30);
		List<Integer> lst16_2 = List.of(20, 40, 30);

		List<Integer> lst16 = lst16_1.stream().filter(lst16_2::contains).toList();
		//System.out.println(lst16);
		
		
		//17 . Sort a List of Employees by Salary Desc + Name Asc
		
		
		
		
		
		//18 Remove All Duplicate Elements Input: [10,20,10,30,40,20] Output: [10,20,30,40]
		
		List<Integer> lst18 = List.of(10,20,10,30,40,20);
		List<Integer> result18 = lst18.stream().distinct().toList();
		//System.out.println(result18);
		
		
		// 19 Convert List<Integer> to int[]
		
		List<Integer> lst19 = List.of(10,20,10,30,40,20);
		int result19[] = lst19.stream().mapToInt(Integer::valueOf).toArray();
		//System.out.println(Arrays.toString(result19));
		
		
		//20. Group Words by Their Length Input: ["apple", "bat", "cat", "banana"] Output:  {3=[bat, cat], 5=[apple], 6=[banana]}
		
		
		List<String> lst20 = List.of("apple", "bat", "cat", "banana");
		Map<Integer, List<String>> result20 = lst20.stream().collect(Collectors.groupingBy( s -> s.length()));
		//System.out.println(result20);
		
		
		
		// 21   input = "aaabbccc";    output= "a3b2c3"
		String str21 = "aaabbccc";  
		
		Map<Character , Long> map21 = str21.chars().mapToObj(c -> (char)c)
													.collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		
		map21.forEach((k,v) -> System.out.print( k + ""+ v));
		
			// Arrange 0's and 1's 
		
		int[] arr = {1, 0, 1, 0, 1, 0, 0, 0};
		Long zeroCount  = Arrays.stream(arr).filter(e -> e==0).count();
		
		int[] arr5 = IntStream.concat(IntStream.generate(() -> 0 ).limit(zeroCount), IntStream.generate(() -> 1 ).limit(arr.length-zeroCount)).toArray();
		System.out.println(Arrays.toString(arr5));
		
	
    }
}
