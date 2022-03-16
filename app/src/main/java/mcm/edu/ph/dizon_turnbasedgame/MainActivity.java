package mcm.edu.ph.dizon_turnbasedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView HeroNameTag, SlimeNameTag;
    ImageButton SkillOne, SkillTwo, SkillThree;
    Button NextTurn;
    ProgressBar HeroHpBar, SlimeHpBar;

        String HeroStats = "Hero";
        int HeroHp = 100;
        int HeroMinDmg = 7;
        int HeroMaxDmg = 15;
        int TurnNumber = 1;

        String SlimeStats = "Slime";
        int SlimeHp = 90;
        int SlimeMinDmg = 6;
        int SlimeMaxDmg = 12;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //name tags
    HeroNameTag = findViewById(R.id.HeroNameTag);
    SlimeNameTag = findViewById(R.id.SlimeNameTag);

    //skills
    SkillOne = findViewById(R.id.SkillOne);
    SkillTwo = findViewById(R.id.SkillTwo);
    SkillThree = findViewById(R.id.SkillThree);

    //button
    NextTurn = findViewById(R.id.NextTurn);

    //hp bars
    HeroHpBar = findViewById(R.id.HeroHpBar);
    SlimeHpBar = findViewById(R.id.SlimeHpBar);

   HeroNameTag.setText(HeroStats);
    SkillOne.setOnClickListener(this);
    SkillTwo.setOnClickListener(this);
    SkillThree.setOnClickListener(this);
    NextTurn.setOnClickListener(this);

    HeroNameTag.setText(String.valueOf(HeroMinDmg) + " -" + String.valueOf(HeroMaxDmg));
    SlimeNameTag.setText(String.valueOf(SlimeMinDmg + " -" + String.valueOf(SlimeMaxDmg)));


    }


    @Override
    public void onClick(View view) {

        Random randomizer = new Random();
        int HeroDps = randomizer.nextInt(HeroMaxDmg - HeroMinDmg) + HeroMaxDmg;
        int SlimeDps = randomizer.nextInt(SlimeMaxDmg - SlimeMinDmg) + SlimeMaxDmg;
        int critChance = randomizer.nextInt(50);
        int evade = randomizer.nextInt(22);

        switch (view.getId()) {
            case R.id.NextTurn:
                //
                if (TurnNumber % 2 == 1) { //add
                    SlimeHp = SlimeHp - HeroDps;
                    TurnNumber++;
                    SlimeNameTag.setText(String.valueOf(SlimeHp));
                    NextTurn.setText("Next Turn (" + String.valueOf(TurnNumber) + ")");


                    if (SlimeHp < 0) {
                        HeroHp = 100;
                        SlimeHp = 90;
                        TurnNumber = 1;
                        NextTurn.setText("Reset Game");

                    }


                } else if (TurnNumber % 2 != 1) {
                    HeroHp = HeroHp - SlimeDps;
                    TurnNumber++;
                    HeroNameTag.setText(String.valueOf(HeroHp));
                    NextTurn.setText("Next Turn (" + String.valueOf(TurnNumber) + ")");


                    if (HeroHp < 0) {
                        HeroHp = 100;
                        SlimeHp = 90;
                        TurnNumber = 1;
                        NextTurn.setText("Reset Game");



                        break;


                    }


                }


        }
    }
}
}