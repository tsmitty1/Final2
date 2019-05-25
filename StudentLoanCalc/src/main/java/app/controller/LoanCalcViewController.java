package app.controller;

import app.StudentCalc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

import org.apache.poi.ss.formula.functions.*;

public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;
	
	@FXML
	private TextField interestRate;
	
	@FXML
	private TextField NbrOfYears;
	
	@FXML
	private TextField additionalPayment;
	
	@FXML
	private Label lblTotalPayment;
	
	@FXML
	private Label lbltotalInterest;
	
	@FXML
	private DatePicker PaymentStartDate;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {

		System.out.println("Amount: " + LoanAmount.getText());
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		System.out.println("Amount: " + dLoanAmount);	
		
		double dInterestRate = Double.parseDouble(interestRate.getText());
		double dNbrOfYears = Double.parseDouble(NbrOfYears.getText());
		double dAdditionalPayment = Double.parseDouble(additionalPayment.getText());
		
		lblTotalPayment.setText(Double.toString(LoanCalulations(dLoanAmount, dInterestRate, dNbrOfYears)));
		lbltotalInterest.setText(Double.toString(LoanCalulations(dLoanAmount, dInterestRate, dNbrOfYears) - dLoanAmount));
		
		LocalDate localDate = PaymentStartDate.getValue();
	 
		System.out.println(localDate);
	}
	
	@FXML
	private double LoanCalulations(double loanAmount, double interestRate, double nbrOfYears) {
		
		double totalPay = FinanceLib.pmt(interestRate, nbrOfYears, loanAmount, 0, false);
		return totalPay;
		
	}
}