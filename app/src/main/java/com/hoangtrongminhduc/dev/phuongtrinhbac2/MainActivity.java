package com.hoangtrongminhduc.dev.phuongtrinhbac2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btngiai, btnxoa;
    EditText edtA, edtB, edtC;
    TextView tvkq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btngiai=(Button) findViewById(R.id.btngiai);
        btngiai.setOnClickListener(new MyEvent());
        btnxoa=(Button) findViewById(R.id.btnxoa);
        btnxoa.setOnClickListener(new MyEvent());
        edtA=(EditText) findViewById(R.id.edtA);
        edtB=(EditText) findViewById(R.id.edtB);
        edtC=(EditText) findViewById(R.id.edtC);
        tvkq=(TextView) findViewById(R.id.tvkq);
    }
    public void giaiPt(){
        int a=Integer.parseInt(edtA.getText()+"");
        int b=Integer.parseInt(edtB.getText()+"");
        int c=Integer.parseInt(edtC.getText()+"");
        String kq;
        DecimalFormat dcf=new DecimalFormat("#.00");
        if(a==0){
            if(b==0){
                if(c==0){
                    kq="Phương trình vô số nghiệm";
                }else kq="Phương trình vô nghiệm";
            }else kq="Pt có 1 nghiệm, x="+dcf.format(-c/b);
        }else {
            double delta=b*b-4*a*c;
            if(delta<0){
                kq="Phương trình vô nghiệm";
            }else
                if(delta==0){
                kq="Pt có nghiệm kép x1=x2="+dcf.format(-b/(2*a));
                } else
                    kq="Pt có 2 No: x1="+dcf.format((-b-Math.sqrt(delta))/(2*a))+"; x2="+dcf.format((-b-Math.sqrt(delta))/(2*a));
        }
        tvkq.setText(kq);
    }
    private class MyEvent implements View.OnClickListener{
        @Override
        public void onClick(View v){
            if(v==btnxoa){
                edtA.setText("");
                edtB.setText("");
                edtC.setText("");
                edtA.requestFocus();
            }else giaiPt();
        }
    }
}
