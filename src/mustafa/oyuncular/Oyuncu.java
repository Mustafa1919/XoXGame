package mustafa.oyuncular;

import java.util.InputMismatchException;
import java.util.Scanner;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import mustafa.logic.Xox;

/**
 * @author casper
 *
 */
public abstract class Oyuncu {

	private String color;
//	private String name;
	private int win;
	
	public int getWin() {return win;}
	public void setWin(int win) {this.win = win;}
	
//	public String getAdi() {return name;}
//	public void setAdi(String name) {this.name = name;}
	
	public String getColor() {return color;	}
	public void setColor(String color) {this.color = color;}
	
	
	/*
	 * Bu metod oyuncular tarafindan override edilmek zorundadir 
	 * her kullanici kendi isaretini tahtanin ilgili konumuna koymalidir 
	 * X veya O olarak 
	 */
	public abstract void markTable(Scanner input);
	
	
	/*
	 * Kullanicidan tahtadaki konumu int deger olarak alinir ve gerekli kontroller 
	 * saglanarak o deger geri dondurulur 
	 * 
	 * Kontroller 1
	 * 		girilen konum 1 ile 9 arasinda olmalidir cunkü tahta 9 bolumdur
	 * Kontrol 2 
	 * 		girilen konumda daha once hamle yapilip yapilmadigi kontrol edilir 
	 * Kontrol 3 
	 * 		girilen konum hata kodu veriyor mu diye kontrol edilir.
	 */
	public int setValue(Scanner input) {
		int choose = 0;
		System.out.print("Hamleniz: ");
		try {
			choose = input.nextInt();
			if(choose < 1 || choose > 9) {
				System.out.println("Lutfen Hamlenizi Tahtadaki Konumdan Yapiniz");
				return 0;
			}
			else if(checkLocations(choose)) {
				System.out.println("Secilen Konum Dolu");
				return 0;
			}
		}
		catch (ValueException e) {
			// TODO: handle exception
			System.out.println("Value Hatasi");
			return 0;
		}
//		catch (InputMismatchException e) {
//			// TODO: handle exception
//			System.out.println("Lutfen Tam Sayi Giriniz");
//			return 0;
//		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Beklenmeyen Bir Hata Olustu " + e);
			return 0;
		}
		return choose;
	}
	
	
	/*
	 * tahtanin o konumu daha once hamle yapilip yapilmadigi kontrol edilir. 
	 * eger hamle yapildiysa false yapilmadiysa true deger doner 
	 */
	private boolean checkLocations(int choose) {
		int[] loc = locations(choose);
		if(Xox.table[loc[0]][loc[1]] > 10)
			return true;
		return false;
	}
	
	public int[] locations(int choose) {
		int[] loc = new int[2];
		if(choose == 3 || choose == 6 || choose == 9) {
			loc[0] = (choose/3) - 1;
			loc[1] = 2;
		}
		else {
			loc[0] = choose / 3;
			loc[1] = (choose%3) - 1;
		}
		return loc;
	}
}
