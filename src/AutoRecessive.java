import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import java.awt.Label;
public class AutoRecessive {

	JFrame frmFern;
	private JTextField textField_dad_dir;
	private JTextField textField_mom_dir;
	private JTextField textField_son_dir;
	private JFileChooser chooser_dad;
	private String dad_model , mom_model ,son_model;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutoRecessive window = new AutoRecessive();
					window.frmFern.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public AutoRecessive(String dad_model ,String mom_model ,String son_model) {
		this.dad_model = dad_model;
		this.mom_model = mom_model;
		this.son_model = son_model;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmFern = new JFrame();
		frmFern.getContentPane().setBackground(new Color(255, 228, 225));
		frmFern.setBackground(Color.WHITE);
		frmFern.setTitle("AR");
		frmFern.setBounds(100, 100, 450,400);
		//frmFern.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFern.getContentPane().setLayout(null);
		
		final JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(62, 300, 288, 14);
		frmFern.getContentPane().add(progressBar);
		progressBar.setStringPainted(true);
		progressBar.setVisible(true);
		
		textField_dad_dir = new JTextField("");
		textField_dad_dir.setBounds(36, 19, 308, 19);
		frmFern.getContentPane().add(textField_dad_dir);
		textField_dad_dir.setColumns(10);
		
		JLabel lblDad = new JLabel("Dad:");
		lblDad.setBounds(36, 0, 46, 15);
		frmFern.getContentPane().add(lblDad);
		
		textField_mom_dir = new JTextField("");
		textField_mom_dir.setBounds(36, 67, 308, 19);
		frmFern.getContentPane().add(textField_mom_dir);
		textField_mom_dir.setColumns(10);
		
		JLabel lblMom = new JLabel("Mom:");
		lblMom.setBounds(36, 51, 70, 15);
		frmFern.getContentPane().add(lblMom);
		chooser_dad = new JFileChooser();
		chooser_dad.setCurrentDirectory(new java.io.File("."));
		chooser_dad.setDialogTitle("Browse the folder to process");
		chooser_dad.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser_dad.setAcceptAllFileFilterUsed(false);
		JButton Button_add_Dad = new JButton("Add");
		Button_add_Dad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		            if (chooser_dad.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		            	textField_dad_dir.setText(chooser_dad.getSelectedFile().toString());
		                System.out.println("getCurrentDirectory(): "+ chooser_dad.getCurrentDirectory());
		                System.out.println("getSelectedFile() : "+ chooser_dad.getSelectedFile());
		                chooser_dad.setCurrentDirectory(chooser_dad.getCurrentDirectory());
		            } else {
		                System.out.println("No Selection ");
		            }
		        }
		});
		URL url = getClass().getResource("81.gif");
		ImageIcon imageIcon = new ImageIcon(url);
		final JLabel lbl_icon = new JLabel(imageIcon);
		lbl_icon.setBounds(147, 181, 117, 112);
		frmFern.getContentPane().add(lbl_icon);
		lbl_icon.setVisible(false);
		
		Button_add_Dad.setBounds(354, 17, 70, 25);
		frmFern.getContentPane().add(Button_add_Dad);
		
		JButton Button_add_Mom = new JButton("Add");
		Button_add_Mom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
	            chooser.setCurrentDirectory(new java.io.File("."));
	            chooser.setDialogTitle("Browse the folder to process");
	            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	            chooser.setAcceptAllFileFilterUsed(false);

	            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	            	textField_mom_dir.setText(chooser.getSelectedFile().toString());
	          
	                System.out.println("getCurrentDirectory(): "+ chooser.getCurrentDirectory());
	                System.out.println("getSelectedFile() : "+ chooser.getSelectedFile());
	            } else {
	                System.out.println("No Selection ");
	            }
			}
		});
		Button_add_Mom.setBounds(354, 65, 70, 25);
		frmFern.getContentPane().add(Button_add_Mom);
		
		textField_son_dir = new JTextField("");
		textField_son_dir.setBounds(36, 113, 308, 19);
		frmFern.getContentPane().add(textField_son_dir);
		textField_son_dir.setColumns(10);
		
		JLabel lblSon = new JLabel("Son:");
		lblSon.setBounds(36, 97, 46, 15);
		frmFern.getContentPane().add(lblSon);
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
	            chooser.setCurrentDirectory(new java.io.File("."));
	            chooser.setDialogTitle("Browse the folder to process");
	            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	            chooser.setAcceptAllFileFilterUsed(false);

	            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	            	textField_son_dir.setText(chooser.getSelectedFile().toString());
	          
	                System.out.println("getCurrentDirectory(): "+ chooser.getCurrentDirectory());
	                System.out.println("getSelectedFile() : "+ chooser.getSelectedFile());
	            } else {
	                System.out.println("No Selection ");
	            }
			}
		});
		btnNewButton_2.setBounds(354, 111, 70, 25);
		frmFern.getContentPane().add(btnNewButton_2);
		
		
		final JLabel lbl_status = new JLabel("Online");
		lbl_status.setBounds(62, 330, 295, 15);
		frmFern.getContentPane().add(lbl_status);
		
		final JButton btnProcess = new JButton("Run");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//loading_panel.setVisible(true);
				btnProcess.setEnabled(false);
				final JFileChooser fileChooser = new JFileChooser();
				fileChooser.setSelectedFile(new File(".xlsx"));
				if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					
				  final File save_to_file = fileChooser.getSelectedFile();
				 
				  lbl_status.setText("Keep clam and have a cup of tea");
				 final long startTime = System.currentTimeMillis();
				 lbl_icon.setVisible(true);
				 Thread Jane = new Thread(){
					
					 Processing process= new Processing(textField_dad_dir.getText(), textField_mom_dir.getText(), textField_son_dir.getText(),dad_model,mom_model,son_model,save_to_file.getAbsolutePath());
					    public void run(){
					    	  progressBar.setValue(25);
			            	  process.Start();
			            	  progressBar.setValue(50);
			            	  try {
			            	  process.Match();
							  progressBar.setValue(75);
							  
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			            	  process.WriteFile();
			            	  if(process.finish()){
			            		  progressBar.setValue(100);
			            		  JOptionPane.showInternalMessageDialog(frmFern.getContentPane(), "Complete !! check file @"+fileChooser.getSelectedFile());
								  lbl_status.setText("Online Now");
								
			            	  }else{
			            		  JOptionPane.showInternalMessageDialog(frmFern.getContentPane(), "Error !! contact Fern asap"+"\n"+"Msg: "+process.ErrorMsg);
			            	  }
			            	  process.destroy();
			            	  
							    long stopTime = System.currentTimeMillis();
							    long elapsedTime = stopTime - startTime;
							    System.out.println("Usage time (Sec):"+elapsedTime/1000);
							    Report();
							    lbl_icon.setVisible(false);
							    progressBar.setValue(0);
								btnProcess.setEnabled(true);
								process = null;
			            
					    }
					};
					Jane.start();
					
			        /* SwingUtilities.invokeLater(new Runnable(){
			             public void run(){
			            	 
			             }
			           }); */
				  // save to file
				/*  Processing process= new Processing(textField_dad_dir.getText(), textField_mom_dir.getText(), textField_son_dir.getText(),save_to_file.getAbsolutePath());
				  process.Read_data_Dad();
		
				  process.Read_data_Mom();
				 
				  process.Read_data_Son();
				
				  JOptionPane.showInternalMessageDialog(frmFern.getContentPane(), "Complete !! check file @"+fileChooser.getSelectedFile());
				  lbl_status.setText("Online Now");*/
				
				}else{
					btnProcess.setEnabled(true);
				}
				
				//loading_panel.setVisible(false);
			}
		});
		btnProcess.setBounds(307, 143, 117, 25);
		frmFern.getContentPane().add(btnProcess);
		
		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setBounds(10, 330, 70, 15);
		frmFern.getContentPane().add(lblStatus);
		
		JLabel lbl_dad_filter = new JLabel("-");
		lbl_dad_filter.setBounds(79, 0, 78, 14);
		frmFern.getContentPane().add(lbl_dad_filter);
		lbl_dad_filter.setText(dad_model);
		JLabel lbl_mom_filter = new JLabel("-");
		lbl_mom_filter.setBounds(79, 51, 97, 14);
		frmFern.getContentPane().add(lbl_mom_filter);
		lbl_mom_filter.setText(mom_model);
		JLabel lbl_son_filter = new JLabel("-");
		lbl_son_filter.setBounds(79, 97, 78, 14);
		frmFern.getContentPane().add(lbl_son_filter);
		lbl_son_filter.setText(son_model);
		
		

	
	
	}
	
	public void Report(){
		int mb = 1024 * 1024; 
		 
		// get Runtime instance
		Runtime instance = Runtime.getRuntime();
 
		System.out.println("***** Heap utilization statistics [MB] *****\n");
 
		// available memory
		System.out.println("Total Memory: " + instance.totalMemory() / mb);
		instance.gc();
		// free memory
		System.out.println("Free Memory: " + instance.freeMemory() / mb);
 
		// used memory
		System.out.println("Used Memory: "
				+ (instance.totalMemory() - instance.freeMemory()) / mb);
 
		// Maximum available memory
		System.out.println("Max Memory: " + instance.maxMemory() / mb);
	}
}
