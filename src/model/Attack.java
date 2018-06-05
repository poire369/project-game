package model;

import java.util.*;

public class Attack {
		
	// Attribut
		private Country countryAttack;

		private List<Unit> attackUnits;

		private Country countryDefend;

		
	// Constructeur
		public Attack(Country countryAttack, List<Unit> attackUnits, Country countryDefend){
			this.countryAttack=countryAttack;
			this.attackUnits=attackUnits;
			this.countryDefend=countryDefend;
		}

		
	// Methode simulAttack
		
		public void simulAttack() {
			List<Unit> countryDefendUnits = countryDefend.getUnits();
			Collections.sort(countryDefendUnits, new Comparator<Unit>() {		//cr�er une instance de comparator
			      @Override
			      public int compare (Unit unit1, Unit unit2) {			
			    	  return Integer.compare(unit1.getDefensePriority(), unit2.getDefensePriority());
			      }
			} );
			List<Unit> defenders = countryDefendUnits.subList(0,2);
			attackUnits.forEach(u->u.setScore(generateScore(u)));
			defenders.forEach(u->u.setScore(generateScore(u)));
			Collections.sort(attackUnits,order(true));
			Collections.sort(defenders,order(false));
			AttackResult attackResult = new AttackResult(countryAttack,countryDefend);
			for(int i=0;i<attackUnits.size();i++){
				Unit attack = attackUnits.get(i);
				Unit defense = defenders.get(i);
				boolean result = defense.getScore()>=attack.getScore();
				attackResult.getResultAttackUnits().put(attack,!result);
				attackResult.getResultDefenseUnits().put(defense,result);
			}
		} 

		private int generateScore(Unit unit){
			return new Random().nextInt((unit.getMaxPower() - unit.getMinPower()) + 1) + unit.getMinPower();
		}

		private Comparator<Unit> order(boolean isAttack){
			return  new Comparator<Unit>() {
				@Override
				public int compare (Unit unit1, Unit unit2) {
					if(unit1.getScore()==unit2.getScore()){
						if(isAttack==true){
							return Integer.compare(unit1.getAttackPriority(), unit2.getAttackPriority());
						} else {
							return Integer.compare(unit1.getDefensePriority(), unit2.getDefensePriority());
						}
					} else {
						return -Integer.compare(unit1.getScore(), unit2.getScore());
					}
				}
			};
		}
		
		
	// Getter & Setters	
		
		public Country getAttack() {
			return countryAttack;
		}

		public void setAttack(Country attack) {
			this.countryAttack = attack;
		}

		public List<Unit> getAttackUnits() {
			return attackUnits;
		}

		public void setAttackUnits(List<Unit> attackUnits) {
			this.attackUnits = attackUnits;
		}

		public Country getDefend() {
			return countryDefend;
		}

		public void setDefend(Country defend) {
			this.countryDefend = defend;
		}
		

}
