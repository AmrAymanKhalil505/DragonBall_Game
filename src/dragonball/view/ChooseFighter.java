package dragonball.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class ChooseFighter extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseFighter frame = new ChooseFighter();
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
	public ChooseFighter() {
		setTitle("DragonBall");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(27, 121, 489, 33);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JRadioButton rdbtnSaiyan = new JRadioButton("Saiyan");
		rdbtnSaiyan.setFont(new Font("Stencil", Font.BOLD, 18));
		buttonGroup.add(rdbtnSaiyan);
		rdbtnSaiyan.setBounds(27, 368, 149, 33);
		contentPane.add(rdbtnSaiyan);
		
		JRadioButton rdbtnNamekian = new JRadioButton("Namekian");
		rdbtnNamekian.setFont(new Font("Stencil", Font.BOLD, 18));
		buttonGroup.add(rdbtnNamekian);
		rdbtnNamekian.setBounds(744, 368, 149, 33);
		contentPane.add(rdbtnNamekian);
		
		JRadioButton rdbtnMajin = new JRadioButton("Majin");
		rdbtnMajin.setFont(new Font("Stencil", Font.BOLD, 18));
		buttonGroup.add(rdbtnMajin);
		rdbtnMajin.setBounds(382, 368, 149, 33);
		contentPane.add(rdbtnMajin);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Earthling");
		rdbtnNewRadioButton.setFont(new Font("Stencil", Font.BOLD, 18));
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(203, 368, 149, 33);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFrieza = new JRadioButton("Frieza");
		rdbtnFrieza.setFont(new Font("Stencil", Font.BOLD, 18));
		buttonGroup.add(rdbtnFrieza);
		rdbtnFrieza.setBounds(562, 368, 149, 33);
		contentPane.add(rdbtnFrieza);
		
		JLabel lblEarthling = new JLabel("Earthling");
		lblEarthling.setIcon(new ImageIcon("C:\\Users\\gigabyte\\Desktop\\DragonBall-M3\\images\\Earthling.jpg"));
		lblEarthling.setBounds(239, 408, 66, 119);
		contentPane.add(lblEarthling);
		
		JLabel lblSaiyan = new JLabel("Saiyan");
		lblSaiyan.setIcon(new ImageIcon("C:\\Users\\gigabyte\\Desktop\\DragonBall-M3\\images\\Saiyan.jpg"));
		lblSaiyan.setBounds(42, 419, 114, 90);
		contentPane.add(lblSaiyan);
		
		JLabel lblNamekian = new JLabel("Namekian");
		lblNamekian.setIcon(new ImageIcon("C:\\Users\\gigabyte\\Desktop\\DragonBall-M3\\images\\Namekian.jpg"));
		lblNamekian.setBounds(790, 408, 66, 119);
		contentPane.add(lblNamekian);
		
		JLabel lblFrieza = new JLabel("Frieza");
		lblFrieza.setIcon(new ImageIcon("C:\\Users\\gigabyte\\Desktop\\DragonBall-M3\\images\\Frieza.jpg"));
		lblFrieza.setBounds(597, 430, 37, 71);
		contentPane.add(lblFrieza);
		
		JLabel lblMajin = new JLabel("Majin");
		lblMajin.setIcon(new ImageIcon("C:\\Users\\gigabyte\\Desktop\\DragonBall-M3\\images\\Majin.jpg"));
		lblMajin.setBounds(424, 433, 66, 64);
		contentPane.add(lblMajin);
		
		JLabel lblNewLabel_1 = new JLabel("Choose your race");
		lblNewLabel_1.setFont(new Font("Stencil", Font.BOLD, 30));
		lblNewLabel_1.setBounds(27, 303, 330, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEnterYourName = new JLabel("Enter your fighter's name");
		lblEnterYourName.setFont(new Font("Stencil", Font.BOLD, 30));
		lblEnterYourName.setBounds(27, 64, 489, 49);
		contentPane.add(lblEnterYourName);
		
		JLabel lblNewLabel = new JLabel("Background");
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 18));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\gigabyte\\Desktop\\DragonBall-M3\\images\\MainMenuBackground.jpg"));
		lblNewLabel.setBounds(0, 0, 1264, 682);
		contentPane.add(lblNewLabel);
	}
}
