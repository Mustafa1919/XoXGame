package mustafa.logic;

public class Xox extends Logic{

	public static int[][] table;
	public Xox() {
		// TODO Auto-generated constructor stub
		table = new int[3][3];
		resetTable();
		printTable();
		startGame();
		input.close();
	}
	
	public void resetTable() {
		int count = 1;
		for(int i=0 ; i<table.length ; i++) {
			for(int j=0 ; j<table[i].length ; j++)
				table[i][j] = count++;
		}
	}
	
	public void printTable() {
		for(int i=0 ; i<table.length ; i++) {
			for(int j=0 ; j<table[i].length ; j++) {
				if(table[i][j] == 22)
					System.out.print("X  ");
				else if(table[i][j] == 11)
					System.out.print("O  ");
				else
					System.out.print(table[i][j] + "  ");
			}
			System.out.println();		
		}
	}
	
}
