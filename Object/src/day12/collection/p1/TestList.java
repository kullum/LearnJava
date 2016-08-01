package day12.collection.p1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import org.junit.Test;

public class TestList {
	//ArrayList  List的主要实现类 但是其在内存中是连续的，所以执行插入和删除操作时需要浪费大量资源
	@Test
	public void testList1(){
		long time = System.currentTimeMillis();
		ArrayList list = new ArrayList();
		//add
		list.add(123);
		list.add("MM");
		System.out.println(list);
		list.add(0,"GG");
		System.out.println(list);
		//remove
		list.remove(0);
		System.out.println(list);
		list.remove(new Integer(123));
		System.out.println(list);
		list.add(123);
		System.out.println(list);
		list.remove(list.indexOf(123));
		System.out.println(list);
		//set
		list.add(0, 456);
		list.add("GG");
		list.set(0, 789);
		System.out.println(list);
		//get
		for(int i =0 ; i < list.size();i++){
			System.out.println(list.get(i));
		}
		//增强的for循环
		for(Object obj : list){
			System.out.println(obj);
		}
		list.add(0,789);
		System.out.println(list.indexOf(789));
		System.out.println(list.lastIndexOf(789));
		System.out.println(list.subList(0, 3));
		System.out.println(System.currentTimeMillis()-time);
	}
	//LinkedList 其在内存中是随即存储的，以链表的形式链接，比较适合频繁插入和删除的情景。
	@Test
	public void testList2(){
		
		long time = System.currentTimeMillis();
		LinkedList list = new LinkedList();
		//add
		list.add(123);
		list.add("MM");
		System.out.println(list);
		list.add(0,"GG");
		System.out.println(list);
		//remove
		list.remove(0);
		System.out.println(list);
		list.remove(new Integer(123));
		System.out.println(list);
		list.add(123);
		System.out.println(list);
		list.remove(list.indexOf(123));
		System.out.println(list);
		//set
		list.add(0, 456);
		list.add("GG");
		list.set(0, 789);
		System.out.println(list);
		//get
		for(int i =0 ; i < list.size();i++){
			System.out.println(list.get(i));
		}
		//增强的for循环
		for(Object obj : list){
			System.out.println(obj);
		}
		list.add(0,789);
		System.out.println(list.indexOf(789));
		System.out.println(list.lastIndexOf(789));
		System.out.println(list.subList(0, 3));
		System.out.println(System.currentTimeMillis()-time);
	}
	//Vector  其具有线程安全的特点，但是由于其执行效率较低，所以一般不考虑。
	@Test
	public void testList3(){
		long time = System.currentTimeMillis();
		Vector list  = new Vector();
		//add
		list.add(123);
		list.add("MM");
		System.out.println(list);
		list.add(0,"GG");
		System.out.println(list);
		//remove
		list.remove(0);
		System.out.println(list);
		list.remove(new Integer(123));
		System.out.println(list);
		list.add(123);
		System.out.println(list);
		list.remove(list.indexOf(123));
		System.out.println(list);
		//set
		list.add(0, 456);
		list.add("GG");
		list.set(0, 789);
		System.out.println(list);
		//get
		for(int i =0 ; i < list.size();i++){
			System.out.println(list.get(i));
		}
		//增强的for循环
		for(Object obj : list){
			System.out.println(obj);
		}
		list.add(0,789);
		System.out.println(list.indexOf(789));
		System.out.println(list.lastIndexOf(789));
		System.out.println(list.subList(0, 3));
		System.out.println(System.currentTimeMillis()-time);
	}
}
