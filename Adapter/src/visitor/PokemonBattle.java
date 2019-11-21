package visitor;

import java.util.Random;
import controller.Controller;
import state.PokemonContext;

public class PokemonBattle extends AVisitor {
	
	public PokemonBattle(Controller c) {
		super(c);
	}
	
	private void visit(PokemonContext winner, PokemonContext loser) {
		
		
		controller.printConsole("\nTaistelun voitti "+winner.getName()+"\n"+winner.getName()+" sai voitosta "+(loser.getLvl() * 75)+"exp\n");
		controller.printConsole("Taistelun hävisi "+loser.getName()+"\n"+loser.getName()+" sai tappiosta "+(winner.getLvl() * 5)+"exp\n");
		
		winner.addExp(loser.getLvl() * 75);
		loser.addExp(winner.getLvl() * 5);

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
				controller.printConsole("Rigged game! "+fire.getName()+" hävisi.\n");
				leafWins = 1;
				continue;
			}else if(leaf.getLvl()>(fire.getLvl()+4)) {
				leafRoll = 0;
				controller.printConsole("Rigged game! "+leaf.getName()+" hävisi.\n");
				fireWins = 1;
				continue;
			}
			
			controller.printConsole("Kierros "+round+"\n");
			if (fireRoll <=75) {
				controller.printConsole(fire.getName() + " hyökkäsi ja osui tehden " + (int)(fire.getAtk()-(leaf.getDef()*0.5))+" pistettä vahinkoa.\n");
				leaf.setHp((int)(leaf.getHp()-(fire.getAtk()-(leaf.getDef()*0.5))));
			} else{
				controller.printConsole(fire.getName() + " hyökkäsi ja mutta ei osunut.\n");
			}
				
			if (leafRoll <=75) {
				controller.printConsole(leaf.getName() + " hyökkäsi ja osui tehden " + (int)(leaf.getAtk()-(fire.getDef()*0.5))+" pistettä vahinkoa.\n");
				fire.setHp((int)(fire.getHp()-(leaf.getAtk()-(fire.getDef()*0.5))));
			} else{
				controller.printConsole(leaf.getName() + " hyökkäsi ja mutta ei osunut.\n");
			}
			
			if(fire.getHp()==0 && leaf.getHp()==0) {
				controller.printConsole("Tasapeli");
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
		
		fire.setHp(fire.getMaxHp());
		leaf.setHp(leaf.getMaxHp());
	}

}
