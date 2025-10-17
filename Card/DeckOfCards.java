package Card;
import java.security.SecureRandom;

public class DeckOfCards
{
   private Card[] deck; 
   private int currentCard; 
   private static final int NUMBER_OF_CARDS = 52; 
   private static final SecureRandom randomNumbers = new SecureRandom();

   public DeckOfCards()
   {
      String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", 
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
      String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

      deck = new Card[NUMBER_OF_CARDS]; 
      currentCard = 0;

      for (int count = 0; count < deck.length; count++) 
         deck[count] = new Card(faces[count % 13], suits[count / 13]);
   } 

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle()
   {
      // next call to method dealCard should start at deck[0] again
      currentCard = 0; 

      // for each Card, pick another random Card (0-51) and swap them
      for (int first = 0; first < deck.length; first++) 
      {
         // select a random number between 0 and 51 
         int second =  randomNumbers.nextInt(NUMBER_OF_CARDS);
         
         // swap current Card with randomly selected Card
         Card temp = deck[first];     //deck eh o vetor que contem as 52 cartas   
         deck[first] = deck[second];   
         deck[second] = temp;            
      } 
   } 

   public Card dealCard() //retorna um Card
   { 
      if (currentCard < deck.length)
         return deck[currentCard++]; //retorna a carta atual e incrementa na currentCard
      else        
         return null; 
   } 
} 