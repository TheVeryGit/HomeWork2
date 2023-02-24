package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    float price = 14000;
    float balance = 1000;
    float stipendy = 2500;
    float percent = 5;
    float[] monthBalance = new float[12];

    public int countMonth(float total, float wage, float percentYear, float money) {

        float monthPercent = percentYear / 12;
        int count = 0;
        float sum = money;
        while (total > 0) {
            count++;
            sum = (sum + wage) * (1 + monthPercent / 100);
            total = (total - sum);

            if (total > money) {
                monthBalance[count - 1] = sum;
            } else { // иначе
                monthBalance[count - 1] = sum;
            }
        }
        return count;
    }


    private TextView countOut;
    private TextView balanceOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        countOut = findViewById(R.id.countOut);
        balanceOut = findViewById(R.id.balanceOut);


        countOut.setText(countMonth(price, stipendy, percent, balance));
        String monthBalanceList = "";
        for (float list : monthBalance) {
            if (list > 0) {
                monthBalanceList = monthBalanceList + Float.toString(list) + " монет ";
            } else {
                break;
            }
            balanceOut.setText("Ваш ежемесячный баланс до покупки : " + monthBalanceList);

        }
    }
}
