package com.bewareofraj.gozinta;

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
	
	private float totalBill;
	private float tipAmount;
	private float tipPercentage;
	private float finalTotal;
	private int numberOfPeople;
	private float costPerPerson;
	
	private TextView txtBillTotal;
	private TextView txtTipAmount;
	private TextView lblTipAmount;
	private TextView txtFinalTotal;
	private TextView lblCostPerPerson;
	private TextView txtCostPerPerson;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		Intent intent = getIntent();
		getValuesFromBundle(intent);
		setTextViewValues();
		
	}

	private void setTextViewValues() {
		
	}

	private void getValuesFromBundle(Intent intent) {
		totalBill = intent.getFloatExtra(EXTRA_FINAL_TOTAL_KEY, 0f);
		tipAmount = intent.getFloatExtra(EXTRA_TIP_AMOUNT_KEY, 0f);
		tipPercentage = intent.getFloatExtra(EXTRA_TIP_PERCENTAGE_KEY, 0f);
		finalTotal = intent.getFloatExtra(EXTRA_FINAL_TOTAL_KEY, 0f);
		numberOfPeople = intent.getIntExtra(EXTRA_NUMBER_OF_PEOPLE_KEY, 0);
		costPerPerson = intent.getFloatExtra(EXTRA_COST_PER_PERSON_KEY, 0f);
	}
}
