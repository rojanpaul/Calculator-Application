package com.conciso.calculator.util;

import com.conciso.calculator.model.CalculatorSvcResponse;

public class ResponseMsgFormatterUtil {
	
	/**
	 * Purpose : For formatting and setting the calculator App Success response
	 * @param msg
	 * @param operationType
	 * @return
	 */
	public static CalculatorSvcResponse formatResponseMsgForCalcSvc(String msg,String operationType,CalculatorSvcResponse calculatorSvcResponse) {
		//To do extra formatting if any
		calculatorSvcResponse.setResponseMessage(msg);
		calculatorSvcResponse.setOperationType(operationType);
		calculatorSvcResponse.setOperationSuccess(true);
		return calculatorSvcResponse;
	}
	
	/**
	 * Purpose : For formatting and setting the calculator App Error response
	 * @param msg
	 * @param operationType
	 * @return
	 */
	public static CalculatorSvcResponse formatResponseMsgForCalcSvcError(CalculatorSvcResponse calculatorSvcResponse) {
		//To do extra formatting if any
		return calculatorSvcResponse;
	}
}
