package start.ctci.ood;

import java.util.List;

enum Suit {
	Spade(0),
	Club(1),
	Diamond(2),
	Heart(3);
	
	int value;
	
	Suit(int v) { value = v; }
}

class Card {
	Suit suit;
	int value;
	boolean available;
	
	private Card() {}
	public Card(Suit suit,int value) {
		this.suit = suit;
		if(this.value<1 || this.value>13) {
			throw new IllegalArgumentException("Not a valid card value");
		}
		this.value = value;
	}
	
	public boolean isAce() {
		return value==1;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void markAvailable() {
		available=true;
	}
	
	public void markUnAvailable() {
		available=false;
	}
}

public class Deck {
	private List<Card> cards;
	
	public void shuffle() {
		
	}
	
	public Card pick() {
		return null;
	}
}
