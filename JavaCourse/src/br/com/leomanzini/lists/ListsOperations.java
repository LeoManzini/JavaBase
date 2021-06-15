package br.com.leomanzini.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListsOperations {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		
		list.add("Maria");
		list.add("Alex");
		list.add("Bob");
		list.add("Anna");
		
		list.add(2, "Marco");
		
		System.out.println("List size: " + list.size());
		
		System.out.println("----------------------");
		
		for(String item : list) {
			System.out.println(item);
		}
		
		System.out.println("----------------------");
		
		list.remove(1); // Can remove searching by the names too
		
		for(String item : list) {
			System.out.println(item);
		}
		
		System.out.println("----------------------");
		
		list.removeIf(item -> item.charAt(0) == 'M');
		
		for(String item : list) {
			System.out.println(item);
		}
		
		System.out.println("----------------------");
		
		System.out.println("Index of Bob: " + list.indexOf("Bob"));
		System.out.println("Index of Bob: " + list.indexOf("Marco"));
		
		System.out.println("----------------------");
		
		List<String> result = list.stream().filter(item -> item.charAt(0) == 'A').collect(Collectors.toList());
		
		for(String item : result) {
			System.out.println(item);
		}
		
		System.out.println("----------------------");
		
		String name = list.stream().filter(item -> item.charAt(0) == 'A').findFirst().orElse(null);
		
		System.out.println("Fist element with 'A' in the name: " + name);
	}
}
