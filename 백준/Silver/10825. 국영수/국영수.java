import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int count;
	static List<Student> list;

	static class Student implements Comparable<Student> {
		String name;
		int kor;
		int eng;
		int math;

		Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}

		@Override
		public int compareTo(Student o) {
			if (o.kor == this.kor) {
				if (o.eng == this.eng) {
					if (o.math == this.math) {
						return this.name.compareTo(o.name);
					} else {
						return o.math - this.math;
					}
				} else {
					return this.eng - o.eng;
				}
			}
			return o.kor - this.kor;

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		count = sc.nextInt();

		list = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			
			String name = sc.next();
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int math = sc.nextInt();

			list.add(new Student(name, kor, eng, math));
		}
		
		Collections.sort(list);
		
		for(Student st : list) {
			System.out.println(st.name);
		}
	}
}