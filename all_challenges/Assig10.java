import java.util.*;

public class Assig10{

	public static void main(String[] args){

		
		List<Integer> list = new ArrayList<>(List.of(1,2,3,2,4,2,1));
		
		Map<Integer,Integer> map = new TreeMap<>();

		for (int ele : list){

			if (!map.containsKey(ele)){
				map.put(ele,1);
			}else{
				map.replace(ele,map.get(ele)+1);
			}
		}

		System.out.println(map);

	}
}