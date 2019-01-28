package at.cgerstberger.austriancardgames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import at.cgerstberger.austriancardgames.card.CardActivity;
import at.cgerstberger.austriancardgames.dice.DiceActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCardActivity = findViewById(R.id.btnCardDeck);
        Button btnDiceActivity = findViewById(R.id.btnDiceCup);

        btnCardActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cardIntent = new Intent(getApplicationContext(), CardActivity.class);
                startActivity(cardIntent);
            }
        });

        btnDiceActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diceIntent = new Intent(getApplicationContext(), DiceActivity.class);
                startActivity(diceIntent);
            }
        });
    }
}
