package paint;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Paint_Uygulamasý extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtRenkler;
	private JTextField txtFralar;
	private JTextField txtekiller;
	private JTextField txtBoyut;
	private JTextField txtzelRenk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paint_Uygulamasý frame = new Paint_Uygulamasý();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Paint_Uygulamasý() {
		setResizable(false);
		setTitle("Paint Uygulamas\u0131");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane Giriþ = new JTabbedPane(JTabbedPane.TOP);
		Giriþ.setBounds(10, 11, 610, 410);
		contentPane.add(Giriþ);
		//***************************************************************************************************************
		//Giriþ paneli 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		Giriþ.addTab("Giriþ", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 117, 75);
		panel.add(panel_1);
		
		textField = new JTextField();
		textField.setText("Ara\u00E7lar");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(10, 10, 90, 20);
		panel_1.add(textField);
		
		//*******************************************************
		// kalem butonu
		JButton kalem = new JButton("");
		kalem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		kalem.setIcon(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\pencil.png"));
		kalem.setToolTipText("Kalem ");
		kalem.setBounds(20, 41, 34, 23);
		panel_1.add(kalem);
		//*********************************************************
		// silgi butonu
		JButton silgi = new JButton("");
		silgi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		silgi.setIcon(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\eraser.png"));
		silgi.setToolTipText("Silgi");
		silgi.setBounds(61, 41, 34, 23);
		panel_1.add(silgi);
		//****************************************************
		JLabel lblNewLabel = new JLabel(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\paint-brush (1).png"));
		lblNewLabel.setToolTipText("F\u0131r\u00E7alar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(116, 0, 59, 26);
		panel.add(lblNewLabel);
		
		JLabel lblekiller = new JLabel("");
		lblekiller.setIcon(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\shapes (2).png"));
		lblekiller.setHorizontalAlignment(SwingConstants.CENTER);
		lblekiller.setBounds(185, 0, 59, 26);
		panel.add(lblekiller);
		//***************************************************************************************
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\painter.png"));
		comboBox.addItem(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\brush-stroke.png"));
		comboBox.setBounds(116, 53, 59, 22);
		panel.add(comboBox);
		
		//********************************************************************************
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\substract.png"));
		comboBox_1.addItem(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\rectangle.png"));
		comboBox_1.addItem(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\ellipse.png"));
		comboBox_1.setBounds(185, 53, 59, 22);
		panel.add(comboBox_1);
		
		JLabel lblBoyut = new JLabel("");
		lblBoyut.setIcon(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\brush.png"));
		lblBoyut.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoyut.setBounds(254, 0, 59, 26);
		panel.add(lblBoyut);
		//******************************************************************************
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.addItem(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\kucuk1.png"));
		comboBox_1_1.addItem(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\orta1.png"));
		comboBox_1_1.addItem(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\buyuk1.png"));
		
		comboBox_1_1.setBounds(254, 53, 59, 22);
		panel.add(comboBox_1_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(323, 5, 17, 17);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(323, 21, 17, 17);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(323, 37, 17, 17);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setForeground(Color.GRAY);
		btnNewButton_3.setBackground(Color.GRAY);
		btnNewButton_3.setBounds(341, 5, 17, 17);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setForeground(Color.PINK);
		btnNewButton_1_1.setBackground(Color.PINK);
		btnNewButton_1_1.setBounds(341, 21, 17, 17);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("New button");
		btnNewButton_2_1.setForeground(Color.YELLOW);
		btnNewButton_2_1.setBackground(Color.YELLOW);
		btnNewButton_2_1.setBounds(341, 37, 17, 17);
		panel.add(btnNewButton_2_1);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBackground(Color.MAGENTA);
		btnNewButton_4.setForeground(Color.MAGENTA);
		btnNewButton_4.setBounds(359, 5, 17, 17);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.setForeground(Color.BLUE);
		btnNewButton_1_2.setBackground(Color.BLUE);
		btnNewButton_1_2.setBounds(359, 21, 17, 17);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_2_2 = new JButton("");
		btnNewButton_2_2.setForeground(Color.LIGHT_GRAY);
		btnNewButton_2_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2_2.setBounds(359, 37, 17, 17);
		panel.add(btnNewButton_2_2);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setForeground(Color.DARK_GRAY);
		btnNewButton_5.setBackground(Color.DARK_GRAY);
		btnNewButton_5.setBounds(377, 5, 17, 17);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.setForeground(new Color(255, 69, 0));
		btnNewButton_1_3.setBackground(new Color(255, 69, 0));
		btnNewButton_1_3.setBounds(377, 21, 17, 17);
		panel.add(btnNewButton_1_3);
		
		JButton btnNewButton_2_3 = new JButton("");
		btnNewButton_2_3.setForeground(Color.GREEN);
		btnNewButton_2_3.setBackground(Color.GREEN);
		btnNewButton_2_3.setBounds(377, 37, 17, 17);
		panel.add(btnNewButton_2_3);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setBackground(new Color(85, 107, 47));
		btnNewButton_6.setForeground(new Color(85, 107, 47));
		btnNewButton_6.setBounds(395, 5, 17, 17);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_1_4 = new JButton("");
		btnNewButton_1_4.setForeground(new Color(147, 112, 219));
		btnNewButton_1_4.setBackground(new Color(147, 112, 219));
		btnNewButton_1_4.setBounds(395, 21, 17, 17);
		panel.add(btnNewButton_1_4);
		
		JButton btnNewButton_2_4 = new JButton("");
		btnNewButton_2_4.setForeground(new Color(100, 149, 237));
		btnNewButton_2_4.setBackground(new Color(100, 149, 237));
		btnNewButton_2_4.setBounds(395, 37, 17, 17);
		panel.add(btnNewButton_2_4);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setBackground(new Color(173, 255, 47));
		btnNewButton_7.setForeground(new Color(173, 255, 47));
		btnNewButton_7.setBounds(414, 5, 17, 17);
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_1_5 = new JButton("");
		btnNewButton_1_5.setForeground(new Color(128, 0, 0));
		btnNewButton_1_5.setBackground(new Color(128, 0, 0));
		btnNewButton_1_5.setBounds(414, 21, 17, 17);
		panel.add(btnNewButton_1_5);
		
		JButton btnNewButton_2_5 = new JButton("");
		btnNewButton_2_5.setBackground(new Color(160, 82, 45));
		btnNewButton_2_5.setForeground(new Color(160, 82, 45));
		btnNewButton_2_5.setBounds(414, 37, 17, 17);
		panel.add(btnNewButton_2_5);
		
		txtRenkler = new JTextField();
		txtRenkler.setEditable(false);
		txtRenkler.setText("Renkler");
		txtRenkler.setHorizontalAlignment(SwingConstants.CENTER);
		txtRenkler.setBounds(323, 55, 108, 20);
		panel.add(txtRenkler);
		txtRenkler.setColumns(10);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setIcon(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\color-wheel.png"));
		btnNewButton_8.setBounds(433, 5, 69, 48);
		panel.add(btnNewButton_8);
		
		JSlider slider = new JSlider();
		slider.setBounds(377, 356, 200, 26);
		panel.add(slider);
		
		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.setIcon(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\plus.png"));
		btnNewButton_9.setBounds(579, 356, 26, 23);
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_9_1 = new JButton("");
		btnNewButton_9_1.setIcon(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\minus.png"));
		btnNewButton_9_1.setBounds(350, 356, 26, 23);
		panel.add(btnNewButton_9_1);
		
		txtFralar = new JTextField();
		txtFralar.setHorizontalAlignment(SwingConstants.CENTER);
		txtFralar.setEditable(false);
		txtFralar.setText("F\u0131r\u00E7alar");
		txtFralar.setBounds(116, 29, 59, 22);
		panel.add(txtFralar);
		txtFralar.setColumns(10);
		
		txtekiller = new JTextField();
		txtekiller.setText("\u015Eekiller");
		txtekiller.setHorizontalAlignment(SwingConstants.CENTER);
		txtekiller.setEditable(false);
		txtekiller.setColumns(10);
		txtekiller.setBounds(185, 29, 59, 22);
		panel.add(txtekiller);
		
		txtBoyut = new JTextField();
		txtBoyut.setText("Boyut");
		txtBoyut.setHorizontalAlignment(SwingConstants.CENTER);
		txtBoyut.setEditable(false);
		txtBoyut.setColumns(10);
		txtBoyut.setBounds(254, 29, 59, 22);
		panel.add(txtBoyut);
		
		txtzelRenk = new JTextField();
		txtzelRenk.setHorizontalAlignment(SwingConstants.CENTER);
		txtzelRenk.setText("\u00D6zel Renk");
		txtzelRenk.setEditable(false);
		txtzelRenk.setBounds(433, 54, 69, 20);
		panel.add(txtzelRenk);
		txtzelRenk.setColumns(10);
		
		//****************************************************************************************
		JPanel panel_2 = new JPanel();
		Giriþ.addTab("Dosya", null, panel_2, null);
	}
}
