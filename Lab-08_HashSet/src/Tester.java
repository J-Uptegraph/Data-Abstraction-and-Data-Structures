
public class Tester {
	
	public static void main(String[] args) {

		HashSet<String> set = new HashSet<>();
		System.out.println("true? " + set.isEmpty());
		System.out.println("true? " + set.add("cat"));
		System.out.println("true? " + set.add("dog"));
		System.out.println("false? " + set.add("dog"));
		System.out.println("2? " + set.size());
		System.out.println("false? " + set.isEmpty());
		System.out.println(set.toString());

		for(char c : "ABCDEFGHIJKLMNOPQUSTUVWXYZ".toCharArray())
			set.add("" + c);
		
		System.out.println(set.toString());
		}
}