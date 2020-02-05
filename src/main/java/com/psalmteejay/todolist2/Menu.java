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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Menu {

	//provide your ToDoList object
	//declare your ToDoList topic

	static List<ToDoList> topicTodoList = new ArrayList<ToDoList>();

	public static void main(String[] args) {

		//Test t = new Test();
		//t.testAll();
		//The run function will start the menu on the output screen
		run();
	}

	//create your run function with the following menu items 
	static void run() {

		boolean quit = false;
		String mainMenu = "" + "1. Add a topic\n" + "2. Select a topic\n" + "3. Assign Task\n" + "4. Assign deadline\n"
				+ "5. Create a task \n" + "6. Mark as done\n" + "7. Remove task \n" + "8. Rename task\n"
				+ "9. Display\n\n" + "0. Quit\n\n";
		int choice = -1;
		while (choice != 0) {

			//The Scanner will input the user's choice
			Scanner input = new Scanner(System.in);
			System.out.println(mainMenu);
			try {
				choice = input.nextInt();
			}
			catch(Exception e) {
				System.out.println("Your enter is not corect, please try again ");
				run();
			}
			

			//you can any conditional statement (if/else or switch)
			//each case, will run the function
			switch (choice) {
			case 1:
				addTopic();
				break;
				//create a case for each menu option
			case 2:
				selectTopic();
				break;
			case 3:
				assignTask();
				break;
			case 4:
				assignDeadline();
				break;
			case 5:
				createTask();
				break;
			case 6:
				markDone();
				break;
			case 7:
				removeTask();
				break;
			case 8:
				renameTask();
				break;
			case 9:
				display();
				break;
			case 0:
				quitProgram();
				break;
			default:
				System.out.println("Invalid entry try again");

			}
		}
		if (choice == 0) {
			quitProgram();
			
		}
		

	}

	//implement the method for each case.  I have provided example code
	//for the first option, addTopic.

	//create addTopic method
	static void addTopic() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter topic name");
		String name = sc.nextLine();

		for (int i = 0; i < topicTodoList.size(); i++) {
			if (topicTodoList.get(i).getTopic().equals(name)) {
				System.out.println("Topic already exists. Try again");
				return;
			}
		}
		topicTodoList.add(new ToDoList(name));
		System.out.println("Topic added successfully");
	}

	//create selectTopic method
	public static ToDoList selectTopic(){

		//Check that the topicTodoList is not empty
		if(topicTodoList.isEmpty()) {
			System.out.println("empty topic list!!! \n");
			System.out.println("Please create first topic");
			run();
			System.exit(0);
		}
		ToDoList todoList = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter topic name");
		String name = sc.nextLine();

		boolean view = false;
		for(ToDoList tdl: topicTodoList) {
			if(tdl.getTopic().equals(name)) {
				view = true;
				todoList = tdl;
				System.out.println("    Topic found");	
				break;
			}
		}
		if(! view) {
			System.out.println("    Topic not found");
			run();
			System.exit(0);
		}
		return todoList;
	}

	//create assignTask method
	public static boolean assignTask(){
		boolean b;

		//Check that the topicTodoList is not empty
		if(topicTodoList.isEmpty()) {
			System.out.println("empty topic list!!! \n");
			System.out.println("Please create first topic");
			run();
			System.exit(0);
		}

		//select topic
		ToDoList toDoList = selectTopic();

		//call the method assignTask to the class ToDoList
		b = toDoList.assignTask();

		return  b;
	}


	//create assignDealine method
	public static boolean assignDeadline(){
		boolean b;

		//Check that the topicTodoList is not empty
		if(topicTodoList.isEmpty()) {
			System.out.println("empty topic list!!! \n");
			System.out.println("Please create first topic");
			run();
			System.exit(0);
		}

		//select topic;
		ToDoList toDoList = selectTopic();

		//call the method assignDeadline to the class ToDoList
		b = toDoList.assignDeadLine();
		return b;
	}

	//create createTask method
	public static void createTask() {

		//Check that the topicTodoList is not empty
		if(topicTodoList.isEmpty()) {
			System.out.println("empty topic list!!! \n");
			System.out.println("Please create first topic");
			run();
			System.exit(0);
		}
		//select topic
		ToDoList toDoList = selectTopic();

		//call method createTask of the type ToDoList
		toDoList.createTask();
	}

	//method display
	public static void display() {

		//Check that the topicTodoList is not empty
		if(topicTodoList.isEmpty()) {
			System.out.println("empty topic list!!! \n");
			System.out.println("Please create first topic");
			run();
			System.exit(0);
		}

		//select topic
		ToDoList toDoList = selectTopic();

		toDoList.display();
	}

	//create markDone method
	public static boolean markDone() {
		boolean b;

		//Check that the topicTodoList is not empty
		if(topicTodoList.isEmpty()) {
			System.out.println("empty topic list!!! \n");
			System.out.println("Please create first topic");
			run();
			System.exit(0);
		}

		//select topic
		ToDoList toDoList = selectTopic();

		b = toDoList.markAsDone();
		return b;
	}

	// create remove method
	public static boolean removeTask() {
		boolean b;

		//Check that the topicTodoList is not empty
		if(topicTodoList.isEmpty()) {
			System.out.println("empty topic list!!! \n");
			System.out.println("Please create first topic");
			run();
			System.exit(0);
		}

		//select topic
		ToDoList toDoList = selectTopic();

		b = toDoList.removeTask();
		return b;
	}

	public static boolean renameTask(){
		boolean b;

		//Check that the topicTodoList is not empty
		if(topicTodoList.isEmpty()) {
			System.out.println("empty topic list!!! \n");
			System.out.println("Please create first topic");
			run();
			System.exit(0);
		}

		//select topic
		ToDoList toDoList = selectTopic();

		//call the method renameTask to the class ToDoList
		b = toDoList.renameTask();
		return  b;
	}

	//boolean method quit
	public static void quitProgram() {
		System.out.println("******GOODBYE******");
		System.exit(0);
	}
}
