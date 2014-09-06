package com.bewareofraj.gozinta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends Activity {

	private EditText txtAmount;
	private EditText txtPeople;
	private Button btnCalculate;

	private final float TIP_PERCENT = 0.18f;

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
				if (!fieldsBlank()) {
					calculate();
				} else {
					Toast toast = Toast.makeText(InputActivity.this, "Please fill in all fields!", Toast.LENGTH_LONG);
					toast.show();
				}
			}
		});
	}

	private void calculate() {
		float billTotal = Float.parseFloat(txtAmount.getText().toString());
		int numberOfPeople = Integer.parseInt(txtPeople.getText().toString());

		float tipAmount = billTotal * TIP_PERCENT;
		float totalWithTip = billTotal + tipAmount;
		float costPerPerson = totalWithTip / numberOfPeople;

		Intent resultIntent = new Intent(InputActivity.this,
				ResultActivity.class);
		resultIntent.putExtra(ResultActivity.EXTRA_TOTAL_KEY, billTotal);
		resultIntent.putExtra(ResultActivity.EXTRA_NUMBER_OF_PEOPLE_KEY,
				numberOfPeople);
		resultIntent.putExtra(ResultActivity.EXTRA_TIP_AMOUNT_KEY, tipAmount);
		resultIntent.putExtra(ResultActivity.EXTRA_FINAL_TOTAL_KEY,
				totalWithTip);
		resultIntent.putExtra(ResultActivity.EXTRA_COST_PER_PERSON_KEY,
				costPerPerson);
		resultIntent.putExtra(ResultActivity.EXTRA_TIP_PERCENTAGE_KEY,
				TIP_PERCENT);

		startActivity(resultIntent);
	}
	
	private boolean fieldsBlank() {
		if (txtAmount.getText().toString().equals("")
				|| txtPeople.getText().toString().equals("")) {
			return true;
		} else {
			return false;
		}
	}

}
