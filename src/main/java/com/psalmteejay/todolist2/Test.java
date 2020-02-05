/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalmteejay.todolist2;

/**
 *
 * @author Omali
 */
import java.util.Scanner;

//remember to import the ToDoList class


public class Test {
	/* public static void main(String[] args) {
		Test t = new Test();

		//this calls a method that runs all of the tests you will implement
		t.testAll();
	}
	*/
	
	
	/* //Test of adding topic
	private static void testaddTopic() {
		Menu.addTopic();
		if (Menu.topicTodoList.size() == 1) {
			EcrireFichier.writeString("Topic added successfully!!!");
		}
	} */

	//Here is an example of the test for adding a task. 
	ToDoList toDoList =new ToDoList("programTest");
	
	private void testCreateTask() {
		
		System.out.println("--------Test create task--------");
		System.out.println("Adding elements to the list");
		toDoList.createTask();
		toDoList.createTask();

		if (toDoList.getTasks().size() == 2) {
			System.out.println("Create Task test is success!!");
			EcrireFichier.writeString("Create Task test is success!!!");
		} else {
			System.out.println("Create Task test is fail!!");
			EcrireFichier.writeString("Create Task test is fail!!!");
		}
		
	}
	
	private void testAssignTask() {
		
		System.out.println("\n--------Test assign task--------");
		boolean isOk = toDoList.assignTask();
		if(isOk) {
			EcrireFichier.writeString("Assign Task test is success!!!");
		}
		else {
			EcrireFichier.writeString("Assign Task test is fail!!!");
		}
	}
	
	private void testAssignDeadLine() {
		
		System.out.println("\n--------Test assign deadline--------");
		boolean isOk = toDoList.assignDeadLine();
		if(isOk) {
			EcrireFichier.writeString("Assign DeadLine test is success!!!");
		}
		else {
			EcrireFichier.writeString("Assign DeadLine test is fail!!!");
		}
	}
	
	private void testMarkAsDone() {
		
		System.out.println("\n--------Test mark as done--------");
		boolean isOk = toDoList.markAsDone();
		if(isOk) {
			EcrireFichier.writeString("Mark as done test is success!!!");
		}
		else {
			EcrireFichier.writeString("Mark as done test is fail!!!");
		}
	}
	
	
	private void  testRenameTask() {
		
		System.out.println("\n--------Test rename task--------");
		boolean isOk = toDoList.renameTask();
		if(isOk) {
			EcrireFichier.writeString("Rename task test is success!!!");
		}
		else {
			EcrireFichier.writeString("Rename task test is fail!!!");
		}
	}
	
	
	private void testRemoveTask() {
		
		System.out.println("\n--------Test remove task--------");
		boolean isOk = toDoList.removeTask();
		if(isOk) {
			EcrireFichier.writeString("Remove test is success!!!");
		}
		else {
			EcrireFichier.writeString("Remove test is fail!!!");
		}
	}
	
	
	private void testDisplay() {
		
		System.out.println("\n--------Test display task--------");
		boolean isOk = toDoList.display();
		if(isOk) {
			EcrireFichier.writeString("Display test is success!!!");
		}
		else {
			EcrireFichier.writeString("Display test is fail!!!");
		}
	}
	
	private void displayTestResult() {
		System.out.println("\n ------------TEST RESULT-------------\n");
		EcrireFichier.readString();
	}
	
	private void runProgam() {
		System.out.println("\n****Please press 1 to run program****");
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		try {
			choice = sc.nextInt();
		}
		
		catch(Exception e) {
			runProgam();
		}
		if (choice  != 1) {
			runProgam();
		}
		Menu.run();
	}

	//implement methods to test all of the methods in ToDoList class
	
	//implement a method called testAll to run each method in your Test class
	void testAll() {
		testCreateTask();
		testAssignTask();
		testAssignDeadLine();
		testMarkAsDone();
		testRenameTask();
		testRemoveTask();
		testDisplay();
		displayTestResult();
		runProgam();
	}
}

