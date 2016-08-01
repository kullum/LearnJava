package day12.collection.p1;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import org.junit.Test;

public class TestSet {
	@Test
	public void teatSet1(){
		//元素的顺序是经过hash校验后得到一个hash值，按照hash值对号入座，
		//判断一个重复元素时，先判断hash值是否相等，若想等再判断equals方法，
		//若hash值相等但equals不等（避免此情况出现），仍会被存储
		HashSet set = new HashSet();
		set.add(123);
		set.add(456);
		set.add("Hello");
		set.add(new Person("MM",21));
		set.add(new Person("MM",21));
		System.out.println(set);
		//先用hash算法对元素进行重复校验，然后再用双向链表进行存储。
		LinkedHashSet set1 = new LinkedHashSet();
		set1.add(123);
		set1.add(456);
		set1.add("Hello");
		set1.add(new Person("MM",21));
		set1.add(new Person("MM",21));
		System.out.println(set1);
		
		//TreeSet要求所存储的元素均为同一类型的元素
		//自然排序在自定义类中继承Comparable类并重写compareTo方法
		TreeSet set2 = new TreeSet();
		//在自定义类中继承Comparable类并重写compareTo方法
		set2.add(new Person("MM",21));
		set2.add(new Person("GG",23));
		System.out.println(set2);
		
		//定制排序  主要用于无法或不便于直接修改自定义类时，因此在外部临时添加。
		//1. 创建一个实现了Comparator接口的类对象
		Comparator com = new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Person && o2 instanceof Person){
					Person p1 = (Person) o1;
					Person p2 = (Person) o2;
					return p1.getName().compareTo(p2.getName());
				}
				return 0;
			}	
		};
		//2. 将此对象作为形参传递给TreeSet的构造器中
		TreeSet set3 = new TreeSet(com);
		set3.add(new Person("MM",21));
		set3.add(new Person("GG",23));
		System.out.println(set3);
		
		//若该定制排序只用在某个特殊的集合中，则可以将Comparator的匿名对象传入TreeSet的构造器
		TreeSet set4 = new TreeSet(new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Person && o2 instanceof Person){
					Person p1 = (Person) o1;
					Person p2 = (Person) o2;
					return p1.getName().compareTo(p2.getName());
				}
				return 0;
			}
		});
		set4.add(new Person("MM",21));
		set4.add(new Person("GG",23));
		System.out.println(set4);
	}
	@Test
	public void treeSet2(){
		Comparator com = new Comparator(){
			@Override
			public int compare(Object obj1, Object obj2) {
				if(obj1 instanceof Employee && obj2 instanceof Employee){
					Employee o1 = (Employee) obj1;
					Employee o2 = (Employee) obj2;
					if(o1.getName().equals(o2.getName())){
						if(o1.getAge().equals(o2.getAge())){
							return o1.getBirthday().compareTo(o2.getBirthday());
						}else{
							return o1.getAge().compareTo(o2.getAge());
						}
					}else{
						return o1.getName().compareTo(o2.getName());
					}
				}
				return 0;
			}
			
		};
		TreeSet set  = new TreeSet(com);
		set.add(new Employee("刘德华",55,new MyDate(12,12,1965)));
		set.add(new Employee("刘德华",56,new MyDate(13,12,1965)));
		set.add(new Employee("刘德华",57,new MyDate(11,12,1965)));
		set.add(new Employee("周润发",56,new MyDate(12,12,1964)));
		System.out.println(set.size());
		for(Object s:set){
			System.out.println(s);
		}
	}
}
