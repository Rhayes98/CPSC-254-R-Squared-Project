/*-===========================================================================-
Author Information
	Program Author: Richard Hayes
	Author Email: brawl1336@gmail.com or rhayes_98@csu.fullerton.edu
	

Program Information
	Program Name: BatchImageProcessor
	Programming Languages: Java
	Date Started: 15 October 2022
	Date of last update: 15 October 2022
	
Files in this Program
	driver.java
	
	Status: in-progress

Program Purpose: We want to create a program that can perform image resizing in batch operations, with the added functinality of splitting .gif files into their individual frames.
	This Program will also feature a UI front-end which will let the user pick the files they wish to operate on and set the parameters for the output image files (file type and resolution)

	
This File
	File Name: frontend.java
	Language: java
	
	Purpose: This file will handle the entire front end of the program. oh boy...
	
	we want to do the following:
		Declare a window (formatted for UI/UX)
		Select image files for processing
		Add image files for processing
		Remove image files from processing queue
		Send image files for processing (send to batcher)
		Keep user aprised of what's going on
	
To Compile this file:
	(in linux terminal)


To Run this Program:
	(in linux terminal)


	
Begin Code Area
-============================================================================*/

class UI_Frontend{
	public static void main(String[] args){
		System.out.println("I'm the UI file. =,)");
	}
	
	public UI_Frontend() { // default constructor
		//Batcher batchling = new Batcher(512, 512, "jpg");
	}
	
	public void hello() { // sanity tester
		System.out.println("I'm the UI file. I hate life.");
		
		//Batcher batchling = new Batcher(512, 512, "jpg");
		Batcher batchling = new Batcher();
		batchling.hello();
	}
}
