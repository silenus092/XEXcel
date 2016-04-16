import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class FilterOut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String model = "";
	private String father_filter = "hom";
	private String mother_filter = "hom";
	private String son_filter = "hom";
	 private ButtonGroup group_dad = new ButtonGroup();
	 private ButtonGroup group_mom = new ButtonGroup();
	 private ButtonGroup group_son = new ButtonGroup();
	 
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			FilterOut dialog = new FilterOut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public FilterOut(String model) {
		this.model =model;
		setTitle("Zygosity Filter");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpn = new JTextPane();
		txtpn.setEditable(false);
		txtpn.setBackground(Color.WHITE);
		txtpn.setForeground(Color.RED);
		txtpn.setText("Please select zygosity value ( hom , het ) in the text box below in order to filter out according to family roll.");
		txtpn.setBounds(10, 11, 414, 40);
		contentPanel.add(txtpn);
		{
			JLabel lblDad = new JLabel("Dad");
			lblDad.setBounds(20, 97, 46, 14);
			contentPanel.add(lblDad);
		}
		{
			JLabel lblMom = new JLabel("Mom");
			lblMom.setBounds(20, 128, 46, 14);
			contentPanel.add(lblMom);
		}
		{
			JLabel lblSon = new JLabel("Son");
			lblSon.setBounds(20, 153, 46, 14);
			contentPanel.add(lblSon);
		}
		{
			JLabel lblselectedModel = new JLabel("Model : ");
			lblselectedModel.setBounds(20, 69, 216, 14);
			lblselectedModel.setText("Model : "+this.model);
			contentPanel.add(lblselectedModel);
		}
		
		JRadioButton rdbtn_dad_hom = new JRadioButton("Hom");
		rdbtn_dad_hom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				father_filter ="hom";
			}
		});
		rdbtn_dad_hom.setSelected(true);
		rdbtn_dad_hom.setBounds(62, 93, 63, 23);
		contentPanel.add(rdbtn_dad_hom);
		
		JRadioButton rdbtn_dad_het = new JRadioButton("Het");
		rdbtn_dad_het.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				father_filter ="het";
			}
		});
		rdbtn_dad_het.setBounds(127, 93, 109, 23);
		contentPanel.add(rdbtn_dad_het);
		group_dad.add(rdbtn_dad_hom);
		group_dad.add(rdbtn_dad_het);
		JRadioButton rdbtn_mom_hom = new JRadioButton("Hom");
		rdbtn_mom_hom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mother_filter ="hom";
			}
		});
		rdbtn_mom_hom.setSelected(true);
		rdbtn_mom_hom.setBounds(62, 119, 63, 23);
		contentPanel.add(rdbtn_mom_hom);
		
		JRadioButton rdbtn_mom_het = new JRadioButton("Het");
		rdbtn_mom_het.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mother_filter ="het";
			}
		});
		rdbtn_mom_het.setBounds(127, 119, 109, 23);
		contentPanel.add(rdbtn_mom_het);
		group_mom.add(rdbtn_mom_hom);
		group_mom.add(rdbtn_mom_het);
		JRadioButton rdbtn_son_hom = new JRadioButton("Hom");
		rdbtn_son_hom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				son_filter = "hom";
			}
		});
		rdbtn_son_hom.setSelected(true);
		rdbtn_son_hom.setBounds(62, 149, 63, 23);
		contentPanel.add(rdbtn_son_hom);
		
		JRadioButton rdbtn_son_het = new JRadioButton("Het");
		rdbtn_son_het.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				son_filter = "het";
			}
		});
		rdbtn_son_het.setBounds(127, 149, 109, 23);
		contentPanel.add(rdbtn_son_het);
		group_son.add(rdbtn_son_hom);
		group_son.add(rdbtn_son_het);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JLabel lblPlease = new JLabel("Are you sure?");
			buttonPane.add(lblPlease);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AutoRecessive window = new AutoRecessive(father_filter,mother_filter,son_filter);
						window.frmFern.setVisible(true);
						FilterOut.this.dispatchEvent(new WindowEvent(FilterOut.this, WindowEvent.WINDOW_CLOSING));
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FilterOut.this.dispatchEvent(new WindowEvent(FilterOut.this, WindowEvent.WINDOW_CLOSING));
			
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
