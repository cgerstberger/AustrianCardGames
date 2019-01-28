package at.cgerstberger.austriancardgames.dice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.nex3z.flowlayout.FlowLayout;

import at.cgerstberger.austriancardgames.R;

public class DiceActivity extends AppCompatActivity {

    private SimpleDiceCup simpleDiceCup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        initDices();

        final FlowLayout flowLayoutDices = findViewById(R.id.flowLayoutDices);
        for(Dice d : simpleDiceCup.getDices()){
            flowLayoutDices.addView(d);
        }

        Button btnAddDice = findViewById(R.id.btnAddDice);
        btnAddDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(simpleDiceCup.getDices().size() < 6){
                    Dice d = new Dice(getApplicationContext());
                    simpleDiceCup.attach(d);
                    flowLayoutDices.addView(d);
                }
            }
        });
        Button btnRemoveDice = findViewById(R.id.btnRemoveDice);
        btnRemoveDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(simpleDiceCup.getDices().size() > 1){
                    Dice d = simpleDiceCup.getDices().get(simpleDiceCup.getDices().size()-1);
                    simpleDiceCup.detach(d);
                    flowLayoutDices.removeView(d);
                }
            }
        });
    }

    private void initDices() {
        simpleDiceCup = new SimpleDiceCup(this);
        simpleDiceCup.attach(new Dice(this));
        simpleDiceCup.attach(new Dice(this));
        simpleDiceCup.attach(new Dice(this));
        simpleDiceCup.attach(new Dice(this));
        simpleDiceCup.attach(new Dice(this));
        simpleDiceCup.attach(new Dice(this));
    }

}
