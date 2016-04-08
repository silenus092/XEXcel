import javax.swing.JPanel;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.CardLayout;

public class Loading extends JPanel {
	
	public Loading() {
		JPanel panel = new JPanel();
		panel.setBounds(32, 5, 239, 138);
		ImageIcon image = new ImageIcon("81.gif");
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Processing... ", new ImageIcon("/home/note/JavaWorkspace/Fern101/81.gif"), SwingConstants.LEADING);
		lblNewLabel.setBounds(37, 5, 229, 128);
		panel.add(lblNewLabel);
		add(panel);
	}


}	
