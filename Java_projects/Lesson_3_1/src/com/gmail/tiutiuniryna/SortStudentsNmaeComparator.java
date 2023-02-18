package com.gmail.tiutiuniryna;

import java.util.Comparator;

public class SortStudentsNmaeComparator implements Comparator {
	@Override
	public int compare(Object obj1, Object obj2) {
		Student student1 = (Student) obj1;
		Student student2 = (Student) obj2;
		
		String lastName1 =student1.getLastName();
		String lastName2 =student2.getLastName();

		if (lastName1.compareTo(lastName2) > 0) {
			return 1;
		}
		if (lastName1.compareTo(lastName2) < 0) {
			return -1;
		}
		return 0;
	}

}
