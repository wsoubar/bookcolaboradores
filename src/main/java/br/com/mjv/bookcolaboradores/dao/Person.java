package br.com.mjv.bookcolaboradores.dao;

import org.jongo.marshall.jackson.oid.ObjectId;


public class Person {

	@ObjectId
	private String _id;
	private String name;
	private int age;

	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "[id=" + _id + ", name=" + name + ", age=" + age + "]";
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
}
