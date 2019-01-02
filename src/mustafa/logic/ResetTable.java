package mustafa.logic;

public class ResetTable {
	public void resetTable() {
		int count = 1;
		for(int i=0 ; i<Xox.table.length ; i++) {
			for(int j=0 ; j<Xox.table[i].length ; j++)
				Xox.table[i][j] = count++;
		}
	}
	
	
	public void printTable() {
		for(int i=0 ; i<Xox.table.length ; i++) {
			for(int j=0 ; j<Xox.table[i].length ; j++) {
				if(Xox.table[i][j] == 22)
					System.out.print("X  ");
				else if(Xox.table[i][j] == 11)
					System.out.print("O  ");
				else
					System.out.print(Xox.table[i][j] + "  ");
			}
			System.out.println();		
		}
	}
}
