CPSC 254: R-Squared Group Project

R-Squared is:
	Richard Hayes (rhayes_98@csu.fullerton.edu), Rodney Muniz (put your email here)
	
Our Project is a simple app that gives users a front end for resizing and exporting image files across various types. (Currently planned for .jpg, .png, .webp, .bmp, and .gif)

To compile:
	(In linux terminal)
	javac *.java
	
	or
	(in linux terminal)
	javac Image_processor.java
	javac GUI.java
	javac BatchImageProcessor
	
To run:
	(in linux terminal)
	java BatchImageProcessor
	
	or
	(In Linux Terminal)
	sh compnrun.sh

Using the Program:
	Place all images you wish to process into the given "temp" folder
	
	Run the program (either via "java BatchImageProcessor" in linux terminal or "sh compnrun.sh" in linux terminal)
	
	In the on-screen window click the button labeled "Load Items to List"
	In the on-screen window click the button labeled "Configure Settings"
		In the pop-up window set your desired image width and height and click "confirm" and close the pop-up window
	In the on-screen window click the button labeled "Process List" and wait for a few seconds
		After waiting your images should be resized in a folder named "Processed" in the local directory of the program.
		
	Enjoy =)
