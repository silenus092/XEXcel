import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
public class main {

	private JFrame frmFern;
	private JTextField textField_dad_dir;
	private JTextField textField_mom_dir;
	private JTextField textField_son_dir;
	private JFileChooser chooser_dad;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frmFern.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmFern = new JFrame();
		frmFern.getContentPane().setBackground(new Color(255, 228, 225));
		frmFern.setBackground(Color.WHITE);
		frmFern.setTitle("MacSim");
		frmFern.setBounds(100, 100, 450, 300);
		frmFern.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFern.getContentPane().setLayout(null);
		
		final Loading loading_panel = new Loading();
		loading_panel.setVisible(true);
		frmFern.getContentPane().add(loading_panel);
		
		textField_dad_dir = new JTextField("");
		textField_dad_dir.setBounds(75, 20, 213, 19);
		frmFern.getContentPane().add(textField_dad_dir);
		textField_dad_dir.setColumns(10);
		
		JLabel lblDad = new JLabel("Dad");
		lblDad.setBounds(36, 22, 70, 15);
		frmFern.getContentPane().add(lblDad);
		
		textField_mom_dir = new JTextField("");
		textField_mom_dir.setBounds(75, 53, 213, 19);
		frmFern.getContentPane().add(textField_mom_dir);
		textField_mom_dir.setColumns(10);
		
		JLabel lblMom = new JLabel("Mom");
		lblMom.setBounds(36, 55, 70, 15);
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
		Button_add_Dad.setBounds(300, 17, 70, 25);
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
		Button_add_Mom.setBounds(300, 50, 70, 25);
		frmFern.getContentPane().add(Button_add_Mom);
		
		textField_son_dir = new JTextField("");
		textField_son_dir.setBounds(75, 95, 213, 19);
		frmFern.getContentPane().add(textField_son_dir);
		textField_son_dir.setColumns(10);
		
		JLabel lblSon = new JLabel("Son");
		lblSon.setBounds(36, 97, 70, 15);
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
		btnNewButton_2.setBounds(300, 92, 70, 25);
		frmFern.getContentPane().add(btnNewButton_2);
		
		
		final JLabel lbl_status = new JLabel("Online");
		lbl_status.setBounds(75, 211, 295, 15);
		frmFern.getContentPane().add(lbl_status);
		
		JButton btnProcess = new JButton("Run");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//loading_panel.setVisible(true);
				JProgressBar progressBar = new JProgressBar();
				progressBar.setIndeterminate(true);
				final JFileChooser fileChooser = new JFileChooser();
				fileChooser.setSelectedFile(new File(".xlsx"));
				if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					
				  final File save_to_file = fileChooser.getSelectedFile();
				 
				  lbl_status.setText("Keep clam and have a cup of tea");
				  Thread Jane = new Thread(){
					    public void run(){
					    	 final Processing process= new Processing(textField_dad_dir.getText(), textField_mom_dir.getText(), textField_son_dir.getText(),save_to_file.getAbsolutePath());
					   
					           SwingUtilities.invokeLater(new Runnable(){
					             public void run(){
					            	
					            	  process.Start();
					            	  if(process.finish()){
					            		  JOptionPane.showInternalMessageDialog(frmFern.getContentPane(), "Complete !! check file @"+fileChooser.getSelectedFile());
										  lbl_status.setText("Online Now");
					            	  }else{
					            		  JOptionPane.showInternalMessageDialog(frmFern.getContentPane(), "Error !! contact Fern asap");
					            	  }
									
					             }
					           }); 
					      
					    }
					};
					Jane.start();
				 
			
				  // save to file
				/*  Processing process= new Processing(textField_dad_dir.getText(), textField_mom_dir.getText(), textField_son_dir.getText(),save_to_file.getAbsolutePath());
				  process.Read_data_Dad();
		
				  process.Read_data_Mom();
				 
				  process.Read_data_Son();
				
				  JOptionPane.showInternalMessageDialog(frmFern.getContentPane(), "Complete !! check file @"+fileChooser.getSelectedFile());
				  lbl_status.setText("Online Now");*/
				
				}
				
				//loading_panel.setVisible(false);
			}
		});
		btnProcess.setBounds(310, 235, 117, 25);
		frmFern.getContentPane().add(btnProcess);
		
		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setBounds(12, 211, 70, 15);
		frmFern.getContentPane().add(lblStatus);
	
	
	}
}
