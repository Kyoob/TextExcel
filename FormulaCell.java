
public class FormulaCell extends Cell {
	
    public FormulaCell(String value, String original, boolean notUpdated) {
		setOriginalValue(original);
		original = original.replace(" ", "").substring(original.indexOf('='));
		switch (original.substring(0, original.indexOf('('))) {
			case ("sum"):
				displayValue = sum(original.substring(original.indexOf('(')), notUpdated)[0] + "";
				break;
			case ("avg"):
			case ("average"):
				displayValue = avg(original.substring(original.indexOf('(')), notUpdated) + "";
				break;
			case ("cat"):
				displayValue = cat(original.substring(original.indexOf('(')));
				break;
			default:
				int[] referenceCell = CellParser.findCoords(original.substring(original.indexOf('(') + 1, original.indexOf(')')));
				if (value.charAt(1) == getOriginalValue().charAt(0) && value.charAt(2) == getOriginalValue().charAt(1))
					System.err.println("Warning: self reference\n");
				displayValue = CellMatrix.getInstance().getValue(CellMatrix.getInstance().getCells()[referenceCell[0]][referenceCell[1]]) + "";;
				break;
		}
    }
    
    private double[] sum(String range, boolean notUpdated) {
    	int sum = 0;
    	int cellNum = 0;
    	int wrongCellNum = 0;
    	Cell[][] cells = CellMatrix.getInstance().getCells();
    	int[][] cellRange = cellRange(range);
    	for (int row = cellRange[0][0]; row <= cellRange[1][0]; ++row)
    		for (int col = cellRange[0][1]; col <= cellRange[1][1]; ++col)
    			if (cells[row][col] instanceof DoubleCell || cells[row][col] instanceof FormulaCell) {
    				++cellNum;
    				sum += Double.parseDouble(cells[row][col].getDisplayValue());
    			} else
    				++wrongCellNum;
    	if (cellNum == 0 && notUpdated)
    		System.err.println("No number cells detected in range.");
    	else if (wrongCellNum > 0 && notUpdated)
    		System.err.println(wrongCellNum + " of " + (cellNum + wrongCellNum) + " cells in range non-number cells, ignored.\n");
    	notUpdated = false;
    	return new double[] {sum, cellNum};
    }
    
    private double avg(String range, boolean notUpdated) {
    	double[] sum = sum(range, notUpdated);
    	return sum[1] > 0 ? sum[0] / sum[1] : sum[0];
    }
    
    private String cat(String range) {
    	String cat = "";
    	Cell[][] cells = CellMatrix.getInstance().getCells();
    	int[][] cellRange = cellRange(range);
    	for (int row = cellRange[0][0]; row <= cellRange[1][0]; ++row)
    		for (int col = cellRange[0][1]; col <= cellRange[1][1]; ++col)
    				cat = cells[row][col].getDisplayValue() != null ? cat.concat(cells[row][col].getDisplayValue()) : cat;
    	return cat;
    }
    
    private int[][] cellRange(String range) {
    	String[] tokens = range.replace("(", "").replace(")", "").split("-");
    	return new int[][] {CellParser.findCoords(tokens[0]), CellParser.findCoords(tokens[1])};
    }
    
}