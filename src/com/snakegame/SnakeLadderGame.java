package com.snakegame;

import java.util.Random;

public class SnakeLadderGame {
public static void main(String args[]) {
	System.out.println("Snake and ladder game simulator");
	//variables and objects
	int position=0;
	Random rand=new Random();
	//computation
	int dice=rand.nextInt(6)+1;
	System.out.println(dice);
	
}
}
