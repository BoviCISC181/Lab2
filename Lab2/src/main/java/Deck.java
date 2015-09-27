
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck(){
		//Here, the deck is populated with cards.
		String[] suits = {"diamond","heart","clubs","spade"};
		for(String suit : suits){
			for (int i=2;i<=14;i++){
				Card c = new Card(i, suit);
				this.deck.add(c);
				
			}
		}
		//Here, the deck is shuffled.
		Collections.shuffle(this.deck);
	}
	
	/*
	 * Where the lab says "Build a method to denote how many cards
	 * are remaining to be drawn", are we supposed to take into 
	 * account how many players there are and how many cards they
	 * have in each of their hands? We should probably wait to implement
	 * until the Hand and Play objects are written?
	 * 
	public int cardsLeft(){
		
	}
	*/
	
	//Draws one card from the end of the arraylist deck.
	public Card drawCard(){
		int deckLength = this.deck.size();
		return(this.deck.get(deckLength-1));
	}
	
	/*
	 * Depending on how we populate the Hand object in Play, this might make 
	 * dealing out cards easier than writing loops that deal one card individually
	 * to several hands. 
	 */
	public ArrayList<Card> drawFiveCards(){
		ArrayList<Card> cards = new ArrayList<Card>();
		for (byte b=0;b<5;b++){
			cards.add(drawCard());
		}
		return(cards);
	}
	
	public ArrayList<Card> getDeck(){
		return this.deck;
	}
}
