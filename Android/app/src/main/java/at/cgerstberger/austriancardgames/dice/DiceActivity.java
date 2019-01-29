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
    private FlowLayout flowLayoutDices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        flowLayoutDices = findViewById(R.id.flowLayoutDices);
        simpleDiceCup = new SimpleDiceCup(this);
        initDices();

        Button btnAddDice = findViewById(R.id.btnAddDice);
        btnAddDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(simpleDiceCup.getDices().size() < 6){
                    final Dice d = new Dice(getApplicationContext());
                    addDice(d);
                }
            }
        });
        Button btnRemoveDice = findViewById(R.id.btnRemoveDice);
        btnRemoveDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(simpleDiceCup.getDices().size() > 1){
                    Dice d = simpleDiceCup.getDices().get(simpleDiceCup.getDices().size()-1);
                    removeDice(d);
                }
            }
        });
        Button btnRollTheDice = findViewById(R.id.btnRollTheDice);
        btnRollTheDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleDiceCup.rollTheDices();
            }
        });
    }

    private void initDices() {
        simpleDiceCup = new SimpleDiceCup(this);
        for(int i = 0; i < 6; i ++){
            final Dice d = new Dice(this);
            addDice(d);
        }
    }

    private void addDice(final Dice d){
        d.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                removeDice(d);
                return true;
            }
        });
        simpleDiceCup.attach(d);
        flowLayoutDices.addView(d);
    }

    private void removeDice(Dice d){
        simpleDiceCup.detach(d);
        flowLayoutDices.removeView(d);
    }
}
