package com.example.arpit.knowyourbody;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateActivity extends Activity {
    /**
     * @var TAG : string type variable hlding a string "AppyActivity" for maintaining activity states through logs
     */
    private static final String TAG = "AppyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
    }

    /**
     * Log : use to print to logcat with a filter, so we can look for the messages we cant to print to log and check the application.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }

    /**
     *
     * @param view : when clicked on the calculate button in activity_main.xml this method will be invoed by that buttonview.
     * @method calculate : It gathers the information to calculate the calories(height,weight,age) by invoking their respetive functions.
     *                     and use that information in another function to generate final resulting calories and set the text of id Result.
     */
    public void calculate(View view) {
        double W = weightMethod();
        double H = heightmethod();
        int A = ageMethod();
        if (A != 0 && H != 0 && W != 0) {
            String result = calorie(W, H, A);
            TextView message = (TextView) findViewById(R.id.result);
            message.setText(result);
        }
    }

    /**
     * @method weightMethod : It checks the checkbox of kg(kilogram) and lbs(pound).
     *                        It make sures only one the checkbox is selected ,if not it makes a toast visible to screen.
     *                        It saves the text from weight editext and convert it into a double and allocates value to W variable with respective checkbox.
     * @return double type W.
     */
    private double weightMethod() {
        double W = 0;
        CheckBox kilogram = (CheckBox) findViewById(R.id.checkBox3);
        boolean kcheckbox = kilogram.isChecked();
        CheckBox lbs = (CheckBox) findViewById(R.id.checkBox4);
        boolean lcheckbox = lbs.isChecked();
        EditText weight = (EditText) findViewById(R.id.editText3);
        String weigh = weight.getText().toString();
        if (weigh.matches("")) {
            Toast.makeText(this, "Please enter weight", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            double weighs = Float.parseFloat(weigh);
            if ((kcheckbox == true && lcheckbox == true) || (kcheckbox == false && lcheckbox == false)) {
                Toast.makeText(this, "Please check either Kg or lbs", Toast.LENGTH_SHORT).show();
                return 0;
            } else if (lcheckbox == true) {
                W = (weighs / 2.2);
            } else if (kcheckbox == true) {
                W = weighs;
            }
        }
        return W;
    }

    /**
     * @method heightMethod : saves the text into ft and in from rexpective height feilds
     *                        and converts them into centimetres(cm)
     *                        if they are left blank it makes a toast accordingly.
     *                        saves the numerics in foot and inch through parseInt method of Integer class.
     *                        and finally saves it all in H.
     * @return double type H.
     */
    private double heightmethod() {
        double H = 0;
        EditText heightft = (EditText) findViewById(R.id.editText1);
        String ft = heightft.getText().toString();
        EditText heightin = (EditText) findViewById(R.id.editText2);
        String in = heightin.getText().toString();
        if (ft.matches("") || (in.matches(""))) {
            Toast.makeText(this, "Please enter height : ft and inch", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            int foot = Integer.parseInt(ft);
            int inch = Integer.parseInt(in);
            H = ((foot * 12 * 2.54) + (inch * 2.54));
        }
        return H;
    }

    /**
     *
     * @return int type agenum : By extracting text from age editext field and then parsing it into int.
     * and saving it into agenum.
     */
    private int ageMethod() {
        int agenum = 0;
        EditText age = (EditText) findViewById(R.id.editText4);
        String agestr = age.getText().toString();
        if (agestr.matches("")) {
            Toast.makeText(this, "Please enter age", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            agenum = Integer.parseInt(agestr);
        }
        return agenum;
    }

    /**
     *
     * @param H : came from method heightMethod(double)
     * @param W : came from method weightMethod(double)
     * @param A : came from method ageMethod(int)
     * @return String type str : This method checks for the male and female checbox and accordingly process the method with all three params.
     *                           and save it in BMR doble type variable, rounds it using Math class method round.
     *                           save the value with the string in str.
     */
    private String calorie(double H, double W, int A) {
        double BMR = 0;
        CheckBox male = (CheckBox) findViewById(R.id.checkBox1);
        Boolean mcheckbox = male.isChecked();
        CheckBox female = (CheckBox) findViewById(R.id.checkBox2);
        Boolean fcheckbox = female.isChecked();
        if ((mcheckbox == true && fcheckbox == true) || (mcheckbox == false && fcheckbox == false)) {
            Toast.makeText(this, "Please check either Male or Female", Toast.LENGTH_SHORT).show();
            return null;
        } else if (fcheckbox == true) {
            BMR = (10 * W) + (6.25 * H) - (5 * A) - 161;
        } else if (mcheckbox == true) {
            BMR = 5 + (10 * W) + (6.25 * H) - (5 * A);
        }
        String str = "Calories required by you are :\n" + Math.round(BMR) + " Kcal per day";
        return str;
    }

}