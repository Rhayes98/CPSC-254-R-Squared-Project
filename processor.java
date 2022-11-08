/*-===========================================================================-
Author Information
	Program Author: Richard Hayes
	Author Email: brawl1336@gmail.com or rhayes_98@csu.fullerton.edu
	

Program Information
	Program Name: BatchImageProcessor
	Programming Languages: Java
	Date Started: 15 October 2022
	Date of last update: 5 November, 2022
	
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
/*
package net.codejava.graphic;
 
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
*/

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


class Image_Processor{

	public Image_Processor() { // default constructor, does nothing right now
	
	}
	
	public void hello() { // sanity tester
		System.out.println("I'm the Processor. I edit the images");
	}
	
	public void buffer_image(int resX, int resY, String file_name, String file_type) {
		try {
			File imageFile = new File(file_name);
			BufferedImage bufferImage = ImageIO.read(imageFile);
			String file_prefix = imageFile.getName().substring(0, imageFile.getName().lastIndexOf('.'));
			    	
			System.out.print("Imagename prefix = ");
			System.out.println(file_prefix);
			    	
			BufferedImage stretchedImage = resizeMe(bufferImage, resX, resY);

			saveImage(stretchedImage, file_type, file_prefix);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static BufferedImage resizeMe(BufferedImage img, int width, int height) {
		Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		BufferedImage resized = new BufferedImage(width, height, img.getType());
		
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		
		return resized;
	}
	
	private static void saveImage(BufferedImage bufferedImage, String imageType, String filePath) {
		try {
			boolean result;
			File directory = new File("./Processed/");
			if ( ! directory.exists() ) {
				directory.mkdir();
			}
			
			File outputfile = new File("./Processed/" + filePath + '.' + imageType);
			
			result = ImageIO.write(bufferedImage, imageType, outputfile);
			// something fucks up here, won't write "jpg to png" or "png to jpg"
			// my money's on the img.getType() in resizeME
			// I give up, I have spent 3 hours googling potential solutions to no avail
			if (result) {
				System.out.print("Saved as");
				System.out.println("./Processed/" + filePath + '.' + imageType);
			} else {
				System.out.println("Could not save the image");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
