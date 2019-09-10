package com.conciso.calculator.model;

import java.util.ArrayList;
/**
 * Calculator Application input request is defined here
 * @author rojan
 *
 */
public class CalculatorSvcRequest {

	private String operationName;
	private ArrayList<Integer> operands = null;
	
	
	public ArrayList<Integer> getOperands() {
		return operands;
	}
	public void setOperands(ArrayList<Integer> operands) {
		this.operands = operands;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	
}
