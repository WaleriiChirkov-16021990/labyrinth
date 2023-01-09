package com.wch.Project;

import com.wch.Abstract.Fields;
import com.wch.Interface.Maze_able;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Random;

public class MazeField extends Fields implements Maze_able {

	private int[] start;
	private int[] exit;
	
	public MazeField(int row, int columns){
		super(row,columns);
	}
	
	public MazeField() {
		super();
	}
	
	@Override
	public void setRows(int rows) {
		super.setRows(rows);
	}
	
	@Override
	public void setColumns(int columns) {
		super.setColumns(columns);
	}
	
	@Override
	public void printField() {
		for (String[] a: super.getField()
		     ) {
			System.out.println(Arrays.toString(a));
		}
	}
	
	@Override
	public void fillGridField() {
		for (int i = 0; i < super.getField().length; i++) {
			for (int j = 0; j < super.getField()[0].length; j++) {
				super.getField()[i][j] = "#";
			}
		}
	}
	
	public int[] getStart() {
		return start;
	}
	
	public void setStart(int[] start) {
		this.start = start;
	}
	
	public int[] getExit() {
		return exit;
	}
	
	public void setExit(int[] exit) {
		this.exit = exit;
	}
	
	@Override
	public void setRNDStart() {
		Random random = new Random();
		start = new int[]{0, random.nextInt(super.getField()[0].length)};
		super.getField()[getStart()[0]][getStart()[1]] = "S";
	}
	
	@Override
	public void setRNDExit() {
		Random random = new Random();
		exit = new int[]{super.getField().length- 1, random.nextInt(super.getField()[0].length)};
		super.getField()[getExit()[0]][getExit()[1]] = "X";
	}
	
	@Override
	public int[][] getExitShortWay() {
		return new int[0][];
	}
	
	public void generateLabyrinth(int[] start, int[] exit) {
		Random random = new Random();
		int a = start[0];
		int b = start[1];
		int count = super.getField().length * super.getField()[0].length / 6;
		while (count > 0) {
//			if (a == exit[0] && b == exit[1] ) {
//				break;
//			}
			int[] ab = toGoRandom(a,b,random);
			super.getField()[a][b] = " ";
//			a = ab[0];
//			b = ab[1];
			a = random.nextInt(super.getField().length);
			b = random.nextInt(super.getField()[0].length);
			count--;
		}
	}
	
	private int @Nullable [] toGoRandom(int a, int b, Random random) {
		int direction;
		int distance ;
		int[][] figures;
		int figure;
//		int flag = 0;
		while (true){
			direction = random.nextInt(0,10);
			distance = random.nextInt(super.getField().length/5);
			figures  = new int[][]{{-distance,1},{1,distance},{distance,-1},{-1,-distance}};
			figure = random.nextInt(0,figures.length);
			if (direction == 0) {
				if (a-distance >= 0) {
					while (distance > 0) {
						a--;
						if (! isExit(a,b)) {
							super.getField()[a][b] = " ";
							distance--;
						} else return new int[]{a,b};
					}
					break;
				}
			} else if (direction == 1) {
				if ((a + figures[figure][0] >= 0 && a + figures[figure][0] < super.getField().length) &&
						(b + figures[figure][1] >= 0 && b + figures[figure][1] < super.getField()[0].length)) {
					while (distance > 0) {
						if (figure == 0) {
							a--;
							if (! isExit(a,b)) {
								super.getField()[a][b] = " ";
								distance--;
							} else return new int[]{a,b};
						} else if (figure == 1) {
							b++;
							if (! isExit(a,b)) {
								super.getField()[a][b] = " ";
								distance--;
							} else return new int[]{a,b};
						} else if (figure == 2) {
							a++;
							if (! isExit(a,b)) {
								super.getField()[a][b] = " ";
								distance--;
							} else return new int[]{a,b};
						} else if (figure == 3) {
							b--;
							if (! isExit(a,b)) {
								super.getField()[a][b] = " ";
								distance--;
							} else return new int[]{a,b};
						}
					}
					if (figure == 0) {
						b++;
						if (isExit(a,b)) {
							return new int[]{a,b};
						}
					} else if (figure == 1) {
						a++;
						if (isExit(a,b)) {
							return new int[]{a,b};
						}
					} else if (figure == 2) {
						b--;
						if (isExit(a,b)) {
							return new int[]{a,b};
						}
					} else {
						a--;
						if (isExit(a,b)) {
							return new int[]{a,b};
						}
					}
					break;
				}
			} else if (direction == 2 || direction == 8) {
				if (b+distance < super.getField()[0].length) {
					while (distance > 0) {
						b++;
						if (! isExit(a,b)) {
							super.getField()[a][b] = " ";
							distance--;
						} else return new int[]{a,b};
					}
					break;
				}
			} else if (direction == 3) {
				if ((a + figures[figure][0] >= 0 && a + figures[figure][0] < super.getField().length) &&
						(b + figures[figure][1] >= 0 && b + figures[figure][1] < super.getField()[0].length)) {
					while (distance > 0) {
						if (figure == 0) {
							a--;
							if (! isExit(a,b)) {
								super.getField()[a][b] = " ";
								distance--;
							} else return new int[]{a,b};
						} else if (figure == 1) {
							b++;
							if (! isExit(a,b)) {
								super.getField()[a][b] = " ";
								distance--;
							} else return new int[]{a,b};
						} else if (figure == 2) {
							a++;
							if (! isExit(a,b)) {
								super.getField()[a][b] = " ";
								distance--;
							} else return new int[]{a,b};
						} else {
							b--;
							if (! isExit(a,b)) {
								super.getField()[a][b] = " ";
								distance--;
							} else return new int[]{a,b};
						}
					}
					if (figure == 0) {
						b++;
						if (isExit(a,b)) {
							return new int[]{a,b};
						}
					} else if (figure == 1) {
						a++;
						if (isExit(a,b)) {
							return new int[]{a,b};
						}
					} else if (figure == 2) {
						b--;
						if (isExit(a,b)) {
							return new int[]{a,b};
						}
					} else {
						a--;
						if (isExit(a,b)) {
							return new int[]{a,b};
						}
					}
					break;
				}
			
			} else if (direction == 4 || direction == 9) {
				if (a+distance < super.getField().length) {
					while (distance > 0) {
						a++;
						if (! isExit(a,b)) {
							super.getField()[a][b] = " ";
							distance--;
						} else return new int[]{a,b};
					}
					break;
				}
			} else if (direction == 5) {
				if ((a + figures[figure][0] >= 0 && a + figures[figure][0] < super.getField().length) &&
						(b + figures[figure][1] >= 0 && b + figures[figure][1] < super.getField()[0].length)) {
					while (distance > 0) {
						if (figure == 0) {
							a--;
							if (! isExit(a,b)) {
								super.getField()[a][b] = " ";
								distance--;
							} else return new int[]{a,b};
						} else if (figure == 1) {
							b++;
							if (! isExit(a,b)) {
								super.getField()[a][b] = " ";
								distance--;
							} else return new int[]{a,b};
						} else if (figure == 2) {
							a++;
							if (! isExit(a,b)) {
								super.getField()[a][b] = " ";
								distance--;
							} else return new int[]{a,b};
						} else {
							b--;
							if (! isExit(a,b)) {
								super.getField()[a][b] = " ";
								distance--;
							} else return new int[]{a,b};
						}
					}
					if (figure == 0) {
						b++;
						if (isExit(a,b)) {
							return new int[]{a,b};
						}
					} else if (figure == 1) {
						a++;
						if (isExit(a,b)) {
							return new int[]{a,b};
						}
					} else if (figure == 2) {
						b--;
						if (isExit(a,b)) {
							return new int[]{a,b};
						}
					} else {
						a--;
						if (isExit(a,b)) {
							return new int[]{a,b};
						}
					}
					break;
				}
			
			} else if (direction == 6) {
				if (b-distance >= 0) {
					while (distance > 0) {
						b--;
						if (! isExit(a,b)) {
							super.getField()[a][b] = " ";
							distance--;
						} else return new int[]{a,b};
					}
					break;
				}
			} else if (direction == 7) {
				if ((a + figures[figure][0] >= 0 && a + figures[figure][0] < super.getField().length) &&
						(b + figures[figure][1] >= 0 && b + figures[figure][1] < super.getField()[0].length)) {
					while (distance > 0) {
						if (figure == 0) {
							a--;
							if (! isExit(a,b)) {
								super.getField()[a][b] = " ";
								distance--;
							} else return new int[]{a,b};
						} else if (figure == 1) {
							b++;
							if (! isExit(a,b)) {
								super.getField()[a][b] = " ";
								distance--;
							} else return new int[]{a,b};
						} else if (figure == 2) {
							a++;
							if (! isExit(a,b)) {
								super.getField()[a][b] = " ";
								distance--;
							} else return new int[]{a,b};
						} else {
							b--;
							if (! isExit(a,b)) {
								super.getField()[a][b] = " ";
								distance--;
							} else return new int[]{a,b};
						}
					}
					if (figure == 0) {
						b++;
						if (isExit(a,b)) {
							return new int[]{a,b};
						}
					} else if (figure == 1) {
						a++;
						if (isExit(a,b)) {
							return new int[]{a,b};
						}
					} else if (figure == 2) {
						b--;
						if (isExit(a,b)) {
							return new int[]{a,b};
						}
					} else {
						a--;
						if (isExit(a,b)) {
							return new int[]{a,b};
						}
					}
					break;
				}
			}
		}
		return new int[]{a,b};
	}
	
	private boolean isExit(int a, int b) {
		if (a == super.getField().length - 1) {
//			a == getExit()[0] && b == getExit()[1]
			return true;
		}
		return false;
	}
	
}
