package rob.myappcompany.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int correct;
    public void generateRandomNumber() {
        Random rand = new Random();
        correct = rand.nextInt(20) + 1;
    }

    public void setButton(View view) {

        EditText numIntEditText = (EditText) findViewById(R.id.numEditText);
        String numStringEditText = numIntEditText.getText().toString();

        String message;

        int intValue;
        //Try-Catch for handle Error of ediText
        try {
            intValue = Integer.parseInt(numStringEditText); //convert editText value into int
        } catch (Exception e) {
            Toast.makeText(this, numStringEditText + "数値を入れて、もう一度！", Toast.LENGTH_LONG).show();
            return;
        }


        if (correct < intValue && intValue <= 20) {
            message = " より小さい";
        } else if (intValue > 20) {
            message = " は、20より大きいよ";
        } else if (correct > intValue) {
            message = " より大きい";
        } else {
            message = " は、正解！！もう一度やってみよう！";
            generateRandomNumber();
        }
        Toast.makeText(this, numStringEditText + message, Toast.LENGTH_LONG).show();

        Log.i("Enter Value", numStringEditText);
        Log.i("Random Value", Integer.toString(correct));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();
    }
}
