package TextExcel;

import java.util.ArrayList;
import java.util.Scanner;

public class FormulaCell extends Cell {
	
    public FormulaCell(String value) {
    	CellMatrix cellmatrix = CellMatrix.getInstance();
    	if (value.contains("sum")) {
    		int minus = value.indexOf("-");
    		int startColumn = value.charAt(value.indexOf(value.substring(minus - 3, minus - 2))) - 'A';
    		int endColumn = value.charAt(value.indexOf(value.substring(minus + 2, minus + 3))) - 'A';
    		int startRow = Integer.parseInt(value.substring(minus - 2, minus - 1));
    		int endRow = Integer.parseInt(value.substring(minus + 3, minus + 4));
    		double total = 0;
    		Cell[][] cell = CellMatrix.getCells();
    		for (int i = 0; i < endRow; i ++) {
    			for (int k = 0; k < endColumn; k++)
    				total += Double.parseDouble(cellmatrix.getValue(cell[startColumn + i][startRow]));
    			total += Double.parseDouble(cellmatrix.getValue(cell[startColumn][startRow + i]));
    		}
    		displayValue = total + "";
    	} else if (value.contains("avg")) {
    		int minus = value.indexOf("-");
    		int startColumn = value.charAt(value.indexOf(value.substring(minus - 3, minus - 2))) - 'A';
    		int endColumn = value.charAt(value.indexOf(value.substring(minus + 2, minus + 3))) - 'A';
    		int startRow = Integer.parseInt(value.substring(minus - 2, minus - 1)) - 1;
    		int endRow = Integer.parseInt(value.substring(minus + 3, minus + 4)) - 1;
    		double total = 0;
    		int counter = 0;
    		Cell[][] cell = CellMatrix.getCells();
    		for (int i = 0; i < endRow; i ++) {
    			for (int k = 0; k < endColumn; k++) {
    				total += Double.parseDouble(cellmatrix.getValue(cell[startColumn + i][startRow]));
    				counter++;
    			}
    			total += Double.parseDouble(cellmatrix.getValue(cell[startColumn][startRow + i]));
    			counter++;
    		}
    		displayValue = total / counter + "";
    	}	// TODO Able to set one cell equal to another
    	displayValue = evaluate(parse(value)) + "";
    }
    
    public ArrayList<String> parse(String input) {
    	ArrayList<String> tokens = new ArrayList<String>();
		Scanner s = new Scanner(input);
		while (s.hasNext()) {
			String token = s.next();
			tokens.add(token);
		}
		tokens.remove(0);
		tokens.remove(tokens.size()-1);
		s.close();
		return tokens;
    }
    
    public double evaluate(ArrayList<String> tokens) {
    	CellMatrix cellmatrix = CellMatrix.getInstance();
    	ArrayList<String> outcome = new ArrayList<String>();
		int i = 0;
		while (i < tokens.size()) {
			if (tokens.get(i).equals("*")) {
				double left = Double.parseDouble(outcome.get(outcome.size() - 1));
				i++;
				double right = Double.parseDouble(tokens.get(i));
				outcome.set(outcome.size() - 1, Double.toString(left * right));
			} else if (tokens.get(i).equals("/")) {
				double left = Double.parseDouble(outcome.get(outcome.size() - 1));
				i++;
				double right = 1/Double.parseDouble(tokens.get(i));
				outcome.set(outcome.size() - 1, Double.toString(left * right));
			} else
				outcome.add(tokens.get(i));
			i++;
		}
		i = 0;
		while (outcome.size() > 1) {
			if (outcome.get(i).equals("+")) {
				double left = 0;
				try {
					left = Double.parseDouble(outcome.get(i - 1));
				} catch (NumberFormatException e) {
					Cell c = cellmatrix.getCell(outcome.get(i - 1));
					String inputValue = cellmatrix.getValue(c);
					left = Double.parseDouble(inputValue);
				}
				double right = 0;
				try {
					right = Double.parseDouble(outcome.get(i + 1));
				} catch (NumberFormatException e) {
					Cell c = cellmatrix.getCell(outcome.get(i + 1));
					String inputValue = cellmatrix.getValue(c);
					right = Double.parseDouble(inputValue);
				}
				outcome.set(i - 1, Double.toString(left  + right));
				outcome.remove(i);
				outcome.remove(i);
			} else if (outcome.get(i).equals("-")) {
				double left = Double.parseDouble(outcome.get(i - 1));
				double right = Double.parseDouble(outcome.get(i + 1));
				outcome.set(i - 1, Double.toString(left - right));
				outcome.remove(i);
				outcome.remove(i);
			} else
				i++;
		}
		return Double.parseDouble(outcome.get(0));
    }
	
}