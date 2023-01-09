package com.wch.Abstract;

public abstract class Fields {
	private int rows;
	private int columns;
	private String[][] field = new String[rows][columns];
	private int[] start;
	private int[] exit;
	protected abstract void printField();
	
	public Fields(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.field = new String[rows+2][columns+2];
	}
	
	public Fields() {
	}
	
	public int getRows() {
		return rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public String[][] getField() {
		return field;
	}
	
	public void setField(String[][] field) {
		this.field = field;
	}
}
