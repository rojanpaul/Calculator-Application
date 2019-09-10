package com.conciso.calculator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conciso.calculator.exception.OperationNotFoundException;
import com.conciso.calculator.model.CalculatorSvcRequest;
import com.conciso.calculator.model.CalculatorSvcResponse;
import com.conciso.calculator.service.CalculatorOperationsService;
import com.conciso.calculator.util.ResponseMsgFormatterUtil;
import com.conciso.calculator.util.ValidationUtil;

/**
 * Calculator REST APIs are defined here
 * 
 * @author rojan
 *
 */
@RestController
@RequestMapping("/calculatorservice")
public class CalculatorController {

	// Class responsible for performing actual mathematical operation
	@Autowired
	private CalculatorOperationsService calculatorOperationsService;

	// Logger constant for logging details
	private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

	/**
	 * Purpose : REST API for Performing ADDITION operation
	 * 
	 * @param calculatorSvcRequest
	 * @return
	 */
	@PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
	public ResponseEntity<CalculatorSvcResponse> additionOperationSvc(
			@RequestBody CalculatorSvcRequest calculatorSvcRequest) {
		logger.info("...Performing addition operation...");
		CalculatorSvcResponse calculatorSvcResponse = new CalculatorSvcResponse();
		if (ValidationUtil.validateInputRequest(calculatorSvcRequest, calculatorSvcResponse)) {
			return new ResponseEntity(calculatorOperationsService.add(calculatorSvcRequest, calculatorSvcResponse),
					HttpStatus.OK);
		} else {
			return new ResponseEntity(ResponseMsgFormatterUtil.formatResponseMsgForCalcSvcError(calculatorSvcResponse),
					HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Purpose : REST API for Performing SUBTRACTION operation
	 * 
	 * @param calculatorSvcRequest
	 * @return
	 */
	@PostMapping(value = "/subtract", produces = "application/json", consumes = "application/json")
	public ResponseEntity<CalculatorSvcResponse> subtractOperationSvc(
			@RequestBody CalculatorSvcRequest calculatorSvcRequest) {
		logger.info("...Performing subtraction operation...");
		CalculatorSvcResponse calculatorSvcResponse = new CalculatorSvcResponse();
		if (ValidationUtil.validateInputRequest(calculatorSvcRequest, calculatorSvcResponse)) {
			return new ResponseEntity(calculatorOperationsService.subtract(calculatorSvcRequest, calculatorSvcResponse),
					HttpStatus.OK);
		} else {
			return new ResponseEntity(ResponseMsgFormatterUtil.formatResponseMsgForCalcSvcError(calculatorSvcResponse),
					HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Purpose : REST API for Performing MUTLIPLICATION operation
	 * 
	 * @param calculatorSvcRequest
	 * @return
	 */
	@PostMapping(value = "/multiply", produces = "application/json", consumes = "application/json")
	public ResponseEntity<CalculatorSvcResponse> multiplyOperationSvc(
			@RequestBody CalculatorSvcRequest calculatorSvcRequest) {
		logger.info("...Performing multiplication operation...");
		CalculatorSvcResponse calculatorSvcResponse = new CalculatorSvcResponse();
		if (ValidationUtil.validateInputRequestForDivMulti(calculatorSvcRequest, calculatorSvcResponse)) {
			return new ResponseEntity(calculatorOperationsService.multiply(calculatorSvcRequest, calculatorSvcResponse),
					HttpStatus.OK);
		} else {
			return new ResponseEntity(ResponseMsgFormatterUtil.formatResponseMsgForCalcSvcError(calculatorSvcResponse),
					HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Purpose : REST API for Performing DIVISION operation
	 * 
	 * @param calculatorSvcRequest
	 * @return
	 */
	@PostMapping(value = "/divide", produces = "application/json", consumes = "application/json")
	public ResponseEntity<CalculatorSvcResponse> divideOperationSvc(
			@RequestBody CalculatorSvcRequest calculatorSvcRequest) {
		logger.info("...Performing division operation...");
		CalculatorSvcResponse calculatorSvcResponse = new CalculatorSvcResponse();
		if (ValidationUtil.validateInputRequestForDivMulti(calculatorSvcRequest, calculatorSvcResponse)) {
			return new ResponseEntity(calculatorOperationsService.divide(calculatorSvcRequest, calculatorSvcResponse),
					HttpStatus.OK);
		} else {
			return new ResponseEntity(ResponseMsgFormatterUtil.formatResponseMsgForCalcSvcError(calculatorSvcResponse),
					HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Purpose : For handling all other exceptions that are occurring in this
	 * controller
	 */
	@ExceptionHandler({ OperationNotFoundException.class })
	public void handleException() {
		logger.error("Exception Occured. Please check detailed log");
	}
}
