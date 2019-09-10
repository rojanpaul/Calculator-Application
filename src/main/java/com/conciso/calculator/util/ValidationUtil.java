package com.conciso.calculator.util;

import java.util.ArrayList;

import com.conciso.calculator.model.CalculatorSvcRequest;
import com.conciso.calculator.model.CalculatorSvcResponse;

public class ValidationUtil {
	
	
	/**
	 * Purpose : Method for validating input request
	 * @param calculatorSvcRequest
	 * @param calculatorSvcResponse
	 * @return
	 */
	public static boolean validateInputRequest(CalculatorSvcRequest calculatorSvcRequest, 
			CalculatorSvcResponse calculatorSvcResponse) {
		ArrayList<String>  errorsList = new ArrayList<String>();
		if(null != calculatorSvcRequest) {
			if(null == calculatorSvcRequest.getOperands() || calculatorSvcRequest.getOperands().isEmpty()) {
				errorsList.add("Operands are missing");				
			}else {
				for (Integer operand:calculatorSvcRequest.getOperands()) {
					if(operand instanceof Integer) {
					}else {
						errorsList.add("All Operands are not Integers");
					}
				}
			}
		}else {
			errorsList.add("Service Request is empty");
		}
		calculatorSvcResponse.setErrorList(errorsList);
		return validateErrorList(calculatorSvcResponse);
	}
	
	/**
	 * Purpose : Method for validating input request
	 * @param calculatorSvcRequest
	 * @param calculatorSvcResponse 
	 * @return
	 */
	public static boolean validateInputRequestForDivMulti(CalculatorSvcRequest calculatorSvcRequest, 
			CalculatorSvcResponse calculatorSvcResponse) {		
		if(validateInputRequest(calculatorSvcRequest, calculatorSvcResponse)) {
			for (Integer operand:calculatorSvcRequest.getOperands()) {
				if(operand == 0) {
					calculatorSvcResponse.getErrorList().add("One of the operands is Zero (0).");
				}
			}
		}	
		return validateErrorList(calculatorSvcResponse);
	}
	
	/**
	 * Purpose : Method for validating error list set 
	 * @param calculatorSvcResponse
	 * @return
	 */
	private static boolean validateErrorList(CalculatorSvcResponse calculatorSvcResponse) {
		if(calculatorSvcResponse.getErrorList().size() == 0) {
			calculatorSvcResponse.setOperationSuccess(true);
			return true;
		}else {
			calculatorSvcResponse.setOperationSuccess(false);
			return false;
		}			
	}
}
