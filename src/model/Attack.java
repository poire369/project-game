package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Attack {
		
	// Attribut
		private Country attack; 
			
		private List<Unit> attackUnits;
	
		private Country defend;
		
	// Constructeur	
		
		public Attack(Country attack, List<Unit> attackUnits, Country defend){
			
			this.attack=attack;
			this.attackUnits=attackUnits;
			this.defend=defend;			
		}

		
	// Méthode simulAttack
		
		public void simulAttack() {
			List<Unit> defenseurs = new ArrayList();
			Collections.sort(defenseurs, new Comparator<Unit>() {		//créer une instance de comparator
			      @Override
			      public int compare (Unit unit1, Unit unit2) {			
			    	  return Integer.compare(unit1.getDefensePriority(), unit2.getDefensePriority());
			      
			      }
			
			} );
		
		} 
		
		
		
		
	// Getter & Setters	
		
		public Country getAttack() {
			return attack;
		}

		public void setAttack(Country attack) {
			this.attack = attack;
		}

		public List<Unit> getAttackUnits() {
			return attackUnits;
		}

		public void setAttackUnits(List<Unit> attackUnits) {
			this.attackUnits = attackUnits;
		}

		public Country getDefend() {
			return defend;
		}

		public void setDefend(Country defend) {
			this.defend = defend;
		}
		

}
