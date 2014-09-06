package com.bewareofraj.gozinta;

import android.app.Activity;
import android.os.Bundle;

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		getValuesFromBundle(savedInstanceState);
		
	}

	private void getValuesFromBundle(Bundle savedInstanceState) {
		totalBill = savedInstanceState.getFloat(EXTRA_TOTAL_KEY);
		tipAmount = savedInstanceState.getFloat(EXTRA_TIP_AMOUNT_KEY);
		tipPercentage = savedInstanceState.getFloat(EXTRA_TIP_PERCENTAGE_KEY);
		finalTotal = savedInstanceState.getFloat(EXTRA_FINAL_TOTAL_KEY);
		numberOfPeople = savedInstanceState.getInt(EXTRA_NUMBER_OF_PEOPLE_KEY);
		costPerPerson = savedInstanceState.getFloat(EXTRA_COST_PER_PERSON_KEY);
	}
}
