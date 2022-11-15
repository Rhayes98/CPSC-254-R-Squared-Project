/* ------------------------------------------------------------------------
 * Image_Processor.java
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
	File Name: Image_Processor.java
	Language: java
	
	Purpose: This file exists to process images. Given an image file and set of parameters, it will take a given image into an intermediary format, then operate on it according to the given parameters (resolution), then place it in a given location.
	
To Compile this file:
	(in linux terminal)
	javac Image_Processor.java

To Run this Program:
	(in linux terminal)
	java Image_Processor
	
Begin Code Area
-============================================================================*/
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/********************************************************************/
/* Image_Processor:                                                 */
/*   Our Backend for handling all image resizing and exports        */
/********************************************************************/
class Image_Processor{

	/* Hello world, chastise user for not launching correctly */
	public Image_Processor() {
		System.out.println("You're supposed to launch BatchImageResizer");
		System.out.println("\tUsage: java BatchImageResizer");
	}
	
	/********************************************************************/
	/* hello:                                                           */
	/*  a debug program, used to test calling hierarchy when first      */
	/*  learning java                                                   */
	/********************************************************************/
	public void hello() { // sanity tester
		System.out.println("I'm the Processor. I edit the images");
	}
	
	/********************************************************************/
	/* buffer_image:                                                    */
	/*  First step when processing image, load old image, pass to method*/
	/*  for resize, pass to method for export                           */
	/********************************************************************/
	public void buffer_image(int resX, int resY, String file_name) {
		System.out.printf("\nBegin conversion of %s\n", file_name);
		try {
			File image_file = new File(file_name);
			BufferedImage buffer = ImageIO.read(image_file);
			
			String file_prefix = image_file.getName().substring(0, image_file.getName().lastIndexOf('.'));
			String file_type = file_name.substring(file_name.lastIndexOf('.'));
			file_type = file_type.substring(1);
			
			//System.out.print("Imagename prefix = ");
			//System.out.println(file_prefix);
			//System.out.printf("File Extension = %s\n", file_type);
			    	
			BufferedImage output_image = resize_me(buffer, resX, resY);

			save_image(output_image, file_type, file_prefix);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/********************************************************************/
	/* resize_me:                                                       */
	/*  when called take given image and parameters for resize and      */
	/*  redraw, return redrawn image                                    */
	/********************************************************************/
	private static BufferedImage resize_me(BufferedImage image, int width, int height) {
		Image temp = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		BufferedImage output = new BufferedImage(width, height, image.getType());
		
		Graphics2D g2d = output.createGraphics();
		g2d.drawImage(temp, 0, 0, null);
		g2d.dispose();
		
		return output;
	}
	
	/********************************************************************/
	/* save_image:                                                      */
	/*  when called take given image and save to given filepath as given*/
	/*  filetype                                                        */
	/********************************************************************/
	private static void save_image(BufferedImage buffered_image, String image_type, String file_path) {
		try {
			boolean result;
			
			File directory = new File("./Processed/");
			if ( ! directory.exists() ) {
				directory.mkdir();
			}
			
			File outputfile = new File("./Processed/" + file_path + '.' + image_type);
			
			result = ImageIO.write(buffered_image, image_type, outputfile);
			if (result) {
				System.out.print("Saved as");
				System.out.println("./Processed/" + file_path + '.' + image_type);
			} else {
				System.out.println("Could not save the image");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
