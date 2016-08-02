package day14.Generic;

import java.util.ArrayList;
import java.util.List;
/*
 * 自定义泛型类，泛型方法
 */

public class Order <E>{
	private E e1;
	ArrayList<E> list = new ArrayList<>();
	
	public <T> List<T> fromArrayToList(T[] k, List<T> list1){
		for(T k1 : k){
			list1.add(k1);
		}
		return list1;
	}
	
	public  <T>T getT(T e){
		return e;
	} 
	
	public void add(){
		list.add(e1);
	}
	
	public E getE1() {
		return e1;
	}

	public void setE1(E e1) {
		this.e1 = e1;
	}
	
}

class IntOrder extends Order<Integer>{
	
}