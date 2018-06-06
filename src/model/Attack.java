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
		
		public AttackResult simulAttack() {
			List<Unit> countryDefendUnits = countryDefend.getUnits();
			Collections.sort(countryDefendUnits, new Comparator<Unit>() {		//cr�er une instance de comparator
			      @Override
			      public int compare (Unit unit1, Unit unit2) {			
			    	  return Integer.compare(unit1.getDefensePriority(), unit2.getDefensePriority());
			      }
			} );
			List<Unit> defenders = countryDefendUnits.subList(0,Math.min(2,countryDefendUnits.size()));
			attackUnits.forEach(u->u.setScore(generateScore(u)));
			defenders.forEach(u->u.setScore(generateScore(u)));
			attackUnits.forEach(u->System.out.println(u.getUnitType()+" "+u.getScore()));
			defenders.forEach(u->System.out.println(u.getUnitType()+" "+u.getScore()));
			Collections.sort(attackUnits,order(true));
			Collections.sort(defenders,order(false));
			System.out.println("attaquant");
			attackUnits.forEach(u->System.out.println(u.getUnitType()+" "+u.getScore()));
			System.out.println("defenseur");
			defenders.forEach(u->System.out.println(u.getUnitType()+" "+u.getScore()));
			AttackResult attackResult = new AttackResult(countryAttack,countryDefend);
			int minSizeList =Math.min(attackUnits.size(),defenders.size());
			System.out.println(minSizeList);
			for(int i=0;i<minSizeList;i++){
				System.out.println("dans la boucle");
				Unit attack = attackUnits.get(i);
				Unit defense = defenders.get(i);
				if(defense.getScore()>=attack.getScore()){
					attack.setStatus("detruit");
				}else{
					defense.setStatus("detruit");
				}
			}
			attackResult.setResultAttackUnits(attackUnits);
			attackResult.setResultDefenseUnits(defenders);
			attackResult.getResultAttackUnits().forEach((v)->System.out.println(v.getUnitType()+" "+v+" "+v.getScore()));
			attackResult.getResultDefenseUnits().forEach((v)->System.out.println(v.getUnitType()+" "+v+" "+v.getScore()));
			return attackResult;
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
