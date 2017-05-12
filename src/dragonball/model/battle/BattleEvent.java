package dragonball.model.battle;

import java.util.EventObject;

import dragonball.model.attack.Attack;
import dragonball.model.cell.Collectible;
import dragonball.model.character.fighter.NonPlayableFighter;

@SuppressWarnings("serial")
public class BattleEvent extends EventObject {
	private BattleEventType type;
	private BattleOpponent currentOpponent;
	private BattleOpponent winner;
	private Attack attack;
	private Collectible collectible;
	private Battle b ;
	// constructor for ENDED
	public BattleEvent(Battle battle, BattleEventType type, BattleOpponent winner) {
		this(battle, type);
		this.winner = winner;
		b= battle;
	}

	// constructor for ATTACK
	public BattleEvent(Battle battle, BattleEventType type, Attack attack) {
		this(battle, type);
		this.attack = attack;
		b= battle;
	}

	// constructor for USE
	public BattleEvent(Battle battle, BattleEventType type, Collectible collectible) {
		this(battle, type);
		this.collectible = collectible;
		b= battle;
	}

	// constructor for others
	public BattleEvent(Battle battle, BattleEventType type) {
		super(battle);
		this.type = type;
		this.currentOpponent = battle.getAttacker();
		b= battle;
	}

	public BattleEventType getType() {
		return type;
	}

	public BattleOpponent getCurrentOpponent() {
		return currentOpponent;
	}

	public BattleOpponent getWinner() {
		return winner;
	}

	public Attack getAttack() {
		return attack;
	}

	public Collectible getCollectible() {
		return collectible;
	}

	public Battle getB() {
		return b;
	}

	public void setB(Battle b) {
		this.b = b;
	}
	
}
