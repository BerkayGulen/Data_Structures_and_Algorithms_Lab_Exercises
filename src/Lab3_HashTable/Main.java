package Lab3_HashTable;

import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		// Created 1000 random integers for your hash table implementation
		Integer[] randomArr = generateRandomNumbers(1000, 1000, 5000);

		// TODO: This is the usage of your implementation for hashing
		MyHashtable myHashtable = new MyHashtable(11);

		/**
		 * CALCULATE TIME: !START!
		 **/
		long startTime = System.nanoTime();

		for (int i : randomArr) {
			myHashtable.insert(i);
		}
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		/**
		 * CALCULATE TIME: !END!
		 **/

		System.out.println("Elapsed Time for custom hash table: "+elapsedTime);

//		myHashtable.printTable();

		///////////////////////// SECOND PART ///////////////////////////

		/* TODO: MyInteger class uses hashing implementation of Java
			it is used for hashing algorithm on Hashtable class of Java
		 */
		// Created 1000 random MyInteger class type integers for your usage in Java Hashtable implementation
		MyInteger[] randomArrJava = generateRandomMyNumbers(1000, 5000, 9000);

		Hashtable<Integer, Integer> javaHashtable = new Hashtable<>(11);

		/**
		 * CALCULATE TIME: !START!
		 **/
		 long startTime2 = System.nanoTime();

		for (MyInteger i : randomArrJava) {
			javaHashtable.put(i.hashCode(), i.get());
		}
		 long endTime2 = System.nanoTime();
		 long elapsedTime2 = endTime2 - startTime2;
		/**
		 * CALCULATE TIME: !END!
		 **/
		System.out.println("Elapsed Time for java hash table: "+elapsedTime2);
		System.out.println("Elapsed time difference custom - java: "+(elapsedTime-endTime2));

	}

	// Returns the current capacity of the hash table
	private static int hashTableCapacity(Hashtable<Integer, Integer> table) {
									//throws NoSuchFieldException, IllegalAccessException {

		Field tableField = null;

		try {
			tableField = Hashtable.class.getDeclaredField("table");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		tableField.setAccessible(true);

		Object[] tempTable = new Object[0];

		try {
			tempTable = (Object[]) tableField.get(table);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return (tempTable == null ? 0 : tempTable.length);
	}

	// Generate random numbers between low and high
	private static Integer[] generateRandomNumbers(int size, int lowBound, int highBound)
	{
		Random rd = new Random();
		Integer[] tempRandom = new Integer[size];

		for (int i = 0; i < tempRandom.length; i++)
		{
			tempRandom[i] = rd.nextInt(highBound - lowBound) + lowBound;
		}

		return tempRandom;
	}

	// Generate random numbers from MyInteger class between low and high
	private static MyInteger[] generateRandomMyNumbers(int size, int lowBound, int highBound)
	{
		Random rd = new Random();
		MyInteger[] tempRandom = new MyInteger[size];

		for (int i = 0; i < tempRandom.length; i++)
		{
			int randomInt = rd.nextInt(highBound - lowBound) + lowBound;
			tempRandom[i] = new MyInteger(randomInt);
		}

		return tempRandom;
	}

	/**
	 * QUESTION 4: Discuss the time complexities
	 *Our custom hash table average time complexity at insert,delete and search O(1).
	 * According to java docs, they have provided the same time complexity at insert, delete and search.
	 * However, the time that takes is not same our custom hash table is faster than java.
	 * this difference occurs due to the couple of reasons:
	 * 1) Handling with Collisions
	 * Our Hash table and java hash table could be use difference collision algorithms.
	 * According to java docs, java uses chaining for handling the collisions, but we use quadratic probing.
	 * quadratic probing is faster than chaining, but it is harder to implement.
	 * 2)Another reason could be load factor.
	 * According to java docs, java uses load factor<0.75, but we use rehashing when half of the array is full which is 0.5.
	 * this load factor difference could be effect the performance of our tables.
	 * 3) Synchronized thread safe structure
	 * java's hashtable uses Synchronized structure so this makes java to operate slower. our structure is sot Synchronized so this could be the reason why our system faster.
	 */
}
