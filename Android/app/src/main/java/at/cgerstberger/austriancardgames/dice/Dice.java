package at.cgerstberger.austriancardgames.dice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import at.cgerstberger.austriancardgames.R;

public class Dice extends android.support.v7.widget.AppCompatImageView {

    private List<Bitmap> bitmapListDices = new ArrayList<>();
    private List<Bitmap> bitmapListDicesShuffled = new ArrayList<>();

    public Dice(Context context) {
        super(context);

        createBitmapListDices();
        initDiceImage();

        this.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                rollTheDice();
            }
        });
    }

    AnimationDrawable animationDrawable;
    private void initDiceImage() {
//        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.dice_animation);
//        Bitmap scaledB = Bitmap.createScaledBitmap(b, 250, 250, true);
//        setImageBitmap(scaledB);
//        setPadding(0,10,0,10);

//        setBackgroundResource(R.drawable.dice_animation);
        setPadding(0,10,0,10);
        setLayoutParams(new ViewGroup.LayoutParams(250, 250));
//        animationDrawable = (AnimationDrawable) getBackground();

        animationDrawable = createAnimation();
        setBackground(animationDrawable);
    }

    private AnimationDrawable createAnimation() {
        AnimationDrawable ad = new AnimationDrawable();
        Collections.shuffle(bitmapListDicesShuffled);
        for(Bitmap b : bitmapListDicesShuffled){
            ad.addFrame(new BitmapDrawable(getResources(), b), 100);
        }
        return ad;
    }

    private void createBitmapListDices(){
        bitmapListDices.add(BitmapFactory.decodeResource(getResources(), R.drawable.dice_one));
        bitmapListDices.add(BitmapFactory.decodeResource(getResources(), R.drawable.dice_two));
        bitmapListDices.add(BitmapFactory.decodeResource(getResources(), R.drawable.dice_three));
        bitmapListDices.add(BitmapFactory.decodeResource(getResources(), R.drawable.dice_four));
        bitmapListDices.add(BitmapFactory.decodeResource(getResources(), R.drawable.dice_five));
        bitmapListDices.add(BitmapFactory.decodeResource(getResources(), R.drawable.dice_six));
        bitmapListDicesShuffled = new ArrayList<>(bitmapListDices);
        Collections.shuffle(bitmapListDicesShuffled);
    }

    public int rollTheDice(){
        if(animationDrawable.isRunning()) {
            // stop animation
            animationDrawable.stop();
            Random rnd = new Random();
            int rndIdx = rnd.nextInt(6);
            // send random dice bitmap as background
            setBackground(new BitmapDrawable(getResources(), bitmapListDices.get(rndIdx)));
        }
        else {
            // generate new random animation
            animationDrawable = createAnimation();
            setBackground(animationDrawable);
            // start animation
            animationDrawable.start();
        }

        // perform animation
        // perform random number generation
        // return random number
        return 1;
    }
}
