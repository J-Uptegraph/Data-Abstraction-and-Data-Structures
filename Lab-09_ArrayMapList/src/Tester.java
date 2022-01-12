
public class Tester {

	public static void main(String[] args) {
		ArrayListMap<String, Integer> alm = new ArrayListMap<String, Integer>();
		
		System.out.println(alm.put("Cindy", 1));
		System.out.println(alm.put("Nina", 2));
		System.out.println(alm.put("Morgan", 3));
		System.out.println(alm.put("Michael", 4));
		
		System.out.println(alm.size());
		System.out.println(alm.containsKey("Morgan"));
		System.out.println(alm.containsKey("Jack"));
		System.out.println(alm.get("Michael"));
		System.out.println(alm.values());
		System.out.println(alm.keySet());
		System.out.println(alm.put("Michael", 6));
		System.out.println(alm.get("Michael"));
		System.out.println(alm.remove("Michael"));
		System.out.println(alm.remove("Morgan"));
		System.out.println(alm.remove("Nina"));
		System.out.println(alm.remove("Cindy"));
		System.out.println(alm.size());
	}
	
}
