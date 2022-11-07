package com.example.mb.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //add tag to the view to track the x an o...in XML file
    //0 is for 00 1 is for xx
    int activePlayer = 0;
    //green 1 and red 2
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean gameActive = true;
    TextView textView;
    Button restartButton;
    static int my_counter=0;
    ImageView i1,i2,i3,i4,i5,i6,i7,i8,i9;
    GridLayout gridLayout;

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;

        String tag = (String) counter.getTag();
        //Toast.makeText(this, tag, Toast.LENGTH_SHORT).show();

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameActive == true) {


            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1500);
my_counter++;
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.oo);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.xx);
                activePlayer = 0;

            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            for (int[] winposition : winningPositions) {
                if (gameState[winposition[0]] == gameState[winposition[1]]
                        && gameState[winposition[1]] == gameState[winposition[2]]
                        && gameState[winposition[0]] != 2) {
                    //someone has won

                    gameActive = false;

                    String winner = "";

                    if (activePlayer == 1) {
                        winner = "Green";
                    } else {
                        winner = "Red";
                    }
                    Toast.makeText(this, winner + " has won..", Toast.LENGTH_LONG).show();

                //    textView.setVisibility(View.VISIBLE);
                  //  restartButton.setVisibility(View.VISIBLE);

                }
            }
            if(gameState[0] == gameState[1]
                    && gameState[1] == gameState[2]
                    && gameState[2] == gameState[3]
                    && gameState[3] == gameState[4]
                    && gameState[4] == gameState[5]
                    && gameState[5] == gameState[6]
                    && gameState[6] == gameState[7])
            {
                gameActive=false;
            }

            if(!gameActive){
                textView.setVisibility(View.VISIBLE);
                restartButton.setVisibility(View.VISIBLE);
            }
        }




            if (my_counter == 9 && gameActive) {
                gameActive = false;
                Toast.makeText(this, "Its TIE...\nnobody has won..", Toast.LENGTH_LONG).show();

              restartGame(restartButton);

            }
        if(!gameActive){
            textView.setVisibility(View.VISIBLE);
            restartButton.setVisibility(View.VISIBLE);
        }



    }
public void restartGame(View view){
    textView.setVisibility(View.GONE);
    restartButton.setVisibility(View.GONE);
     activePlayer = 0;
    //green 1 and red 2
   gameState = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2};
  winningPositions = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
          {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    gameActive = true;

    for(int i = 0; i < gridLayout.getChildCount(); i++) {
        ImageView child = (ImageView) gridLayout.getChildAt(i);
        child.setImageResource(0);
        // do stuff with child view
    }
  /*  i1.setImageResource(0);
    i2.setImageResource(0);
    i3.setImageResource(0);
    i4.setImageResource(0);
    i5.setImageResource(0);
    i6.setImageResource(0);
    i7.setImageResource(0);
    i8.setImageResource(0);
    i9.setImageResource(0);  */
    //R.id.imageView1.setImageResource(0);

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textView = findViewById(R.id.textView);
         restartButton = findViewById(R.id.button);
        gridLayout=findViewById(R.id.gridLayout);
         i1=findViewById(R.id.imageView1);
         i2=findViewById(R.id.imageView2);
         i3=findViewById(R.id.imageView3);
         i4=findViewById(R.id.imageView4);
         i5=findViewById(R.id.imageView5);
         i6=findViewById(R.id.imageView6);
         i7=findViewById(R.id.imageView7);
         i8=findViewById(R.id.imageView8);
         i9=findViewById(R.id.imageView9);


         }

    }
