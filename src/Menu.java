import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frmMacsim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmMacsim.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMacsim = new JFrame();
		frmMacsim.setTitle("Macsim 0.2");
		frmMacsim.setBounds(100, 100, 450, 300);
		frmMacsim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton_2 = new JButton("Autosomal Recessive");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilterOut dialog = new FilterOut("Autosomal Recessive");
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(28, 63, 233, 23);
		
		JButton btnNewButton = new JButton("Autosomal Dominant");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(28, 99, 233, 23);
		frmMacsim.getContentPane().setLayout(null);
		frmMacsim.getContentPane().add(btnNewButton_2);
		frmMacsim.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(182, 187, 117, 67);
		frmMacsim.getContentPane().add(panel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		frmMacsim.getContentPane().add(menuBar);
		
		JMenu mnAbout = new JMenu("Help");
		menuBar.add(mnAbout);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Welcome");
		mnAbout.add(mntmNewMenuItem);
		
		JMenuItem mntmHelp = new JMenuItem("About");
		mnAbout.add(mntmHelp);
		
		JLabel lblNewLabel = new JLabel("Select Model");
		lblNewLabel.setBounds(28, 32, 127, 14);
		frmMacsim.getContentPane().add(lblNewLabel);
	}
}
