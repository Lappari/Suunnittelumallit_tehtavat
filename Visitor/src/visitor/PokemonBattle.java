package visitor;

import java.util.Random;
import java.util.Scanner;

import state.PokemonContext;

public class PokemonBattle extends AVisitor {
	
	private Scanner scanner = new Scanner(System.in);
	
	private void visit(PokemonContext winner, PokemonContext loser) {
		
		
		System.out.println("\nTaistelun voitti "+winner.getName()+"\n"+winner.getName()+" sain voitosta "+(loser.getLvl() * 100)+"exp\n");
		System.out.println("Taistelun hävisi "+loser.getName()+"\n"+loser.getName()+" sain tappiosta "+(winner.getLvl() * 3)+"exp\n");
		
		winner.addExp(loser.getLvl() * 100);
		loser.addExp(winner.getLvl() * 3);
		scanner.nextLine();
		
		// tarkistetaan saiko voittaja tai häviäkä levelin
		if (winner.getExp() >= (winner.getLvl() * winner.getLvlExpMultiplayer())) {
			winner.levelUp();
		}
		
		if (loser.getExp() >= (loser.getLvl() * loser.getLvlExpMultiplayer())) {
			loser.levelUp();
		}
	}

	public void pokemonBattle(PokemonContext fire, PokemonContext leaf) {

		int fireRoll, leafRoll, fireWins = 0, leafWins = 0, round = 0;
		Random r = new Random();
		
		fire.setHp(fire.getMaxHp());
		leaf.setHp(leaf.getMaxHp());
		
		while (fireWins < 1 && leafWins < 1) {
			round++;

			fireRoll = r.nextInt(100) + 1;
			leafRoll = r.nextInt(100) + 1;
			
			//tasoitus mahdollisuus
			if(fire.getLvl()>(leaf.getLvl()+4)) {
				fireRoll = 0;
				System.out.println("Rigged game! "+fire.getName()+" hävisi.");
				leafWins = 1;
				continue;
			}else if(leaf.getLvl()>(fire.getLvl()+4)) {
				leafRoll = 0;
				System.out.println("Rigged game! "+leaf.getName()+" hävisi.");
				fireWins = 1;
				continue;
			}
			
			System.out.println("Kierros "+round);
			if (fireRoll <=75) {
				System.out.println(fire.getName() + " hyökkäsi ja osui tehden " + (int)(fire.getAtk()-leaf.getDef()*0.7)+" pistettä vahinkoa.");
				leaf.setHp((int)(leaf.getHp()-(fire.getAtk()-leaf.getDef()*0.7)));
			} else{
				System.out.println(fire.getName() + " hyökkäsi ja mutta ei osunut.");
			}
				
			if (leafRoll <=75) {
				System.out.println(leaf.getName() + " hyökkäsi ja osui tehden " + (int)(leaf.getAtk()-fire.getDef()*0.7)+" pistettä vahinkoa.");
				fire.setHp((int)(fire.getHp()-(leaf.getAtk()-fire.getDef()*0.7)));
			} else{
				System.out.println(leaf.getName() + " hyökkäsi ja mutta ei osunut.");
			}
			
			if(fire.getHp()==0 && leaf.getHp()==0) {
				System.out.println("Tasapeli");
				break;
			}
			else if(fire.getHp()<=0) {
				leafWins = 1;
			}else if(leaf.getHp()<=0) {
				fireWins = 1;
			}
		}

		if (fireWins == 1) {
			visit(fire, leaf);
		} else if(leafWins==1){
			visit(leaf, fire);
		}
	}

}
