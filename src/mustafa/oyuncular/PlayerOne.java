package mustafa.oyuncular;

import java.util.Scanner;

import mustafa.logic.Xox;

public class PlayerOne extends Oyuncu{
	
	public PlayerOne() {
		// TODO Auto-generated constructor stub
		setColor("Mavi");
		setWin(0);
	}

	@Override
	public void markTable(Scanner input) {
		// TODO Auto-generated method stub
		int move = 0;
		while(move == 0) {
			move = setValue(input);
		}
		int[] loc = locations(move);
		Xox.table[loc[0]][loc[1]] = 22;
	}

}
