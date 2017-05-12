package dragonball.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JComboBox;

public class WorldMode extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorldMode frame = new WorldMode();
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
	public WorldMode() {
		setTitle("DragonBall");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(10,10));
		
		for (int i = 0; i<100 ; i++)
		{
			JLabel label1 = new JLabel("Cell"+ i);
			Image img = new ImageIcon(this.getClass().getResource("/Cell.png")).getImage();
			label1.setIcon(new ImageIcon(img));
			label1.setBounds(181, 71, 89, 89);
			contentPane.add(label1);
		}
	}

}
