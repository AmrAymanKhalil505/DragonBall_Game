package dragonball.model.dragon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;

public class Dragon implements Serializable {
	private String name;
	private ArrayList<SuperAttack> superAttacks;
	private ArrayList<UltimateAttack> ultimateAttacks;
	private int senzuBeans;
	private int abilityPoints;

	public Dragon(String name, ArrayList<SuperAttack> superAttacks, ArrayList<UltimateAttack> ultimateAttacks,
			int senzuBeans, int abilityPoints) {
		this.name = name;
		this.superAttacks = superAttacks;
		this.ultimateAttacks = ultimateAttacks;
		this.senzuBeans = senzuBeans;
		this.abilityPoints = abilityPoints;
	}

	public String getName() {
		return name;
	}

	public ArrayList<SuperAttack> getSuperAttacks() {
		return superAttacks;
	}

	public ArrayList<UltimateAttack> getUltimateAttacks() {
		return ultimateAttacks;
	}

	public int getSenzuBeans() {
		return senzuBeans;
	}

	public int getAbilityPoints() {
		return abilityPoints;
	}

	// get random wishes this dragon can grant
	public DragonWish[] getWishes() {
		ArrayList<DragonWish> wishes = new ArrayList<>();

		if (senzuBeans > 0) {
			wishes.add(new DragonWish(this, DragonWishType.SENZU_BEANS, senzuBeans));
		}

		if (abilityPoints > 0) {
			wishes.add(new DragonWish(this, DragonWishType.ABILITY_POINTS, abilityPoints));
		}

		if (superAttacks.size() > 0) {
			SuperAttack randomSuperAttack = superAttacks.get(new Random().nextInt(superAttacks.size()));
			wishes.add(new DragonWish(this, DragonWishType.SUPER_ATTACK, randomSuperAttack));
		}

		if (ultimateAttacks.size() > 0) {
			UltimateAttack randomUltimateAttack = ultimateAttacks.get(new Random().nextInt(ultimateAttacks.size()));
			wishes.add(new DragonWish(this, DragonWishType.ULTIMATE_ATTACK, randomUltimateAttack));
		}

		return wishes.toArray(new DragonWish[wishes.size()]);
	}
	public String toString()
	{
	String s0 = "Dragon name is "+getName()+" and he offers\n"+getSenzuBeans()+" senzo beans\n"+getAbilityPoints() +" ability points\n";
	String s1 ="";
			for (int i =0 ; i<getSuperAttacks().size();i++)
			{s1 = s1+"Super Attack "+getSuperAttacks().get(i).toString()+"\n";	
			}
			for (int j =0 ; j<getUltimateAttacks().size();j++)
			{s1 = s1+"Ultimate Attack "+getSuperAttacks().get(j).toString()+"\n";	
			}
			return s0 +s1;
			
	}
}
