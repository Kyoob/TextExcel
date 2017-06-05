
public class FormulaCell extends Cell {
	
    public FormulaCell(String value, String original, boolean notUpdated) {
		setOriginalValue(original);
		if (original.contains("sum") || original.contains("avg"))
			if (original.contains("sum"))
				displayValue = sum(original.substring(original.indexOf('m') + 1), notUpdated)[0] + "";
			else
				displayValue = avg(original.substring(original.indexOf('g') + 1), notUpdated) + "";
		else {
	    	int[] referenceCell = TextExcel.findCoords(original.substring(original.indexOf('(') + 1, original.indexOf(')')));
	    	if (value.charAt(1) == original.charAt(0) && value.charAt(2) == original.charAt(1))
	    		System.err.println("Warning: self reference\n");
	    	displayValue = CellMatrix.getInstance().getValue(CellMatrix.getInstance().getCells()[referenceCell[0]][referenceCell[1]]) + "";
		}
    }
    
    public double[] sum(String range, boolean notUpdated) {
    	int sum = 0;
    	int cellNum = 0;
    	int wrongCellNum = 0;
    	CellMatrix instance = CellMatrix.getInstance();
    	Cell[][] cells = instance.getCells();
    	String[] tokens = range.replace(" ", "").replace("(", "").replace(")", "").split("-");
    	int[] cell1 = TextExcel.findCoords(tokens[0]);
    	int[] cell2 = TextExcel.findCoords(tokens[1]);
    	for (int row = cell1[0]; row <= cell2[0]; ++row)
    		for (int col = cell1[1]; col <= cell2[1]; ++col) {
    			++cellNum;
    			if (cells[row][col] instanceof DoubleCell || cells[row][col] instanceof FormulaCell)
    				sum += Double.parseDouble(cells[row][col].getDisplayValue());
    			else
    				++wrongCellNum;
    		}
    	if (cellNum == 0 && notUpdated)
    		System.err.println("No number cells detected in range.");
    	else if (wrongCellNum > 0 && notUpdated)
    		System.err.println(wrongCellNum + " of " + cellNum + " cells in range non-number cells, ignored.\n");
    	notUpdated = false;
    	return new double[] {sum, cellNum};
    }
    
    public double avg(String range, boolean notUpdated) {
    	double[] sum = sum(range, notUpdated);
    	if (sum[1] > 0)
    		return sum[0] / sum[1];
    	return sum[0];
    }
}