package dragonball.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class BattleMode extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleMode frame = new BattleMode();
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
	public BattleMode() {
		setTitle("DragonBall");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Image img = new ImageIcon(this.getClass().getResource("/Battle.jpg")).getImage();
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Me");
		lblNewLabel.setBounds(63, 130, 68, 121);
		contentPane.add(lblNewLabel);
		
		JLabel label1 = new JLabel("Battle");
		label1.setBounds(5, 5, 474, 252);
		label1.setIcon(new ImageIcon(img));
		contentPane.add(label1);
		
	}
}
