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
	File Name: batcher.java
	Language: java
	
	Purpose: This file will handle the batch process, given a list of files and a set of parameters it will pass them one at time to the processor for processing. This file is the middle ground between the frontend and the image processor
	This file will keep a dynamic list of file locations and a set of parameters (file type and resolution). It will iterate through said list, passing it's items and the parameters to the processor for operation. It will recieve the file locations from the frontend
	
To Compile this file:
	(in linux terminal)


To Run this Program:
	(in linux terminal)


	
Begin Code Area
-============================================================================*/

class Batcher{

	int res_x = 512;
	int res_y = 512;
	String file_type = "jpg";
	// want to add a dynamic list here, stores file locations to pass to processor
	
	public Batcher() { // default constructor
	
	}
	
	public Batcher(int res1, int res2, String typer){ // constructor with variables
		this.res_x = res1;
		this.res_y = res2;
		this.file_type = typer;
		
	}
	
	public void hello() { // sanity tester
		System.out.println("I'm the Batcher. I handle the Image Processor.");
		
		Image_Processor procler = new Image_Processor();
		procler.hello();
	}
	
	public void setter(int res1, int res2, String typer) { // setter, used in changing variables if necessary
		res_x = res1;
		res_y = res2;
		
		file_type = typer;
	}
}
