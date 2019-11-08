package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NoppaPeli extends Game{
	
	int winner;          		//tallennetaan voittajan numero
	int round =0;		    	//lasketaan mones pelikierros menossa
	int[][] bestThrow;	    	//käytetään suurimman heittoluvun löytämiseen, ensimmäinen sarake heitto luku toinen sarake pelaajan numero
	private int[][] players;	//ensimmäiseen sarakkeeseen tallennetaan nopan silmäluku tokaan pelaajan kierros voitot.
	private Random r;
	
	public NoppaPeli() {}

	@Override
	void initializeGame() {		
		this.players = new int[super.playersCount+1][super.playersCount+1]; 
		bestThrow = new int[2][2]; //2 riviä ja saraketta jotta voidaan tarkistaa tuliko samoja lukuja
		r = new Random();
	}

	@Override
	void makePlay(int player) {
		players[player][0] = r.nextInt(20)+1; //pelaajat heittävät 20 sivuista noppaa jottei tulisi samoja lukuja
		
		//kaikki pelaajat heittäneet kerran katsotaan kierroksen voittaja
		if(player==super.playersCount-1) {
			round++;
			//alustetaan parhaan heiton etsintä taulukko
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					bestThrow[i][j]=0;
				}
			}
			//katsotaan kuka heitti parhaan tuloksen
			for(int i=0;i<super.playersCount;i++) {
				if(players[i][0]>bestThrow[0][0]) {
					bestThrow[0][0]=players[i][0];
					bestThrow[0][1]= i;
				}else if(players[i][0]==bestThrow[0][0]) {
					bestThrow[1][0]=players[i][0];
					bestThrow[1][1]= i;
				}
			}
			//heitot käyty läpi katsotaan kuka on voittaja jos tasapeli niin ei kukaan
			if(bestThrow[0][0]==bestThrow[1][0]) {
				System.out.println("Kierros "+round+" tasapeli pelaajilla "+(bestThrow[0][1]+1)+" ja "+(bestThrow[1][1]+1)+" noppatulos: "+bestThrow[0][0]+" ei voittoja");
			}else {
				System.out.println("Kierroksen " +round+" voitti pelaaja "+(bestThrow[0][1]+1)+" heitolla "+bestThrow[0][0]);
				players[bestThrow[0][1]][1]++;//voitto lisätään pelaajalle
			}
			
		}
	}

	@Override
	boolean endOfGame() {
		for(int i=0;i<super.playersCount;i++) {
			if(players[i][1]==3) {
				winner=i+1;
				return true;
			}
		}
		return false;
	}

	@Override
	void printWinner() {
		System.out.println("Pelin voitti numero "+winner);
		
	}

}
