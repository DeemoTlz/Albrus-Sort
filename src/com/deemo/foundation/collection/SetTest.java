package com.deemo.foundation.collection;

import org.testng.annotations.Test;

import java.util.*;

public class SetTest {

	@Test
	public void testHashMap() {
		Bean b1 = new Bean("AA");
		Bean b2 = new Bean("BB");
		Bean b3 = new Bean("CC");
		Bean b4 = new Bean("DD");
		Bean b5 = new Bean("EE");

		Map<Bean, Integer> hashMap = new HashMap<>(4, 1);
		hashMap.put(b1, 1);
		hashMap.put(b2, 2);
		hashMap.put(b3, 3);
		hashMap.put(b4, 4);
		hashMap.put(b5, 5);
		hashMap.put(b1, 0);

		System.out.println(hashMap);
	}

	@Test
	public void testSet() {
		Bean b1 = new Bean("AA", 13);
		Bean b2 = new Bean("BB", 12);
		Bean b3 = new Bean("AA", 11);
		//Bean b4 = new Bean("AA", 15);

		Set<Bean> set = new HashSet<>();

		set.add(b1);
		set.add(b2);
		set.add(b3);
		//set.add(b4);

		System.out.println(set);
	}

	private static class Bean {
		private String name;

		private Integer age;
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		Bean(String name) {
			this.name = name;
		}

		Bean(String name, Integer age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Bean{" +
					"name='" + name + '\'' +
					", age=" + age +
					'}';
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Bean bean = (Bean) o;
			return Objects.equals(name, bean.name);
		}

		@Override
		public int hashCode() {
			return 2111;
		}
	}
}
