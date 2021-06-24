package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //variables
    final static char array[]={'+','-'};
    static int count=1,decimalcount=0,token=0;
    private static char signs=' ';
    String editable,result;
    String ans;
    int index;
    double prev,next,answer,percen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer keys=MediaPlayer.create(this,R.raw.number);
        final MediaPlayer clearbtn=MediaPlayer.create(this,R.raw.operator);
        Button zero = (Button) findViewById(R.id.zero);
        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.three);
        Button four = (Button) findViewById(R.id.four);
        Button five = (Button) findViewById(R.id.five);
        Button six = (Button) findViewById(R.id.six);
        Button seven = (Button) findViewById(R.id.seven);
        Button eight = (Button) findViewById(R.id.eight);
        Button nine = (Button) findViewById(R.id.nine);
        Button plus = (Button) findViewById(R.id.plus);
        Button minus = (Button) findViewById(R.id.minus);
        Button multiply = (Button) findViewById(R.id.multiply);
        Button divide = (Button) findViewById(R.id.divide);
        Button decimal = (Button) findViewById(R.id.dot);
        Button percentage = (Button) findViewById(R.id.percent);
        Button equals = (Button) findViewById(R.id.equals);
        Button clear = (Button) findViewById(R.id.C);
        Button total_clear = (Button) findViewById(R.id.CE);
        EditText output = (EditText) findViewById(R.id.Answer);
        TextView history = (TextView) findViewById(R.id.History);
        output.setShowSoftInputOnFocus(false);
        ans = output.getText().toString();
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearbtn.start();
                ans = output.getText().toString();
                if (ans != "") {
                    if (ans.length() == 1) {
                        signs = ' ';
                        output.setText("");
                    } else if (ans.length() > 1) {
                        index = output.getSelectionStart();
                        int len = output.length();
                        if (index < output.length()) {
                            if (ans.charAt(index) == '+' || ans.charAt(index) == 'x'
                                    || ans.charAt(index) == '÷' || ans.charAt(index) == '-') {
                                signs = ' ';
                            }
                            if (index == 0 || output.requestFocus() == false) {
                                ans = ans.substring(1, ans.length());
                                output.setText(ans);
                            } else if (output.requestFocus() == true) {
                                ans = ans.substring(0, index) +
                                        ans.substring(index + 1, ans.length());
                                output.setText(ans);
                            } else if (index == ans.length() && output.requestFocus() == true) {
                                ans = ans.substring(0, ans.length());
                                output.setText(ans);
                            }
                        }
                    }
                }
                if (index > 1)
                    output.setSelection(index);
            }
        });
        clear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                clearbtn.start();
                final Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (clear.isPressed()) {
                            ans = output.getText().toString();
                            if (ans != "") {
                                if (ans.length() == 1) {
                                    signs = ' ';
                                    output.setText("");
                                } else if (ans.length() > 1) {
                                    index = output.getSelectionStart();
                                    int len = output.length();
                                    if (index < output.length()) {
                                        if (ans.charAt(index) == '+' || ans.charAt(index) == 'x'
                                                || ans.charAt(index) == '÷' || ans.charAt(index) == '-') {
                                            signs = ' ';
                                        }
                                        if (index == 0 || output.requestFocus() == false) {
                                            ans = ans.substring(1, ans.length());
                                            output.setText(ans);
                                        } else if (output.requestFocus() == true) {
                                            ans = ans.substring(0, index) +
                                                    ans.substring(index + 1, ans.length());
                                            output.setText(ans);
                                        } else if (index == ans.length() && output.requestFocus() == true) {
                                            ans = ans.substring(0, ans.length());
                                            output.setText(ans);
                                        }
                                    }
                                }
                            }
                            if (index > 1)
                                output.setSelection(index);
                            clear.postDelayed(this, 300);
                        } else {
                            clear.postInvalidate();
                            clear.invalidate();
                        }
                    }
                };
                clear.post(runnable);
                return true;
            }
        });
        total_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearbtn.start();
                output.setText("");
                history.setText("");
                output.setSelection(output.getSelectionStart());
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { keys.start();
                editable = output.getText().toString();
                index = output.getSelectionStart();
                if (index == 0 || output.requestFocus() == false) {
                    output.setText(output.getText() + "0");
                } else if (output.requestFocus() == true) {
                    ans = "0" + editable.substring(index, editable.length());
                    output.setText(output.getText().toString().substring(0, index) + ans);
                }
                output.setSelection(index);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { keys.start();

                editable = output.getText().toString();
                index = output.getSelectionStart();
                if (index == 0 || output.requestFocus() == false) {
                    output.setText(output.getText() + "1");
                } else if (output.requestFocus() == true) {
                    ans = "1" + editable.substring(index, editable.length());
                    output.setText(output.getText().toString().substring(0, index) + ans);
                }
                output.setSelection(index);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { keys.start();
                editable = output.getText().toString();
                index = output.getSelectionStart();
                if (index == 0 || output.requestFocus() == false) {
                    output.setText(output.getText() + "2");
                } else if (output.requestFocus() == true) {
                    ans = "2" + editable.substring(index, editable.length());
                    output.setText(output.getText().toString().substring(0, index) + ans);
                }
                output.setSelection(index);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { keys.start();
                editable = output.getText().toString();
                index = output.getSelectionStart();
                if (index == 0 || output.requestFocus() == false) {
                    output.setText(output.getText() + "3");
                } else if (output.requestFocus() == true) {
                    ans = "3" + editable.substring(index, editable.length());
                    output.setText(output.getText().toString().substring(0, index) + ans);
                }
                output.setSelection(index);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { keys.start();
                editable = output.getText().toString();
                index = output.getSelectionStart();
                if (index == 0 || output.requestFocus() == false) {
                    output.setText(output.getText() + "4");
                } else if (output.requestFocus() == true) {
                    ans = "4" + editable.substring(index, editable.length());
                    output.setText(output.getText().toString().substring(0, index) + ans);
                }
                output.setSelection(index);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { keys.start();
                editable = output.getText().toString();
                index = output.getSelectionStart();
                if (index == 0 || output.requestFocus() == false) {
                    output.setText(output.getText() + "5");
                } else if (output.requestFocus() == true) {
                    ans = "5" + editable.substring(index, editable.length());
                    output.setText(output.getText().toString().substring(0, index) + ans);
                }
                output.setSelection(index);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { keys.start();
                editable = output.getText().toString();
                index = output.getSelectionStart();
                if (index == 0 || output.requestFocus() == false) {
                    output.setText(output.getText() + "6");
                } else if (output.requestFocus() == true) {
                    ans = "6" + editable.substring(index, editable.length());
                    output.setText(output.getText().toString().substring(0, index) + ans);
                }
                output.setSelection(index);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { keys.start();
                editable = output.getText().toString();
                index = output.getSelectionStart();
                if (index == 0 || output.requestFocus() == false) {
                    output.setText(output.getText() + "7");
                } else if (output.requestFocus() == true) {
                    ans = "7" + editable.substring(index, editable.length());
                    output.setText(output.getText().toString().substring(0, index) + ans);
                }
                output.setSelection(index);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { keys.start();
                editable = output.getText().toString();
                index = output.getSelectionStart();
                if (index == 0 || output.requestFocus() == false) {
                    output.setText(output.getText() + "8");
                } else if (output.requestFocus() == true) {
                    ans = "8" + editable.substring(index, editable.length());
                    output.setText(output.getText().toString().substring(0, index) + ans);
                }
                output.setSelection(index);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { keys.start();
                editable = output.getText().toString();
                index = output.getSelectionStart();
                if (index == 0 || output.requestFocus() == false) {
                    output.setText(output.getText() + "9");
                } else if (output.requestFocus() == true) {
                    ans = "9" + editable.substring(index, editable.length());
                    output.setText(output.getText().toString().substring(0, index) + ans);
                }
                output.setSelection(index);
            }
        });
       /* sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==1){
                count=0;
                editable=output.getText().toString();
                if(signs==' '){
                    ans="-"+editable;
                }
                else if(signs!=' '){
                    if(signs=='+' || signs=='-')
                    index=editable.indexOf(signs);
                    else if(signs=='*')
                    index=editable.indexOf('x');
                        else
                    index=editable.indexOf('÷');
                    if(editable.charAt(index+1)<editable.length()-1)
                        ans=editable.substring(0,index )+"-"
                                +editable.substring(index+2,editable.length());
                    else
                ans=editable.substring(0,index )+"-";
                }
                    output.setText(ans);
                }
                else if(count==0){
                    count=1;
                    editable=output.getText().toString();
                    if(signs==' '){
                        ans=editable.substring(1, editable.length());
                    }
                    else if(signs!=' '){
                        if(signs=='+' || signs=='-')
                            index=editable.indexOf(signs);
                        else if(signs=='*')
                            index=editable.indexOf('x');
                        else
                            index=editable.indexOf('÷');
                        if(editable.charAt(index+2)!='\0')
                            ans=editable.substring(0,index )
                                    +editable.substring(index+2,editable.length());
                        else
                            ans=editable.substring(0,index );
                    }
                    output.setText(ans);
                }
                output.setSelection(output.getSelectionStart());
            }
        });*/
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { keys.start();
                if (decimalcount != 1) {
                    editable = output.getText().toString();
                    index = output.getSelectionStart();
                    if (decimalcount == 0)
                        decimalcount = 1;
                    if (index == 0 || output.requestFocus() == false) {
                        output.setText(output.getText() + ".");
                    } else if (output.requestFocus() == true) {
                        ans = "." + editable.substring(index, editable.length());
                        output.setText(output.getText().toString().substring(0, index) + ans);
                    }
                }
                output.setSelection(output.getSelectionStart());
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { keys.start();
                editable = output.getText().toString();
                if (signs == ' ' && output.getText().length()!=0) {
                    decimalcount = 0;
                    signs = '+';
                    count = 1;
                    if (editable == "")
                        output.setText("0");
                    prev = Double.parseDouble(output.getText().toString());
                    output.setText(output.getText() + "+");
                }
                output.setSelection(output.getSelectionStart());
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { keys.start();
                if (signs == ' ' && output.getText().length()!=0) {
                    count = 1;
                    decimalcount = 0;
                    signs = '-';
                    prev = Double.parseDouble(output.getText().toString());
                    output.setText(output.getText() + "-");
                }
                output.setSelection(output.getSelectionStart());
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { keys.start();
                if (signs == ' ' &&  output.getText().length()!=0) {
                    count = 1;
                    decimalcount = 0;
                    signs = '*';
                    prev = Double.parseDouble(output.getText().toString());
                    output.setText(output.getText() + "x");
                }
                output.setSelection(output.getSelectionStart());
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { keys.start();
                if (signs == ' ' &&  output.getText().length()!=0) {
                    count = 1;
                    decimalcount = 0;
                    signs = '/';
                    prev = Double.parseDouble(output.getText().toString());
                    output.setText(output.getText() + "÷");
                }
                output.setSelection(output.getSelectionStart());
            }
        });
        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { keys.start();
                String ans2;
                editable=output.getText().toString();
                if(output.getSelectionStart()>editable.indexOf(signs) || output.getSelectionStart()>editable.indexOf('x')
                        ||output.getSelectionStart()>editable.indexOf('÷'))
                    if(signs!=' ' && output.getText().length()!=0){
                        decimalcount=0;

                            ans=editable.substring(0,editable.indexOf('x'));
                            ans2=editable.substring(editable.indexOf('x')+1,editable.length());
                            if(ans2.length()!=0) {
                                history.setText(ans + "x" + ans2 + "%");
                                if (token == 1) {
                                    next = Double.parseDouble(ans2);
                                    answer = percen * (next / 100);
                                } else {
                                    prev = Double.parseDouble(ans);
                                    next = Double.parseDouble(ans2);
                                    answer = prev * (next / 100);
                                }


                                result = Double.toString(answer);
                                output.setText(result);
                                signs = ' ';
                                decimalcount = 0;
                            }
                    }
                else
                    if(signs==' ' && output.getText().length()!=0){
                        decimalcount=0;
                        editable=output.getText().toString();
                        signs='*';
                        percen=Double.parseDouble(editable)/100;
                        token=1;
                        output.setText(output.getText().toString()+"%x");
                    }
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { keys.start();

                ans = output.getText().toString();
                if (ans.substring(ans.indexOf(signs) + 1, ans.length()) != null) {
                    switch (signs) {
                        case '+':
                            editable = ans.substring(ans.indexOf('+') + 1, ans.length());
                            history.setText(ans);
                            next = Double.parseDouble(editable);
                            answer = (next) + (prev);
                            result = Double.toString(answer);
                            output.setText(result);
                            break;
                        case '-':
                            editable = ans.substring(ans.indexOf('-') + 1, ans.length());
                            history.setText(ans);
                            next = Double.parseDouble(editable);
                            answer = (prev) - (next);
                            result = Double.toString(answer);
                            output.setText(result);
                            break;
                        case '*':
                            editable = ans.substring(ans.indexOf('x') + 1, ans.length());
                            history.setText(ans);
                            next = Double.parseDouble(editable);
                            if(token==1)
                                answer=percen*next;
                            else
                                answer = prev * next;
                            result = Double.toString(answer);
                            output.setText(result);
                            break;
                        case '/':
                            editable = ans.substring(ans.indexOf('÷') + 1, ans.length());
                            history.setText(ans);
                            next = Double.parseDouble(editable);
                            answer = prev / next;
                            result = Double.toString(answer);
                            output.setText(result);
                    }
                    signs = ' ';
                    decimalcount = 0;
                }
            }
        });

    }
}