/* ------------------------------------------------------------------------
 * GUI.java
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
	File Name: GUI.java
	Language: java
	
	Purpose: This file will handle the entire front end of the program. oh boy...
	
To Compile this file:
	(in linux terminal)
	javac GUI.java

To Run this Program:
	(in linux terminal)
	java BatchImageProcessor.java

	
Begin Code Area
-============================================================================*/
import java.io.File;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

/********************************************************************/
/* GUI class exists to handle all of the front end for the program. */
/********************************************************************/
public class GUI implements ActionListener {

	private int res_x = 512, res_y = 512;
	private DefaultListModel list_model;
	private JList file_list;
	private ArrayList <String> file_queue;
	// file_queue will mirror list_model (when one gets input, they both get input) so we can properly call bufferedImage
	
	/* Declare windows, we don't use all of these */
	private JFrame main_frame;
	private JFrame config_frame;
	private JFrame help_frame;
	
	/* Declare various panels and widgets to put in the windows */
	private JPanel layout, button_panel;
	private JPanel config_field_panel, config_button_panel;
	private JMenuBar menu;
	private JScrollPane list_scroller;
	
	/* Declare menu and menu items */
	private JMenu file, help;
	private JMenuItem menu_open, menu_clear, menu_config;
	
	/* Declare buttons and widgets to be put in panels */
	private JButton add_file, configure_file, clear_list, start_batch;
	private JButton config_confirm;
	private JTextField config_box_1, config_box_2;
	
	/* Hello world, chastise user for not launching correctly */
	public static void main(String[] args){
		System.out.println("You're supposed to launch BatchImageResizer");
		System.out.println("\tUsage: java BatchImageResizer");
	}
	
	public GUI() { // default constructor, handle absolutely everything
		/* redecalre the file_queue, or else it won't work */
		file_queue = new ArrayList<String>(1);
		
		/* redeclare the panel with arguments */
		layout = new JPanel(new GridBagLayout());
			layout.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Top Bar Menu
		menu = new JMenuBar();
		file = new JMenu("File");
		help = new JMenu("Help");
			menu.add(file);
			//menu.add(help);
		
			menu_open = new JMenuItem("Load Files");
				menu_open.addActionListener(this);
				menu_open.setActionCommand("load");
			menu_clear = new JMenuItem("Clear List");
				menu_clear.addActionListener(this);
				menu_clear.setActionCommand("clear");
			menu_config = new JMenuItem("Configure Parameters");
				menu_config.addActionListener(this);
				menu_config.setActionCommand("config");
		
			file.add(menu_open);
			//file.add(menu_clear);
			file.add(menu_config);
		
		/* control panel 1 and it's associated buttons */
		button_panel = new JPanel(new GridLayout(4, 1));
		//button_panel_label = new JLabel("Control Panel");
		
		add_file = new JButton("Load Files to list");
			add_file.addActionListener(this);
			add_file.setActionCommand("load");
			
		configure_file = new JButton("Configure Settings");
			configure_file.addActionListener(this);
			configure_file.setActionCommand("config");
			
		clear_list = new JButton("Clear List");
			clear_list.addActionListener(this);
			clear_list.setActionCommand("clear");
			
		start_batch = new JButton("Process List");
			start_batch.addActionListener(this);
			start_batch.setActionCommand("batch");
			
		button_panel.add(add_file);
		button_panel.add(configure_file);
		//button_panel.add(clear_list);
		button_panel.add(start_batch);
		
		/* list panel, for viewing the file list */
		list_model = new DefaultListModel<String>();
		JList list = new JList<>(list_model);
		
		list_scroller = new JScrollPane(list);
		
		/* print out the panels */
		main_frame = new JFrame("Image Resize Program");
		main_frame.setSize(512, 512);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		main_frame.getContentPane().add(BorderLayout.NORTH, menu);
		main_frame.getContentPane().add(BorderLayout.WEST, button_panel);
		main_frame.getContentPane().add(BorderLayout.CENTER, list_scroller);
		
		main_frame.setVisible(true);
	}
	
	/********************************************************************/
	/* actionPerformed:                                                 */
	/*  The action listener, whenever an action is performed go here and*/
	/*  read the action to determine what we should do                  */
	/********************************************************************/
	public void actionPerformed(ActionEvent e) {
		if ("load".equals(e.getActionCommand())) {
			load_from_temp();
		} else if ("load".equals(e.getActionCommand())) {
			load_from_temp();
		} else if ("config".equals(e.getActionCommand())) {
			
			config_field_panel = new JPanel();
			config_button_panel = new JPanel();
			
			config_box_1 = new JTextField(Integer.toString(res_x), 5);
			config_box_2 = new JTextField(Integer.toString(res_y), 5);
				config_field_panel.add(config_box_1);
				config_field_panel.add(config_box_2);
			
			config_confirm = new JButton("Confirm");
				config_confirm.addActionListener(this);
				config_confirm.setActionCommand("Configurate");
				
				config_button_panel.add(config_confirm);
			
			config_frame = new JFrame ("Config");
			config_frame.setSize(256, 128);
			
			config_frame.getContentPane().add(BorderLayout.NORTH, config_field_panel);
			config_frame.getContentPane().add(BorderLayout.SOUTH, config_button_panel);
			config_frame.setVisible(true);
			
		} else if ("clear".equals(e.getActionCommand())) {
			clear_list();
		} else if ("batch".equals(e.getActionCommand())) {
			batch_out();
		} else if ("Configurate".equals(e.getActionCommand())) {
			config_resolution(Integer.parseInt(config_box_1.getText()), Integer.parseInt(config_box_2.getText()));
			System.out.println("Resolution updated");
			print_out();
			config_frame.setVisible(false);
			config_frame.dispose();
		}
	} 
	
	/********************************************************************/
	/* hello:                                                           */
	/*  a debug program, used to test calling hierarchy when first      */
	/*  learning java                                                   */
	/********************************************************************/
	public void hello() {
		System.out.println("I'm the UI file. I hate life.");
		
		Image_Processor procler1 = new Image_Processor();
		procler1.hello();
	}
	
	/********************************************************************/
	/* push_list:                                                       */
	/*  called with a string, will push that string into the JList and  */
	/*  the parallel file_queue                                         */
	/********************************************************************/
	public void push_list(String file_path) {
		list_model.addElement(file_path);
		file_queue.add(file_path);
	}
	
	/********************************************************************/
	/* load_from_temp:                                                  */
	/*  when called will populate the file_list and file_queue with     */
	/*  items from the directory ./temp via push_list()                 */
	/********************************************************************/
	public void load_from_temp() {
		File dir = new File("./temp/");
		File[] contents = dir.listFiles();
		
		for (File f : contents) {
			push_list(f.getPath());
		}
	}
	
	/********************************************************************/
	/* config_resolution:                                               */
	/*  when called set the global resolutions for when we batch_out    */
	/********************************************************************/
	public void config_resolution (int res1, int res2) {
		res_x = res1;
		res_y = res2;
	}
	
	/********************************************************************/
	/* clear_list:                                                      */
	/*  when called will clear our on screen list and the internal      */
	/*  file_queue.                                                     */
	/* NOTE: does not work in current state, might fix later            */
	/********************************************************************/
	public void clear_list() {
		list_model = new DefaultListModel<String>();
		list_model.removeAllElements();
		file_queue.clear();
		file_list = new JList(list_model);
	}
	
	/********************************************************************/
	/* batch_out:                                                       */
	/*  iterate through our list and pass to image processor for        */
	/*  conversion.                                                     */
	/********************************************************************/
	public void batch_out() {
		Image_Processor procler = new Image_Processor();
		for (int i=0; i < file_queue.size(); i++) {
			procler.buffer_image( res_x, res_y, file_queue.get(i));
		}
		
		//progress_frame = new JFrame("All Done");
		//progress_frame.setSize(20, 40);
	}
	
	/********************************************************************/
	/* print_out:                                                       */
	/*  leftover debug method to make sure everything works config      */
	/*  method worked properly.                                         */
	/********************************************************************/
	public void print_out(){
		System.out.printf("Res_x [%d], res_y [%d] \n", res_x, res_y);
	}
}
/* end class declaration */
