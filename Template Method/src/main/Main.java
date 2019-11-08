package main;

import java.util.Scanner;

import game.NoppaPeli;

public class Main {

	public static void main(String[] args) {
		
		int players = 0;
		NoppaPeli game = new NoppaPeli();
		Scanner scan = new Scanner(System.in);
		
		while(players <=0) {
		System.out.println("Anna pelaaja määrä:");
		players = scan.nextInt();
		}
		
		game.playOneGame(players);
	}

}
