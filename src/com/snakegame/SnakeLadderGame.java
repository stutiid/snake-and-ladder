package com.snakegame;

import java.util.Random;

public class SnakeLadderGame {
	public static void main(String args[]) {
		System.out.println("Welcome to snake and ladder simulator");
		// variables and objects
		int position = 0;// initial position of player
		Random rand = new Random(); // using Random class of java.util
		int option;
		// printing initial position of player
		System.out.println("your initial position is " + position);
		// loop till player reach the winning spot which is 100
		while (position < 100) {
			int dice = rand.nextInt(6) + 1; // dice number generator
			System.out.println("dice " + dice);
			option = rand.nextInt(3) + 1; // option generator
			System.out.println("option " + option);
			// checking out the options
			if (option == 1)
				System.out.println("NO Play, your position is same as before " + position);
			else if (option == 2) {
				int tempPosition = position + dice;
				if (tempPosition > 100) // need exact 100 to win
					System.out.println("You need to get exact 100 your current positon is same as before " + position);
				else {
					position = tempPosition; // updating the position
					System.out.println("you got ladder, your current position is = " + position);
				}
			} else {
				int tempPosition = position - dice;
				if (tempPosition < 0) // if tempPosition is negative then you have to restart
					position = 0;
				else
					position = tempPosition; // updating the position
				System.out.println("You got bitten by snake, your current position is =" + position);
			}
		}
	}
}