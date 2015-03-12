package tipcalculator.huji.ac.il.tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class TipCalculator extends ActionBarActivity {

    private static final double TIP_PERCENT = 0.12; // Representing 12% tip.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void calculateTip(View view) {
        EditText editBillText = (EditText) findViewById(R.id.edtBillAmount);
        double billAmount = Double.parseDouble(editBillText.getText().toString());

        CheckBox checkBox = (CheckBox) findViewById(R.id.chkRound);
        boolean toRound = checkBox.isChecked();

        TextView tipText = (TextView) findViewById(R.id.txtTipResult);

        double tipAmount = (TIP_PERCENT * billAmount);

        if (toRound) { // setting the number as an integer (long)
            long tipLongAmount = Math.round(tipAmount);
            tipText.setText(Long.toString(tipLongAmount));
        }
        else { // Setting the number with 2 decimal points.
            NumberFormat formatter = new DecimalFormat("#0.00");
            tipText.setText(formatter.format(tipAmount));
        }
    }
}
