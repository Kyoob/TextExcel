
public class CellMatrix {
	
	private static final int ROWS = TextExcel.ROWS;
	private static final int COLUMNS = TextExcel.COLUMNS;
	private static final int WIDTH = TextExcel.WIDTH;
	private static Cell[][] cells = new Cell[ROWS][COLUMNS];
	private static CellMatrix instance;
	
	private CellMatrix() {
		for (int row = 0; row < ROWS; row++)
			for (int col = 0; col < COLUMNS; col++)
				if (row == 0 && col > 0)
					cells[row][col] = new Cell(getCol(col - 1));
				else if (col == 0 && row > 0)
					cells[row][col] = new Cell("" + (row));
				else
					cells[row][col] = new Cell();
	}
	
	public static CellMatrix getInstance() {
		if (instance == null)
			instance = new CellMatrix();
		return instance;
	}
	
	public Cell[][] getCells() {
		return cells;
	}
	
	private String getCol (int col) {
		return "" + (char)('A' + col);
	}
	
	public void setValue(int row, int col, String value, String original) throws Exception {
		cells[row][col] = CellParser.parseCell(value, original);
	}
	
	public String getValue(Cell c){
		return c.getDisplayValue();
	}
	
	public Cell getCell(String s) {
		int[] c = TextExcel.findCoords(s);
		return cells[c[0]][c[1]];
	}
	
	public void print() {
		System.out.println();
		for (int rows = 0; rows < ROWS; rows++) {
			for (int cols = 0; cols < COLUMNS; cols++) {
				cells[rows][cols].print();
				System.out.print("|");
			}
			System.out.println();
			for (int i = 0; i < COLUMNS; i++) {
				for (int j = 0; j < WIDTH; j++)
					System.out.print("-");
				System.out.print("+");
			}
			System.out.println();
		}
	}
	
	public void clear(String input) throws Exception {
		if (input.contains(" ")) {
			String[] tokens = input.split(" ");
			int[] value = TextExcel.findCoords(tokens[1]);
			cells[value[0]][value[1]].setDisplayValue(null);
		} else
			for (int x = 1; x < ROWS; x++)
				for (int y = 1; y < COLUMNS; y++)
					cells[x][y].setDisplayValue(null);
	}
	
}