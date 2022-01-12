
public class Student implements Comparable<Student>{
	
	public String name;
	public int act;
	public boolean legacy;
	
	// Determines the priority
	private int score() {
		return act + (legacy ? 1 : 0);
	}

	// Workhorse Constructor
	
	public Student(String name, int act, boolean legacy) {
		super();
		this.name = name;
		this.act = act;
		this.legacy = legacy;
	}

	@Override
	public int compareTo(Student o) {
		int ms = score();
		int os = o.score();
		// if my score != other's score return other's score - my score
		// this will sort in descending order
		if (ms != os) 			return os - ms;
		// if my act != other's act return other's act - my act 
		// sort in descending order
		if (act != o.act)		return o.act - act;
		return name.compareTo(o.name);
	}
	
	@Override
	public String toString() {
		return String.format("<%s, %d%s>",
				name, score(), (legacy ? "*" :  ""));
	}
	
}
