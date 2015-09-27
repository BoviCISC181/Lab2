import java.util.ArrayList;
import java.util.Collections;

public class Hand {
	
	public ArrayList<Card> hand = new ArrayList<Card>();
	
	public Hand(){
		//empty; the Play class should handle taking cards from deck and 
		//giving them to hand.
	}
	
	//It's only 5 elements so bubblesort wont be a big deal
	public void sortHand(){
		for (int i=0;i<this.hand.size()-1;i++){
			for (int j=1;j<this.hand.size()-1;j++){
				if (hand.get(i).getRank()>hand.get(j).getRank()){
					//holderCard holds the value, so it's not lost in the switch
					Card holderCard = hand.get(j);
					hand.set(j, hand.get(i));
					hand.set(i, holderCard);
					//set it back to null
					holderCard = null;
				}
			}
		}
	}
	
	public static boolean isFlush(ArrayList<Card> hand){
		//if any don't match the suit of the first, the suits are not all the same
		for (int i=0;i<5;i++){
			if (hand.get(0).getSuit() != hand.get(i).getSuit()){
				return(false);
			}
		}
		return(true);
	}
	
	public static boolean isStraight(ArrayList<Card> hand){
		//once it's sorted, the last card rank - first card rank must equal 4 (since they'd be in order)
		//just make sure to sort in Play class once the hand is populated with cards
		return((hand.get(4).getRank()-hand.get(0).getRank())==4);
	}
	
	public static boolean isFourOfaKind(ArrayList<Card> hand){
		/*Same logic as isFlush, but once sorted, the four might start at 
		 * the beginning or second place of the hand depending on their rank.
		 * Two loops: one starting at 0 iterating over 4 cards, then one starting at 1
		 * iterating over the next 4 cards.
		 */
		boolean bool1 = true;
		boolean bool2 = true;
		for (int i=1;i<4;i++){
			if (hand.get(0).getRank() != hand.get(i).getRank()){
				bool1 = false;
				break;
			}
			bool1 = true;
		}
		for (int i=2;i<5;i++){
			if (hand.get(1).getRank() != hand.get(i).getRank()){
				bool2 = false;
				break;
			}
			bool2 = true;
		}
		//bool 1 and 2 cannot both be true because that would mean 5 of a kind (impossible in standard deck)
		return(bool1 || bool2);
	}
	
	public static boolean isStraightFlush(ArrayList<Card> hand){
		//straight flush must be a flush and a straight
		return(isStraight(hand) && isFlush(hand));
	}
	
	public static boolean isRoyalFlush(ArrayList<Card> hand){
		/*It has to be a strightflush, and begin with 10, 
		 * so the methods are already written :)
		 */
		return ((hand.get(0).getRank()==10) && (Hand.isStraightFlush(hand)));
	}
	public static boolean isThreeOfaKind(ArrayList<Card> hand){
		//do same thing as in 4 of a kind, but with three loops to check all possible positions
		//make sure the hand is not 4 of a kind first to make control flow easier
		if (Hand.isFourOfaKind(hand)){
			return(false);
		}
		boolean bool1 = true;
		boolean bool2 = true;
		boolean bool3 = true;
		for (int i=1;i<3;i++){
			if (hand.get(0).getRank() != hand.get(i).getRank()){
				bool1 = false;
				break;
			}
			//dont think i have to set true here. leave as comment until testing is complete tho.
			//bool1 = true;
		}
		for (int i=2;i<4;i++){
			if (hand.get(1).getRank() != hand.get(i).getRank()){
				bool2 = false;
				break;
			}
		}
		for (int i=3;i<4;i++){
			if (hand.get(2).getRank() != hand.get(i).getRank()){
				bool2 = false;
				break;
			}
		}
		return(bool1 || bool2 || bool3);
	}
	
	
	/*Do same as isThreeOfaKind, check if 4 of a kind, then three, then do loops with control flow and booleans.
	 *but do it tomorrow as sleep is very important for efficiency.
	 *also, email prof gibbons about Card having no setters/getters and how we are supposed to sort, or decide hands without it
	 *Since you wont remember what you were doing since youre so tired now, im writing the code going down in number of cards
	 *first 4 of a kind, then 3, etc. so i can check at the beginning of each if it was the previous.
	 *nest them so once i call 1 pair, it calls 3 of a kind, which already has 4 of a kind in it. 
	 *make sure to get accurate responses for the method youre actually calling, dont want to call isOnePair and have 
	 *4 of a kind return true up the nesting ladder...
	 *if (4 of a kind){
	 *    return(false);
	 *}
	 *that^^^ should go in 3 of a kind. leave the else{} blank so nothing gets messed
	 *hopefully this will make sence in the few hours
	 */
	public static boolean isOnePair(ArrayList<Card> hand){
		if (Hand.isThreeOfaKind(hand)){
			return(false);
		}
		boolean bool1 = true;
		boolean bool2 = true;
		boolean bool3 = true;
		boolean bool4 = true;
		if (hand.get(0).getRank() != hand.get(1).getRank()){
			bool1 = false;
		}
		if (hand.get(1).getRank() != hand.get(2).getRank()){
			bool2 = false;
		}
		if (hand.get(2).getRank() != hand.get(3).getRank()){
			bool3 = false;
		}
		if (hand.get(3).getRank() != hand.get(4).getRank()){
			bool4 = false;
		}
		
		if (bool1 || bool2 || bool3 || bool4){
			return(true);
		}
		return(false);
	}

	public static boolean istwoPair(ArrayList<Card> hand){
		if (Hand.isThreeOfaKind(hand)){
			return(false);
		}
		boolean bool1 = true;
		boolean bool2 = true;
		boolean bool3 = true;
		boolean bool4 = true;
		if (hand.get(0).getRank() != hand.get(1).getRank()){
			bool1 = false;
		}
		if (hand.get(1).getRank() != hand.get(2).getRank()){
			bool2 = false;
		}
		if (hand.get(2).getRank() != hand.get(3).getRank()){
			bool3 = false;
		}
		if (hand.get(3).getRank() != hand.get(4).getRank()){
			bool4 = false;
		}
		/*
		 * find a way to check if two booleans are true.
		 * i think this should work.
		 * it checks for a combination of pairs (i think it works)
		 */
		if ((bool1 && bool3) || (bool1 && bool4) || (bool2 && bool4)){
			return(true);
		}
		return(false);
	}
	
	public void tieBreaker(Hand hand1, Hand hand2){
		
	}
	
	
	/*
	 * Still have to write:
	 * 	isFullHouse()
	 * 	and isNoPair() might want to call this isHighCard()
	 * for nopair just check all others and if they all fail it must be high card only
	 */
	
	/*
	public static boolean isFullHouse(ArrayList<Card> hand){
		/*
		 * doing 
		 * if (isThreeOfaKind(hand) && isOnePair(hand))
		 * will always return true if isThreeOfaKind(hand) is true
		 *
		
		if (isThreeOfaKind(hand)){
			
		}
	}*/
}












