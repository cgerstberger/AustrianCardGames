package at.cgerstberger.austriancardgames.dice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;

import at.cgerstberger.austriancardgames.R;

public class Dice extends android.support.v7.widget.AppCompatImageView {
    public Dice(Context context) {
        super(context);

        initDiceImage();

        this.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(animationDrawable.isRunning())
                    animationDrawable.stop();
                else
                    animationDrawable.start();
            }
        });
    }

    AnimationDrawable animationDrawable;
    private void initDiceImage() {
//        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.dice_animation);
//        Bitmap scaledB = Bitmap.createScaledBitmap(b, 250, 250, true);
//        setImageBitmap(scaledB);
//        setPadding(0,10,0,10);

        setBackgroundResource(R.drawable.dice_animation);
        setPadding(0,10,0,10);
        setLayoutParams(new ViewGroup.LayoutParams(250, 250));
        animationDrawable = (AnimationDrawable) getBackground();
    }

    public int rollTheDice(){
        // perform animation
        // perform random number generation
        // return random number
        return 1;
    }
}
