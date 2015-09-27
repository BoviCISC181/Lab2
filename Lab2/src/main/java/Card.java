
public class Card {
	/*
	 * how should i sort or evaluate hands with no accessors or mutators.
	 */
	private int rank;
	private String suit;
	
	public Card (int rank, String suit){
		this.rank = rank;
		this.suit = suit;
	}
	
	public int getRank(){
		return(this.rank);
	}
	public String getSuit(){
		return(this.suit);
	}
}