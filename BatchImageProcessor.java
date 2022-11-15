/* ------------------------------------------------------------------------
 * BatchImageProcessor.java
 * ------------------------------------------------------------------------
 * 
 * Copyright © 2022 RSquared Authors
 * 
 * This source file may be used and distributed without restriction provided
 * that this copyright statement is not removed from the file and that any
 * derivative work contains the original copyright notice and the associated
 * disclaimer.
 *
 * This source file is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * This source file is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the noasic library.  If not, see http://www.gnu.org/licenses
 * 
 * ------------------------------------------------------------------------ */
/*-===========================================================================-
Author Information
	Program Author: Richard Hayes
	Author Email: brawl1336@gmail.com or rhayes_98@csu.fullerton.edu
	

Program Information
	Program Name: BatchImageProcessor
	Programming Languages: Java
	Date Started: 15 October 2022
	Date of last update: 13 November 2022
	
Files in this Program
	BatchImageProcessor.java
	GUI.java
	Image_Processor.Java
	
	Status: Complete

Program Purpose:
	This Program will create a UI front-end which will let the user load files from a folder named "temp", set the configuration for the output of the files, and resize the given images in batches to the given specifications.
	
This File
	File Name: BatchImageProcessor.java
	Language: java
	
	Purpose: This file exists to drive the rest of the program, it will call the UI front end and whatever else we need it to do.
	This file is essentially the "top" of the program
	
To Compile this file:
	(in linux terminal)
	javac BatchImageProcessor.java


To Run this Program:
	(in linux terminal)
	java BatchImageProcessor
	
	or
	(in linux terminal)
	sh compnrun.sh

	
Begin Code Area
-============================================================================*/

/*********************************/
/* This class exists to act as a */
/* driver for the rest of the    */
/* classes.                      */
/*********************************/
class BatchImageProcessor{
	public static void main(String[] args) {
		System.out.println("Hello, World!");
		GUI front = new GUI();
	}
}
