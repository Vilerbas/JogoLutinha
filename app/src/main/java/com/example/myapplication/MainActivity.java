package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int playerScore = 0;
    private int enemyScore = 0;

    private ImageView player_Health_bar;
    private ImageView enemy_Health_bar;

    private ArrayList<Integer> playerHealth = new ArrayList<>();
    private ArrayList<Integer> enemyHealth = new ArrayList<>();

    private TextView playerScoreText;
    private TextView enemyScoreText;

    private Button playerAttackButton;
    private Button enemyAttackButton;

    private ImageView playerStickCharacter;
    private ImageView enemyStickCharacter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player_Health_bar = findViewById(R.id.player_health_bar);
        enemy_Health_bar = findViewById(R.id.enemy_health_bar);

        playerScoreText = findViewById(R.id.player_score_text);
        enemyScoreText = findViewById(R.id.enemy_score_text);

        playerAttackButton = findViewById(R.id.player_attack_button);
        enemyAttackButton = findViewById(R.id.enemy_attack_button);

        playerStickCharacter = findViewById(R.id.player_stick_character);
        playerStickCharacter.setScaleX(-1);
        enemyStickCharacter = findViewById(R.id.enemy_stick_character);


        for(int i = 0; i < 10; i++){
            playerHealth.add(1);
            enemyHealth.add(1);
        }


        playerAttackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(enemyHealth.size() > 0){
                    enemyHealth.remove(0);
                    enemy_Health_bar.setScaleX((float) enemyHealth.size() / 10);
                }
                if(enemyHealth.size() == 0) {
                    playerScore++;
                    playerScoreText.setText(+ playerScore);
                    for (int i = 0; i < 10; i++) {
                        enemyHealth.add(1);
                        playerHealth.add(1);
                    }
                    enemy_Health_bar.setScaleX(1);
                    player_Health_bar.setScaleX(1);
                }
            }
        });
        enemyAttackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(playerHealth.size() > 0){
                    playerHealth.remove(0);
                    player_Health_bar.setScaleX((float) playerHealth.size() / 10);

                    if(playerHealth.size() == 0) {
                        enemyScore++;
                        enemyScoreText.setText(+ enemyScore);
                        for (int i = 0; i < 10; i++) {
                            playerHealth.add(1);
                            enemyHealth.add(1);
                        }
                        player_Health_bar.setScaleX(1);
                        enemy_Health_bar.setScaleX(1);
                    }
                }
            }
        });
    }
}