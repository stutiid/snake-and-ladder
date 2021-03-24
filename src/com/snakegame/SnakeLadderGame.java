package com.snakegame;

import java.util.Random;

public class SnakeLadderGame {
	// instance variables
	int position = 0;
	int count = 0;

	// static variables common for whole class
	static int dice;
	static int option;

	// computation for getting ladder in the game
	public void ladder() {
		int tempPosition = this.position + dice;
		if (tempPosition > 100) // need exact 100 to win
		{
			System.out.println("You need to get exact 100 your current positon is same as before " + this.position);
		} else {
			this.position = tempPosition; // updating the position
			System.out.println("you got ladder, your current position is = " + this.position);
		}
	}

	// method of snake bite in the game
	public void snakeBite() {
		int tempPosition = this.position - dice;
		if (tempPosition < 0) // if tempPosition is negative then you have to restart
		{
			this.position = 0;
			System.out.println("you need to restart, current position is " + this.position);
		} else {
			this.position = tempPosition; // updating the position
			System.out.println("You got bitten by snake, your current position is =" + this.position);
		}
	}

	// main method
	public static void main(String args[]) {
		System.out.println("Welcome to snake ladder game simulator");

		// objects and variables
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
				diceAndOptionGenerator();
				player1.count++;// counting the number of times dice was played
				// checking out the options
				if (SnakeLadderGame.option == 1) {
					System.out.println("NO Play, your position is same as before " + player1.position);
					turn = 1;
				} else if (SnakeLadderGame.option == 2) {
					player1.ladder();
					if (player1.position != 100) {
						System.out.println("again play as you got the ladder");
						turn = 0;
					}
				} else {
					player1.snakeBite();
					turn = 1;
				}
			}
			// turn 1 is for player2
			else {
				System.out.println("Player2 turn");
				diceAndOptionGenerator();
				player2.count++;
				// checking out the options
				if (SnakeLadderGame.option == 1) {
					System.out.println("NO Play, your position is same as before " + player2.position);
					turn = 0;
				} else if (SnakeLadderGame.option == 2) {
					player2.ladder();
					if (player2.position != 100) {
						System.out.println("again play as you got the ladder");
						turn = 1;
					}
				} else {
					player2.snakeBite();
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

	// method to generate dice and options randomly
	public static void diceAndOptionGenerator() {
		Random rand = new Random();
		dice = rand.nextInt(6) + 1; // dice number generator
		option = rand.nextInt(3) + 1; // option generator
		System.out.println("dice : " + dice);
		System.out.println("option : " + option);
	}
}