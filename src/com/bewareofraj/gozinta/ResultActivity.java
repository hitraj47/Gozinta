package com.bewareofraj.gozinta;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {
	
	public static final String EXTRA_TOTAL_KEY = "TOTAL_BILL";
	public static final String EXTRA_TIP_AMOUNT_KEY = "TIP_AMOUNT";
	public static final String EXTRA_TIP_PERCENTAGE_KEY = "TIP_PERCENTAGE";
	public static final String EXTRA_FINAL_TOTAL_KEY = "FINAL_TOTAL";
	public static final String EXTRA_NUMBER_OF_PEOPLE_KEY = "NUMBER_OF_PEOPLE";
	public static final String EXTRA_COST_PER_PERSON_KEY = "COST_PER_PERSON";
	public static final String EXTRA_QUALITY_KEY = "QUALITY";
	
	private float totalBill;
	private float tipAmount;
	private float tipPercentage;
	private float finalTotal;
	private int numberOfPeople;
	private float costPerPerson;
	private String quality;
	
	private TextView txtBillTotal;
	private TextView txtTipAmount;
	private TextView lblTipAmount;
	private TextView txtFinalTotal;
	private TextView lblCostPerPerson;
	private TextView txtCostPerPerson;
	private TextView txtQuality;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		Intent intent = getIntent();
		getValuesFromBundle(intent);
		
		initializeGUI();
		setTextViewValues();
		
	}

	private void initializeGUI() {
		txtBillTotal = (TextView) findViewById(R.id.txtBillTotal);
		txtTipAmount = (TextView) findViewById(R.id.txtTipAmount);
		lblTipAmount = (TextView) findViewById(R.id.lblTipAmount);
		txtFinalTotal = (TextView) findViewById(R.id.txtFinalTotal);
		lblCostPerPerson = (TextView) findViewById(R.id.lblCostPerPerson);
		txtCostPerPerson = (TextView) findViewById(R.id.txtCostPerPerson);
		txtQuality = (TextView) findViewById(R.id.txtQuality);
	}

	private void setTextViewValues() {
		DecimalFormat money = new DecimalFormat("$###.00");
		DecimalFormat percentage = new DecimalFormat("###%");
		
		txtBillTotal.setText(money.format(totalBill));
		txtTipAmount.setText(money.format(tipAmount));
		lblTipAmount.setText("Tip Amount (" + percentage.format(tipPercentage) + ")");
		txtFinalTotal.setText("Final total: " + money.format(finalTotal));
		lblCostPerPerson.setText("Cost per person (" + numberOfPeople + " people):");
		txtCostPerPerson.setText(money.format(costPerPerson));
		txtQuality.setText("Service quality: " + quality);
	}

	private void getValuesFromBundle(Intent intent) {
		totalBill = intent.getFloatExtra(EXTRA_TOTAL_KEY, 0f);
		tipAmount = intent.getFloatExtra(EXTRA_TIP_AMOUNT_KEY, 0f);
		tipPercentage = intent.getFloatExtra(EXTRA_TIP_PERCENTAGE_KEY, 0f);
		finalTotal = intent.getFloatExtra(EXTRA_FINAL_TOTAL_KEY, 0f);
		numberOfPeople = intent.getIntExtra(EXTRA_NUMBER_OF_PEOPLE_KEY, 0);
		costPerPerson = intent.getFloatExtra(EXTRA_COST_PER_PERSON_KEY, 0f);
		quality = intent.getStringExtra(EXTRA_QUALITY_KEY);
	}
}
