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
			File imageFile = new File(file_name);
			BufferedImage bufferImage = ImageIO.read(imageFile);
			
			String file_prefix = imageFile.getName().substring(0, imageFile.getName().lastIndexOf('.'));
			String file_type = file_name.substring(file_name.lastIndexOf('.'));
			file_type = file_type.substring(1);
			
			//System.out.print("Imagename prefix = ");
			//System.out.println(file_prefix);
			//System.out.printf("File Extension = %s\n", file_type);
			    	
			BufferedImage stretchedImage = resize_me(bufferImage, resX, resY);

			saveImage(stretchedImage, file_type, file_prefix);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/********************************************************************/
	/* resize_me:                                                       */
	/*  when called take given image and parameters for resize and      */
	/*  redraw, return redrawn image                                    */
	/********************************************************************/
	private static BufferedImage resize_me(BufferedImage img, int width, int height) {
		Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		BufferedImage resized = new BufferedImage(width, height, img.getType());
		
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		
		return resized;
	}
	
	/********************************************************************/
	/* save_image:                                                      */
	/*  when called take given image and save to given filepath as given*/
	/*  filetype                                                        */
	/********************************************************************/
	private static void saveImage(BufferedImage bufferedImage, String imageType, String filePath) {
		try {
			boolean result;
			File directory = new File("./Processed/");
			if ( ! directory.exists() ) {
				directory.mkdir();
			}
			
			File outputfile = new File("./Processed/" + filePath + '.' + imageType);
			
			result = ImageIO.write(bufferedImage, imageType, outputfile);
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
