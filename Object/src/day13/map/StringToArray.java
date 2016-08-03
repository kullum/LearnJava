package day13.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringToArray {
	public static void main(String[] args) {
		String s = "abcdDFasgvasgaweftrawrgvaergaewrgaerrgaergaer";
		String s2,s3;
		String s4="";
		String[] s0 =s.split("");
		Long time1 = System.currentTimeMillis();
		Set<String> set0 = new HashSet<>();
		
		System.out.println(s0.length);
		for(int i = 0; i<s0.length;i++){
			for(int j=i+1;j<s0.length;j++){
				for(int k =0;k<s0.length;k++){
					if(k==i || k==j)
						continue;
					s4 += s0[k];
				}
				set0.add(s4);
				s4 = "";
			}
		}
		System.out.println(System.currentTimeMillis()-time1);
		for(String s1 : set0){
			System.out.println(s1);
		}
		
		
		
		
		
		time1 = System.currentTimeMillis();
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		list = Arrays.asList(s0);//只是简单的在数组和集合之间桥接了一下，不能调用add和remove方法
//		list.remove(0);
		ArrayList<String> list1 = new ArrayList<>();
		for(String s1 : list){
			list1.add(s1);
		}
		for(int i =0 ;i<list1.size();i++){
				s2 = list1.get(i);
				list1.remove(i);
				for(int j=i+1; j<list1.size();j++){
					s3 = list1.get(j);
					list1.remove(j);
					for(String s5 : list1){
						s4 += s5;
					}
					set.add(s4);
					s4 = "";
					list1.add(j, s3);
				}
				list1.add(i, s2);
		}
		System.out.println(System.currentTimeMillis()-time1);
		
		
	}
}
