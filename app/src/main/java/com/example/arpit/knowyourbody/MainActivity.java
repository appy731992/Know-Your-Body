package com.example.arpit.knowyourbody;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * @calculate : It will take the user to the CalculateActivity.class file, In app the user will go to the Calculate Calories activity.
     * This method  starts another activity.
     */
    public void calculate(View view) {
        Intent intent = new Intent(this, CalculateActivity.class);
        startActivity(intent);
    }
    /**
     * @daily : It will take the user to the DailyActivity.class file, In app the user will go to the Daily Intake activity.
     * This method  starts another activity.
     */
    public void daily(View view) {
        Intent intent = new Intent(this, DailyActivity.class);
        startActivity(intent);
    }
    /**
     * @build : It will take the user to the BuildActivity.class file, In app the user will go to the To Build Muscle activity.
     * This method  starts another activity.
     */
    public void build(View view) {
        Intent intent = new Intent(this, BuildActivity.class);
        startActivity(intent);
    }
    /**
     * @lose : It will take the user to the LoseActivity.class file, In app the user will go to the To Lose Weight activity.
     * This method  starts another activity.
     */
    public void lose(View view) {
        Intent intent = new Intent(this, LoseActivity.class);
        startActivity(intent);
    }
    /**
     * @protein : It will take the user to the ProteinActivity.class file, In app the user will go to the 3 Protein-Rich Meals activity.
     * This method  starts another activity.
     */
    public void protein(View view) {
        Intent intent = new Intent(this, ProteinActivity.class);
        startActivity(intent);
    }
}
