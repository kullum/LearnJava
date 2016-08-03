package day14.Generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DAO<T> {
	private Map<String,T> map;
	
	public DAO(Map<String, T> map) {
		super();
		this.map = map;
	}
	public void save(String id, T entity){
		map.put(id, entity);
	}
	public T get(String id){
		return map.get(id);
	}
	public void update(String id, T entity){
		map.put(id, entity);
	}
	public List<T> list(){
		List<T> list = new ArrayList<>();
		for(String s : map.keySet()){
			list.add(map.get(s));
		}
		return list;
	}
	public void delete(String id){
		map.remove(id);
	}
}
class User{
	private int id,age;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + ", name=" + name + "]";
	}
	
}
