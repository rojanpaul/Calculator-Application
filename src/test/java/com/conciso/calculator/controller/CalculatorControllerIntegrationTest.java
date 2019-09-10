package com.conciso.calculator.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.conciso.calculator.model.CalculatorSvcRequest;
import com.conciso.calculator.model.CalculatorSvcResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CalculatorControllerIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	/**
	 * Purpose : Integration test for add operation
	 * Expression evaluated : 299 + 92 + 448
	 * @throws Exception
	 */
	@Test
	public void additionOperationIntegrationTest() throws Exception {
		CalculatorSvcRequest calculatorSvcRequest = new CalculatorSvcRequest();
		ArrayList<Integer> operands = new ArrayList<Integer>();
		operands.add(299);
		operands.add(92);
		operands.add(448);
		calculatorSvcRequest.setOperands(operands);
		ResponseEntity<CalculatorSvcResponse> calculatorSvcResponseEntity = this.restTemplate.postForEntity(
				"http://localhost:" + port + "/calculatorservice/add", calculatorSvcRequest,
				CalculatorSvcResponse.class);
		CalculatorSvcResponse calculatorSvcResponse = calculatorSvcResponseEntity.getBody();
		System.out.println(calculatorSvcResponse.getResponseMessage());
		assertEquals("Result after performing + operation :-  299 + 92 + 448 = 839.0", calculatorSvcResponse.getResponseMessage());
	}
	

	/**
	 * Purpose : Integration test for subtract operation
	 * Expression evaluated : 902 -10 -4-33-94
	 * @throws Exception
	 */
	@Test
	public void subtractionOperationIntegrationTest() throws Exception {
		CalculatorSvcRequest calculatorSvcRequest = new CalculatorSvcRequest();
		ArrayList<Integer> operands = new ArrayList<Integer>();
		operands.add(902);
		operands.add(10);
		operands.add(4);
		operands.add(33);
		operands.add(94);
		calculatorSvcRequest.setOperands(operands);
		ResponseEntity<CalculatorSvcResponse> calculatorSvcResponseEntity = this.restTemplate.postForEntity(
				"http://localhost:" + port + "/calculatorservice/subtract", calculatorSvcRequest,
				CalculatorSvcResponse.class);
		CalculatorSvcResponse calculatorSvcResponse = calculatorSvcResponseEntity.getBody();
		System.out.println(calculatorSvcResponse.getResponseMessage());
		assertEquals("Result after performing - operation :-  902 - 10 - 4 - 33 - 94 = 761.0", calculatorSvcResponse.getResponseMessage());
	}
	
	/**
	 * Purpose : Integration test for multiply operation
	 * Expression evaluated : 20 * 321 * 45
	 * @throws Exception
	 */
	@Test
	public void multiplicationOperationIntegrationTest() throws Exception {
		CalculatorSvcRequest calculatorSvcRequest = new CalculatorSvcRequest();
		ArrayList<Integer> operands = new ArrayList<Integer>();
		operands.add(20);
		operands.add(321);
		operands.add(45);
		calculatorSvcRequest.setOperands(operands);
		ResponseEntity<CalculatorSvcResponse> calculatorSvcResponseEntity = this.restTemplate.postForEntity(
				"http://localhost:" + port + "/calculatorservice/multiply", calculatorSvcRequest,
				CalculatorSvcResponse.class);
		CalculatorSvcResponse calculatorSvcResponse = calculatorSvcResponseEntity.getBody();
		System.out.println(calculatorSvcResponse.getResponseMessage());
		assertEquals("Result after performing * operation :-  20 * 321 * 45 = 288900.0", calculatorSvcResponse.getResponseMessage());
	}

	/**
	 * Purpose : Integration test for divide operation
	 * Expression evaluated : 1200 / 23 / 4
	 * @throws Exception
	 */
	@Test
	public void divisionOperationIntegrationTest() throws Exception {
		CalculatorSvcRequest calculatorSvcRequest = new CalculatorSvcRequest();
		ArrayList<Integer> operands = new ArrayList<Integer>();
		operands.add(1200);
		operands.add(23);
		operands.add(4);
		calculatorSvcRequest.setOperands(operands);
		ResponseEntity<CalculatorSvcResponse> calculatorSvcResponseEntity = this.restTemplate.postForEntity(
				"http://localhost:" + port + "/calculatorservice/divide", calculatorSvcRequest,
				CalculatorSvcResponse.class);
		CalculatorSvcResponse calculatorSvcResponse = calculatorSvcResponseEntity.getBody();
		System.out.println(calculatorSvcResponse.getResponseMessage());
		assertEquals("Result after performing / operation :-  1200 / 23 / 4 = 13.043478260869565", calculatorSvcResponse.getResponseMessage());
	}

}
