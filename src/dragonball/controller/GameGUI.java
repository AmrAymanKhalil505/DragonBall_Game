package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dragonball.model.attack.PhysicalAttack;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.cell.Collectible;
import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.Majin;
import dragonball.model.character.fighter.Namekian;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.dragon.Dragon;
import dragonball.model.dragon.DragonWish;
import dragonball.model.dragon.DragonWishType;
import dragonball.model.exceptions.DuplicateAttackException;
import dragonball.model.exceptions.MapIndexOutOfBoundsException;
import dragonball.model.exceptions.MaximumAttacksLearnedException;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.NotEnoughAbilityPointsException;
import dragonball.model.exceptions.NotEnoughKiException;
import dragonball.model.exceptions.NotEnoughSenzuBeansException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;
import dragonball.model.game.GameState;
import dragonball.model.world.World;
import dragonball.view.BattleMode;
import dragonball.view.ChooseFighter;
import dragonball.view.EnterYourName;
import dragonball.view.View;
import dragonball.view.ViewListener;
import dragonball.view.WorldMode;

public  class GameGUI implements GameListener,ActionListener,ViewListener {
	
	private Game game;
	private View view;
	
	
	
	
	public GameGUI() throws MissingFieldException, UnknownAttackTypeException
	{
		game = new Game();
		game.setListener(this);
		view = new View();
		view.setListener(this);
		view.setVisible(true);
		view.getBattle_Mode().setVisible(false);
		view.getNewUltimateAttacksPanel().setVisible(false);
		view.getNewSuperAttacksPanel().setVisible(false);
		view.getMainMenu().setVisible(true);
		view.getEnterYourName().setVisible(false);
		view.getChooseFighter().setVisible(false);
		view.getWorld_mode_2().setVisible(false);
		view.getDragonMode().setVisible(false);
		view.getSwitch().setVisible(false);
	}
	
	
	@Override
	public void onDragonCalled(Dragon dragon) {
		// TODO Auto-generated method stub
		
		JOptionPane.showMessageDialog(new JFrame(), "I am an unquenchable fire,The center of all energy,The stout heroic heart.I am truth and light,I hold power and glory in my sway.My presenceDisperses dark clouds.I have been chosenTo tame the Fates.", "collectible found",
    	        JOptionPane.INFORMATION_MESSAGE);
		view.getWorld_mode_2().setVisible(false);
		view.getDragonMode().setVisible(true);
		
		ArrayList<JButton> SuperAttacksButtons =new ArrayList<JButton>();
		ArrayList<JButton> UltimateAttacksButtons =new ArrayList<JButton>();
		ArrayList<SuperAttack> superAttacks=dragon.getSuperAttacks();
		ArrayList<UltimateAttack> ultimateAttacks=dragon.getUltimateAttacks();
		JButton btnSenzo = new JButton(dragon.getSenzuBeans()+" Senzo bean");
		btnSenzo.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent a)
		    {view.getDragonMode().setVisible(false);
			view.getWorld_mode_2().setVisible(true);
			game.onWishChosen(new DragonWish(dragon,DragonWishType.SENZU_BEANS,dragon.getSenzuBeans()));
			game.getPlayer().setSenzuBeans(game.getPlayer().getSenzuBeans()+dragon.getSenzuBeans());
			updatePlayerStatsInMap();
		    }});
		view.getDragonWishPanel().add(btnSenzo);
		JButton btnAbility = new JButton(dragon.getAbilityPoints()+" AbilityPoint");
		btnAbility.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent a)
			    {view.getDragonMode().setVisible(false);
				view.getWorld_mode_2().setVisible(true);
				game.onWishChosen(new DragonWish(dragon,DragonWishType.ABILITY_POINTS,dragon.getAbilityPoints()));
				game.getPlayer().setSenzuBeans(game.getPlayer().getActiveFighter().getAbilityPoints()+dragon.getAbilityPoints());
				updatePlayerStatsInMap(); }});
		view.getDragonWishPanel().add(btnAbility);
		
		
		for (int i=0;i<superAttacks.size();i++) {
			// create a JButton for each product in the supermarket
			JButton btnSuperAttack = new JButton();
			// set its text to the product's info
			btnSuperAttack.setText(superAttacks.get(i).toString());
			
			btnSuperAttack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					JButton btnAttack = (JButton) e.getSource();
					// get its index within the ArrayList of buttons
					int AttackIndex = SuperAttacksButtons.indexOf(btnAttack);
					// get the corresponding product from the supermarket
					SuperAttack  Attack = ((SuperAttack) superAttacks.get(AttackIndex));
					// invoke the buy method on it
					view.getDragonMode().setVisible(false);
					view.getWorld_mode_2().setVisible(true);
					game.onWishChosen(new DragonWish(dragon,DragonWishType.SUPER_ATTACK,Attack));
					game.getPlayer().getSuperAttacks().add(Attack);
					updatePlayerStatsInMap();}});
			view.getDragonWishPanel().add(btnSuperAttack);
			SuperAttacksButtons.add(btnSuperAttack);
		}		
		
			for (int j=0;j<ultimateAttacks.size();j++) {
				// create a JButton for each product in the supermarket
				JButton btnAttack = new JButton();
				btnAttack.setBounds(0,0 ,30, 30);
				// set its text to the product's info
				btnAttack.setText(ultimateAttacks.get(j).toString());
				// add the controller as its ActionListener
				btnAttack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						JButton btnAttack = (JButton) e.getSource();
						// get its index within the ArrayList of buttons
						int AttackIndex = UltimateAttacksButtons.indexOf(btnAttack);
						// get the corresponding product from the supermarket
						UltimateAttack  Attack = ((UltimateAttack) ultimateAttacks.get(AttackIndex));
						// invoke the buy method on it
						
						game.getPlayer().getUltimateAttacks().add(Attack);
						updatePlayerStatsInMap();
						}});
				view.getDragonWishPanel().add(btnAttack);
				UltimateAttacksButtons.add(btnAttack);
			// add it to the products buy buttons panel
		
			// and also add it to the ArrayList for later use
			}
		
		updateTxtDragonWishes(dragon);
	}
		
		

	

	@Override
	public void onCollectibleFound(Collectible collectible) {
		
		switch (collectible) {
		case SENZU_BEAN:
			JOptionPane.showMessageDialog(new JFrame(), "You found a Senzu Bean ", "collectible found",
	    	        JOptionPane.INFORMATION_MESSAGE);
			break;
		case DRAGON_BALL:
			JOptionPane.showMessageDialog(new JFrame(), "You found a DRAGON BALL ", "collectible found",
	    	        JOptionPane.INFORMATION_MESSAGE);
			break;
		}
		updatePlayerStatsInMap();
	}

	@Override
	public void onBattleEvent(BattleEvent e) {
		// TODO Auto-generated method stub\
		NonPlayableFighter foe = e.getB().getFoeNPF();
		if(e.getType()!=BattleEventType.ENDED){
		 view.getBattle_Mode().setVisible(true);
		  view.getWorld_mode_2().setVisible(false);
		  
		  PlayableFighter me = game.getPlayer().getActiveFighter();
		  if (!foe.isStrong())
		   view.getFoeFighter().setIcon(new ImageIcon(view.getWeakImg()));
		  else
		   view.getFoeFighter().setIcon(new ImageIcon(view.getBossImg()));
		   Frieza Fri =new Frieza("");
		      Majin Maj =new Majin("");
		      Saiyan Sai =new Saiyan("");
		      Namekian Nam =new Namekian("");
		      Earthling Ear = new Earthling("");
		  if (game.getPlayer().getActiveFighter().getClass() == Fri.getClass())
		   view.getMeFighter().setIcon(new ImageIcon(view.getFriezabImg()));
		  if (game.getPlayer().getActiveFighter().getClass() == Maj.getClass())
		   view.getMeFighter().setIcon(new ImageIcon(view.getMajinbImg()));
		  if (game.getPlayer().getActiveFighter().getClass() == Sai.getClass())
		   view.getMeFighter().setIcon(new ImageIcon(view.getSaiyanbImg()));
		  if (game.getPlayer().getActiveFighter().getClass() == Nam.getClass())
		   view.getMeFighter().setIcon(new ImageIcon(view.getNamekianbImg()));
		  if (game.getPlayer().getActiveFighter().getClass() == Ear.getClass())
		   view.getMeFighter().setIcon(new ImageIcon(view.getEarthlinbImg()));
		  
		  view.getFoeInfo().setText("Name:\n"+foe.getName()+"\nlevel\n="+foe.getLevel()+"\nHealth\n="+foe.getHealthPoints()+"\nBlastDamage\n="+ foe.getBlastDamage()+"\nPhysicalDamage\n="+foe.getPhysicalDamage()+"\nKi\n="+foe.getKi()+"\nStamina\n="+foe.getStamina());
		  view.getMeInfo().setText("Name:\n"+me.getName()+"\nlevel\n="+me.getLevel()+"\nHealth\n="+me.getHealthPoints()+"\nBlastDamage\n="+ me.getBlastDamage()+"\nPhysicalDamage\n="+me.getPhysicalDamage()+"\nKi\n="+me.getKi()+"\nStamina\n="+me.getStamina());
		  if(e.getType()==BattleEventType.STARTED){
		  JButton btnPhy = new JButton("Physical Attack");
		  btnPhy.setBounds(1006, 172, 226, 23);
		  btnPhy.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent arg0) {
		      		try {
						e.getB().attack(new PhysicalAttack());
					} catch (NotEnoughKiException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		      		view.getFoeInfo().setText("Name:\n"+foe.getName()+"\nlevel\n="+foe.getLevel()+"\nHealth\n="+foe.getHealthPoints()+"\nBlastDamage\n="+ foe.getBlastDamage()+"\nPhysicalDamage\n="+foe.getPhysicalDamage()+"\nKi\n="+foe.getKi()+"\nStamina\n="+foe.getStamina());
		  		  view.getMeInfo().setText("Name:\n"+me.getName()+"\nlevel\n="+me.getLevel()+"\nHealth\n="+me.getHealthPoints()+"\nBlastDamage\n="+ me.getBlastDamage()+"\nPhysicalDamage\n="+me.getPhysicalDamage()+"\nKi\n="+me.getKi()+"\nStamina\n="+me.getStamina());		view.restActionButtons();	
		  		  view.getActionArea().setText("You did a Physical Attack");}
		      });
		  view.getAction_buttons().add(btnPhy);
		  JButton bnBlock = new JButton("Block");
		  bnBlock.setBounds(1006, 172, 226, 23);
		  bnBlock.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent arg0) {
		      		e.getB().block();
		      		view.getFoeInfo().setText("Name:\n"+foe.getName()+"\nlevel\n="+foe.getLevel()+"\nHealth\n="+foe.getHealthPoints()+"\nBlastDamage\n="+ foe.getBlastDamage()+"\nPhysicalDamage\n="+foe.getPhysicalDamage()+"\nKi\n="+foe.getKi()+"\nStamina\n="+foe.getStamina());
		      	  view.getActionArea().setText("You Blocked");
		      		view.getMeInfo().setText("Name:\n"+me.getName()+"\nlevel\n="+me.getLevel()+"\nHealth\n="+me.getHealthPoints()+"\nBlastDamage\n="+ me.getBlastDamage()+"\nPhysicalDamage\n="+me.getPhysicalDamage()+"\nKi\n="+me.getKi()+"\nStamina\n="+me.getStamina());  		view.restActionButtons();		      	}
		      });
		  view.getAction_buttons().add(bnBlock);
		  JButton bnSenzo = new JButton("Use Senzo");
		  bnSenzo.setBounds(1006, 172, 226, 23);
		  bnSenzo.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent arg0) {
		      		try {
						e.getB().use(game.getPlayer(), Collectible.SENZU_BEAN);
					} catch (NotEnoughSenzuBeansException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(new JFrame(), "Not enough Senzu Beans", "Not enough",
				    	        JOptionPane.ERROR_MESSAGE);
					};
					view.getFoeInfo().setText("Name:\n"+foe.getName()+"\nlevel\n="+foe.getLevel()+"\nHealth\n="+foe.getHealthPoints()+"\nBlastDamage\n="+ foe.getBlastDamage()+"\nPhysicalDamage\n="+foe.getPhysicalDamage()+"\nKi\n="+foe.getKi()+"\nStamina\n="+foe.getStamina());
					 view.getActionArea().setText("You used a senzo ");
					view.getMeInfo().setText("Name:\n"+me.getName()+"\nlevel\n="+me.getLevel()+"\nHealth\n="+me.getHealthPoints()+"\nBlastDamage\n="+ me.getBlastDamage()+"\nPhysicalDamage\n="+me.getPhysicalDamage()+"\nKi\n="+me.getKi()+"\nStamina\n="+me.getStamina());				view.restActionButtons();		      	}
		      });
		  view.getAction_buttons().add(bnSenzo);
		  
		
			
		 
			
			
			
			ArrayList<JButton> SuperAttacksButtons =new ArrayList<JButton>();
			
			ArrayList<SuperAttack> superAttacks=me.getSuperAttacks();
			
			
			
			for (int i=0;i<superAttacks.size();i++) {
				// create a JButton for each product in the supermarket
				JButton btnSuperAttack = new JButton();
				// set its text to the product's info
				btnSuperAttack.setText(superAttacks.get(i).toString());
				
				btnSuperAttack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent argo){
						JButton btnAttack = (JButton) e.getSource();
						// get its index within the ArrayList of buttons
						int AttackIndex = SuperAttacksButtons.indexOf(btnAttack);
						// get the corresponding product from the supermarket
						SuperAttack  Attack = ((SuperAttack) superAttacks.get(AttackIndex));
						try {
							e.getB().attack(Attack);
						} catch (NotEnoughKiException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(new JFrame(), "Not enough Ki", "Not enough",
					    	        JOptionPane.ERROR_MESSAGE);
						}
						view.getFoeInfo().setText("Name:\n"+foe.getName()+"\nlevel\n="+foe.getLevel()+"\nHealth\n="+foe.getHealthPoints()+"\nBlastDamage\n="+ foe.getBlastDamage()+"\nPhysicalDamage\n="+foe.getPhysicalDamage()+"\nKi\n="+foe.getKi()+"\nStamina\n="+foe.getStamina());
						view.getActionArea().setText("You used a SuperAttack "+Attack.toString());
						view.getMeInfo().setText("Name:\n"+me.getName()+"\nlevel\n="+me.getLevel()+"\nHealth\n="+me.getHealthPoints()+"\nBlastDamage\n="+ me.getBlastDamage()+"\nPhysicalDamage\n="+me.getPhysicalDamage()+"\nKi\n="+me.getKi()+"\nStamina\n="+me.getStamina());				view.restActionButtons();		}});
				view.getAction_buttons().add(btnSuperAttack);
				
			}		
			
			ArrayList<JButton> UltimateAttacksButtons =new ArrayList<JButton>();
			
			ArrayList<UltimateAttack> UltimateAttacks=me.getUltimateAttacks();
			
			
			
			for (int i=0;i<UltimateAttacks.size();i++) {
				// create a JButton for each product in the supermarket
				JButton btnUltimateAttack = new JButton();
				// set its text to the product's info
				btnUltimateAttack.setText(UltimateAttacks.get(i).toString());
				
				btnUltimateAttack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent argo){
						JButton btnAttack = (JButton) e.getSource();
						// get its index within the ArrayList of buttons
						int AttackIndex = UltimateAttacksButtons.indexOf(btnAttack);
						// get the corresponding product from the supermarket
						UltimateAttack  Attack = ((UltimateAttack) me.getUltimateAttacks().get(AttackIndex));
						// invoke the buy method on it
						try {
							e.getB().attack( Attack);
						} catch (NotEnoughKiException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(new JFrame(), "Not enough Ki", "Not enough",
					    	        JOptionPane.ERROR_MESSAGE);
						}
						view.getFoeInfo().setText("Name:\n"+foe.getName()+"\nlevel\n="+foe.getLevel()+"\nHealth\n="+foe.getHealthPoints()+"\nBlastDamage\n="+ foe.getBlastDamage()+"\nPhysicalDamage\n="+foe.getPhysicalDamage()+"\nKi\n="+foe.getKi()+"\nStamina\n="+foe.getStamina());
						view.getActionArea().setText("You used a UlimateAttack "+Attack.toString()); 
						view.getMeInfo().setText("Name:\n"+me.getName()+"\nlevel\n="+me.getLevel()+"\nHealth\n="+me.getHealthPoints()+"\nBlastDamage\n="+ me.getBlastDamage()+"\nPhysicalDamage\n="+me.getPhysicalDamage()+"\nKi\n="+me.getKi()+"\nStamina\n="+me.getStamina()); view.restActionButtons();					}
				 });
					
				view.getAction_buttons().add(btnUltimateAttack);	
				
			}

		   
		 
			}}
		else 
		{PlayableFighter me = game.getPlayer().getActiveFighter();
		
		
		if (e.getWinner() == me) {
			
			view.getWorld_mode_2().setVisible(true);
			view.getBattle_Mode().setVisible(false);
			updatePlayerStatsInMap();
			// if opponent is boss
			if (foe.isStrong()) {
				view.restMap();
				updatePlayerStatsInMap();
				view.getWorld_mode_2().setVisible(true);
				view.getBattle_Mode().setVisible(false);
				
		}  }//TODO
			else {
				JOptionPane.showMessageDialog(new JFrame(), "You Lost", "Game Over",
		    	        JOptionPane.ERROR_MESSAGE);
					
			}
			
			
		
		
		 
		}
	}
	
	public static void main(String[] args) throws MissingFieldException, UnknownAttackTypeException {
		GameGUI a = new GameGUI();
	}

	@Override
	public void onLoadgame() {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void onChangePlayerName(String name) {
		try{
		game.getPlayer().setName(name);
		updatePlayerStatsInMap();
		}
		catch(NullPointerException e)
		{
			game.getPlayer().setName(name);
		}
	}

	

	
	

	public void onMakingnewSaiyan(String name) {
		Saiyan f = new Saiyan(name);
		
		game.getPlayer().addFighter(f);
		try{
		updatePlayerStatsInMap();
		}
		catch (NullPointerException e)
		{game.getPlayer().setActiveFighter(f);
		updatePlayerStatsInMap();
			
		}
		
	}

	@Override
	public void onMakingnewFrieza(String name) {
		Frieza f =new Frieza(name);
		game.getPlayer().addFighter(f);
		try{
		updatePlayerStatsInMap();
		}
		catch (NullPointerException e)
		{game.getPlayer().setActiveFighter(f);
		 updatePlayerStatsInMap();
		}
	}

	@Override
	public void onMakingnewNamekain(String name) {
		Namekian f =new Namekian(name);
		game.getPlayer().addFighter(f);
		try{
		updatePlayerStatsInMap();
		}
		catch (NullPointerException e)
		{game.getPlayer().setActiveFighter(f);
		 updatePlayerStatsInMap();
			
		}
	}

	@Override
	public void onMakingnewMajin(String name) {
		Majin f =new Majin(name);
		game.getPlayer().addFighter(f);
		try{
		updatePlayerStatsInMap();
		}
		catch (NullPointerException e)
		{game.getPlayer().setActiveFighter(f);
		 updatePlayerStatsInMap();
			
		}
	}

	@Override
	public void onMakingnewEarthling(String name) {
		Majin f =new Majin(name);
		game.getPlayer().addFighter(f);
		try{
			updatePlayerStatsInMap();
			}
		catch (NullPointerException e)
		{game.getPlayer().setActiveFighter(f);
		 updatePlayerStatsInMap();
			
		}
	}

	

	@Override
	public void keyPressedLeft() {
		// TODO Auto-generated method stub
		if(view.getLblPlayerCell().getX()-68>=0)
		 view.getLblPlayerCell().setBounds(view.getLblPlayerCell().getX()-68,view.getLblPlayerCell().getY(), 68, 68);
	try{	game.getWorld().moveLeft();}
	catch( MapIndexOutOfBoundsException e)
	{  
		JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "You are going away",
    	        JOptionPane.ERROR_MESSAGE);
	}
	
	}

	@Override
	public void keyPressedUp() {
		// TODO Auto-generated method stub
		if(view.getLblPlayerCell().getY()-68>=0)
			 view.getLblPlayerCell().setBounds(view.getLblPlayerCell().getX(),view.getLblPlayerCell().getY()-68, 68, 68);
		try{	game.getWorld().moveUp();}
		catch( MapIndexOutOfBoundsException e)
		{  
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "You are going away",
	    	        JOptionPane.ERROR_MESSAGE);
		}
	
		
	}

	@Override
	public void keyPressedDown() {
		// TODO Auto-generated method stub
		if(view.getLblPlayerCell().getY()+68<680)
			 view.getLblPlayerCell().setBounds(view.getLblPlayerCell().getX(),view.getLblPlayerCell().getY()+68, 68, 68);
		try{game.getWorld().moveDown();}
		catch( MapIndexOutOfBoundsException e)
		{  
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "You are going away",
	    	        JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void keyPressedRight() {
		// TODO Auto-generated method stub
		if(view.getLblPlayerCell().getX()+68<680)
			 view.getLblPlayerCell().setBounds(view.getLblPlayerCell().getX()+68,view.getLblPlayerCell().getY(), 68, 68);
		try{game.getWorld().moveRight();}
		catch( MapIndexOutOfBoundsException e)
		{  
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "You are going away",
	    	        JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void updatePlayerStatsInMap() {
	
		view.getTxtPlayerStats().setEditable(true);
		view.getTxtPlayerStats().setText("Player name is "+game.getPlayer().getName()+"\nSenzo beans = "+game.getPlayer().getSenzuBeans()+"\nDragonBalls = "+game.getPlayer().getDragonBalls()+"\n"+game.getPlayer().getActiveFighter().toString());
		view.getTxtPlayerStats().setEditable(false);
		
		
	}



public void updateTxtDragonWishes(Dragon dragon) {
	//TODO
	view.getTxtDragonWishes().setText(dragon.toString()+"and your stats is\nPlayer name is "+game.getPlayer().getName()+"\nSenzo beans = "+game.getPlayer().getSenzuBeans()+"\nDragonBalls = "+game.getPlayer().getDragonBalls()+"\n"+game.getPlayer().getActiveFighter().toString()+"\nability points = "+game.getPlayer().getActiveFighter().toString());

}



@Override
public void callswitching() {
	// TODO Auto-generated method stub
	
	ArrayList<PlayableFighter> f=game.getPlayer().getFighters();
	ArrayList<JButton> fighterButtons=new ArrayList<JButton> ();
		for (int i=0;i<f.size();i++) {
			// create a JButton for each product in the supermarket
			JButton btnFighters = new JButton();
			// set its text to the product's info
			btnFighters.setText(game.getPlayer().getFighters().get(i).getName()+" "+f.get(i).getClass());
			
			btnFighters.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					JButton MyFighter = (JButton) e.getSource();
					// get its index within the ArrayList of buttons
					int MyFighterIndex = fighterButtons.indexOf(MyFighter);
					// get the corresponding product from the supermarket
					Earthling Ear =new Earthling("");
					Frieza Fri =new Frieza("");
					Majin Maj =new Majin("");
					Saiyan Sai =new Saiyan("");
					Namekian Nam =new Namekian("");
					if(game.getPlayer().getFighters().get(MyFighterIndex).getClass()==Ear.getClass())
					{
						
						view.getLblPlayerCell().setIcon(new ImageIcon(view.getEarthlingimgincells()));
					}
					if(game.getPlayer().getFighters().get(MyFighterIndex).getClass()==Fri.getClass())
					{
						
						view.getLblPlayerCell().setIcon(new ImageIcon(view.getFriezaimg()));
					}
					if(game.getPlayer().getFighters().get(MyFighterIndex).getClass()==Maj.getClass())
					{
						
						view.getLblPlayerCell().setIcon(new ImageIcon(view.getMajinimg()));
					}
					if(game.getPlayer().getFighters().get(MyFighterIndex).getClass()==Sai.getClass())
					{
						
						view.getLblPlayerCell().setIcon(new ImageIcon(view.getPlayerInCells()));
					}
					if(game.getPlayer().getFighters().get(MyFighterIndex).getClass()==Nam.getClass())
					{
						
						view.getLblPlayerCell().setIcon(new ImageIcon(view.getNamekainimgincells()));
					}
					// invoke the buy method on it
					game.getPlayer().setActiveFighter(game.getPlayer().getFighters().get(MyFighterIndex));
					view.getWorld_mode_2().setVisible(true);
					view.getSwitch().setVisible(false);
					updatePlayerStatsInMap();view.resetSwitchPanel();}});
			view.getMyFighters().add(btnFighters);
			fighterButtons.add(btnFighters);
			
	}
}

@Override
public void AddingSuperAttack() {
	// TODO Auto-generated method stub
	PlayableFighter dragon = game.getPlayer().getActiveFighter();
	
	view.getNewSuperAttacksPanel().setVisible(true);
	view.getWorld_mode_2().setVisible(false);
	
	ArrayList<JButton> SuperAttacksButtons =new ArrayList<JButton>();
	
	ArrayList<SuperAttack> superAttacks=game.getPlayer().getSuperAttacks();
	
	
	
	for (int i=0;i<superAttacks.size();i++) {
		// create a JButton for each product in the supermarket
		JButton btnSuperAttack = new JButton();
		// set its text to the product's info
		btnSuperAttack.setText(superAttacks.get(i).toString());
		
		btnSuperAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				JButton btnAttack = (JButton) e.getSource();
				// get its index within the ArrayList of buttons
				int AttackIndex = SuperAttacksButtons.indexOf(btnAttack);
				// get the corresponding product from the supermarket
				SuperAttack  Attack = ((SuperAttack) superAttacks.get(AttackIndex));
				// invoke the buy method on it
				view.getDragonMode().setVisible(false);
				view.getWorld_mode_2().setVisible(true);
				
				try {
				
					game.getPlayer().getActiveFighter().addNewSuperAttack(Attack);
				} catch (MaximumAttacksLearnedException e1) {
					JOptionPane.showMessageDialog(new JFrame(), "U reached the maximum number of the SuperAttacks use assign Attacks instead", "Maximum Attacks Learned",
			    	        JOptionPane.ERROR_MESSAGE);
					
				}
				catch (DuplicateAttackException e1)
				{
					JOptionPane.showMessageDialog(new JFrame(), "U Already have that Attack", "Duplicate Attack",
			    	        JOptionPane.ERROR_MESSAGE);
				}
				updatePlayerStatsInMap();}});
		view.getAllSuperAttacksPanel().add(btnSuperAttack);
		SuperAttacksButtons.add(btnSuperAttack);
	}		
	
	updateTxtSuperAttacks(dragon.getSuperAttacks());
}




@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void AddingUltimateAttack() {
	
		PlayableFighter dragon = game.getPlayer().getActiveFighter();
		
		view.getNewUltimateAttacksPanel().setVisible(true);
		view.getWorld_mode_2().setVisible(false);
		
		ArrayList<JButton> UltimateAttacksButtons =new ArrayList<JButton>();
		
		ArrayList<UltimateAttack> UltimateAttacks=game.getPlayer().getUltimateAttacks();
		
		
		
		for (int i=0;i<UltimateAttacks.size();i++) {
			// create a JButton for each product in the supermarket
			JButton btnSuperAttack = new JButton();
			// set its text to the product's info
			btnSuperAttack.setText(UltimateAttacks.get(i).toString());
			
			btnSuperAttack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					JButton btnAttack = (JButton) e.getSource();
					// get its index within the ArrayList of buttons
					int AttackIndex = UltimateAttacksButtons.indexOf(btnAttack);
					// get the corresponding product from the supermarket
					UltimateAttack  Attack = ((UltimateAttack) UltimateAttacks.get(AttackIndex));
					// invoke the buy method on it
					view.getNewUltimateAttacksPanel().setVisible(false);
					view.getWorld_mode_2().setVisible(true);
					
					try {
						game.getPlayer().getActiveFighter().addNewUltimateAttack(Attack);
					} catch (MaximumAttacksLearnedException e1) {
						JOptionPane.showMessageDialog(new JFrame(), "You reached the maximum number of the SuperAttacks use assign Attacks instead", "Maximum Attacks Learned",
				    	        JOptionPane.ERROR_MESSAGE);
						
					}
					catch (DuplicateAttackException e1)
					{
						JOptionPane.showMessageDialog(new JFrame(), "You  Already have that Attack", "Duplicate Attack",
				    	        JOptionPane.ERROR_MESSAGE);
					}
					updatePlayerStatsInMap();}});
			view.getAllSuperAttacksPanel().add(btnSuperAttack);
			UltimateAttacksButtons.add(btnSuperAttack);
		}		
		
		updateTxtUltimateAttacks(dragon.getUltimateAttacks());
	}


	private void updateTxtUltimateAttacks(ArrayList<UltimateAttack> e) {
	// TODO Auto-generated method stub
	
		String s ="";
		for (int i=0;i<e.size();i++)
		{s=s+e.get(i).toString()+"\n";
		}

view.getTxtNameOfThePlayer().setText(s);
}




	public void updateTxtSuperAttacks(ArrayList<SuperAttack> e) {
		// TODO Auto-generated method stub
		String s ="";
				for (int i=0;i<e.size();i++)
				{s=s+e.get(i).toString()+"\n";
				}
		
		view.getTxtNameOfThePlayer().setText(s);
	}


	@Override
	public void UpgradeUsingAbilityPoints(char c) {
		// TODO Auto-generated method stub
		try {
			game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), c);
		} catch (NotEnoughAbilityPointsException e) {
			JOptionPane.showMessageDialog(new JFrame(), "You Don't have Ability Points", "Missing AbilityPoints",
	    	        JOptionPane.ERROR_MESSAGE);
		}
		updatePlayerStatsInMap();
		
	}


	@Override
	public void save() {
		// TODO Auto-generated method stub
		try {
			game.save(""+this.getClass().getResource("/Save.txt"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(new JFrame(), "Save problem", "Save problem",
	    	        JOptionPane.ERROR_MESSAGE);
		}
	}
	
}


	


		
		
	

	


	

	



