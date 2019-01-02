package mustafa.logic;

import java.util.Random;
import java.util.Scanner;

import mustafa.oyuncular.Oyuncu;
import mustafa.oyuncular.PlayerOne;
import mustafa.oyuncular.PlayerTwo;

public class Logic extends ResetTable implements OyunBasla{
	private Oyuncu[] players;
	private int[] triage;
	private Random rnd;
	protected Scanner input;
	
	public Logic() {
		// TODO Auto-generated constructor stub
		rnd = new Random();
		triage = new int[10];
		input = new Scanner(System.in);
		createPlayer();
		printPlayerInfo();
	}

	
	/*
	 * oyunu kimin kazandigini kontrol eder
	 */
	public boolean ifWinGame() {
		for(int i=0 ; i<Xox.table.length ; i++) {
			if((Xox.table[i][1] == Xox.table[i][2]) && (Xox.table[i][0] == Xox.table[i][2])){
				if(Xox.table[i][0] == 11) {
					players[1].setWin(players[1].getWin()+1);
					System.out.println("Kazanan : " + players[1].getColor() + "\n");
					printPlayerInfo();
					return true;
				}
				else if(Xox.table[i][0] == 22) {
					players[0].setWin(players[0].getWin()+1);
					System.out.println("Kazanan : " + players[0].getColor() + "\n");
					printPlayerInfo();
					return true;
				}

			}
		}
		for(int i=0 ; i<Xox.table.length ; i++) {
			if((Xox.table[1][i] == Xox.table[2][i]) && (Xox.table[0][i] == Xox.table[2][i])){
				if(Xox.table[0][i] == 11) {
					players[1].setWin(players[1].getWin()+1);
					System.out.println("Kazanan : " + players[1].getColor() + "\n");
					printPlayerInfo();
					return true;
				}
				else if(Xox.table[0][i] == 22) {
					players[0].setWin(players[0].getWin()+1);
					System.out.println("Kazanan : " + players[0].getColor() + "\n");
					printPlayerInfo();
					return true;
				}
			}
		}
		if((Xox.table[0][0] == Xox.table[1][1]) && (Xox.table[1][1] == Xox.table[2][2])) {
			if(Xox.table[0][0] == 11) {
				players[1].setWin(players[1].getWin()+1);
				System.out.println("Kazanan : " + players[1].getColor() + "\n");
				printPlayerInfo();
				return true;
			}
			else if(Xox.table[0][0] == 22) {
				players[0].setWin(players[0].getWin()+1);
				System.out.println("Kazanan : " + players[0].getColor() + "\n");
				printPlayerInfo();
				return true;
			}
		}
		if((Xox.table[0][2] == Xox.table[1][1]) && (Xox.table[1][1] == Xox.table[2][0])) {
			if(Xox.table[0][2] == 11) {
				players[1].setWin(players[1].getWin()+1);
				System.out.println("Kazanan : " + players[1].getColor() + "\n");
				printPlayerInfo();
				return true;
			}
			else if(Xox.table[0][2] == 22) {
				players[0].setWin(players[0].getWin()+1);
				System.out.println("Kazanan : " + players[0].getColor() + "\n");
				printPlayerInfo();
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 * hangi oyuncunun once baslayacagini gosteren random uretilen dizi 
	 */
	public int[] getTriage() {return triage;}
	
	
	/*
	 * (non-Javadoc)
	 * @see mustafa.logic.OyunBasla#createPlayer()
	 * 
	 * oyunculari olusturarak triage dizisini olusturur 
	 */
	@Override
	public void createPlayer() {
		// TODO Auto-generated method stub
		players = new Oyuncu[2];
		players[0] = new PlayerOne();
		players[1] = new PlayerTwo();
		for (int i=0; i<triage.length ; i++) {
			triage[i] = rnd.nextInt(2);
		}
	}

	
	/*
	 * (non-Javadoc)
	 * @see mustafa.logic.OyunBasla#printPlayerInfo()
	 * 
	 * Oyuncu bilgilerini ekrana yazar
	 */
	@Override
	public void printPlayerInfo() {
		// TODO Auto-generated method stub
		System.out.println("Oyuncu 1 Bilgileri = \n\t" + players[0].getColor() + 
							" rekli oyuncunun puani: " + players[0].getWin());
		System.out.println("Oyuncu 2 Bilgileri = \n\t" + players[1].getColor() + 
				" rekli oyuncunun puani: " + players[1].getWin());
	}

	
	/*
	 * (non-Javadoc)
	 * @see mustafa.logic.OyunBasla#startGame()
	 * 
	 * oyunu baslatir
	 */
	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		int move;
		int tourTriage = 0;
		int firstStart , secandStart;
		while(true) {
			move = 0;
			if(tourTriage>triage.length)
				tourTriage = 0;
			if(triage[tourTriage] == 1) {
				firstStart = 1;
				secandStart = 0;
			}
			else {
				firstStart = 0;
				secandStart = 1;
			}
			while(move < 9) {
				System.out.println("Move : " + move);
				System.out.print(players[firstStart].getColor() + " ");
				players[firstStart].markTable(input);
				move++;
				printTable();
				if(move > 4) {
					if(ifWinGame())
						break;
				}
				if(move < 9) {
					System.out.print(players[secandStart].getColor() + " ");
					players[secandStart].markTable(input);
					move++;
					printTable();
					if(move > 4) {
						if(ifWinGame())
							break;
					}
				}
			}
			tourTriage++;
			resetTable();
			printTable();
			//galibiyet sayisi 3'e ulasanin kazanmasini kontrol et
			if(players[0].getWin() == 3) {
				System.out.println("OYUN BITTI...");
				System.out.println("Kazanan " + players[0].getColor());
				break;
			}
			if(players[1].getWin() == 3) {
				System.out.println("OYUN BITTI...");
				System.out.println("Kazanan " + players[1].getColor());
				break;
			}
		}
	}

}
