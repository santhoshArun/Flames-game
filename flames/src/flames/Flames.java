package flames;

import java.util.Scanner;

public class Flames {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name1 = null, name2 = null;
		
		System.out.print("Enter the name 1: ");
		name1 = sc.nextLine();
		
		System.out.print("Enter the name 2: ");
		name2 = sc.nextLine();
		
		StrikeCombo s = new StrikeCombo(name1, name2);
		FindFlames f = new FindFlames(s.count(), name1, name2);
		f.result();
		
	}

}

class StrikeCombo {
	
	public StringBuilder name1, name2;
	public int length1, length2, i, j, count = 0;
	
	public StrikeCombo(String name1, String name2) {
		this.name1 = new StringBuilder(name1);
		this.name2 = new StringBuilder(name2);
		
		length1 = name1.length();
		length2 = name2.length();
	}
	
	public void generateFinal() {
		
		for(i = 0; i < length1; i++) {	
			for(j = 0; j < length2; j++) {
				if(name1.charAt(i) == name2.charAt(j)) {
					name1.setCharAt(i, '*');
					name2.setCharAt(j, '*');
				}
			}
		}
	}
	
	public void countRemain() {
		for(i = 0; i < length1; i++) {
			if(name1.charAt(i) != '*') {
				count++;
			}
		}
		for(i = 0; i < length2; i++) {
			if(name2.charAt(i) != '*') {
				count++;
			}
		}
	}
	
	public int count() {
		generateFinal();
		countRemain();
		return count;
	}
	
}


class FindFlames {
	
	public int count, position;
	public String flames = "FLAMES", temp, name1, name2;
	
	
	public FindFlames(int count, String name1, String name2) {
		this.count = count;
		this.name1 = name1;
		this.name2 = name2;
	}
	
	public void flames() {
		
		while(flames.length() != 1) {
			
			position = (count) % flames.length();
			
			if(position != 0)
	           {
	               temp = flames.substring(position) + flames.substring(0, position-1); //Append part start from next char to strike and first charater to char before strike.
	           }
	           else
	           {
	               temp = flames.substring(0, flames.length()-1); //If mod result zero we can strike last letter easily
	           }
	           flames = temp;
				
		}
		
	}
	
	public void result() {
		flames();
		switch(flames) {
		case "F": 
			System.out.println(name2 + " is a friend to " + name1);
			break;
		case "L": 
			System.out.println(name2 + " loves " + name1);
			break;
		case "A": 
			System.out.println(name2 + " has an affection on " + name1);
			break;
		case "M": 
			System.out.println(name2 + " will marry " + name1);
			break;
		case "E": 
			System.out.println(name2 + " is an enemy of " + name1);
			break;
		case "S": 
			System.out.println(name2 + " is the sister of " + name1);
			break;
		}
	}

}