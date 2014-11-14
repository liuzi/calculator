package com.example.jiangliu.myapplication5;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * Created by jiangliu on 14-11-12.
 */
public class mainActivity extends Activity {
    //declare widget
    Button b[]=new Button[10];
    String s[]={"dot","sign","add","sub","mul","div","equ","left","right","C","ce","del","MS","mplu","MC","","sqrt","fact","ln","pow"};
    TextView print=null;
    TextView bracket=null;
    String num1="";
    String num2="";
    double num3=0;
    String result="";
    String Sign=null;
    int left_bracket=0;
    int mark=0;
    //boolean division=false;
    boolean Dot=false;
    private StringBuffer display=new StringBuffer('0');

    //delete method
    private void delete(){
        if(display.charAt(display.length()-1)=='.'){
            Dot=false;
        }
        display.deleteCharAt(display.length()-1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        //get widget
        b[0]=(Button)findViewById(R.id.button16);
        b[1]=(Button)findViewById(R.id.button12);
        b[2]=(Button)findViewById(R.id.button13);
        b[3]=(Button)findViewById(R.id.button14);
        b[4]=(Button)findViewById(R.id.button9);
        b[5]=(Button)findViewById(R.id.button10);
        b[6]=(Button)findViewById(R.id.button11);
        b[7]=(Button)findViewById(R.id.button6);
        b[8]=(Button)findViewById(R.id.button7);
        b[9]=(Button)findViewById(R.id.button8);
        Button dot=(Button)findViewById(R.id.dot);
        Button sign=(Button)findViewById(R.id.sign);
        Button add=(Button)findViewById(R.id.add);
        Button sub=(Button)findViewById(R.id.sub);
        Button mul=(Button)findViewById(R.id.mul);
        Button div=(Button)findViewById(R.id.div);
        Button equ=(Button)findViewById(R.id.equ);
        Button left=(Button)findViewById(R.id.left);
        Button right=(Button)findViewById(R.id.right);
        Button C=(Button)findViewById(R.id.C);
        Button ce=(Button)findViewById(R.id.ce);
        Button del=(Button)findViewById(R.id.del);
        Button MS=(Button)findViewById(R.id.MS);
        Button mplu=(Button)findViewById(R.id.mplu);
        Button mc=(Button)findViewById(R.id.mc);
        Button MR=(Button)findViewById(R.id.MR);
        Button sqrt=(Button)findViewById(R.id.sqrt);
        Button fact=(Button)findViewById(R.id.fact);
        Button ln=(Button)findViewById(R.id.ln);
        Button pow=(Button)findViewById(R.id.pow);
        print=(TextView)findViewById(R.id.textView);
        bracket=(TextView)findViewById(R.id.textView4);
       // Operate op=new Operate();


        //handling numbers
        class PrintNumber implements OnClickListener{
            @Override
            public void onClick(View v){
                Button btn=(Button)v;
                //shuru feiling shuzi
                if(v.getId()!=R.id.button16){
                    //if meiyou feiling shuzi shuru
                    if(mark==0){
                        if(Dot==false){
                            display.deleteCharAt(display.length()-1);
                        }
                        mark=1;
                    }
                    //if gangshurufuhao
                    else if(mark==2){
                        mark=1;
                    }
                    display.append(btn.getText());
                }
                //button 0
                else{
                    if(mark==1) {
                        display.append(btn.getText());
                    }
                    else if(mark==2){
                        display.append(btn.getText());
                        mark=0;
                    }
                    else if(mark==0){
                        if(Dot==true){
                            display.append(btn.getText());
                        }
                    }
                }
                print.setText(display);
            }
        }
        PrintNumber get=new PrintNumber();
        //add listener
        for(int i=0;i<10;i++){
            b[i].setOnClickListener(get);
        }

        //handling mark
        class PrintMark implements OnClickListener{
            @Override
            public void onClick(View v){
                Button btn=(Button)v;
                switch(v.getId()){
                    case R.id.add:
                    case R.id.sub:
                    case R.id.mul:
                        if(mark!=2){
                            mark=2;
                        }
                        else{
                            delete();
                        }
                        display.append(btn.getText());
                        Dot=false;
                        break;
                    case R.id.div:
                        if(mark!=2){
                            mark=2;
                        }
                        else{
                            delete();
                        }
                        display.append(btn.getText());
                        Dot=false;
                        break;
                    case R.id.dot:
                        //wei shuru xiaoshudian ze zhijie tianjiaxiaoshudian
                        if(Dot==false){
                            if(mark==2){
                                display.append(0);
                                mark=0;
                            }
                            display.append(btn.getText());
                        }
                        break;
                    case R.id.left:
                        display.append(btn.getText());
                        bracket.setText("left:"+left_bracket++);
                        break;
                    case R.id.right:
                        if(left_bracket!=0){
                            display.append(btn.getText());
                            bracket.setText("left:"+left_bracket--);
                        }
                        break;
                    case R.id.C:
                        display.delete(0,display.length()-1);
                        display.append('0');
                        mark=0;
                        Dot=false;
                        break;
                    case R.id.del:
                        delete();
                        break;
                    //case R.id.mc


                }
                print.setText(display);
            }
        }







    }

}
