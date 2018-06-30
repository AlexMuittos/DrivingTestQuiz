package com.example.android.drivingtestquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*
    there are 8 correct answers and each question is 5 marks.
    to get full marks, you have to score 40/40
    All the scores are global variables since they will be used to compute the final score
    */
    int qsnOneScore = 0;
    int qsnTwoScore = 0;
    int qsnThreeScore = 0;
    int qsnFourScore = 0;
    int qsnFiveScore = 0;
    int qsnSixScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioButtonClicked(View view) {


        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        //@param option11, option12, option13. the first digit denotes the question number and the second one denotes the option nummber.


        /* Check which radio button was clicked
        Confirm correctness of question 1*/
        switch (view.getId()) {
            case R.id.option11:
                if (checked)
                    qsnOneScore += 0;


                break;
            case R.id.option12:
                if (checked)
                    qsnOneScore += 5;
                else
                    qsnOneScore -= 5;

                break;
            case R.id.option13:
                if (checked)
                    qsnOneScore += 0;

                break;

            //Check the correctness of question 2

            case R.id.option21:
                if (checked)
                    qsnTwoScore += 5;
                else
                    qsnTwoScore -= 5;

                break;
            case R.id.option22:
                if (checked)
                    qsnTwoScore += 0;

                break;
            case R.id.option23:
                if (checked)
                    qsnTwoScore += 0;

                break;


            //Check the correctness of question 3

            case R.id.option31:
                if (checked)
                    qsnThreeScore += 5;
                else
                    qsnThreeScore -= 5;

                break;
            case R.id.option32:
                if (checked)
                    qsnThreeScore += 0;

                break;
            case R.id.option33:
                if (checked)
                    qsnThreeScore += 0;

                break;


            //Check the correctness of question 4

            case R.id.option41:
                if (checked)
                    qsnFourScore += 5;
                else
                    qsnFourScore -= 5;

                break;
            case R.id.option42:
                if (checked)
                    qsnFourScore += 0;

                break;
            case R.id.option43:
                if (checked)
                    qsnFourScore += 0;

                break;
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.check1:
                if (checked)
                    //
                    qsnFiveScore += 5;
                else
                    qsnFiveScore -= 5;

                break;
            case R.id.check2:
                if (checked)
                    //
                    qsnFiveScore += 0;
                break;

            case R.id.check3:
                if (checked)
                    //
                    qsnFiveScore += 5;
                else
                    qsnFiveScore -= 5;

                break;

            case R.id.check4:
                if (checked)
                    //
                    qsnFiveScore += 5;
                else
                    qsnFiveScore -= 5;


        }
    }


    public void printScore(View view) {
        //@param candidateName is the name entered from the TextView
        EditText nameTextView = (EditText) findViewById(R.id.nameTextView);
        String candidateName = nameTextView.getText().toString();

        //@param psi is the answer given in the last question
        EditText psiTextView = (EditText) findViewById(R.id.psiTextView);
        int psi = Integer.parseInt(psiTextView.getText().toString());


        //Is the value between 25-45?
        if (psi < 25 && psi > 45) {
            qsnSixScore += 0;
        } else if (psi >= 25 && psi <= 45) {
            qsnSixScore += 5;
        }


        //@param score is the sum of all the scores for the six questions
        int score = finalScore(qsnOneScore, qsnTwoScore, qsnThreeScore, qsnFourScore, qsnFiveScore, qsnSixScore);

        Toast.makeText(this, "Dear " + candidateName + ", your score is: " + score + "/40",
                Toast.LENGTH_LONG).show();

    }

    private int finalScore(int qsnOneScore, int qsnTwoScore, int qsnThreeScore, int qsnFourScore, int qsnFiveScore, int qsnSixScore) {
        int score = qsnOneScore + qsnTwoScore + qsnThreeScore + qsnFourScore + qsnFiveScore + qsnSixScore;
        return score;
    }
}
