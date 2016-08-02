package day13.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*
 * 操作Collection以及Map的工具类：Collection
 * 注意：区分Collection与Collections
 */

public class TestCollections {
	/*
	 * reverse(List):反转List中元素的排序
	 * shuffle(List):对List集合元素进行随机排序
	 * sort(List):根据元素的自然顺序对指定List集合按升序排序
	 * sort(List,Comparator):根据指定的Comparator产生的顺序对List集合元素进行排序
	 * swap(List,int i,int j):将指定list集合中的i处元素和j处元素进行交换
	 */
	@Test
	public void testCollection1(){
		List list = new ArrayList();
		list.add("AA");
		list.add("BB");
		list.add("DD");
		list.add("CC");
		list.add("FF");
		list.add("EE");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		Collections.sort(list, new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof String && o2 instanceof String ){
					String s1 = ( String ) o1;
					String s2 = ( String ) o2;
					return -s1.compareTo(s2);
				}
				return 0;
			}});
		System.out.println(list);
		Collections.swap(list, 0, 3);
		System.out.println(list);
		
	}
	/*
	 * Object max(Collection):根据元素的自然排序，返回给定集合中的最大元素
	 * Object max(Collection,Comparator):根据Comparator指定的顺序，返回给定集合中的最大元素
	 * Object min(Collection):
	 * Object min(Collection Comparator):
	 * int frequency(Collection Object):返回指定集合中制定元素的出现次数
	 * void copy(List dest,List src):将src中的内容复制到dest中
	 * boolean replaceAll(List list,Object oldVal,Object newVal):使用新值替换
	 * 
	 */
	@Test
	public void testCollection2(){
		List list = new ArrayList();
		list.add("AA");
		list.add("BB");
		list.add("DD");
		list.add("CC");
		list.add("FF");
		list.add("EE");
		System.out.println(list);
		Object s1 = Collections.max(list);
		System.out.println(s1);
		Object s2 = Collections.max(list, new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof String && o2 instanceof String ){
					String s1 = ( String ) o1;
					String s2 = ( String ) o2;
					return -s1.compareTo(s2);
				}
				return 0;
			}});
		System.out.println(s2);
		System.out.println(Collections.frequency(list, "BB"));
		List list2 = Arrays.asList(new Object[6]);
		Collections.copy(list2, list);
		System.out.println(list2);
		Collections.replaceAll(list, "FF","GG");
		System.out.println(list);
	}
	/*
	 * Collections类中提供了多个synchronizedXxx()方法，
	 * 该方法可将指定集合包装成线程同步的集合，
	 * 从而可以解决多线程并发访问集合时的线程安全问题
	 */
	@Test
	public void testCollection3(){
		List list = new ArrayList();
		list.add("AA");
		list.add("BB");
		list.add("DD");
		list.add("CC");
		list.add("FF");
		list.add("EE");
		Collections.synchronizedList(list);
		System.out.println(list);
	}
}
