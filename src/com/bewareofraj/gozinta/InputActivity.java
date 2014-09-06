package com.bewareofraj.gozinta;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends Activity {

	private EditText txtAmount;
	private EditText txtPeople;
	private Button btnCalculate;
	
	private final static float TIP_PERCENT = 0.18f;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input);
		
		initializeGui();
	}

	private void initializeGui() {
		// initialize UI
		txtAmount = (EditText) findViewById(R.id.txtBill);
		txtPeople = (EditText) findViewById(R.id.txtNumberOfPeople);
		btnCalculate = (Button) findViewById(R.id.btnCalculate);
		btnCalculate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				calculate();
			}
		});
	}
	
	private void calculate() {
		float billTotal = Float.parseFloat(txtAmount.getText().toString());
		Log.v("goz", "Bill total: " + Float.toString(billTotal));
	}

}
