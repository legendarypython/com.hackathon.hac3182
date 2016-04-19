package com.example.com.hackathon.hac3182;

import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;



public class Pagetwo extends Activity implements OnClickListener,
OnCheckedChangeListener {

TextView idname, text1;
Button exp;
String gotbread;
RadioGroup q1, q2, q3, q4;
int seconds, minutes, counter;

private static final String FORMAT = "%02d:%02d:%02d";

@Override
protected void onCreate(Bundle savedInstanceState) {
// TODO Auto-generated method stub
super.onCreate(savedInstanceState);
setContentView(R.layout.ptwol);
initialize();
text1 = (TextView) findViewById(R.id.textView5);

new CountDownTimer(30000, 1000) { // adjust the milli seconds here

	public void onTick(long millisUntilFinished) {

		text1.setText("Time left "
				+ String.format(
						FORMAT,
						TimeUnit.MILLISECONDS
								.toHours(millisUntilFinished),
						TimeUnit.MILLISECONDS
								.toMinutes(millisUntilFinished)
								- TimeUnit.HOURS
										.toMinutes(TimeUnit.MILLISECONDS
												.toHours(millisUntilFinished)),
						TimeUnit.MILLISECONDS
								.toSeconds(millisUntilFinished)
								- TimeUnit.MINUTES
										.toSeconds(TimeUnit.MILLISECONDS
												.toMinutes(millisUntilFinished))));
	}

	public void onFinish() {
		text1.setText("done!");
	}
}.start();
Toast.makeText(this, "you have 30 seconds", Toast.LENGTH_LONG).show();

Bundle gotbasket = getIntent().getExtras();
gotbread = gotbasket.getString("name");
idname.setText(gotbread);

Thread timer = new Thread() {

	public void run() {
		try {
			sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {

			Bundle bun = new Bundle();
			bun.putString("idname", idname.getText().toString());
			bun.putInt("markno", counter);
			Intent intent = new Intent(Pagetwo.this, Result.class);
			intent.putExtras(bun);
			startActivity(intent);

		}
	}

};
timer.start();

}

private void initialize() {
// TODO Auto-generated method stub
idname = (TextView) findViewById(R.id.p2tv1);
q1 = (RadioGroup) findViewById(R.id.radioGroup1);
q2 = (RadioGroup) findViewById(R.id.radioGroup2);
q3 = (RadioGroup) findViewById(R.id.radioGroup3);
q4 = (RadioGroup) findViewById(R.id.radioGroup4);
q1.setOnCheckedChangeListener(this);
q2.setOnCheckedChangeListener(this);
q3.setOnCheckedChangeListener(this);
q4.setOnCheckedChangeListener(this);
exp = (Button) findViewById(R.id.bexp);
exp.setOnClickListener(this);
}

@Override
public void onCheckedChanged(RadioGroup group, int checkedId) {
// TODO Auto-generated method stub
switch (group.getId()) {

case R.id.radioGroup1:
	switch (checkedId) {
	case R.id.radio0:
		counter += 1;
		break;

	}
	break;
case R.id.radioGroup2:
	switch (checkedId) {

	case R.id.radio21:
		counter += 1;
		break;

	}
	break;
case R.id.radioGroup3:
	switch (checkedId) {

	case R.id.radio32:
		counter += 1;
		break;
	}
	break;
case R.id.radioGroup4:
	switch (checkedId) {
	case R.id.radio43:
		counter += 1;
		break;

	}
	break;

}
}

@Override
public void onClick(View v) {
// TODO Auto-generated method stub
Bundle bun = new Bundle();
bun.putString("idname", idname.getText().toString());
bun.putInt("markno", counter);
Intent intent = new Intent(Pagetwo.this, Result.class);
intent.putExtras(bun);
startActivity(intent);

}

}
