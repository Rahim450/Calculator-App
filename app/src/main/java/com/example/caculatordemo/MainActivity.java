package com.example.caculatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView Screen;
    private Button AC,power,back,Div,plus,mul,minus,one,two,three,four,five,six,seven,eight,nine,zero,Ans,point,equal;
    private  String input,Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Screen = (TextView) findViewById(R.id.ScreenID);

        AC= (Button) findViewById(R.id.ac_ID);
        power= (Button) findViewById(R.id.power_ID);
        back= (Button) findViewById(R.id.back_ID);
        Div=  (Button)findViewById(R.id.div_ID);
        mul= (Button) findViewById(R.id.mul_ID);
        plus= (Button) findViewById(R.id.add_ID);
        minus= (Button)findViewById(R.id.sub_ID);
        one=  (Button) findViewById(R.id.one_ID);
        two= (Button)  findViewById(R.id.two_ID);
        three= (Button) findViewById(R.id.three_ID);
        four=  (Button)findViewById(R.id.four_ID);
        five= (Button) findViewById(R.id.five_ID);
        six= (Button) findViewById(R.id.six_ID);
        seven= (Button) findViewById(R.id.seven_ID);
        eight= (Button) findViewById(R.id.eight_ID);
        nine= (Button) findViewById(R.id.nine_ID);
        zero= (Button) findViewById(R.id.zero_ID);
        Ans= (Button) findViewById(R.id.ans_ID);
        point= (Button) findViewById(R.id.point_ID);
        equal= (Button) findViewById(R.id.equal_ID);

    }

    public  void ButtonClick(View view){
        Button button =(Button)view;
        String data = button.getText().toString();
        switch (data){

            case "AC":
                input="";
                break;

            case "Ans":
                input+="Answer";
                break;

            case "*":
                input+="*";
                break;

            case "²":
                solve();
                input+="²";
                break;

            case "=":
             solve();
              Answer= input;
                break;

            case "C":
                String newText = input.substring(0,input.length()-1);
                input=newText;
                break;
            default:
                if (input==null){
                    input="";
                }
                if (data.equals("+")||data.equals("-")||data.equals("/")||data.equals("*")){
                    solve();
                }
                input+=data;
        }
        Screen.setText(input);
    }
    private  void  solve(){
    if (input.split("\\*").length==2){
        String number[] =input.split("\\*");

        try {
            double mul = Double.parseDouble(number[0])*Double.parseDouble(number[1]);
            input=mul+"";
        }
        catch (Exception e){
            //Toggle error
        }
      }

       else if (input.split("/").length==2){
            String number[] =input.split("/");

            try {
                double div = Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                input=div+"";
            }
            catch (Exception e){
                //Toggle error
            }
        }
        else if (input.split("²").length==2){
            String number[] =input.split("²");

            try {
                double pow =Math.pow(Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                input=pow+"";
            }
            catch (Exception e){
                //Toggle error
            }
        }
    else if (input.split("\\+").length==2){
        String number[] =input.split("\\+");

        try {
            double sum =Double.parseDouble(number[0])+Double.parseDouble(number[1]);
            input=sum+"";
        }
        catch (Exception e){
            //Toggle error
        }
    }
    else if (input.split("-").length==2){
        String number[] =input.split("-");
        //to substract negative number like-8-5
            if (number[0]=="" && number.length==2){
              number[0]=0+"";
            }

        try {
            double sub =Double.parseDouble(number[0])-Double.parseDouble(number[1]);
            input=sub+"";
        }
        catch (Exception e){
            //Toggle error
        }
    }
     // to remove the last digit .0 from integer result like 9 instead of 9.0

        String n[] =input.split("\\.");
       if (n.length>1){
           if (n[1].equals("0")){
               input=n[0];
           }
       }
       Screen.setText(input);
    }
}