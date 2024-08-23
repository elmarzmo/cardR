
public enum Rank {
ONE(1),
TWO(2),
THREE(3),
FOUR(4),
FIVE(5),
SIX(6),
SEVEN(7),
TEN(10),
ELEVEN(11),
TWELVE(12);

private final int rankValue;
//Constructor
private Rank(int rankValue) {
	 this.rankValue= rankValue;
}
//Public method
public int getRank() {
return rankValue;
}
}
