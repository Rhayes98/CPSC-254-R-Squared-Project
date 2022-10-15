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
	File Name: processor.java
	Language: java
	
	Purpose: This file exists to process images. Given an image file and set of parameters, it will take a given image into an intermediary format, then operate on it according to the given parameters (file type and resolution), then place it in a given location (can be given as parameter or create a directory in present directory)
	
	Given a .gif (or other animated image) it should break the image into it's individual frames (given name.gif output: name-1.jpg, name-2.jpg, name-3.jpg)
	
	This program will be called by batcher repeatedly in sequence
	
To Compile this file:
	(in linux terminal)


To Run this Program:
	(in linux terminal)

	
Begin Code Area
-============================================================================*/

class Image_Processor{
	
	// want to look into buffer image library
	 
	
	public Image_Processor() { // default constructor, does nothing right now
	
	}
	
	public void hello() { // sanity tester
		System.out.println("I'm the Processor. I edit the images");
	}
	
	public void export(String location, String type, int resX, int resY) { // literally the only reason this file exists. Recieve file location, res_x, res_y, and desired file type then process, want to also keep in mind the .gif split feature we want
	
		// load image from file location, want to save name if possible
		
		// process along x-axis
		
		// process along y-axis
		
		// export image with given type
		// keep in mind, .gifs will be split into individual frames (name-1.out, name-2.out, name-3.out, ..., name-n.out)
	}
}
