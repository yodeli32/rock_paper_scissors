package com.example.rock_paper_scissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button rock, scissors, paper;
    TextView score, alert;
    ImageView ComputerChoice, HumanChoice;

    int HumanScore, ComputerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paper = (Button) findViewById(R.id.paper);
        scissors = (Button) findViewById(R.id.scissors);
        rock = (Button) findViewById(R.id.rock);

        ComputerChoice = (ImageView) findViewById(R.id.ComputerChoice);
        HumanChoice = (ImageView) findViewById(R.id.HumanChoice);

        score = (TextView) findViewById(R.id.score);

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HumanChoice.setImageResource(R.drawable.paper);
                TextView popup = (TextView)findViewById(R.id.alertView);
                String message = play_turn("paper");
                //Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                popup.setText(message);
                popup.setVisibility(View.VISIBLE);

                score.setText("Player: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(ComputerScore));
            }
        });

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HumanChoice.setImageResource(R.drawable.rock);
                TextView popup = (TextView)findViewById(R.id.alertView);
                String message = play_turn("rock");
                //Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                popup.setText(message);
                popup.setVisibility(View.VISIBLE);

                score.setText("Player: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(ComputerScore));
            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HumanChoice.setImageResource(R.drawable.scissors);
                TextView popup = (TextView)findViewById(R.id.alertView);
                String message = play_turn("scissors");
               // Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                popup.setText(message);
                popup.setVisibility(View.VISIBLE);


                score.setText("Player: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(ComputerScore));
            }
        });

    }

    public String play_turn( String player_choice) {
        String computer_choice = "";
        Random r = new Random();

        // choose 1 2 or 3
        int computer_choice_number = r.nextInt(3) + 1;

        if (computer_choice_number == 1) {
            computer_choice = "rock";
        } else

        if (computer_choice_number == 2) {
            computer_choice = "scissors";
        } else

        if (computer_choice_number == 3) {
            computer_choice = "paper";
        }

        //set the computer image based on his choice
        if (computer_choice == "rock") {
            ComputerChoice.setImageResource(R.drawable.rock);
        } else
        if (computer_choice == "scissors") {
            ComputerChoice.setImageResource(R.drawable.scissors);
        } else
        if (computer_choice == "paper") {
            ComputerChoice.setImageResource(R.drawable.paper);
        }

        // determine who won.
        if (computer_choice == player_choice) {
            return "Draw! Nobody Won.";
        }
        else if (player_choice == "rock" && computer_choice == "scissors") {
            HumanScore++;
            return "Rock crushes scissors. You win!";
        }
        else if (player_choice == "rock" && computer_choice == "paper") {
            ComputerScore++;
            return "Paper covers rock. Computer wins!";
        }
        else if (player_choice == "scissors" && computer_choice == "rock") {
            ComputerScore++;
            return "Rock crushes scissors. Computer wins!";
        }
        else if (player_choice == "scissors" && computer_choice == "paper") {
            HumanScore++;
            return "Scissors cuts paper. You win!";
        }
        else if (player_choice == "paper" && computer_choice == "rock") {
            HumanScore++;
            return "Paper covers rock. You win!";
        }
        else if (player_choice == "paper" && computer_choice == "scissors") {
            ComputerScore++;
            return "Scissors cuts paper. Computer wins!";
        }
        else return"Not sure...";
    }


}
