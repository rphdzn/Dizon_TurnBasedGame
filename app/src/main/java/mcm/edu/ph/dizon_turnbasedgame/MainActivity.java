package mcm.edu.ph.dizon_turnbasedgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView HeroNameTag, SlimeNameTag, DPSHero, DPSSlime;
    ImageButton SkillOne, SkillTwo, SkillThree;
    Button NextTurn;
    ProgressBar HeroHpBar, SlimeHpBar;

        String HeroStats = "Hero";
        int HeroHp = 100;
        int HeroHpPercentage;
        int HeroMinDmg = 7;
        int HeroMaxDmg = 15;
        int TurnNumber = 1;

        String SlimeStats = "Slime";
        int SlimeHp = 90;
        int SlimeHPPercentage;
        int SlimeMinDmg = 6;
        int SlimeMaxDmg = 12;
        Boolean disablestatus = false;
        int buttoncounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //name tags
    HeroNameTag = findViewById(R.id.HeroNameTag);
    SlimeNameTag = findViewById(R.id.SlimeNameTag);
    
    //DPS descriptor
        DPSHero = findViewById(R.id.DPShero);
        DPSSlime = findViewById(R.id.DPSslime);

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



    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {

        Random randomizer = new Random();
        int HeroDps = randomizer.nextInt(HeroMaxDmg - HeroMinDmg) + HeroMaxDmg;
        int SlimeDps = randomizer.nextInt(SlimeMaxDmg - SlimeMinDmg) + SlimeMaxDmg;
        int critChance = randomizer.nextInt(50);
        if (critChance <= 20){

        }
        int evade = randomizer.nextInt(22);
        if (evade < 5){

        }
        if (TurnNumber % 2 == 1) {
            SkillOne.setEnabled(false);
        } else if (TurnNumber % 2 != 1) {
            SkillOne.setEnabled(true);

        }
        if (buttoncounter > 0) {
            SkillOne.setEnabled(false);
            buttoncounter--;
        } else if (buttoncounter == 0) {
            SkillOne.setEnabled(true);
        }
        if (TurnNumber % 2 == 1) {
            SkillTwo.setEnabled(false);
        } else if (TurnNumber % 2 != 1) {
            SkillTwo.setEnabled(true);
        }
        if (buttoncounter > 0) {
            SkillTwo.setEnabled(false);
            buttoncounter--;
        } else if (buttoncounter == 0) {
            SkillTwo.setEnabled(true);
        }
        if (TurnNumber % 2 == 1) {
            SkillThree.setEnabled(false);
        } else if (TurnNumber % 2 != 1) {
            SkillThree.setEnabled(true);
        }
        if (buttoncounter > 0) {
            SkillThree.setEnabled(false);
            buttoncounter--;
        } else if (buttoncounter == 0) {
            SkillThree.setEnabled(true);
        }


        switch (view.getId()) {

            case R.id.SkillOne:
                SlimeHp = SlimeHp - 17;
                SlimeHPPercentage = SlimeHp * 20 / 90;
                SlimeHpBar.setProgress((int) SlimeHPPercentage, true);
                TurnNumber++;
                DPSSlime.setText(String.valueOf(SlimeHp));
                NextTurn.setText("Next Turn (" + String.valueOf(TurnNumber) + ")");


                if (SlimeHp < 0) {
                    HeroHp = 100;
                    SlimeHp = 90;
                    TurnNumber = 1;
                    NextTurn.setText("Reset Game");
                }

                buttoncounter = 1;
                break;

            case R.id.SkillTwo:
                SlimeHp = SlimeHp - 17;
                SlimeHPPercentage = SlimeHp * 20 / 90;
                SlimeHpBar.setProgress((int) SlimeHPPercentage, true);
                TurnNumber++;
                DPSSlime.setText(String.valueOf(SlimeHp));
                NextTurn.setText("Next Turn(" + String.valueOf(TurnNumber) + ")");

                if (SlimeHp < 0) {
                    HeroHp = 100;
                    SlimeHp = 90;
                    TurnNumber = 1;
                    NextTurn.setText("Reset Game");
                }

                buttoncounter = 1;
                break;

            case R.id.SkillThree:
                SlimeHp = SlimeHp - 260;
                SlimeHPPercentage = SlimeHp * 100 / 4000;
                SlimeHpBar.setProgress((int) SlimeHPPercentage, true);
                TurnNumber++;
                DPSSlime.setText(String.valueOf(SlimeHp));
                NextTurn.setText("Next Turn(" + String.valueOf(TurnNumber) + ")");


                if (SlimeHp < 0) {
                    HeroHp = 100;
                    SlimeHp = 90;
                    TurnNumber = 1;
                    NextTurn.setText("Reset Game");

                }

                buttoncounter = 1;
                break;

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
