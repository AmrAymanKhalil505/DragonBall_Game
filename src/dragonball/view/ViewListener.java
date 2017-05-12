package dragonball.view;

import java.util.EventListener;

import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.PlayableFighter;

public interface ViewListener  extends EventListener  {
	public void onLoadgame();
	public void onChangePlayerName(String text);
	
	public void onMakingnewSaiyan(String Type);
	public void onMakingnewFrieza(String Type);
	public void onMakingnewNamekain(String Type);
	public void onMakingnewMajin(String Type);
	public void onMakingnewEarthling(String Type);

	public void keyPressedLeft();
	public void keyPressedUp();
	public void keyPressedDown();
	public void keyPressedRight();
	public void updatePlayerStatsInMap();
	
	
	public void callswitching();
	public void AddingSuperAttack();
	public void AddingUltimateAttack();
	public void UpgradeUsingAbilityPoints(char c);
	public void save();
	
	

}
