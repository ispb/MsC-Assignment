package commandline;

import java.util.ArrayList;
import java.util.Stack;
/**
 * The abstract class 'Player' establishes the variables and methods that both the human and AI players require
 * to play the game. This includes a 'Score' for the database, a deck of Cards (held in a stack), 
 * a name, and a boolean value denoting whether the player has any cards left in their stack. 
 */
public abstract class Player {

	
	protected int score = 0; // tracks the score
//	private ArrayList<Card> hand = new ArrayList<>(); // current hand
	protected Stack<Card> playerDeck = new Stack<>();
//	abstract int selectAttribute();
	protected String playerName;
	protected boolean hasCards = true;
	
	
	
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * This method increments the score by one - it's used when a player wins a round.
	 */
	public void winsRound() {
		this.score ++;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Player(String playerName) {
	this.playerName = playerName;
}
	/**
	 * This is used to add cards to each player's deck. 
	 */
	public void pushToDeck(Card card) {
		playerDeck.push(card);	
		
	}
	/**
	 * This is used when taking cards from a player's deck. 
	 */
	public Card popACard() {
		return playerDeck.pop();
	}
	
	/**
	 * This method checks whether or not a player has any cards left in their deck, and updates the 
	 * boolean 'deckIsEmpty' accordingly. This is used when deciding which players are still in the game
	 * and for determining if there is an overall winner. 
	 */
	public boolean deckEmptyCheck() {

		
		boolean deckIsEmpty = false;
		
		if (playerDeck.isEmpty()) {
			
			deckIsEmpty = true;
			
		}
		
		return deckIsEmpty;
		
	}
	public boolean checkCards() {
		return hasCards;
	}
	
	public void hasNoCards() {
		this.hasCards = false;
	}
	
	/**
	 * This is used at the start of a round to examine the player's card and its attributes. 
	 * This is instead of 'popping' in order to make the process of collecting the cards for the winner 
	 * easier. 
	 */
	public Card peekACard() {
		return playerDeck.peek();
	}
	
	/**
	 * This is a modified toString, simply detailing the contents of a player's deck for the Test Log and troubleshooting. 
	 */
	public String displayPlayerHand() {

		String getLogging = "\nThis is " + playerName + ". \nNumber of cards in their hand: " + playerDeck.size() + "\nPrinting " + this.playerName
				+ "'s hand...\n" + playerDeck + "\n------------";
		
		System.out.println("Number of cards in the hand: " + playerDeck.size());
		System.out.println("Printing " + this.playerName + "'s hand...");
		System.out.println(playerDeck);
		return getLogging;	
	}

	public Stack<Card> getHand(){
		return playerDeck;
	}
	
	/**
	 * The method for selecting which attribute to play from the 'peeked' at card is kept abstract, in order to write 
	 * different methods for the AI and human variations on our players. 
	 */
	protected abstract int selectAttribute(Card testCard);
}

