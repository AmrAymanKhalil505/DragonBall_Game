package dragonball.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;

public class EnterYourName extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterYourName frame = new EnterYourName();
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
	public EnterYourName() {
		setTitle("DragonBall");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(411, 377, 388, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter your name");
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 40));
		lblNewLabel.setBounds(411, 280, 422, 111);
		contentPane.add(lblNewLabel);
		
		JLabel lblBackground = new JLabel("Background");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\gigabyte\\Desktop\\DragonBall-M3\\images\\MainMenuBackground.jpg"));
		lblBackground.setBounds(0, 0, 1264, 682);
		contentPane.add(lblBackground);
	}
}
