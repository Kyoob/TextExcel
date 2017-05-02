
public class CellMatrix {
	
	public static final int ROWS = 11;
	public static final int COLUMNS = 7;
	public static final int WIDTH = 12;
	private static Cell[][] cell = new Cell[ROWS][COLUMNS];
	private static CellMatrix instance;
	
	public static CellMatrix getInstance() {
		if (instance == null) {
			instance = new CellMatrix();
		}
		return instance;
	}
	
	public static Cell[][] getCelll() {
		return cell;
	}
	
	private CellMatrix() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				if (row == 0 && col > 0) {
					cell[row][col] = new Cell(getCol(col - 1));
				}
				else if (col == 0 && row > 0) {
					cell[row][col] = new Cell("" + (row));
				}
				else {
					cell[row][col] = new Cell();
				}
			}
		}
	}
	
	private String getCol (int col) {
		char c = 'A';
		c += col;
		return "" + c;
	}
	
	public void setValue(int rows, int cols, String value, String original) throws Exception {
		Cell c = CellParser.parseCell(value);
		cell[rows][cols] = c;
		c.originalValue = original;
	}
	
	public String getValue(Cell c){
		return c.value;
	}
	
	public Cell getCell(String s) {
		int[] c = TextExcel.findCoords(s);
		return cell[c[0]][c[1]];
	}
	
	public void print() {
		System.out.println();
		for (int rows = 0; rows < ROWS; rows++) {
			for (int cols = 0; cols < COLUMNS; cols++) {
				cell[rows][cols].print();
				System.out.print("|");
			}
			System.out.println();
			for (int i=0; i < COLUMNS; i++) {
				for (int j=0; j < WIDTH; j++) {
					System.out.print("-");
				}
				System.out.print("+");
			}
			System.out.println();
		}
	}
	
	public void clear(String input) throws Exception {
		if (input.contains(" ")) {
			String[] tokens = input.split(" ");
			int[] value = TextExcel.findCoords(tokens[1]);
			cell[value[0]][value[1]].value = null;
		} else {
			for (int x = 1; x < ROWS; x++) {
				for (int y = 1; y < COLUMNS; y++) {
					cell[x][y].value = null;
				}
			}
		}
	}
	
}