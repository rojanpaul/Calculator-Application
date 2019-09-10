package com.conciso.calculator.model;

import java.util.ArrayList;

/**
 * Calculator Application output response is defined here
 * @author rojan
 *
 */

public class CalculatorSvcResponse {
	private String operationType;
	private String responseMessage;
	private boolean operationSuccess;
	private double actualResult;
	private ArrayList<String> errorList;
	
	
	public double getActualResult() {
		return actualResult;
	}

	public void setActualResult(double actualResult) {
		this.actualResult = actualResult;
	}

	public boolean isOperationSuccess() {
		return operationSuccess;
	}

	public void setOperationSuccess(boolean operationSuccess) {
		this.operationSuccess = operationSuccess;
	}

	public ArrayList<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(ArrayList<String> errorList) {
		this.errorList = errorList;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
