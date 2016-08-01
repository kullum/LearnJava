package day12.collection.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

/*
 * 1.存储对象可以考虑:①数组 ②集合
 * 2.数组存储对象的特点：int[] i = new int[10];int[0] = 10;
 * 		》弊端：①一旦创建，其长度不可变。②真实的数组存放的对象的个数是不可知的
 * 3.
 * 
 * */
public class TestCollection {

	@Test
	public void testCollection3(){
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("123");
		Date d = new Date();
		coll.add(d);
		Person p = new Person ("MM",23);
		coll.add(new Person ("MM",23));
		System.out.println(coll);
		
		Collection coll1 = new ArrayList();
		coll1.add(456);
		coll1.add("123");
		coll1.add(d);
		//10. removeAll(Collection coll):从当前集合中删除包含coll的元素
		coll.removeAll(coll1);
		System.out.println(coll);
		//11 equals(Obj obj)：判断两个集合中的元素是否完全相同。
		Collection coll2 = new ArrayList();
		coll2.add(123);
		coll2.add(p);
		System.out.println(coll.equals(coll2));
		//12 hashCode()
		System.out.println(coll.hashCode());
		//13 toArray() 将集合转化为数组，用Arrays.asList(数组)可以将数组转化为集合
		System.out.println();
		Object[] obj = coll.toArray();
		for(int i = 0; i < obj.length;i++){
			System.out.println(obj[i]);
		}
		Collection coll3 = Arrays.asList(obj);
		System.out.println(coll3);

		//14 iterator() : 返回一个Iterator接口实现类的对象，进而实现集合的遍历
		System.out.println(coll);
		System.out.println();
		Iterator iterator = coll.iterator(); 
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		
	}
	
	@Test
	public void testCollection2(){
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("123");
		Date d = new Date();
		coll.add(d);
		Person p = new Person ("MM",23);
		coll.add(new Person ("MM",23));
		System.out.println(coll.size());
		System.out.println(coll);
		//6. contains(Obj obj ):判断集合中是否包含指定的obj元素，如果包含分拿回true，否则返回false
		//判断的依据：根据元素所在类的equals()方法进行判断。
		//明确：如果存入的元素是自定义类的对象，要求：自定义类要重写equals方法。
		System.out.println(coll.contains(p));
		//7. containsAll(Collection coll): 判断当前集合中是否包含coll中所有元素
		Collection coll1 = new ArrayList();	
		coll1.add(123);
		coll1.add(p);
		coll1.add(d);
		System.out.println(coll.containsAll(coll1));
		//8. retainAll(Collection coll):两个集合取交集（相同的元素），结果返回给调用该方法的集合
		coll.retainAll(coll1);
		System.out.println(coll);
		//9. remove(Obj obj):删除集合中的obj元素，若删除成功，返回true。否则，返回false
		System.out.println(coll.remove(d));
		
		
	}
	
	@Test
	public void testCollection1(){
		Collection coll = new ArrayList();
		//Size():返回集合中元素的个数
		System.out.println(coll.size());
		//2. add(Object obj):向集合中添加元素
		coll.add(123);
		coll.add("123");
		coll.add(new Date());
		System.out.println(coll.size());
		//3. addAll(Collection coll) :将形参coll中包含的所有元素添加到当前的集合中
		Collection coll1 = Arrays.asList(1,2,3);
		coll.addAll(coll1);
		System.out.println(coll.size());
		System.out.println(coll);
		//isEmpty()
		System.out.println(coll.isEmpty());
		//5. clear() :清空集合元素
		coll.clear();
		System.out.println(coll.isEmpty());
		
		
	}
}
