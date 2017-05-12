package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.*;

import javax.naming.ldap.Rdn;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.Timer;

import java.awt.Label;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.game.GameListener;



import java.awt.GridBagLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.BoxLayout;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTree;
import javax.swing.JScrollBar;

public class View extends JFrame   {
	private JPanel world_mode_2;
	private JTextArea txtNewSuperAttacks;
	private JPanel NewSuperAttacksPanel;
	private JPanel gameView;
	private JPanel mainMenu;
	private JPanel enterYourName;
	private JPanel chooseFighter;
	private JLabel background;
	private JButton btnNewGame;
	private JButton btnLoadGame;
	private JButton btnExit;
	private JLabel background2;
	private JButton btnDone;
	private JTextField txtNameOfThePlayer;
	private JLabel lblNewLabel;
	private JButton btnDoneChoosingThe;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lbMajin;
	private JLabel lbEarthling;
	private JLabel lbFrieza;
	private JLabel lbNamekain;
	private JTextField textFieldNameOfFigther;
	private JLabel lblNewLabel_1;
	private ViewListener listener ;
	//private GameGUI gameGUI;
	private JTextArea txtstats;
	private Image MainMenuimg = new ImageIcon(this.getClass().getResource("/MainMenuBackground.jpg")).getImage();
	private Image Saiyanimg = new ImageIcon(this.getClass().getResource("/Saiyan.jpg")).getImage();
	private Image Majinimg = new ImageIcon(this.getClass().getResource("/Majin.jpg")).getImage();
	private Image Namekainimg = new ImageIcon(this.getClass().getResource("/Namekian.jpg")).getImage();
	private Image Earthlingimg = new ImageIcon(this.getClass().getResource("/Earthling.jpg")).getImage();
	private Image PlayerInCells = new ImageIcon (this.getClass().getResource("/ssJ.png")).getImage();
	private Image Friezaimg=new ImageIcon(this.getClass().getResource("/Frieza.jpg")).getImage();
	private Image Cellimag=new ImageIcon(this.getClass().getResource("/grid.png")).getImage();
	private Image Bossimg=new ImageIcon(this.getClass().getResource("/Boss.png")).getImage();
	private Image Dragonimg = new ImageIcon(this.getClass().getResource("/Dragon.jpg")).getImage();
	private JPanel DragonMode;
	private JPanel DragonWishPanel ;
	private JTextArea txtPlayerStatsinMap;
	private JRadioButton rdbtnSaiyan;
	private JRadioButton rdbtnEarthling;
	private JRadioButton rdbtnNamekain;
	private JRadioButton rdbtnMajin;
	private  JTextArea txtDragonWishes;
	private Image Earthlingimgincells = new ImageIcon(this.getClass().getResource("/earthlingincells2.png")).getImage();
	private Image Namekainimgincells = new ImageIcon(this.getClass().getResource("/namakenincells.png")).getImage();
	private JPanel MyFighters;
	private JPanel AllSuperAttacksPanel;
	private JPanel NewUltimateAttacksPanel;
	private JPanel AllUltimatePanel;
	private JTextArea txtUltimateSuperAttacks;
	private JLabel meFighter;
	private JLabel foeFighter;
	private Image BossImg=new ImageIcon(this.getClass().getResource("/Boss_Battle.png.png")).getImage();
	private Image SaiyanbImg=new ImageIcon(this.getClass().getResource("/Saiyan_battle.png.png")).getImage();
	private Image MajinbImg=new ImageIcon(this.getClass().getResource("/Majin_Battle.png.png")).getImage();
	private Image FriezabImg=new ImageIcon(this.getClass().getResource("/Frieza_battle.png.png")).getImage();
	private Image NamekianbImg=new ImageIcon(this.getClass().getResource("/Namekian_Battle.png.png")).getImage();
	private Image EarthlinbImg=new ImageIcon(this.getClass().getResource("/Earthling_Battle.png.png")).getImage();
	private Image WeakImg=new ImageIcon(this.getClass().getResource("/weak_Battle.png.png")).getImage();
	private Image background_battel= new ImageIcon(this.getClass().getResource("/BattleBack.jpg")).getImage();
	public Image getBackground_battel() {
		return background_battel;
	}


	private JPanel Battle_Mode;
	private JTextArea actionArea;
	private JTextArea meInfo;
	private JTextArea foeInfo;
	private JPanel action_buttons;
	public void setMyFighters(JPanel myFighters) {
		MyFighters = myFighters;
	}

	
	private  JLabel lblPlayerCell;
	private JRadioButton rdbtnFrieza;
	private char RDFighter1 ='S'; 
	private JLabel lblNewLabel_2;
	private JButton btnNewFighter;
	private  JButton btnSwitch_fighters;
	public JButton getBtnNewFighter() {
		return btnNewFighter;
	}

	public JButton getBtnSwitch_fighters() {
		return btnSwitch_fighters;
	}

	public JTextArea getTxtPlayerStatsinMap() {
		return txtPlayerStatsinMap;
	}

	public JPanel getMyFighters() {
		return MyFighters;
	}

	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}

	public JLabel getLblNewLabel_3() {
		return lblNewLabel_3;
	}

	
	public Image getBossimg() {
		return Bossimg;
	}

	public void setBossimg(Image bossimg) {
		Bossimg = bossimg;
	}

	public JTextArea getTxtswitch() {
		return txtswitch;
	}


	private JLabel lblNewLabel_3;
	private  JPanel Switch;
	private JTextArea txtswitch;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JButton btnSave;
	public char getRDFighter1() {
		return RDFighter1;
	}

	public Image getEarthlingimg() {
		return Earthlingimg;
	}


	public void setRDFighter1(char rDFighter1) {
		RDFighter1 = rDFighter1;
	}



	public Image getCellimag() {
		return Cellimag;
	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
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
	public View() {
		setTitle("DragonBall");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		gameView = new JPanel();
		gameView.setBackground(Color.DARK_GRAY);
		gameView.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(gameView);
		gameView.setLayout(null);
	/*	for (int i = 0; i<10 ; i++)
		{for(int j=0;j<10;j++)
		{
			JLabel label1 = new JLabel("Cell ["+i+"] ["+j+"]");
			Image img = new ImageIcon(this.getClass().getResource("/Cell.png")).getImage();
			label1.setIcon(new ImageIcon(img));
			label1.setBounds(181, 71, 89, 89);
			panel.add(label1);
		}
		}*/
		    
		     world_mode_2 = new JPanel();
		     world_mode_2.setBounds(0, 0, 1264, 684);
		     gameView.add(world_mode_2);
		     world_mode_2.setLayout(null);
		     
		     //TODO 
		     
		     
		     txtPlayerStatsinMap = new JTextArea();
		     txtPlayerStatsinMap.setEditable(false);
		     txtPlayerStatsinMap.setBounds(730, 11, 266, 304);
		     world_mode_2.add(txtPlayerStatsinMap);
		     
		      
		     
		      
		      JPanel panel = new JPanel();
		      panel.setBounds(0, 0, 680,  680);
		      world_mode_2.add(panel);
		      panel.setLayout(null);
		      
		      JLabel lblBoss = new JLabel("");
		      lblBoss.setIcon(new ImageIcon(Bossimg));
		      lblBoss.setBounds(0, 0, 68, 68);
		      panel.add(lblBoss);
		      
		       lblPlayerCell = new JLabel("");
		       lblPlayerCell.addKeyListener(new KeyAdapter() {
		       	@Override //TODO
		       	public void keyPressed(KeyEvent arg0) {
		       		System.out.println(arg0);
		       	}
		       });
		       lblPlayerCell.setBounds(612, 612, 68, 68);
		       lblPlayerCell.setIcon(new ImageIcon(PlayerInCells));
		       panel.add(lblPlayerCell);
		       
		       JLabel lblbackcells = new JLabel("New label");
		       lblbackcells.setBounds(0, 0, 680, 680);
		       lblbackcells.setIcon(new ImageIcon (getCellimag()));
		       panel.add(lblbackcells);
		       btnNewFighter = new JButton("Make a new fighter");
		       btnNewFighter.setBounds(730, 326, 266, 36);
		       btnNewFighter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				chooseFighter.setVisible(true);
				world_mode_2.setVisible(false);
				}
			
		});
		       world_mode_2.add(btnNewFighter);
		       
		       
		       
		        btnSwitch_fighters = new JButton("switch fighters");
		        btnSwitch_fighters.setBounds(730, 373, 266, 36);
		        btnSwitch_fighters.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					getSwitch().setVisible(true);
					world_mode_2.setVisible(false);
					if(listener!=null)
					{
						listener.callswitching();
					}
					}
				
			});
		        world_mode_2.add(btnSwitch_fighters);
		        
		        JButton btnAddNewSuperAttack = new JButton("Add New Super Attack");
		        btnAddNewSuperAttack.setBounds(730, 425, 266, 36);
		        btnAddNewSuperAttack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					
					if(listener!=null)
						listener.AddingSuperAttack();
				}
				
			});
		        world_mode_2.add(btnAddNewSuperAttack);
		        
		        JButton btnUp = new JButton("Up");
		        btnUp.setBounds(823, 553, 89, 23);
		        btnUp.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent a)
		            {
		            	if(listener!=null)
		            		listener.keyPressedUp();
		            }});
		        
		        world_mode_2.add(btnUp);
		        
		        JButton btnLeft = new JButton("Left");
		        btnLeft.setBounds(730, 596, 89, 23);
		        btnLeft.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent a)
		            {
		            	if(listener!=null)
		            		listener.keyPressedLeft();
		            }});
		        world_mode_2.add(btnLeft);
		        
		        JButton btnRight = new JButton("Right");
		        btnRight.setBounds(907, 596, 89, 23);
		        btnRight.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent a)
		            {
		            	if(listener!=null)
		            		listener.keyPressedRight();
		            }});
		        
		        world_mode_2.add(btnRight);
		        
		        JButton btnDown = new JButton("Down");
		        btnDown.setBounds(823, 637, 89, 23);
		        btnDown.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent a)
		            {
		            	if(listener!=null)
		            		listener.keyPressedDown();
		            }});
		        world_mode_2.add(btnDown);
		        
		        JButton btnNewUltiAttack = new JButton("Add a new ulti Attack");
		        btnNewUltiAttack.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		if (listener!=null)
		        			listener.AddingUltimateAttack();
		        	}
		        });
		        btnNewUltiAttack.setBounds(730, 472, 266, 36);
		        world_mode_2.add(btnNewUltiAttack);
		        
		        JButton btnUpgradeHealth = new JButton("+50 health using ability points ");
		        btnUpgradeHealth.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		if (listener!=null)
		        			listener.UpgradeUsingAbilityPoints('H');
		        	}
		        });
		        btnUpgradeHealth.setBounds(1006, 36, 226, 23);
		        world_mode_2.add(btnUpgradeHealth);
		        
		        JButton btnUpgradeBlastdamaUsing = new JButton("+50 blastDama using ability points ");
		        btnUpgradeBlastdamaUsing.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		if (listener!=null)
		        			listener.UpgradeUsingAbilityPoints('B');
		        	}
		        });
		        btnUpgradeBlastdamaUsing.setBounds(1006, 70, 226, 23);
		        world_mode_2.add(btnUpgradeBlastdamaUsing);
		        
		        JButton btnPydamaUsing = new JButton("+50 Physical Dama using ability points ");
		        btnPydamaUsing.setBounds(1006, 104, 226, 23);
		        btnPydamaUsing.addActionListener(new ActionListener() {
			      	public void actionPerformed(ActionEvent arg0) {
			      		if (listener!=null)
			      			listener.UpgradeUsingAbilityPoints('P');
			      	}
			      });
		        world_mode_2.add(btnPydamaUsing);
		        
		        JButton btnMaxkiUsing = new JButton("+1 MaxKi using ability points ");
		        btnMaxkiUsing.setBounds(1006, 138, 226, 23);
		        btnMaxkiUsing.addActionListener(new ActionListener() {
			      	public void actionPerformed(ActionEvent arg0) {
			      		if (listener!=null)
			      			listener.UpgradeUsingAbilityPoints('K');
			      	}
			      });
		        world_mode_2.add(btnMaxkiUsing);
		        
		        JButton btnMaxstaminaUsing = new JButton("+1 MaxStamina using ability points ");
		        btnMaxstaminaUsing.setBounds(1006, 172, 226, 23);
		        btnMaxstaminaUsing.addActionListener(new ActionListener() {
			      	public void actionPerformed(ActionEvent arg0) {
			      		if (listener!=null)
			      			listener.UpgradeUsingAbilityPoints('S');
			      	}
			      });
		        world_mode_2.add(btnMaxstaminaUsing);
		        
		        JRadioButton rdbtnNewRadioButton = new JRadioButton("SuperAttack2");
		        buttonGroup_1.add(rdbtnNewRadioButton);
		        rdbtnNewRadioButton.setBounds(1047, 240, 109, 23);
		        world_mode_2.add(rdbtnNewRadioButton);
		        
		        JRadioButton rdbtnSuperattack_1 = new JRadioButton("SuperAttack3");
		        buttonGroup_1.add(rdbtnSuperattack_1);
		        rdbtnSuperattack_1.setBounds(1047, 266, 109, 23);
		        world_mode_2.add(rdbtnSuperattack_1);
		        
		        JRadioButton rdbtnSuperattack_2 = new JRadioButton("SuperAttack4");
		        buttonGroup_1.add(rdbtnSuperattack_2);
		        rdbtnSuperattack_2.setBounds(1047, 292, 109, 23);
		        world_mode_2.add(rdbtnSuperattack_2);
		        
		        JRadioButton rdbtnSuperattack = new JRadioButton("SuperAttack1");
		        buttonGroup_1.add(rdbtnSuperattack);
		        rdbtnSuperattack.setBounds(1047, 216, 109, 23);
		        world_mode_2.add(rdbtnSuperattack);
		        
		        JRadioButton rdbtnUltimateAttack = new JRadioButton("Ultimate Attack 1");
		        buttonGroup_2.add(rdbtnUltimateAttack);
		        rdbtnUltimateAttack.setBounds(1047, 373, 109, 23);
		        world_mode_2.add(rdbtnUltimateAttack);
		        
		        JRadioButton rdbtnUltimateAttack_1 = new JRadioButton("Ultimate Attack 2");
		        buttonGroup_2.add(rdbtnUltimateAttack_1);
		        rdbtnUltimateAttack_1.setBounds(1047, 399, 109, 23);
		        world_mode_2.add(rdbtnUltimateAttack_1);
		        
		        JButton btnAssignAttack = new JButton("Assign Super Attack ");
		        btnAssignAttack.setBounds(1047, 333, 167, 23);
		        world_mode_2.add(btnAssignAttack);
		        
		        JButton btnNewButton = new JButton("Assign Ultimate Attack");
		        btnNewButton.setBounds(1047, 432, 167, 23);
		        world_mode_2.add(btnNewButton);
		        
		        btnSave = new JButton("save game");
		        btnSave.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		if (listener!=null)
		        			listener.save();
		        	}
		        });
		        btnSave.setBounds(1095, 506, 89, 58);
		        world_mode_2.add(btnSave);
		    
		    Battle_Mode = new JPanel();
		    Battle_Mode.setBounds(0, 0, 1264, 682);
		    gameView.add(Battle_Mode);
		    Battle_Mode.setLayout(null);
		    
		    foeFighter = new JLabel("");
		    foeFighter.setIcon(new ImageIcon("C:\\Users\\gigabyte\\Desktop\\DragonBall-M3\\images\\weak_Battle.png"));
		    foeFighter.setBounds(791, 280, 183, 348);
		    Battle_Mode.add(foeFighter);
		    
		    meFighter = new JLabel("");
		    meFighter.setIcon(new ImageIcon("C:\\Users\\gigabyte\\Desktop\\DragonBall-M3\\images\\Saiyan_battle.png"));
		    meFighter.setBounds(312, 299, 286, 330);
		    Battle_Mode.add(meFighter);
		    
		    action_buttons = new JPanel();
		    action_buttons.setBackground(Color.WHITE);
		    action_buttons.setBounds(0, 571, 1264, 111);
		    Battle_Mode.add(action_buttons);
		    action_buttons.setLayout(new GridLayout(2, 0, 0, 0));
		    
		    actionArea = new JTextArea();
		    actionArea.setBounds(0, 0, 1264, 68);
		    Battle_Mode.add(actionArea);
		    
		    meInfo = new JTextArea();
		    meInfo.setBounds(0, 68, 115, 561);
		    Battle_Mode.add(meInfo);
		    
		    foeInfo = new JTextArea();
		    foeInfo.setBounds(1137, 67, 127, 561);
		    Battle_Mode.add(foeInfo);
		    
		    JLabel lblNewLabel_2_1 = new JLabel("Background");
		    lblNewLabel_2_1.setIcon(new ImageIcon(getBackground_battel()));
		    lblNewLabel_2_1.setBounds(114, 0, 1022, 682);
		    Battle_Mode.add(lblNewLabel_2_1);
		 
		  NewSuperAttacksPanel = new JPanel();
		 NewSuperAttacksPanel.setBounds(0, 0, 1264, 680);
		 gameView.add(NewSuperAttacksPanel);
		 NewSuperAttacksPanel.setLayout(null);
		  
		   AllSuperAttacksPanel = new JPanel();
		   AllSuperAttacksPanel.setForeground(Color.WHITE);
		   AllSuperAttacksPanel.setBounds(0, 377, 1254, 292);
		   NewSuperAttacksPanel.add(AllSuperAttacksPanel);
		   AllSuperAttacksPanel.setLayout(new GridLayout(4, 0, 0, 0));
		 
		  txtNewSuperAttacks = new JTextArea();
		 txtNewSuperAttacks.setBounds(10, 5, 1244, 368);
		 NewSuperAttacksPanel.add(txtNewSuperAttacks);
		 
		 
		  		NewUltimateAttacksPanel = new JPanel();
		  		NewUltimateAttacksPanel.setBounds(0, 0, 1264, 680);
			 gameView.add(NewUltimateAttacksPanel);
			 NewUltimateAttacksPanel.setLayout(null);
			  
			   AllUltimatePanel = new JPanel();
			   AllUltimatePanel.setForeground(Color.WHITE);
			   AllUltimatePanel.setBounds(0, 377, 1254, 292);
			   NewUltimateAttacksPanel.add( AllUltimatePanel);
			   AllSuperAttacksPanel.setLayout(new GridLayout(4, 0, 0, 0));
			 
			  txtUltimateSuperAttacks = new JTextArea();
			 txtUltimateSuperAttacks.setBounds(10, 5, 1244, 368);
			 NewUltimateAttacksPanel.add(txtUltimateSuperAttacks);
		 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 
		 mainMenu = new JPanel();
		 mainMenu.setBounds(0, 0, 1264, 684);
		 gameView.add(mainMenu);
		 mainMenu.setLayout(null);
		 mainMenu.setVisible(true);
		 
		  btnNewGame = new JButton("New Game");
		  btnNewGame.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent a)
				    {
				    	mainMenu.setVisible(false);
				    	enterYourName.setVisible(true);
				    }});
		  btnNewGame.setFont(new Font("Tele-Marines", Font.BOLD | Font.ITALIC, 30));
		  btnNewGame.setBounds(57, 56, 307, 34);
		  mainMenu.add(btnNewGame);
		  
		   btnLoadGame = new JButton("Load Game");
		   btnLoadGame.setFont(new Font("Tele-Marines", Font.BOLD | Font.ITALIC, 30));
		   btnLoadGame.setBounds(57, 116, 307, 34);
		   mainMenu.add(btnLoadGame);
		   btnLoadGame.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent a)
			    {
			    	// TODO  loading the game
			    
			    	JOptionPane.showMessageDialog(new JFrame(), "No Load  Yet ", "Load Error",
			    	        JOptionPane.ERROR_MESSAGE);
			    	
			    }});
		   btnExit = new JButton("Exit ");
		   btnExit.setFont(new Font("Tele-Marines", Font.BOLD | Font.ITALIC, 30));
		   btnExit.setBounds(57, 571, 307, 34);
		   mainMenu.add(btnExit);
		   btnExit.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent a)
			    {
			    	System.exit(0);
			    	
			    }});
		   
		   	  background = new JLabel("");
		   	  background.setIcon(new ImageIcon(getMainMenuimg()));
		   	  background.setBounds(0, 0, 1264, 684);
		   	  mainMenu.add(background);
		 //////////////////////////////////////////////////////////////////////////////////////
		 		enterYourName = new JPanel();
		 		enterYourName.setBounds(0, 0, 1264, 682);
		 		gameView.add(enterYourName);
		 		enterYourName.setLayout(null);
		 		enterYourName.setVisible(false);
		 		
		 		txtNameOfThePlayer = new JTextField();
		 		txtNameOfThePlayer.setText("Player1 ");
		 		txtNameOfThePlayer.setBounds(83, 150, 227, 23);
		 		enterYourName.add(txtNameOfThePlayer);
		 		txtNameOfThePlayer.setColumns(10);
		 		
		 		btnDone = new JButton("Done ");
		 		btnDone.addActionListener(new ActionListener() {
		 			public void actionPerformed(ActionEvent e){
		 				//gameGUI.changePlayerName(txtNameOfThePlayer.getText());
		 				if(txtNameOfThePlayer.getText().length()==0)
		 					JOptionPane.showMessageDialog(new JFrame(), "There can not be a player without name", "NullText",
		 			    	        JOptionPane.ERROR_MESSAGE);
		 				else {
		 					
		 				enterYourName.setVisible(false);
		 				chooseFighter.setVisible(true);
		 				if(listener!=null)
		 				listener.onChangePlayerName(txtNameOfThePlayer.getText());	}
		 			}
		 		});
		 		btnDone.setFont(new Font("Digital-7", Font.BOLD | Font.ITALIC, 30));
		 		btnDone.setBounds(83, 184, 191, 37);
		 		enterYourName.add(btnDone);
		 		
		 		JLabel lblEnterYourName = new JLabel("Enter your name here ");
		 		lblEnterYourName.setFont(new Font("Digital-7", Font.BOLD | Font.ITALIC, 30));
		 		lblEnterYourName.setHorizontalAlignment(SwingConstants.CENTER);
		 		lblEnterYourName.setBounds(83, 90, 317, 50);
		 		enterYourName.add(lblEnterYourName);
		 		
		 		background2 = new JLabel("");
		 		background2.setBounds(0, 0, 1264, 684);
		 		background2.setIcon(new ImageIcon(getMainMenuimg()));
		 		enterYourName.add(background2);
///////////////////////////////////////////////////////////////////////////////////////////////////		
		chooseFighter = new JPanel();
		chooseFighter.setBounds(0, 0, 1264, 682);
		gameView.add(chooseFighter);
		chooseFighter.setLayout(null);
		chooseFighter.setVisible(false);
		
		btnDoneChoosingThe = new JButton("Done choosing the fighter");
		btnDoneChoosingThe.setFont(new Font("Digital-7", Font.BOLD | Font.ITALIC, 18));
		btnDoneChoosingThe.setBounds(81, 528, 267, 66);
		chooseFighter.add(btnDoneChoosingThe);
		btnDoneChoosingThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//gameGUI.changePlayerName(txtNameOfThePlayer.getText());
				if(textFieldNameOfFigther.getText().length()==0)
					JOptionPane.showMessageDialog(new JFrame(), "There can not be fighter without name", "NullText",
			    	        JOptionPane.ERROR_MESSAGE);
				else {
					
					
				
				chooseFighter.setVisible(false);
				world_mode_2.setVisible(true);
				
				if(getRdbtnSaiyan().isSelected()) { lblPlayerCell.setIcon(new ImageIcon(PlayerInCells));if(listener!=null)listener.onMakingnewSaiyan(textFieldNameOfFigther.getText());}
				if(getRdbtnMajin().isSelected()){lblPlayerCell.setIcon(new ImageIcon(getMajinimg()));if(listener!=null)listener.onMakingnewMajin(textFieldNameOfFigther.getText());}
				if(getRdbtnFrieza().isSelected()){lblPlayerCell.setIcon(new ImageIcon(getFriezaimg()));if(listener!=null)listener.onMakingnewFrieza(textFieldNameOfFigther.getText());}
				if(getRdbtnNamekain().isSelected()){lblPlayerCell.setIcon(new ImageIcon(getNamekainimgincells()));if(listener!=null)listener.onMakingnewNamekain(textFieldNameOfFigther.getText());}
				if(getRdbtnEarthling().isSelected()){lblPlayerCell.setIcon(new ImageIcon(getEarthlingimgincells()));if(listener!=null)listener.onMakingnewEarthling(textFieldNameOfFigther.getText());}
				
				
			}
			}});
		lbMajin = new JLabel("");
		lbMajin.setIcon(new ImageIcon(getMajinimg()));
		lbMajin.setBounds(227, 312, 58, 66);
		chooseFighter.add(lbMajin);
		
		JLabel lbSaiyan = new JLabel("");
		lbSaiyan.setIcon(new ImageIcon(getSaiyanimg()));
		lbSaiyan.setBounds(92, 302, 109, 90);
		chooseFighter.add(lbSaiyan);
		
		lbEarthling = new JLabel("");
		lbEarthling.setIcon(new ImageIcon(getEarthlingimg()));
		lbEarthling.setBounds(362, 290, 66, 118);
		chooseFighter.add(lbEarthling);
		
		lbFrieza = new JLabel("");
		lbFrieza.setIcon(new ImageIcon(getFriezaimg()));
		lbFrieza.setBounds(495, 282, 47, 110);
		chooseFighter.add(lbFrieza);
		
		lbNamekain = new JLabel("");
		lbNamekain.setIcon(new ImageIcon(getNamekainimg()));
		lbNamekain.setBounds(634, 290, 66, 118);
		chooseFighter.add(lbNamekain);
		
		textFieldNameOfFigther = new JTextField();
		textFieldNameOfFigther.setBounds(81, 499, 213, 20);
		chooseFighter.add(textFieldNameOfFigther);
		textFieldNameOfFigther.setColumns(10);
		
		lblNewLabel_1 = new JLabel("The name of the fighter");
		lblNewLabel_1.setFont(new Font("Digital-7", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(81, 438, 335, 50);
		chooseFighter.add(lblNewLabel_1);
		//TODO
		 rdbtnSaiyan = new JRadioButton("Saiyan");
		rdbtnSaiyan.setSelected(true);
		buttonGroup.add(rdbtnSaiyan);
		rdbtnSaiyan.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnSaiyan.setBounds(92, 256, 109, 23);
		chooseFighter.add(rdbtnSaiyan);
		rdbtnSaiyan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				setRDFighter1('S');}
			
		});
		 rdbtnEarthling = new JRadioButton("Earthling");
		buttonGroup.add(rdbtnEarthling);
		rdbtnEarthling.setBounds(352, 256, 109, 23);
		chooseFighter.add(rdbtnEarthling);
		rdbtnEarthling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				setRDFighter1('E');}
			
		});
		 rdbtnNamekain = new JRadioButton("Namekain");
		buttonGroup.add(rdbtnNamekain);
		rdbtnNamekain.setBounds(624, 256, 109, 23);
		chooseFighter.add(rdbtnNamekain);
		rdbtnSaiyan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				setRDFighter1('N');}
			
		});
		 rdbtnMajin = new JRadioButton("Majin");
		buttonGroup.add(rdbtnMajin);
		rdbtnMajin.setBounds(227, 256, 109, 23);
		chooseFighter.add(rdbtnMajin);
		rdbtnSaiyan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				setRDFighter1('M');}
			
		});
		 rdbtnFrieza = new JRadioButton("Frieza");
		buttonGroup.add(rdbtnFrieza);
		rdbtnFrieza.setBounds(485, 256, 109, 23);
		chooseFighter.add(rdbtnFrieza);
		rdbtnSaiyan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				setRDFighter1('F');}
			
		});
		lblNewLabel = new JLabel("backgroundFighterChoosing");
		lblNewLabel.setBounds(0, 0, 1264, 682);
		chooseFighter.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(getMainMenuimg()));
		
		 DragonMode = new JPanel();
		 DragonMode.setBounds(0, 0, 1280, 720);
		 gameView.add(DragonMode);
		 DragonMode.setLayout(null);
		 
		 txtDragonWishes = new JTextArea();
		 txtDragonWishes.setLineWrap(true);
		 txtDragonWishes.setBounds(1012, 0, 242, 385);
		 DragonMode.add(txtDragonWishes);
		 
		
		 DragonWishPanel = new JPanel();
		 DragonWishPanel.setBounds(0, 388, 1254, 295);
		 DragonMode.add(DragonWishPanel);
		 DragonWishPanel.setLayout(new GridLayout(4, 0, 0, 0));
		 
		 JLabel lblNewLabel_7 = new JLabel("");
		 lblNewLabel_7.setBounds(0, 0, 1009, 385);
		 DragonMode.add(lblNewLabel_7);
		 lblNewLabel_7.setIcon(new ImageIcon(getDragonimg()));
		 
		 Switch = new JPanel();
		 Switch.setBounds(0, 0, 1254, 681);
		 gameView.add(Switch);
		 Switch.setLayout(null);
		 
		 txtswitch = new JTextArea();
		 txtswitch.setEditable(false);
		 txtswitch.setBounds(0, 0, 1244, 365);
		 Switch.add(txtswitch);
		 
		  MyFighters = new JPanel();
		  MyFighters.setBounds(0, 376, 1270, 305);
		  Switch.add(MyFighters);
		  MyFighters.setLayout(new GridLayout(4, 0, 0, 0));
		  
		  
		//////////////////////////////////////////////////////////////////////////////////////		
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
			
/////////////////////////////////////////////////////////////////////////////////////
	}

	public JLabel getMeFighter() {
		return meFighter;
	}

	public JLabel getFoeFighter() {
		return foeFighter;
	}

	public Image getBossImg() {
		return BossImg;
	}

	public Image getSaiyanbImg() {
		return SaiyanbImg;
	}

	public Image getMajinbImg() {
		return MajinbImg;
	}

	public Image getFriezabImg() {
		return FriezabImg;
	}

	public Image getNamekianbImg() {
		return NamekianbImg;
	}

	public Image getEarthlinbImg() {
		return EarthlinbImg;
	}

	public Image getWeakImg() {
		return WeakImg;
	}

	public JPanel getBattle_Mode() {
		return Battle_Mode;
	}

	public JTextArea getActionArea() {
		return actionArea;
	}

	public JTextArea getMeInfo() {
		return meInfo;
	}

	public JTextArea getFoeInfo() {
		return foeInfo;
	}

	public JPanel getAction_buttons() {
		return action_buttons;
	}

	public JPanel getNewUltimateAttacksPanel() {
		return NewUltimateAttacksPanel;
	}

	public JPanel getAllUltimatePanel() {
		return AllUltimatePanel;
	}

	public JTextArea getTxtUltimateSuperAttacks() {
		return txtUltimateSuperAttacks;
	}

	public JTextArea getTxtNewSuperAttacks() {
		return txtNewSuperAttacks;
	}

	public JPanel getNewSuperAttacksPanel() {
		return NewSuperAttacksPanel;
	}

	public JPanel getAllSuperAttacksPanel() {
		return AllSuperAttacksPanel;
	}

	public JPanel getAllAttacksPanel() {
		return AllSuperAttacksPanel;
	}

	public JPanel getSwitch() {
		return Switch;
	}

	public void setSwitch(JPanel switch1) {
		Switch = switch1;
	}

	public JRadioButton getRdbtnSaiyan() {
		return rdbtnSaiyan;
	}

	public JRadioButton getRdbtnEarthling() {
		return rdbtnEarthling;
	}

	public JRadioButton getRdbtnNamekain() {
		return rdbtnNamekain;
	}

	public JRadioButton getRdbtnMajin() {
		return rdbtnMajin;
	}

	public JRadioButton getRdbtnFrieza() {
		return rdbtnFrieza;
	}

	public Image getFriezaimg() {
		return Friezaimg;
	}

	public Image getMainMenuimg() {
		return MainMenuimg;
	}



	public Image getSaiyanimg() {
		return Saiyanimg;
	}



	public Image getMajinimg() {
		return Majinimg;
	}



	public Image getNamekainimg() {
		return Namekainimg;
	}



	public JButton getBtnNewGame() {
		return btnNewGame;
	}

	public JButton getBtnLoadGame() {
		return btnLoadGame;
	}

	public JButton getBtnExit() {
		return btnExit;
	}
	public JButton getBtnDone() {
		return btnDone;
	}

	public JPanel getGameView() {
		return gameView;
	}

	public JPanel getMainMenu() {
		return mainMenu;
	}

	public JPanel getEnterYourName() {
		return enterYourName;
	}

	public JPanel getChooseFighter() {
		return chooseFighter;
	}

	public JLabel getBackground2() {
		return background2;
	}

	public JTextField getTxtNameOfThePlayer() {
		return txtNameOfThePlayer;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public JButton getBtnDoneChoosingThe() {
		return btnDoneChoosingThe;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public JLabel getLbMajin() {
		return lbMajin;
	}

	public JLabel getLbEarthling() {
		return lbEarthling;
	}

	public JLabel getLbFrieza() {
		return lbFrieza;
	}

	public JLabel getLbNamekain() {
		return lbNamekain;
	}

	public JTextField getTextField() {
		return textFieldNameOfFigther;
	}

	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}



	public void setListener(ViewListener e) {
		
		this.listener=e;
	}

	public JPanel getWorld_mode_2() {
		return world_mode_2;
	}

	



	public JLabel getLblPlayerCell() {
		return lblPlayerCell;
	}

	public void setLblPlayerCell(JLabel lblPlayerCell) {
		this.lblPlayerCell = lblPlayerCell;
	}

	public JTextField getTextFieldNameOfFigther() {
		return textFieldNameOfFigther;
	}

	public JTextArea getTxtstats() {
		return txtstats;
	}

	public ViewListener getListener() {
		return listener;
	}

	public Image getPlayerInCells() {
		return PlayerInCells;
	}

	public void setPlayerInCells(Image playerInCells) {
		PlayerInCells = playerInCells;
	}
	public Image getNamekainimgincells() {
		return Namekainimgincells;
	}

	public Image getEarthlingimgincells() {
		return Earthlingimgincells;
	}

	public JTextArea getTxtDragonWishes() {
		return txtDragonWishes;
	}

	public JTextArea getTxtPlayerStats() {
		return txtPlayerStatsinMap;
	}

	public void setTxtPlayerStats(JTextArea txtPlayerStats) {
		this.txtPlayerStatsinMap = txtPlayerStats;
	}
	public void restAttacksPanel()
	{
		JPanel NewAttacksPanel = new JPanel();
		 NewAttacksPanel.setBounds(0, 0, 1264, 680);
		 gameView.add(NewAttacksPanel);
		 NewAttacksPanel.setLayout(null);
		 
		 JTextArea txtNewAttacks = new JTextArea();
		 txtNewAttacks.setBounds(10, 5, 1244, 368);
		 NewAttacksPanel.add(txtNewAttacks);
		 
		  AllSuperAttacksPanel = new JPanel();
		 AllSuperAttacksPanel.setBounds(0, 377, 1254, 292);
		 NewAttacksPanel.add(AllSuperAttacksPanel);
	}

	public JPanel getDragonWishPanel() {
		return DragonWishPanel;
	}

	public JPanel getDragonMode() {
		return DragonMode;
	}

	public Image getDragonimg() {
		return Dragonimg;
	}

	public void resetSwitchPanel() {
		Switch = new JPanel();
		 Switch.setBounds(0, 0, 1254, 681);
		 gameView.add(Switch);
		 Switch.setLayout(null);
		 
		 txtswitch = new JTextArea();
		 txtswitch.setEditable(false);
		 txtswitch.setBounds(0, 0, 1244, 365);
		 Switch.add(txtswitch);
		 
		  MyFighters = new JPanel();
		  MyFighters.setBounds(0, 376, 1270, 305);
		  Switch.add(MyFighters);
		  MyFighters.setLayout(new GridLayout(4, 0, 0, 0));
		
	}

	public void restMap() {
		world_mode_2 = new JPanel();
	    world_mode_2.setBounds(0, 0, 1264, 684);
	    gameView.add(world_mode_2);
	    world_mode_2.setLayout(null);
	    
	    //TODO 
	    
	    
	    txtPlayerStatsinMap = new JTextArea();
	    txtPlayerStatsinMap.setEditable(false);
	    txtPlayerStatsinMap.setBounds(730, 11, 266, 304);
	    world_mode_2.add(txtPlayerStatsinMap);
	    
	     
	    
	     
	     JPanel panel = new JPanel();
	     panel.setBounds(0, 0, 680,  680);
	     world_mode_2.add(panel);
	     panel.setLayout(null);
	     
	     JLabel lblBoss = new JLabel("");
	     lblBoss.setIcon(new ImageIcon(Bossimg));
	     lblBoss.setBounds(0, 0, 68, 68);
	     panel.add(lblBoss);
	     
	      lblPlayerCell = new JLabel("");
	      lblPlayerCell.addKeyListener(new KeyAdapter() {
	      	@Override //TODO
	      	public void keyPressed(KeyEvent arg0) {
	      		System.out.println(arg0);
	      	}
	      });
	      lblPlayerCell.setBounds(612, 612, 68, 68);
	      lblPlayerCell.setIcon(new ImageIcon(PlayerInCells));
	      panel.add(lblPlayerCell);
	      
	      JLabel lblbackcells = new JLabel("New label");
	      lblbackcells.setBounds(0, 0, 680, 680);
	      lblbackcells.setIcon(new ImageIcon (getCellimag()));
	      panel.add(lblbackcells);
	      btnNewFighter = new JButton("Make a new fighter");
	      btnNewFighter.setBounds(730, 326, 266, 36);
	      btnNewFighter.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			chooseFighter.setVisible(true);
			world_mode_2.setVisible(false);
			}
		
	});
	      world_mode_2.add(btnNewFighter);
	      
	      
	      
	       btnSwitch_fighters = new JButton("switch fighters");
	       btnSwitch_fighters.setBounds(730, 373, 266, 36);
	       btnSwitch_fighters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				getSwitch().setVisible(true);
				world_mode_2.setVisible(false);
				if(listener!=null)
				{
					listener.callswitching();
				}
				}
			
		});
	       world_mode_2.add(btnSwitch_fighters);
	       
	       JButton btnAddNewSuperAttack = new JButton("Add New Super Attack");
	       btnAddNewSuperAttack.setBounds(730, 425, 266, 36);
	       btnAddNewSuperAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				if(listener!=null)
					listener.AddingSuperAttack();
			}
			
		});
	       world_mode_2.add(btnAddNewSuperAttack);
	       
	       JButton btnUp = new JButton("Up");
	       btnUp.setBounds(823, 553, 89, 23);
	       btnUp.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent a)
	           {
	           	if(listener!=null)
	           		listener.keyPressedUp();
	           }});
	       
	       world_mode_2.add(btnUp);
	       
	       JButton btnLeft = new JButton("Left");
	       btnLeft.setBounds(730, 596, 89, 23);
	       btnLeft.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent a)
	           {
	           	if(listener!=null)
	           		listener.keyPressedLeft();
	           }});
	       world_mode_2.add(btnLeft);
	       
	       JButton btnRight = new JButton("Right");
	       btnRight.setBounds(907, 596, 89, 23);
	       btnRight.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent a)
	           {
	           	if(listener!=null)
	           		listener.keyPressedRight();
	           }});
	       
	       world_mode_2.add(btnRight);
	       
	       JButton btnDown = new JButton("Down");
	       btnDown.setBounds(823, 637, 89, 23);
	       btnDown.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent a)
	           {
	           	if(listener!=null)
	           		listener.keyPressedDown();
	           }});
	       world_mode_2.add(btnDown);
	       
	       JButton btnNewUltiAttack = new JButton("Add a new ulti Attack");
	       btnNewUltiAttack.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent arg0) {
	       		if (listener!=null)
	       			listener.AddingUltimateAttack();
	       	}
	       });
	       btnNewUltiAttack.setBounds(730, 472, 266, 36);
	       world_mode_2.add(btnNewUltiAttack);
	       
	       JButton btnUpgradeHealth = new JButton("+50 health using ability points ");
	       btnUpgradeHealth.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent e) {
	       		if (listener!=null)
	       			listener.UpgradeUsingAbilityPoints('H');
	       	}
	       });
	       btnUpgradeHealth.setBounds(1006, 36, 226, 23);
	       world_mode_2.add(btnUpgradeHealth);
	       
	       JButton btnUpgradeBlastdamaUsing = new JButton("+50 blastDama using ability points ");
	       btnUpgradeBlastdamaUsing.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent arg0) {
	       		if (listener!=null)
	       			listener.UpgradeUsingAbilityPoints('B');
	       	}
	       });
	       btnUpgradeBlastdamaUsing.setBounds(1006, 70, 226, 23);
	       world_mode_2.add(btnUpgradeBlastdamaUsing);
	       
	       JButton btnPydamaUsing = new JButton("+50 Physical Dama using ability points ");
	       btnPydamaUsing.setBounds(1006, 104, 226, 23);
	       btnPydamaUsing.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent arg0) {
		      		if (listener!=null)
		      			listener.UpgradeUsingAbilityPoints('P');
		      	}
		      });
	       world_mode_2.add(btnPydamaUsing);
	       
	       JButton btnMaxkiUsing = new JButton("+1 MaxKi using ability points ");
	       btnMaxkiUsing.setBounds(1006, 138, 226, 23);
	       btnMaxkiUsing.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent arg0) {
		      		if (listener!=null)
		      			listener.UpgradeUsingAbilityPoints('K');
		      	}
		      });
	       world_mode_2.add(btnMaxkiUsing);
	       
	       JButton btnMaxstaminaUsing = new JButton("+1 MaxStamina using ability points ");
	       btnMaxstaminaUsing.setBounds(1006, 172, 226, 23);
	       btnMaxstaminaUsing.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent arg0) {
		      		if (listener!=null)
		      			listener.UpgradeUsingAbilityPoints('S');
		      	}
		      });
	       world_mode_2.add(btnMaxstaminaUsing);
	       
	       JRadioButton rdbtnNewRadioButton = new JRadioButton("SuperAttack2");
	       buttonGroup_1.add(rdbtnNewRadioButton);
	       rdbtnNewRadioButton.setBounds(1047, 240, 109, 23);
	       world_mode_2.add(rdbtnNewRadioButton);
	       
	       JRadioButton rdbtnSuperattack_1 = new JRadioButton("SuperAttack3");
	       buttonGroup_1.add(rdbtnSuperattack_1);
	       rdbtnSuperattack_1.setBounds(1047, 266, 109, 23);
	       world_mode_2.add(rdbtnSuperattack_1);
	       
	       JRadioButton rdbtnSuperattack_2 = new JRadioButton("SuperAttack4");
	       buttonGroup_1.add(rdbtnSuperattack_2);
	       rdbtnSuperattack_2.setBounds(1047, 292, 109, 23);
	       world_mode_2.add(rdbtnSuperattack_2);
	       
	       JRadioButton rdbtnSuperattack = new JRadioButton("SuperAttack1");
	       buttonGroup_1.add(rdbtnSuperattack);
	       rdbtnSuperattack.setBounds(1047, 216, 109, 23);
	       world_mode_2.add(rdbtnSuperattack);
	       
	       JRadioButton rdbtnUltimateAttack = new JRadioButton("Ultimate Attack 1");
	       buttonGroup_2.add(rdbtnUltimateAttack);
	       rdbtnUltimateAttack.setBounds(1047, 373, 109, 23);
	       world_mode_2.add(rdbtnUltimateAttack);
	       
	       JRadioButton rdbtnUltimateAttack_1 = new JRadioButton("Ultimate Attack 2");
	       buttonGroup_2.add(rdbtnUltimateAttack_1);
	       rdbtnUltimateAttack_1.setBounds(1047, 399, 109, 23);
	       world_mode_2.add(rdbtnUltimateAttack_1);
	       
	       JButton btnAssignAttack = new JButton("Assign Super Attack ");
	       btnAssignAttack.setBounds(1047, 333, 167, 23);
	       world_mode_2.add(btnAssignAttack);
	       
	       JButton btnNewButton = new JButton("Assign Ultimate Attack");
	       btnNewButton.setBounds(1047, 432, 167, 23);
	       world_mode_2.add(btnNewButton);
	   
		
	}

	public void restActionButtons() {
		action_buttons = new JPanel();
	    action_buttons.setBackground(Color.WHITE);
	    action_buttons.setBounds(0, 571, 1264, 111);
	    Battle_Mode.add(action_buttons);
	    action_buttons.setLayout(new GridLayout(2, 0, 0, 0));
		
	}
}