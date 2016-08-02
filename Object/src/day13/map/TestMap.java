package day13.map;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import day12.collection.p1.Person;
/*
 * 使用hash算法对每个元素进行hash校验，得到一个hash值。
 * 在内存中建立一个“数组链表”数组的长度初始值为16，
 * 元素的存储位置为hash值对16（数组长度）取余数，得到的数即为在数组中的存储位置。
 * 数组中存放的是单向链表，数组的每个单元若该单元未存有元素则该单元为null，
 * 若存有元素则显示该元素的键值对，并且将指针指向null，等待下一个元素的地址。
 * 每个单元中最多存有8个元素，大于8时，将该数组长度扩大一倍并重新计算每个元素的存放单元。
 * 并且当元素个数大于数组长度的3/4时，数组增大一倍，并重新计算.
 */
public class TestMap {
	//HashMap
	@Test
	public void testMap1(){
		System.out.println("HashMap");
		Map map = new HashMap();
		map.put("AA", 213);
		map.put("BB", 456);	
		map.put("BB", 45);
		map.put(123, "CC");
		map.put(null, null);
		map.put(new Person("zhang",3), 77);
		map.put(new Person("li",4), 88);
		System.out.println(map.size());
		System.out.println(map);
		//遍历：
		//1.Set keySet() 与 Collection value() 和 Object get(Object key)
		Set set = map.keySet();
		for(Object s : set){
			System.out.println(s);
			System.out.println(map.get(s));
		}
		Collection val = map.values();
		for(Object v : val){
			System.out.println(v);
		}
		//2. Set entrySet()将map中的每个entry转化为Set集合的每个元素（Map.Entry类）的两个属性（用getKey与getValue访问）
		Set set1 = map.entrySet();
		for(Object s : set1){
			Map.Entry entry =  (Map.Entry) s;
			System.out.println(entry.getKey()+ "------"+ entry.getValue());
		}
		map.remove("BB");
		System.out.println(map);
		
	} 
	//LinkedHashMap
	@Test
	public void testMap2(){
		System.out.println("LinkedHashMap");
		Map map = new LinkedHashMap();
		map.put(789, "CC");
		map.put("BB", 456);
		map.put(new Person("张三",23), 789);
		map.put("AA", 123);
		map.put("CC", 789);
		System.out.println(map.size());
		System.out.println(map);
		//遍历：
		//1.Set keySet() 与 Collection value() 和 Object get(Object key)
		Set set = map.keySet();
		for(Object s : set){
			System.out.println(s);
			System.out.println(map.get(s));
		}
		Collection val = map.values();
		for(Object v : val){
			System.out.println(v);
		}
		//2. Set entrySet()将map中的每个entry转化为Set集合的每个元素（Map.Entry类）的两个属性（用getKey与getValue访问）
		Set set1 = map.entrySet();
		for(Object s : set1){
			Map.Entry entry =  (Map.Entry) s;
			System.out.println(entry.getKey()+ "------"+ entry.getValue());
		}
	} 
	//TreeMap
	@Test
	public void TestTreeMap(){
		Map tree = new TreeMap(new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Person && o1 instanceof Person){
					Person obj1 = (Person) o1;
					Person obj2 = (Person) o2;
					return obj1.getAge().compareTo(obj2.getAge());
				}
				return 0;
			}
			
		});
		tree.put(new Person("张三",22), 95);
		tree.put(new Person("李四",25), 95);
		tree.put(new Person("王五",28), 95);
		tree.put(new Person("麻六",21), 95);
		System.out.println(tree);
		
	}
	//Hashtable 太古老了，基本不用
	
	//Properties处理属性文件
	@Test
	public void testProperties() throws FileNotFoundException, IOException{
		Properties pro = new Properties();
		pro.load(new FileInputStream(new File("jdbc.properties")));
		String uesr = pro.getProperty("user");
		System.out.println(uesr);		
		System.out.println(pro.getProperty("password"));
	}
}
