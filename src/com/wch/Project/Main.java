package com.wch.Project;

public class Main {
	public static void main(String[] args) {
		MazeField mazeField = new MazeField(40, 40);
		mazeField.fillGridField();
		mazeField.setRNDStart();
		mazeField.setRNDExit();
		mazeField.printField();
		mazeField.generateLabyrinth(mazeField.getStart(), mazeField.getExit());
		System.out.println();
		mazeField.printField();
		
	}
}