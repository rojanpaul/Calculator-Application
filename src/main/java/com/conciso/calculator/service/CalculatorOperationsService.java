package com.conciso.calculator.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.conciso.calculator.model.CalculatorSvcRequest;
import com.conciso.calculator.model.CalculatorSvcResponse;
import com.conciso.calculator.util.ResponseMsgFormatterUtil;

/**
 * Calculator Application actual mathematical operations are defined here
 * 
 * @author rojan
 *
 */

@Service
public class CalculatorOperationsService {

	// Operation Constants
	private static final String ADDITION = "+";
	private static final String SUBTRACTION = "-";
	private static final String MULTIPLICATION = "*";
	private static final String DIVISION = "/";

	// Logger constant
	private static final Logger logger = LoggerFactory.getLogger(CalculatorOperationsService.class);

	/**
	 * Purpose : Performing ADDITION operation
	 * 
	 * @param calculatorSvcRequest
	 * @return
	 */
	public CalculatorSvcResponse add(CalculatorSvcRequest calculatorSvcRequest,
			CalculatorSvcResponse calculatorSvcResponse) {
		calculatorSvcRequest.setOperationName(ADDITION);
		double sum = 0;
		for (Integer operand : calculatorSvcRequest.getOperands()) {
			sum = sum + operand;
		}
		calculatorSvcResponse.setActualResult(sum);
		logger.info("Successfully completed ADDITION operation...! : ");
		return ResponseMsgFormatterUtil.formatResponseMsgForCalcSvc(performOperation(calculatorSvcRequest, calculatorSvcResponse),
				ADDITION,calculatorSvcResponse);
	}

	/**
	 * Purpose : Performing SUBTRACTION operation
	 * 
	 * @param calculatorSvcRequest
	 * @return
	 */
	public CalculatorSvcResponse subtract(CalculatorSvcRequest calculatorSvcRequest,
			CalculatorSvcResponse calculatorSvcResponse) {
		calculatorSvcRequest.setOperationName(SUBTRACTION);
		double difference = calculatorSvcRequest.getOperands().get(0);
		ArrayList<Integer> operands = new ArrayList<Integer>();
		operands.addAll(calculatorSvcRequest.getOperands());
		operands.remove(0);
		for (Integer operand : operands) {
			difference = difference - operand;
		}
		calculatorSvcResponse.setActualResult(difference);
		logger.info("Successfully completed SUBTRACTION operation...! : ");
		return ResponseMsgFormatterUtil.formatResponseMsgForCalcSvc(performOperation(calculatorSvcRequest, calculatorSvcResponse),
				SUBTRACTION,calculatorSvcResponse);
	}

	/**
	 * Purpose : Performing MULTIPLICATION operation
	 * 
	 * @param calculatorSvcRequest
	 * @return
	 */
	public CalculatorSvcResponse multiply(CalculatorSvcRequest calculatorSvcRequest,
			CalculatorSvcResponse calculatorSvcResponse) {
		calculatorSvcRequest.setOperationName(MULTIPLICATION);
		double result = 1;
		for (Integer operand : calculatorSvcRequest.getOperands()) {
			result = result * operand;
		}
		calculatorSvcResponse.setActualResult(result);
		logger.info("Successfully completed MULTIPLICATION operation...! : ");
		return ResponseMsgFormatterUtil.formatResponseMsgForCalcSvc(performOperation(calculatorSvcRequest, calculatorSvcResponse),
				MULTIPLICATION,calculatorSvcResponse);
	}

	/**
	 * Purpose : Performing DIVISION operation
	 * 
	 * @param calculatorSvcRequest
	 * @return
	 */
	public CalculatorSvcResponse divide(CalculatorSvcRequest calculatorSvcRequest,
			CalculatorSvcResponse calculatorSvcResponse) {
		calculatorSvcRequest.setOperationName(DIVISION);
		double result = calculatorSvcRequest.getOperands().get(0);
		ArrayList<Integer> operands = new ArrayList<Integer>();
		operands.addAll(calculatorSvcRequest.getOperands());
		operands.remove(0);
		for (Integer operand : operands) {
			if (operand != 0)
				result = result / operand;
		}
		calculatorSvcResponse.setActualResult(result);
		logger.info("Successfully completed DIVISION operation...! : ");
		return ResponseMsgFormatterUtil.formatResponseMsgForCalcSvc(performOperation(calculatorSvcRequest, calculatorSvcResponse),
				DIVISION,calculatorSvcResponse);
	}

	/**
	 * Purpose : For creating the response message syntax
	 * 
	 * @param calculatorSvcRequest
	 * @return
	 */
	private static String performOperation(CalculatorSvcRequest calculatorSvcRequest, CalculatorSvcResponse calculatorSvcResponse) {
		int count = 0;
		StringBuilder respMsg = new StringBuilder(
				"Result after performing " + calculatorSvcRequest.getOperationName() + " operation :- ");
		for (Integer operand : calculatorSvcRequest.getOperands()) {
			respMsg.append(" ");
			respMsg.append(operand);
			respMsg.append(" ");
			if (count == calculatorSvcRequest.getOperands().size() - 1) {
				respMsg.append("=");
				respMsg.append(" ");
				respMsg.append(calculatorSvcResponse.getActualResult());
			} else {
				respMsg.append(calculatorSvcRequest.getOperationName());
			}
			count++;
		}
		return respMsg.toString();
	}
}
