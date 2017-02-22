package com.example.hluan.mysecondapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePage extends AppCompatActivity {
   Button myButton,Right,Left,Up,Down;
   List<TextView> textView;
    Integer[] matrix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
        myButton=(Button) findViewById(R.id.back);
        myButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GamePage.this, MainActivity.class);
                startActivity(i);
            }
        });
        Right=(Button) findViewById(R.id.Right);
        Right.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                for (Integer i = 0; i < 4; i++) {
                    for (Integer j = 3; j >= 0; j--) {
                        Integer currentVal = matrix[4 * i + j];
                        if (currentVal == 0)
                            continue;
                        for (Integer k = 1; k <= j; k++) {
                            if(matrix[4 * i + j - k]!=0&&matrix[4 * i + j - k]!=currentVal)
                                break;
                            if (matrix[4 * i + j - k] == currentVal) {
                                matrix[4 * i + j] = currentVal * 2;
                                matrix[4 * i + j - k] = 0;
                                break;
                            }
                        }
                    }
                }
                //////delete 0 in the line

                    for (Integer i = 0; i < 4; i++) {

                        for (Integer j = 3; j >= 0; j--) {

                            for (Integer cou = 0; cou < 4; cou++) {

                               if (matrix[4 * i + j] == 0) {
                                    for (Integer k = 0; k < j; k++) {
                                        matrix[4 * i + j - k] = matrix[i * 4 + j - k - 1];

                                }
                                matrix[4 * i] = 0;
                            }
                        }
                    }
                }
                    if (GenerateNew())
                        Refresh();
                    else {
                        for (Integer i = 0; i < 16; i++) {
                            matrix[i] = 0;
                        }
                    }

            }
        });

        Left=(Button)findViewById(R.id.Left);
        Left.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                for (Integer i = 0; i < 4; i++) {
                    for (Integer j = 0; j <= 3; j++) {
                        Integer currentVal = matrix[4 * i + j];
                        if (currentVal == 0)
                            continue;
                        for (Integer k = 1; k <=3-j; k++) {
                            if(matrix[4 * i + j + k]!=0&&matrix[4 * i + j + k]!=currentVal)
                                break;
                            if (matrix[4 * i + j + k] == currentVal) {
                                matrix[4 * i + j] = currentVal * 2;
                                matrix[4 * i + j + k] = 0;
                                break;
                            }
                        }
                    }
                }
                //////delete 0 in the line

                for (Integer i = 0; i < 4; i++) {

                    for (Integer j = 0; j <= 3; j++) {

                        for (Integer cou = 0; cou < 4; cou++) {

                            if (matrix[4 * i + j] == 0) {
                                for (Integer k = 0; k <3-j; k++) {
                                    matrix[4 * i + j + k] = matrix[i * 4 + j + k + 1];

                                }
                                matrix[4 * i+3] = 0;
                            }
                        }
                    }
                }
                if (GenerateNew())
                    Refresh();
                else {
                    for (Integer i = 0; i < 16; i++) {
                        matrix[i] = 0;
                    }
                }
            }
        });

        Up=(Button)findViewById(R.id.UP);
        Up.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                for (Integer j = 0; j <= 3; j++) {
                for (Integer i = 0; i < 4; i++) {
                        Integer currentVal = matrix[4 * i + j];
                        if (currentVal == 0)
                            continue;
                        for (Integer k = 1; k <=3-i; k++) {
                            if(matrix[4 * (i+k) + j ]!=0&&matrix[4 * (i+k)+ j]!=currentVal)
                                break;
                            if (matrix[4 * (i+k)+ j ] == currentVal) {
                                matrix[4 * i + j] = currentVal * 2;
                                matrix[4 * (i+k) + j] = 0;
                                break;
                            }
                        }
                    }
                }
                //////delete 0 in the line
                for (Integer j = 0; j <= 3; j++) {
                for (Integer i = 0; i < 4; i++) {
                     for (Integer cou = 0; cou < 4; cou++) {

                            if (matrix[4 * i + j] == 0) {
                                for (Integer k = 0; k <3-i; k++) {
                                    matrix[4 * (i+k) + j] = matrix[4 * (i+k+1) + j];

                                }
                                matrix[4 * 3+j] = 0;
                            }
                        }
                    }
                }
                if (GenerateNew())
                    Refresh();
                else {
                    for (Integer i = 0; i < 16; i++) {
                        matrix[i] = 0;
                    }
                }
            }
        });



    Down=(Button) findViewById(R.id.Down);
        Down.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                for (Integer j = 0; j <= 3; j++) {
                    for (Integer i = 3; i>=0; i--) {
                        Integer currentVal = matrix[4 * i + j];
                        if (currentVal == 0)
                            continue;
                        for (Integer k = 1; k <=i; k++) {
                            if(matrix[4 * (i-k) + j ]!=0&&matrix[4 * (i-k)+ j]!=currentVal)
                                break;
                            if (matrix[4 * (i-k)+ j ] == currentVal) {
                                matrix[4 * i + j] = currentVal * 2;
                                matrix[4 * (i-k) + j] = 0;
                                break;
                            }
                        }
                    }
                }
                //////delete 0 in the line
                for (Integer j = 0; j <= 3; j++) {
                    for (Integer i = 3; i >=0; i--) {
                        for (Integer cou = 0; cou < 4; cou++) {

                            if (matrix[4 * i + j] == 0) {
                                for (Integer k = 0; k <i; k++) {
                                    matrix[4 * (i-k) + j] = matrix[4 * (i-k-1) + j];

                                }
                                matrix[j] = 0;
                            }
                        }
                    }
                }
                if (GenerateNew())
                    Refresh();
                else {
                    for (Integer i = 0; i < 16; i++) {
                        matrix[i] = 0;
                    }
                }
            }
        });





        matrix=new Integer[16];
        for(Integer i=0;i<16;i++)
        {
            matrix[i]=0;
        }
        for(Integer i=0;i<2;i++) {
            Random rand = new Random();
            Integer temp = rand.nextInt(15) + 1;
            matrix[temp] = 2;
        }
        textView=new ArrayList<TextView>();
           // Integer ID= Integer.parseInt("@+id/b"+i.toString());
        textView.add((TextView) this.findViewById(R.id.b0));
        textView.add((TextView) this.findViewById(R.id.b1));
        textView.add((TextView) this.findViewById(R.id.b2));
        textView.add((TextView) this.findViewById(R.id.b3));
        textView.add((TextView) this.findViewById(R.id.b4));
        textView.add((TextView) this.findViewById(R.id.b5));
        textView.add((TextView) this.findViewById(R.id.b6));
        textView.add((TextView) this.findViewById(R.id.b7));
        textView.add((TextView) this.findViewById(R.id.b8));
        textView.add((TextView) this.findViewById(R.id.b9));
        textView.add((TextView) this.findViewById(R.id.b10));
        textView.add((TextView) this.findViewById(R.id.b11));
        textView.add((TextView) this.findViewById(R.id.b12));
        textView.add((TextView) this.findViewById(R.id.b13));
        textView.add((TextView) this.findViewById(R.id.b14));
        textView.add((TextView) this.findViewById(R.id.b15));
        for(Integer i=0;i<16;i++)
        {

            textView.get(i).setText(" "+matrix[i]);


        }


    }
    public boolean GenerateNew()
    {
        List<Integer> blank=new ArrayList<Integer>();
        Integer count=0;
        for(Integer i=0;i<16;i++)
        {
            if(matrix[i]==0)
            {
                count++;
                blank.add(i);
            }

        }
        if(blank.size()<=1)
            return false;
        else
        {
            for(Integer i=0;i<2;i++) {
                Random rand = new Random();
                Integer temp = rand.nextInt(blank.size() - 1) + 1;
                matrix[blank.get(temp)] = 2;
                blank.remove(temp);
            }

            return true;
        }
    }
    public void Refresh()
    {
        for(Integer i=0;i<16;i++)
        {

            textView.get(i).setText(" "+matrix[i]);


        }
    }



}
