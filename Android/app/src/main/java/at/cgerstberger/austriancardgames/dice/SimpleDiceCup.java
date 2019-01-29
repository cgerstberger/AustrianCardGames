package at.cgerstberger.austriancardgames.dice;

import android.content.Context;

import com.nex3z.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.List;

public class SimpleDiceCup extends FlowLayout {
    private List<Dice> dices = new ArrayList<>();

    public SimpleDiceCup(Context context) {
        super(context);
    }

    public void attach(Dice d){
        dices.add(d);
    }

    public void detach(Dice d){
        dices.remove(d);
    }

    public int rollTheDices(){
        int eyesNumber = 0;
        for(Dice d : dices){
            eyesNumber += d.rollTheDice();
        }
        return eyesNumber;
    }

    public List<Dice> getDices(){
        return dices;
    }
}
