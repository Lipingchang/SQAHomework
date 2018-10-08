package class3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		System.out.println("student:");
		List<Student> stulist = SortUtils.getRandom(Student.class, 1, 20);
		Set<Student> sets = SortUtils.sortTreeSet(stulist);
		
		for(Iterator<Student> it = sets.iterator();it.hasNext();) {
			System.out.println(it.next().getName());
		}
		
		System.out.println("\n\nteacher:");
		
		List<Teacher> teacherlist = SortUtils.getRandom(Teacher.class, 1, 20);
		Map<Integer, Teacher> sett = SortUtils.sortTreeMap(teacherlist);
		
		for(Iterator<Integer> it = sett.keySet().iterator();it.hasNext();) {
			System.out.println( sett.get(it.next()).getName());
		}
		
	}
}
