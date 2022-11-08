/*-===========================================================================-
Author Information
	Program Author: Richard Hayes
	Author Email: brawl1336@gmail.com or rhayes_98@csu.fullerton.edu
	

Program Information
	Program Name: BatchImageProcessor
	Programming Languages: Java
	Date Started: 15 October 2022
	Date of last update: 6 November 2022
	
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
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

public class GUI implements ActionListener {

	private int res_x = 512;
	private int res_y = 512;
	private DefaultListModel list_model;
	private JList file_list;
	private ArrayList <String> file_queue;
	// file_queue will mirror list_model (when one gets input, they both get input) so we can properly call bufferedImage
	
	private JFrame main_frame;
	private JFrame progress_frame;
	private JFrame help_frame;
	
	private JPanel layout;
	private JPanel button_panel;
	private JMenuBar menu;
	private JScrollPane list_scroller;
	
	private JMenu file;
	private JMenu help;
	
	private JMenuItem menu_open;
	private JMenuItem menu_clear;
	private JMenuItem menu_config;
	
	private JLabel button_panel_label;
	
	private JButton add_file, configure_file, clear_list, start_batch;
	
	private Action ac_add_file, ac_config, ac_clear, ac_batch;
	
	public static void main(String[] args){
		System.out.println("I'm the UI file. =,)");
	}
	
	public GUI() { // default constructor
		//Batcher batchling = new Batcher(512, 512, "jpg");
		
		layout = new JPanel(new GridBagLayout());
			layout.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Top Bar Menu
		menu = new JMenuBar();
		file = new JMenu("File");
		help = new JMenu("Help");
			menu.add(file);
			menu.add(help);
		
			menu_open = new JMenuItem("Load Files");
			menu_clear = new JMenuItem("Clear List");
			menu_config = new JMenuItem("Configure Parameters");
		
			file.add(menu_open);
			file.add(menu_clear);
			file.add(menu_config);
		
		// control panel 1 and buttons
		button_panel = new JPanel(new GridLayout(4, 1));
		button_panel_label = new JLabel("Control Panel");
		
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
			button_panel.add(clear_list);
			button_panel.add(start_batch);
		
		// list panel, for viewing the file list
		list_model = new DefaultListModel<String>();
		JList list = new JList<>(list_model);
		
		list_scroller = new JScrollPane(list);
		
		// print out the panels
		main_frame = new JFrame("Image Resize Program");
		main_frame.setSize(512, 512);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		main_frame.getContentPane().add(BorderLayout.NORTH, menu);
		main_frame.getContentPane().add(BorderLayout.WEST, button_panel);
		main_frame.getContentPane().add(BorderLayout.CENTER, list_scroller);
		
		main_frame.setVisible(true);
	}
	
	// action event handler
	public void actionPerformed(ActionEvent e) {
		if ("load".equals(e.getActionCommand())) {
			this.hello();
		} else if ("load".equals(e.getActionCommand())) {
			load_from_temp();
		} else if ("config".equals(e.getActionCommand())) {
			
		} else if ("clear".equals(e.getActionCommand())) {
			clear_list();
		} else if ("batch".equals(e.getActionCommand())) {
			batch_out();
		}
	} 

	
	public void hello() { // sanity tester
		System.out.println("I'm the UI file. I hate life.");
		
		//Batcher batchling = new Batcher(512, 512, "jpg");
		Image_Processor procler1 = new Image_Processor();
		procler1.hello();
	}
	

	public void push_list(String file_path) {
		list_model.addElement(file_path);
		file_queue.add(file_path);
	}
	
	public void load_from_temp() {
		// we want to read all valid image files from ./temp/ and load them into our list
	}
	
	public void config_resolution (int res1, int res2) {
		res_x = res1;
		res_y = res2;
	}
	
	public void clear_list() {
		list_model = new DefaultListModel<String>();
		file_queue.clear();
		file_list = new JList(list_model);
	}
	
	public void batch_out() {
		Image_Processor procler = new Image_Processor();
		for (int i=0; i < file_queue.size(); i++) {
			procler.buffer_image( res_x, res_y, file_queue.get(i), "jpg");
		}
	}

}
