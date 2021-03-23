package com.snakegame;

import java.util.Random;

public class SnakeLadderGame {
	public static void main(String args[]) {
		System.out.println("Snake and ladder game simulator");
		// variables and objects
		int position = 0;
		Random rand = new Random(); // using Random class of java.util
		int option;
		// computation
		int dice = rand.nextInt(6) + 1; // dice number generator
		System.out.println("dice " + dice);
		option = rand.nextInt(3) + 1; // option generator
		System.out.println("option " + option);
		// checking out the options
		if (option == 1)
			System.out.println("NO Play, your position is same as before " + position);
		else if (option == 2) {
			int tempPosition = position + dice;
			System.out.println("you got ladder, your current position is = " + tempPosition);
		} else {
			int tempPosition = position - dice;
			System.out.println("You got bitten by snake, your current position is =" + tempPosition);
		}
	}
}
