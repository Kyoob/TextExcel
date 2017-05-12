
import java.util.ArrayList;
import java.util.Scanner;

public class FormulaCell extends Cell {
	
    public FormulaCell(String value, String original) {
		setOriginalValue(original);
//    	CellMatrix cellmatrix = CellMatrix.getInstance();
//    	if (value.contains("sum")) {
//    		int minus = value.indexOf("-");
//    		int startColumn = value.charAt(value.indexOf(value.substring(minus - 3, minus - 2))) - 'A';
//    		int endColumn = value.charAt(value.indexOf(value.substring(minus + 2, minus + 3))) - 'A';
//    		int startRow = Integer.parseInt(value.substring(minus - 2, minus - 1));
//    		int endRow = Integer.parseInt(value.substring(minus + 3, minus + 4));
//    		double total = 0;
//    		Cell[][] cells = CellMatrix.getCells();
//    		for (int i = 0; i < endRow; i++) {
//    			for (int k = 0; k < endColumn; k++)
//    				total += Double.parseDouble(cellmatrix.getValue(cells[startColumn + i][startRow]));
//    			total += Double.parseDouble(cellmatrix.getValue(cells[startColumn][startRow + i]));
//    		}
//    		displayValue = total + "";
//    	} else if (value.contains("avg")) {
//    		int minus = value.indexOf("-");
//    		int startColumn = value.charAt(value.indexOf(value.substring(minus - 3, minus - 2))) - 'A';
//    		int endColumn = value.charAt(value.indexOf(value.substring(minus + 2, minus + 3))) - 'A';
//    		int startRow = Integer.parseInt(value.substring(minus - 2, minus - 1)) - 1;
//    		int endRow = Integer.parseInt(value.substring(minus + 3, minus + 4)) - 1;
//    		double total = 0;
//    		int counter = 0;
//    		Cell[][] cell = CellMatrix.getCells();
//    		for (int i = 0; i < endRow; i++) {
//    			for (int j = 0; j < endColumn; j++) {
//    				total += Double.parseDouble(cellmatrix.getValue(cell[startColumn + i][startRow]));
//    				counter++;
//    			}
//    			total += Double.parseDouble(cellmatrix.getValue(cell[startColumn][startRow + i]));
//    			counter++;
//    		}
//    		displayValue = total / counter + "";
//    	}
//    	displayValue = evaluate(parse(value)) + "";
    	int[] cell = TextExcel.findCoords(value.substring(1,3));
    	if (value.charAt(1) == original.charAt(0) && value.charAt(2) == original.charAt(1))
    		System.err.println("Warning: self reference");
    	displayValue = CellMatrix.getInstance().getValue(CellMatrix.getInstance().getCells()[cell[0]][cell[1]]) + "";
    }
    
//    public ArrayList<String> parse(String input) {
//    	ArrayList<String> tokens = new ArrayList<String>();
//		Scanner s = new Scanner(input);
//		while (s.hasNext()) {
//			String token = s.next();
//			tokens.add(token);
//		}
//		tokens.remove(0);
//		tokens.remove(tokens.size() - 1);
//		s.close();
//		return tokens;
//    }
//    
//    public double evaluate(ArrayList<String> tokens) {
//    	CellMatrix cellmatrix = CellMatrix.getInstance();
//    	ArrayList<String> outcome = new ArrayList<String>();
//		int i = 0;
//		while (i < tokens.size()) {
//			if (tokens.get(i).equals("*")) {
//				double left = Double.parseDouble(outcome.get(outcome.size() - 1));
//				i++;
//				double right = Double.parseDouble(tokens.get(i));
//				outcome.set(outcome.size() - 1, Double.toString(left * right));
//			} else if (tokens.get(i).equals("/")) {
//				double left = Double.parseDouble(outcome.get(outcome.size() - 1));
//				i++;
//				double right = 1/Double.parseDouble(tokens.get(i));
//				outcome.set(outcome.size() - 1, Double.toString(left * right));
//			} else
//				outcome.add(tokens.get(i));
//			i++;
//		}
//		i = 0;
//		while (outcome.size() > 1) {
//			if (outcome.get(i).equals("+")) {
//				double left = 0;
//				try {
//					left = Double.parseDouble(outcome.get(i - 1));
//				} catch (NumberFormatException e) {
//					Cell c = cellmatrix.getCell(outcome.get(i - 1));
//					String inputValue = cellmatrix.getValue(c);
//					left = Double.parseDouble(inputValue);
//				}
//				double right = 0;
//				try {
//					right = Double.parseDouble(outcome.get(i + 1));
//				} catch (NumberFormatException e) {
//					Cell c = cellmatrix.getCell(outcome.get(i + 1));
//					String inputValue = cellmatrix.getValue(c);
//					right = Double.parseDouble(inputValue);
//				}
//				outcome.set(i - 1, Double.toString(left  + right));
//				outcome.remove(i);
//				outcome.remove(i);
//			} else if (outcome.get(i).equals("-")) {
//				double left = Double.parseDouble(outcome.get(i - 1));
//				double right = Double.parseDouble(outcome.get(i + 1));
//				outcome.set(i - 1, Double.toString(left - right));
//				outcome.remove(i);
//				outcome.remove(i);
//			} else
//				i++;
//		}
//		return Double.parseDouble(outcome.get(0));
//    }
    
    public double sum() {
    	return 0;
    }
    
    public double avg() {
    	return 0;
    }
}