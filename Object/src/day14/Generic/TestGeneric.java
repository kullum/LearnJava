package day14.Generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
/*
 * 泛型的使用
 * 1.在集合中使用泛型
 * 2.自定义泛型类，泛型接口，泛型方法
 * 3.泛型与继承关系
 * 4.通配符
 */
public class TestGeneric {
	@Test
	public void testDAO(){
		DAO<User> dao = new DAO<>(new HashMap<String,User>());
		dao.save("AA", new User(1,21,"zhang3"));
		dao.save("BB", new User(2,22,"li4"));
		dao.save("CC", new User(3,23,"wang5"));
		dao.save("BB", new User(2,25,"ma6"));
		System.out.println(dao.get("BB"));
		dao.update("BB", new User(4,25,"ma6"));
		dao.delete("CC"); 
		List<User> list = dao.list();
		System.out.println(list);
	}
	/*
	 * 通配符 ?
	 * List<A>、List<B>......都是List<?>的子类
	 * 
	 * ? extends A  可以存放A以及其子类的类型
	 * ? super A 可以存放A以及其父类的类型
	 */
	@Test
	public void testGeneric1(){
		List<Object> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		//list1 = list2;  Type mismatch: cannot convert from List<String> to List<Object>
		//List<Object>与List<String>是并列关系，并没有继承关系
		
		List<?> list = null;
		list =list1;//List<?>是父类
		list = list2;//List<?>是父类
		
		List<? extends Number> list3 = null;
		List<Integer> list4 =null;
		list3 = list4;
		// list3 = list1;  ? extends A  可以存放A以及其子类的类型
		List<? super Number> list5 = null;
		list5 =list1;//* ? super A 可以存放A以及其父类的类型
	}
	
	
	/*
	 * 自定义泛型类，泛型方法
	 */
	@Test
	public void testOrder(){
		Order <Boolean> order = new Order<>();
		order.setE1(true);
		order.add();
		order.setE1(false);
		order.add();
		System.out.println(order.list);
		
		IntOrder i = new IntOrder();
		i.setE1(123);
		i.add();
		i.setE1(456);
		i.add();
		System.out.println(i.list);
		
		Integer i1 = order.getT(456);
		System.out.println(i1);
		
		Integer[] i2 = new Integer[]{123,456,789};
		List<Integer> list1= new ArrayList<>();
		List<Integer> list2 = order.fromArrayToList(i2, list1);
		System.out.println(list2);
	}
	@Test
	public void testGeneric(){
		Map<String,Integer> map = new HashMap<>();
		map.put("AA", 456);
		map.put("BB", 456);
		map.put("CC", 456);
		map.put("DD", 456);
		map.put("EE", 456);
		map.put("FF", 456);
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		for(Map.Entry<String, Integer> s : set){
			System.out.println(s.getKey()+"--->"+s.getValue());
		}
	}
}
