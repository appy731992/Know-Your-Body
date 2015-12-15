package com.example.arpit.knowyourbody;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
    }
    /**
     *
     * @param view : when clicked on the calculate button in activity_main.xml this method will be invoked by that button.
     * @calculateButton : It gathers the information to calculate the calories(height,weight,age) by invoking their respective functions.
     *                     and use that information in another function to generate final resulting calories and set the text of id Result.
     */
    public void calculateButton(View view) {
        double weight = weightMethod();
        double height = heightmethod();
        int age = ageMethod();
        if (age != 0 && height != 0 && weight != 0) {
            String result = calorieCalculate(weight, height, age);
            TextView message = (TextView) findViewById(R.id.result);
            message.setText(result);
        }
    }

    /**
     * @weightMethod : It checks the RadioButton for kg(kilogram) and lbs(pound).
     *                        It make sures that one of the RadioButton is selected ,if not it makes a toast visible to screen.
     *                        It saves the text from weight editext and convert it into a double and allocates value to weight variable with respective Radiobutton.
     * @return double type W.
     */
    private double weightMethod() {
        double weight = 0;
        RadioButton kilogramButton = (RadioButton) findViewById(R.id.kg_radio_button);
        boolean kilogram = kilogramButton.isChecked();
        RadioButton lbsButton = (RadioButton) findViewById(R.id.lbs_radio_button);
        boolean lbs = lbsButton.isChecked();
        EditText weightText = (EditText) findViewById(R.id.editText3);
        String weightString = weightText.getText().toString();
        if (weightString.matches("")) {
            Toast.makeText(this, "Please enter weight", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            double weightNumber = Float.parseFloat(weightString);
            if (!kilogram && !lbs){
                Toast.makeText(this, "Please check either Kg or lbs", Toast.LENGTH_SHORT).show();
                return 0;
            } else if (lbs) {
                weight = (weightNumber / 2.2);
            } else if (kilogram) {
                weight = weightNumber;
            }
        }
        return weight;
    }

    /**
     * @heightMethod : saves the text into ft(foot) and in(inches) from respective height fields
     *                        and converts them into centimetres(cm)
     *                        if they are left blank it makes a toast accordingly.
     *                        saves the numeric in foot and inch through parseInt method of Integer class.
     *                        and finally saves it all in height.
     * @return double type height.
     */
    private double heightmethod() {
        double height = 0;
        EditText heightft = (EditText) findViewById(R.id.editText1);
        String ft = heightft.getText().toString();
        EditText heightinch = (EditText) findViewById(R.id.editText2);
        String in = heightinch.getText().toString();
        if (ft.matches("") || (in.matches(""))) {
            Toast.makeText(this, "Please enter height : ft and inch", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            int foot = Integer.parseInt(ft);
            int inch = Integer.parseInt(in);
            height = ((foot * 12 * 2.54) + (inch * 2.54));
        }
        return height;
    }

    /**
     *
     * @return int type agenum : By extracting text from age editext field and then parsing it into int.
     * and saving it into agenum.
     */
    private int ageMethod() {
        int agenum = 0;
        EditText age = (EditText) findViewById(R.id.editText4);
        String agestring = age.getText().toString();
        if (agestring.matches("")) {
            Toast.makeText(this, "Please enter age", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            agenum = Integer.parseInt(agestring);
        }
        return agenum;
    }

    /**
     *
     * @param height : came from method heightMethod(double)
     * @param weight : came from method weightMethod(double)
     * @param age : came from method ageMethod(int)
     * @return String type string : This method checks for the male and female RadioButton and accordingly process the method with all three params.
     *                           and save it in calories double type variable, rounds it using Math class method round.
     *                           save the value with the string type variable named string.
     */
    private String calorieCalculate(double height, double weight, int age) {
        double calories = 0;
        RadioButton maleRadioButton = (RadioButton) findViewById(R.id.male_radiobutton);
        Boolean male = maleRadioButton.isChecked();
        RadioButton femaleRadioButton = (RadioButton) findViewById(R.id.female_radiobutton);
        Boolean female = femaleRadioButton.isChecked();
        if (!male && !female) {
            Toast.makeText(this, "Please check either Male or Female", Toast.LENGTH_SHORT).show();
            return null;
        } else if (female) {
            calories = (10 * weight) + (6.25 * height) - (5 * age) - 161;
        } else if (male) {
            calories = 5 + (10 * weight) + (6.25 * height) - (5 * age);
        }
         return "Calories required by you are :\n" + Math.round(calories) + " Kcal per day";
    }

}