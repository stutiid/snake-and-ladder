package com.snakegame;

import java.util.Random;

public class SnakeLadderGame {
	// instance variables
	int position = 0;
	int count = 0;

	public static void main(String args[]) {
		System.out.println("Welcome to snake ladder game simulator");

		// objects and variables
		Random rand = new Random();
		SnakeLadderGame player1 = new SnakeLadderGame();
		SnakeLadderGame player2 = new SnakeLadderGame();
		int turn = 0; // whose turn is
		// printing initial position of player
		System.out.println("player1 initial position is " + player1.position);
		System.out.println("player1 initial position is " + player1.position);
		// loop till one of the two player reach the winning spot which is 100
		while (player1.position < 100 && player2.position < 100) {
			// turn 0 is for player1
			if (turn == 0) {
				System.out.println("Player1 turn");
				int dice = rand.nextInt(6) + 1; // dice number generator
				player1.count++;// counting the number of times dice was played
				int option = rand.nextInt(3) + 1; // option generator
				System.out.println("dice : " + dice);
				System.out.println("option : " + option);
				// checking out the options
				if (option == 1) 
				{
					System.out.println("NO Play, your position is same as before " + player1.position);
					turn = 1;
				} 
				else if (option == 2) 
				{
					player1.position = ladder(player1.position, dice);
					if (player1.position != 100) {
						System.out.println("again play as you got the ladder");
						turn = 0;
					}
				} 
				else 
				{
					player1.position = snakeBite(player1.position, dice);
					turn = 1;
				}
			}
			//turn 1 is for player2
			else 
			{
				System.out.println("Player2 turn");
				int dice = rand.nextInt(6) + 1; // dice number generator
				player2.count++;// counting the number of times dice was played
				int option = rand.nextInt(3) + 1; // option generator
				System.out.println("dice : " + dice);
				System.out.println("option : " + option);
				// checking out the options
				if (option == 1) 
				{
					System.out.println("NO Play, your position is same as before " + player2.position);
					turn = 0;
				} 
				else if (option == 2) 
				{
					player2.position = ladder(player2.position, dice);
					if (player2.position != 100) {
						System.out.println("again play as you got the ladder");
						turn = 1;
					}
				} 
				else 
				{
					player2.position = snakeBite(player2.position, dice);
					turn = 0;
				}
			}
		}
		// checking who has won
		if (player1.position == 100)
			System.out.println("player1 has won and number of dice rolls is" + player1.count);
		else
			System.out.println("player2 has won and number of dice rolls is" + player2.count);

	}

	// method for ladder
	public static int ladder(int spot, int dice) {
		int tempPosition = spot + dice;
		if (tempPosition > 100) // need exact 100 to win
		{
			System.out.println("You need to get exact 100 your current positon is same as before " + spot);
			return spot;
		} 
		else 
		{
			spot = tempPosition; // updating the position
			System.out.println("you got ladder, your current position is = " + spot);
			return spot;
		}
	}

	// method of snake bite in the game
	public static int snakeBite(int spot, int dice) {
		int tempPosition = spot - dice;
		if (tempPosition < 0) // if tempPosition is negative then you have to restart
		{
			spot = 0;
			System.out.println("you need to restart, current position is " + spot);
			return spot;
		} 
		else 
		{
			spot = tempPosition; // updating the position
			System.out.println("You got bitten by snake, your current position is =" + spot);
			return spot;
		}
	}
}