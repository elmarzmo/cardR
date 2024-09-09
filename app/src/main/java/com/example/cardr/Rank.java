package com.example.cardr;

public enum Rank {
ONE(1),
TWO(2),
THREE(3),
FOUR(4),
FIVE(5),
SIX(6),
SEVEN(7),
TEN(8),
ELEVEN(9),
TWELVE(10);

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
