package test;

import java.util.*;
import util.MyDate;
import lab1.*;

public class TestPeople {

	public static void main(String[] args) {
		
		ArrayList<Person> people = new ArrayList<>();
		
		// Create our peeps
		people.add(new Person("John", "123 Nowhere", "john@aol.com", "911"));
		people.add(new Employee("Ralph", "321 Somewhere", 
				"ralph@porcelainthrone.com", "411", "ABC", 49000,
				new MyDate()));
		ArrayList<String> hours = new ArrayList<>();
		hours.add("9:00 am to 11:00 am");
		people.add(new Faculty("Jacob", "100 Main", "jacob@aol.com",
				"555-1234", "ABC", 62000, new MyDate(), Rank.PROFESSOR, hours));
		people.add(new Staff("Lucy", "711 Store", "lucy@aol.com",
				"555-2345", "111", 58000, new MyDate(), "Boss"));		
		people.add(new Student("Ewe", "456 Oak", "ewe@do.com",
				"555-9876", Status.FRESHMAN));
		
		assert people.size() == 6 : "Not the right size";
		
		for( Person p : people) {
			System.out.print(p.toString() + " ");
			if( p instanceof Student) {
				System.out.println(((Student)p).getClassification());
			}
			else if( p instanceof Faculty) {
				System.out.println(((Faculty)p).getRank());
			}
			else
			{
				System.out.println(p.getEmail());
			}
		}

	}

}
