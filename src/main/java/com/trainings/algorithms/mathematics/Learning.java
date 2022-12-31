package com.trainings.algorithms.mathematics;

import java.awt.Color;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;

public class Learning {
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
		
	}

}

class Game {
	
	private List<Ball> ballsList = new Vector<>();

	private Set<Ball> balls = new HashSet<>();
	{
		Ball ball = new Ball();
		ball.setPositionX(2);
		balls.add(ball);
	}
	
	private Map<Color, Ball> colorBallMap = new HashMap<>();
	
	public void start() {
		
		
		System.out.println("Starting the game.");
		
		System.out.printf("List with size %d.", ballsList.size());
		
		
		Ball ball = new Ball();
		balls.add(ball);
		balls.add(ball);
		balls.add(ball);
		balls.add(ball);
		balls.add(ball);
		balls.add(ball);
		
		for (Ball ballX : balls) {
			colorBallMap.put(ballX.getColor(), ballX);
		}
		
		Set<Color> keySet = colorBallMap.keySet();
		
		for (Color color : keySet) {
			Ball ballY = colorBallMap.get(color);
			ballY.getColor();
		}
		
		
		System.out.printf("Different balls with size %d.",balls.size());
		
		ball.printBallPosition();
		
		ball.bounce();
		
		ball.printBallPosition();
		
		ball.draw();
	}
	
}

class Ball {
	private int positionX = 0;
	private int positionY = 0;
	private Color color = Color.GREEN;
	
	public void bounce() {
		positionX += 10;
	}
	
	public void printBallPosition() {
		System.out.printf("Ball position is x %d, y %d \n", positionX, positionY);
	}
	
	public void draw() {
		System.out.println("o");
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, positionX, positionY);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ball other = (Ball) obj;
		return Objects.equals(color, other.color) && positionX == other.positionX && positionY == other.positionY;
	}
	
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}

