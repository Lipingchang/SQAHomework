package class3;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SortUtils {
	public static <T extends Person> List<T> getRandom(Class<T> classname,int start,int end){
		Constructor<T> constr = null;
		try {
			constr = classname.getConstructor(String.class,String.class);//			T  t = constr.newInstance("name","number");
		} catch ( Exception e) {
			e.printStackTrace();
		}
		List<T> re = new ArrayList<T>();
		
		int count = end - start+1;
		Random rad = new Random(System.currentTimeMillis());
		int[] list = new int[count];    
		boolean[] allreadyin = new boolean[count];  
		for(int i = start; i<=end; i++ ){
			int pos = rad.nextInt(count);
			if(allreadyin[pos] != false ){  
				pos = nextnotready(allreadyin,pos);
			}
			list[pos] = i;
			allreadyin[pos] = true;
 				
		}
		
 		for( int i = 0; i<count; i++){
			//System.out.println(list[i]);
			try {
				T t = constr.newInstance("name"+list[i],""+list[i]);
				re.add(t);
			} catch (Exception e) {
				e.printStackTrace();
			}  
		}
		return re;
		
	}
	
	public static <T extends Person> Set<T> sortTreeSet(List<T> list){
		
		TreeSet<T> set = new TreeSet<T>( new Comparator<T>() {
			public int compare(T a,T b) {
				return -personCompareMethod(a,b);
			}
		});
		
		Iterator<T> it = list.iterator();
		while( it.hasNext() ) {
			T t = (T) it.next();
			set.add(t);
		}
		return (Set<T>)set;
	}
	
	public static <T extends Person> Map<Integer,T> sortTreeMap(List<T> list){
		TreeMap<Integer,T> map = new TreeMap<Integer,T>();
		for(Iterator<T> it=list.iterator();it.hasNext();) {
			T t = it.next();
			map.put(Integer.parseInt(t.getNumber()), t);
		}
		
		
		return (Map<Integer,T>)map;
	}
	
	private static int nextnotready(boolean[] list,int pos){
		int start = pos+1; int end = list.length;
		for( int i = start;i<end;i++){
			if( list[i] == false )
				return i;
		}
		start = 0;end = pos-1;
		for(int i = start;i<end;i++){
			if(list[i] == false)
				return i;
		}
		return -1;
	}
	public static int personCompareMethod(Person a,Person b) { // upper 
		return Integer.parseInt(a.getNumber()) - Integer.parseInt(b.getNumber());	}
}
