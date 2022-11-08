/*-===========================================================================-
Author Information
	Program Author: Richard Hayes
	Author Email: brawl1336@gmail.com or rhayes_98@csu.fullerton.edu
	

Program Information
	Program Name: BatchImageProcessor
	Programming Languages: Java
	Date Started: 15 October 2022
	Date of last update: 7 November 2022
	
Files in this Program
	driver.java
	
	Status: in-progress

Program Purpose: We want to create a program that can perform image resizing in batch operations, with the added functinality of splitting .gif files into their individual frames.
	This Program will also feature a UI front-end which will let the user pick the files they wish to operate on and set the parameters for the output image files (file type and resolution)

	
This File
	File Name: driver.java
	Language: java
	
	Purpose: This file exists to drive the rest of the program, it will call the UI front end and whatever else we need it to do.
	This file is essentially the "top" of the program
	
To Compile this file:
	(in linux terminal)
	javac driver.java


To Run this Program:
	(in linux terminal)
	java driver


	
Begin Code Area
-============================================================================*/

class Driver{
	public static void main(String[] args) {
		System.out.println("Hello, World!");
		GUI front = new GUI();
		//front.hello();	
	}
}
