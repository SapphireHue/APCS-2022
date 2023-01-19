public class Card {
    private String name, suit;
    private int rank;

    public Card() {
        suit = name = "default";
        rank = 0;
    }

    public Card(String n, String s, int r) {
        name = n;
        suit = s;
        rank = r;
    }

    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public void setName(String n) {
        name = n;
    }

    public void setSuit(String s) {
        suit = s;
    }

    public void setRank(int r) {
        rank = r;
    }

    public boolean equals(Object obj){
        Card c = (Card) obj;
        return(name.equals(c.getName()) && suit.equals(c.getSuit()) && rank == c.getRank());
    }

    public int compareTo(Object obj){
        Card c = (Card) obj;
        String suitOrder = "diamonds hearts spades clubs";
        if(equals(c)){
           return 0; 
        }
        else if(suitOrder.indexOf(suit) > suitOrder.indexOf(c.getSuit())){
            return 1;
        }
        else if(suitOrder.indexOf(suit) < suitOrder.indexOf(c.getSuit())){
            return -1;
        }
        else{
            return (rank-c.getRank())/Math.abs(rank-c.getRank());
        }
    }

    public String toString(){
        return (suit.charAt(0)+name+"("+rank+")");
    }
}