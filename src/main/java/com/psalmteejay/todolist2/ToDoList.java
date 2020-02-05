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
import java.util.List;
import java.util.Scanner;

public class ToDoList {

	private String topic;
	
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	private List<Task> tasks = new ArrayList<>();

	public ToDoList(String topicName) {
		this.topic = topicName;
	}

	//below, implement the methods provided in the UML diagram
	//I provided the task creation and the task creation methods

	//implement boolean method for assignTask, assignDeadLine
	//display, markAsDone, removeTask and renameTask

	 
	public void createTask() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter task name");
		String name = sc.nextLine();
		
		//Check that the name is entered
		if (name.isEmpty()) {
			do {
				System.out.println("It's obligatory! Please enter task name");
				name = sc.nextLine();
			}while(name.isEmpty());
		}
		System.out.println("Please enter employee name");
		String empname = sc.nextLine();
		System.out.println("Please enter due date");
		System.out.println("Please enter your date in the format dd/MM/yyyy");
		Scanner scanner = new Scanner(System.in);
		Date d = null;
		try {
			d = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// look if task name is in the list
		boolean exist = false;
		for (Task task: tasks) {
			if(task.getName().equals(name)) {
				exist = true;
				break;
			}
		}

		if (! exist) {
			Task t = new Task();
			t.setName(name);
			t.setDeadLine(d);
			t.setEmployee(empname);
			tasks.add(t);
			System.out.println("Task added successfully.");
		}
		else {
			System.out.println("This task exist in the list.");
		}
	}	
	
	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	//boolean method assignTask()
	public boolean assignTask() {
		boolean b = false;
		
		// ask task name
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter task name that you want to change employee name");
		String name = sc.nextLine();
		
		// ask employee name
		System.out.println("Please enter employee name");
		String empName = sc.nextLine();	
		
		for (Task task : tasks) {
			if (task.getName().equals(name)){
				// assign employee to task
				System.out.println("Le nom qui a ete modifier est:  " + task.getEmployee());
				task.setEmployee(empName);
				System.out.println("tache assigne avec succes! " );
				b = true;
				break;
			}
		}
		return b;
	}
	
	//boolean method assignDeadLine
	public boolean assignDeadLine() {
		boolean b = false;
		
		int deadlineIsCorrect = 1;
		
		// enter task name
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter task name");
		String name = sc.nextLine();
		
		//enter assign deadline
		System.out.println("Please enter your date in the format dd/MM/yyyy");
		Scanner scanner = new Scanner(System.in);
		Date d = null;
		try {
			d = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Assign deadline is fail");
			deadlineIsCorrect = 0;
		}
		if(deadlineIsCorrect == 1) {
			for (Task task: tasks) {
				if (task.getName().equals(name)) {
					task.setDeadLine(d);
					System.out.println("assign deadline is succeful" + task.getDeadLine());
					b = true;
					break;
				}
			}
		}
		
		return b;
	}
	
	//create display method
	public boolean display() {
		boolean b = false;
		int compt = 0;
		for (Task task: tasks) {
			System.out.println(task.toString());
			compt ++;
		}
		if(tasks.size() == compt) {
			b = true;
		}
		return b;
	}
	
	//create markAsDone method
	public boolean markAsDone() {
		boolean b = false;
		
		Scanner  sc  = new Scanner(System.in);
		System.out.println("please enter task name");
		String name = sc.nextLine();
		for (Task task: tasks) {
			if (task.getName().equals(name)) {
				task.setDone(true);
				System.out.println("Task is okay");
				b = true;
			}
		}
		return b;
	}
	
	//create method removeTask
	public boolean removeTask() {
		boolean b = false;
		
		//ask name of task to remove
		Scanner  sc  = new Scanner(System.in);
		System.out.println("please enter task name to remove");
		String name = sc.nextLine();
		for (Task task: tasks) {
			if (task.getName().equals(name)) {
				tasks.remove(task);
				b = true;
				System.out.println("task remove");
				break;
			}
		}
		
		return b;
	}
	
	//boolean method renameTask()
	public boolean renameTask() {
		boolean b = false;
			
		// ask last task name
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the last task name");
		String lName = sc.nextLine();
		
		// ask mew task  name
		System.out.println("Please enter the new task name");
		String nName = sc.nextLine();
		
		//search if a task have this name in the list tasks
		boolean exist = false;
		for (Task task: tasks) {
			if (task.getName().equals(nName)) {
				exist = true;
				break;
			}
		}
		for (Task task : tasks) {
			if (task.getName().equals(lName) && !exist){
				// rename task
				task.setName(nName);
				System.out.println("the name of task is change! " );
				b = true;
				break;
			}
				
		}
		if (!b) {
			System.out.println("This name of task exist in this task list! ");
		}
			
		return b;
	}

}


