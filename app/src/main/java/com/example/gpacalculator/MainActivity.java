package com.example.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //hr = credit-hrs & mk = marks & gd = grade
    EditText hr1,hr2,hr3,hr4,hr5,hr6,hr7,hr8,hr9,hr10;
    TextView mk1,mk2,mk3,mk4,mk5,mk6,mk7,mk8,mk9,mk10,result,gd1,gd2,gd3,gd4,gd5,gd6,gd7,gd8,gd9,gd10;
    Button equalBtn,newBtn,cgpaBtn;

    //one credit Hours lists
    //Array lists for crdeitHours
    ArrayList<Integer> one_credit_hrs_marks = new ArrayList();
    //Array lists for grades
    ArrayList<String> one_credit_hrs_grades = new ArrayList();
    //Array lists for grades
    ArrayList<Double> one_credit_hrs_points = new ArrayList();

    //two credit Hours lists
    //Array lists for crdeitHours
    ArrayList<Integer> two_credit_hrs_marks = new ArrayList();
    //Array lists for grades
    ArrayList<String> two_credit_hrs_grades = new ArrayList();
    //Array lists for grades
    ArrayList<Double> two_credit_hrs_points = new ArrayList();

    //three credit Hours lists
    //Array lists for crdeitHours
    ArrayList<Integer> three_credit_hrs_marks = new ArrayList();
    //Array lists for grades
    ArrayList<String> three_credit_hrs_grades = new ArrayList();
    //Array lists for grades
    ArrayList<Double> three_credit_hrs_points = new ArrayList();

    //Four credit Hours lists
    //Array lists for crdeitHours
    ArrayList<Integer> four_credit_hrs_marks = new ArrayList();
    //Array lists for grades
    ArrayList<String> four_credit_hrs_grades = new ArrayList();
    //Array lists for grades
    ArrayList<Double> four_credit_hrs_points = new ArrayList();

    //Store items form dictionaries
    int hrs_sum = 0;
    double points_sum = 0;
    //arrayLists to store points and hrs
    ArrayList<Integer> hrs_array = new ArrayList();
    ArrayList<Double> points_array = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //All Credit hours EdittextBoxes
        hr1 = findViewById(R.id.hrtxt_1);
        hr2 = findViewById(R.id.hrtxt_2);
        hr3 = findViewById(R.id.hrtxt_3);
        hr4 = findViewById(R.id.hrtxt_4);
        hr5 = findViewById(R.id.hrtxt_5);
        hr6 = findViewById(R.id.hrtxt_6);
        hr7 = findViewById(R.id.hrtxt_7);
        hr8 = findViewById(R.id.hrtxt_8);
        hr9 = findViewById(R.id.hrtxt_9);
        hr10 = findViewById(R.id.hrtxt_10);

        //All marks EdittextBoxes
        mk1 = findViewById(R.id.marktxt_1);
        mk2 = findViewById(R.id.marktxt_2);
        mk3 = findViewById(R.id.marktxt_3);
        mk4 = findViewById(R.id.marktxt_4);
        mk5 = findViewById(R.id.marktxt_5);
        mk6 = findViewById(R.id.marktxt_6);
        mk7 = findViewById(R.id.marktxt_7);
        mk8 = findViewById(R.id.marktxt_8);
        mk9 = findViewById(R.id.marktxt_9);
        mk10 = findViewById(R.id.marktxt_10);

        //All grades TextBoxs
        gd1 = findViewById(R.id.gradetxt_1);
        gd2 = findViewById(R.id.gradetxt_2);
        gd3 = findViewById(R.id.gradetxt_3);
        gd4 = findViewById(R.id.gradetxt_4);
        gd5 = findViewById(R.id.gradetxt_5);
        gd6 = findViewById(R.id.gradetxt_6);
        gd7 = findViewById(R.id.gradetxt_7);
        gd8 = findViewById(R.id.gradetxt_8);
        gd9 = findViewById(R.id.gradetxt_9);
        gd10 = findViewById(R.id.gradetxt_10);

        //Button and result Box
        result =  findViewById(R.id.result_gpatxt);
        equalBtn = findViewById(R.id.equal_btn);
        newBtn = findViewById(R.id.new_btn);
        cgpaBtn = findViewById(R.id.cgpa_btn);

        //one credit hour list
        //Add Marks to list
        one_credit_hrs_marks.add(8);one_credit_hrs_marks.add(9);one_credit_hrs_marks.add(10);one_credit_hrs_marks.add(11);one_credit_hrs_marks.add(12);
        one_credit_hrs_marks.add(13);one_credit_hrs_marks.add(14);one_credit_hrs_marks.add(15);one_credit_hrs_marks.add(16);
        //Add quality points
        one_credit_hrs_points.add(1.0);one_credit_hrs_points.add(1.5);one_credit_hrs_points.add(2.0);one_credit_hrs_points.add(2.33);one_credit_hrs_points.add(2.67);
        one_credit_hrs_points.add(3.0);one_credit_hrs_points.add(3.33);one_credit_hrs_points.add(3.67);one_credit_hrs_points.add(4.0);
        //Add grades
        one_credit_hrs_grades.add("D-");one_credit_hrs_grades.add("D+");one_credit_hrs_grades.add("C-");one_credit_hrs_grades.add("C");one_credit_hrs_grades.add("C+");
        one_credit_hrs_grades.add("B-");one_credit_hrs_grades.add("B");one_credit_hrs_grades.add("B+");one_credit_hrs_grades.add("A");

        //two credit hour list
        //Add Marks to list
        two_credit_hrs_marks.add(16);two_credit_hrs_marks.add(17);two_credit_hrs_marks.add(18);two_credit_hrs_marks.add(19);two_credit_hrs_marks.add(20);
        two_credit_hrs_marks.add(21);two_credit_hrs_marks.add(22);two_credit_hrs_marks.add(23);two_credit_hrs_marks.add(24);two_credit_hrs_marks.add(25);
        two_credit_hrs_marks.add(26);two_credit_hrs_marks.add(27);two_credit_hrs_marks.add(28);two_credit_hrs_marks.add(29);two_credit_hrs_marks.add(30);
        two_credit_hrs_marks.add(31);two_credit_hrs_marks.add(32);

        //Add quality points
        two_credit_hrs_points.add(2.0);two_credit_hrs_points.add(2.5);two_credit_hrs_points.add(3.0);two_credit_hrs_points.add(3.5);two_credit_hrs_points.add(4.0);
        two_credit_hrs_points.add(4.33);two_credit_hrs_points.add(4.67);two_credit_hrs_points.add(5.0);two_credit_hrs_points.add(5.33);two_credit_hrs_points.add(5.67);
        two_credit_hrs_points.add(6.0);two_credit_hrs_points.add(6.33);two_credit_hrs_points.add(6.67);two_credit_hrs_points.add(7.0);two_credit_hrs_points.add(7.33);
        two_credit_hrs_points.add(7.67);two_credit_hrs_points.add(8.0);
        //Add grades
        two_credit_hrs_grades.add("D-");two_credit_hrs_grades.add("D");two_credit_hrs_grades.add("D");two_credit_hrs_grades.add("D+");two_credit_hrs_grades.add("C-");
        two_credit_hrs_grades.add("C-");two_credit_hrs_grades.add("C");two_credit_hrs_grades.add("C");two_credit_hrs_grades.add("C+");two_credit_hrs_grades.add("C+");
        two_credit_hrs_grades.add("B-");two_credit_hrs_grades.add("B-");two_credit_hrs_grades.add("B");two_credit_hrs_grades.add("B");two_credit_hrs_grades.add("B+");
        two_credit_hrs_grades.add("B+");two_credit_hrs_grades.add("A");

        //three credit hour list
        //Add Marks to list
        three_credit_hrs_marks.add(24);three_credit_hrs_marks.add(25);three_credit_hrs_marks.add(26);three_credit_hrs_marks.add(27);three_credit_hrs_marks.add(28);
        three_credit_hrs_marks.add(29);three_credit_hrs_marks.add(30);three_credit_hrs_marks.add(31);three_credit_hrs_marks.add(32);three_credit_hrs_marks.add(33);
        three_credit_hrs_marks.add(34);three_credit_hrs_marks.add(35);three_credit_hrs_marks.add(36);three_credit_hrs_marks.add(37);three_credit_hrs_marks.add(38);
        three_credit_hrs_marks.add(39);three_credit_hrs_marks.add(40);three_credit_hrs_marks.add(41);three_credit_hrs_marks.add(42);three_credit_hrs_marks.add(43);
        three_credit_hrs_marks.add(44);three_credit_hrs_marks.add(45);three_credit_hrs_marks.add(46);three_credit_hrs_marks.add(47);three_credit_hrs_marks.add(48);
        //Add quality points
        three_credit_hrs_points.add(3.0);three_credit_hrs_points.add(3.5);three_credit_hrs_points.add(4.0);three_credit_hrs_points.add(4.5);three_credit_hrs_points.add(5.0);
        three_credit_hrs_points.add(5.5);three_credit_hrs_points.add(6.0);three_credit_hrs_points.add(6.33);three_credit_hrs_points.add(6.67);three_credit_hrs_points.add(7.0);
        three_credit_hrs_points.add(7.33);three_credit_hrs_points.add(7.67);three_credit_hrs_points.add(8.0);three_credit_hrs_points.add(8.33);three_credit_hrs_points.add(8.67);
        three_credit_hrs_points.add(9.0);three_credit_hrs_points.add(9.33);three_credit_hrs_points.add(9.67);three_credit_hrs_points.add(10.0);three_credit_hrs_points.add(10.33);
        three_credit_hrs_points.add(10.67);three_credit_hrs_points.add(11.0);three_credit_hrs_points.add(11.33);three_credit_hrs_points.add(11.67);three_credit_hrs_points.add(12.0);
        //Add grades
        three_credit_hrs_grades.add("D-");three_credit_hrs_grades.add("D-");three_credit_hrs_grades.add("D");three_credit_hrs_grades.add("D");three_credit_hrs_grades.add("D+");
        three_credit_hrs_grades.add("D+");three_credit_hrs_grades.add("C-");three_credit_hrs_grades.add("C-");three_credit_hrs_grades.add("C-");three_credit_hrs_grades.add("C");
        three_credit_hrs_grades.add("C");three_credit_hrs_grades.add("C");three_credit_hrs_grades.add("C+");three_credit_hrs_grades.add("C+");three_credit_hrs_grades.add("C+");
        three_credit_hrs_grades.add("B-");three_credit_hrs_grades.add("B-");three_credit_hrs_grades.add("B-");three_credit_hrs_grades.add("B");three_credit_hrs_grades.add("B");
        three_credit_hrs_grades.add("B");three_credit_hrs_grades.add("B+");three_credit_hrs_grades.add("B+");three_credit_hrs_grades.add("B+");three_credit_hrs_grades.add("A");

        //Four credit hour list
        //Add Marks to list
        four_credit_hrs_marks.add(32);four_credit_hrs_marks.add(33);four_credit_hrs_marks.add(34);four_credit_hrs_marks.add(35);four_credit_hrs_marks.add(36);
        four_credit_hrs_marks.add(37);four_credit_hrs_marks.add(38);four_credit_hrs_marks.add(39);four_credit_hrs_marks.add(40);four_credit_hrs_marks.add(41);
        four_credit_hrs_marks.add(42);four_credit_hrs_marks.add(43);four_credit_hrs_marks.add(44);four_credit_hrs_marks.add(45);four_credit_hrs_marks.add(46);
        four_credit_hrs_marks.add(47);four_credit_hrs_marks.add(48);four_credit_hrs_marks.add(49);four_credit_hrs_marks.add(50);four_credit_hrs_marks.add(51);
        four_credit_hrs_marks.add(52);four_credit_hrs_marks.add(53);four_credit_hrs_marks.add(54);four_credit_hrs_marks.add(55);four_credit_hrs_marks.add(56);
        four_credit_hrs_marks.add(57);four_credit_hrs_marks.add(58);four_credit_hrs_marks.add(59);four_credit_hrs_marks.add(60);four_credit_hrs_marks.add(61);
        four_credit_hrs_marks.add(62);four_credit_hrs_marks.add(63);four_credit_hrs_marks.add(64);
        //Add quality points
        four_credit_hrs_points.add(4.0);four_credit_hrs_points.add(4.5);four_credit_hrs_points.add(5.0);four_credit_hrs_points.add(5.5);four_credit_hrs_points.add(6.0);
        four_credit_hrs_points.add(6.5);four_credit_hrs_points.add(7.0);four_credit_hrs_points.add(7.5);four_credit_hrs_points.add(8.0);four_credit_hrs_points.add(8.33);
        four_credit_hrs_points.add(8.67);four_credit_hrs_points.add(9.0);four_credit_hrs_points.add(9.33);four_credit_hrs_points.add(9.67);four_credit_hrs_points.add(10.0);
        four_credit_hrs_points.add(10.33);four_credit_hrs_points.add(10.67);four_credit_hrs_points.add(11.0);four_credit_hrs_points.add(11.33);four_credit_hrs_points.add(11.67);
        four_credit_hrs_points.add(12.0);four_credit_hrs_points.add(12.33);four_credit_hrs_points.add(12.67);four_credit_hrs_points.add(13.0);four_credit_hrs_points.add(13.33);
        four_credit_hrs_points.add(13.67);four_credit_hrs_points.add(14.0);four_credit_hrs_points.add(14.33);four_credit_hrs_points.add(14.67);four_credit_hrs_points.add(15.0);
        four_credit_hrs_points.add(15.33);four_credit_hrs_points.add(15.67);four_credit_hrs_points.add(16.0);
        //Add grades
        four_credit_hrs_grades.add("D-");four_credit_hrs_grades.add("D-");four_credit_hrs_grades.add("D-");four_credit_hrs_grades.add("D");four_credit_hrs_grades.add("D");
        four_credit_hrs_grades.add("D+");four_credit_hrs_grades.add("D+");four_credit_hrs_grades.add("D+");four_credit_hrs_grades.add("C-");four_credit_hrs_grades.add("C-");
        four_credit_hrs_grades.add("C-");four_credit_hrs_grades.add("C-");four_credit_hrs_grades.add("C");four_credit_hrs_grades.add("C");four_credit_hrs_grades.add("C");
        four_credit_hrs_grades.add("C");four_credit_hrs_grades.add("C+");four_credit_hrs_grades.add("C+");four_credit_hrs_grades.add("C+");four_credit_hrs_grades.add("C+");
        four_credit_hrs_grades.add("B-");four_credit_hrs_grades.add("B-");four_credit_hrs_grades.add("B-");four_credit_hrs_grades.add("B-");four_credit_hrs_grades.add("B");
        four_credit_hrs_grades.add("B");four_credit_hrs_grades.add("B");four_credit_hrs_grades.add("B");four_credit_hrs_grades.add("B+");four_credit_hrs_grades.add("B+");
        four_credit_hrs_grades.add("B+");four_credit_hrs_grades.add("B+");four_credit_hrs_grades.add("A");


        hr1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_1();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd1.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mk1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_1();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd1.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        hr2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_2();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd2.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mk2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_2();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd2.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        hr3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_3();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd3.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mk3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_3();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd3.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        hr4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_4();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd4.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mk4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_4();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd4.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        hr5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_5();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd5.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mk5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_5();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd5.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        hr6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_6();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd6.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mk6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_6();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd6.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        hr7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_7();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd7.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mk7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_7();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd7.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        hr8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_8();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd8.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mk8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_8();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd8.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        hr9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_9();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd9.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mk9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_9();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd9.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        hr10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_10();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd10.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mk10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0){
                    try{
                        sub_method_10();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    gd10.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hr1.setText("0");mk1.setText("0");gd1.setText("");
                hr2.setText("0");mk2.setText("0");gd2.setText("");
                hr3.setText("0");mk3.setText("0");gd3.setText("");
                hr4.setText("0");mk4.setText("0");gd4.setText("");
                hr5.setText("0");mk5.setText("0");gd5.setText("");
                hr6.setText("0");mk6.setText("0");gd6.setText("");
                hr7.setText("0");mk7.setText("0");gd7.setText("");
                hr8.setText("0");mk8.setText("0");gd8.setText("");
                hr9.setText("0");mk9.setText("0");gd9.setText("");
                hr10.setText("0");mk10.setText("0");gd10.setText("");

                points_sum=0;
                hrs_sum=0;
                points_array.clear();
                hrs_array.clear();
                result.setText("0");
            }
        });

        cgpaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Comming Soon",Toast.LENGTH_SHORT).show();
            }
        });

        //Equal Button action
        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                points_array.clear();
                hrs_array.clear();
                //Call all methods of equal button
                try{
                    equal_method_1();
                }catch (Exception e){
                    e.printStackTrace();
                }
                try{
                    equal_method_2();
                }catch (Exception e){
                    e.printStackTrace();
                }
                try{
                    equal_method_3();
                }catch (Exception e){
                    e.printStackTrace();
                }
                try{
                    equal_method_4();
                }catch (Exception e){
                    e.printStackTrace();
                }
                try{
                    equal_method_5();
                }catch (Exception e){
                    e.printStackTrace();
                }
                try{
                    equal_method_6();
                }catch (Exception e){
                    e.printStackTrace();
                }
                try{
                    equal_method_7();
                }catch (Exception e){
                    e.printStackTrace();
                }
                try{
                    equal_method_8();
                }catch (Exception e){
                    e.printStackTrace();
                }
                try{
                    equal_method_9();
                }catch (Exception e){
                    e.printStackTrace();
                }
                try{
                    equal_method_10();
                }catch (Exception e){
                    e.printStackTrace();
                }

                for(Integer num : hrs_array){
                    hrs_sum += num;
                }
                for(Double num : points_array){
                    points_sum += num;
                }
                try{
                    result.setText(String.valueOf(points_sum/hrs_sum));
                }catch (Exception e){
                    e.printStackTrace();
                }
                points_array.clear();
                hrs_array.clear();
                points_sum=0;
                hrs_sum=0;

            }
        });

    }

    public void sub_method_1(){
        String get_hrs = hr1.getText().toString();
        String get_marks = mk1.getText().toString();

            if(Integer.parseInt(get_hrs)==1){
                if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                    gd1.setText("F");
                }else if(get_marks==""){
                    gd1.setText("");
                }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                    gd1.setText("A");
                }
                else if(Integer.parseInt((get_marks))>20){
                    gd1.setText("Invalid");
                }else{
                    int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                    String get_grade = (String) one_credit_hrs_grades.get(get_index);
                    gd1.setText(get_grade);
                }
            }else if(Integer.parseInt(get_hrs)==2){
                if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                    gd1.setText("F");
                }else if(get_marks==""){
                    gd1.setText("");
                }
                else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                    gd1.setText("A");
                }else if(Integer.parseInt((get_marks))>40){
                    gd1.setText("Invalid");
                }else{
                    int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                    String get_grade = (String) two_credit_hrs_grades.get(get_index);
                    gd1.setText(get_grade);
                }
            }else if(Integer.parseInt(get_hrs)==3){
                if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                    gd1.setText("F");
                }else if(get_marks==""){
                    gd1.setText("");
                }
                else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                    gd1.setText("A");
                }else if(Integer.parseInt((get_marks))>60){
                    gd1.setText("Invalid");
                }else{
                    int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                    String get_grade = (String) three_credit_hrs_grades.get(get_index);
                    gd1.setText(get_grade);
                }
            }else if(Integer.parseInt(get_hrs)==4){
                if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                    gd1.setText("F");
                }else if(get_marks==""){
                    gd1.setText("");
                }
                else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                    gd1.setText("A");
                }else if(Integer.parseInt((get_marks))>80){
                    gd1.setText("Invalid");
                }else{
                    int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                    String get_grade = (String) four_credit_hrs_grades.get(get_index);
                    gd1.setText(get_grade);
                }
            }else if(get_hrs==null){
                gd1.setText("");
            }
            else if(Integer.parseInt(get_hrs)==0){
                gd1.setText("");
            }else if(Integer.parseInt(get_hrs)>4){
                gd1.setText("Invalid");
        }
    }
    public void sub_method_2(){
        String get_hrs = hr2.getText().toString();
        String get_marks = mk2.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                gd2.setText("F");
            }else if(get_marks==""){
                gd1.setText("");
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                gd2.setText("A");
            }
            else if(Integer.parseInt((get_marks))>20){
                gd2.setText("Invalid");
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) one_credit_hrs_grades.get(get_index);
                gd2.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                gd2.setText("F");
            }else if(get_marks==""){
                gd2.setText("");
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                gd2.setText("A");
            }else if(Integer.parseInt((get_marks))>40){
                gd2.setText("Invalid");
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) two_credit_hrs_grades.get(get_index);
                gd2.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                gd2.setText("F");
            }else if(get_marks==""){
                gd2.setText("");
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                gd2.setText("A");
            }else if(Integer.parseInt((get_marks))>60){
                gd1.setText("Invalid");
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) three_credit_hrs_grades.get(get_index);
                gd2.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                gd1.setText("F");
            }else if(get_marks==""){
                gd2.setText("");
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                gd2.setText("A");
            }else if(Integer.parseInt((get_marks))>80){
                gd2.setText("Invalid");
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) four_credit_hrs_grades.get(get_index);
                gd2.setText(get_grade);
            }
        }else if(get_hrs==null){
            gd2.setText("");
        }
        else if(Integer.parseInt(get_hrs)==0){
            gd2.setText("");
        }else if(Integer.parseInt(get_hrs)>4){
            gd2.setText("Invalid");
        }
    }
    public void sub_method_3(){
        String get_hrs = hr3.getText().toString();
        String get_marks = mk3.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                gd3.setText("F");
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                gd3.setText("A");
            }else if(get_marks==""){
                gd3.setText("");
            }
            else if(Integer.parseInt((get_marks))>20){
                gd3.setText("Invalid");
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) one_credit_hrs_grades.get(get_index);
                gd3.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                gd3.setText("F");
            }else if(get_marks==""){
                gd3.setText("");
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                gd3.setText("A");
            }else if(Integer.parseInt((get_marks))>40){
                gd3.setText("Invalid");
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) two_credit_hrs_grades.get(get_index);
                gd3.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                gd3.setText("F");
            }else if(get_marks==""){
                gd3.setText("");
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                gd3.setText("A");
            }else if(Integer.parseInt((get_marks))>60){
                gd3.setText("Invalid");
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) three_credit_hrs_grades.get(get_index);
                gd3.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                gd3.setText("F");
            }else if(get_marks==""){
                gd3.setText("");
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                gd3.setText("A");
            }else if(Integer.parseInt((get_marks))>80){
                gd3.setText("Invalid ");
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) four_credit_hrs_grades.get(get_index);
                gd3.setText(get_grade);
            }
        }else if(get_hrs==null){
            gd3.setText("");
        }
        else if(Integer.parseInt(get_hrs)==0){
            gd3.setText("");
        }else if(Integer.parseInt(get_hrs)>4){
            gd3.setText("Invalid");
        }
    }
    public void sub_method_4(){
        String get_hrs = hr4.getText().toString();
        String get_marks = mk4.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                gd4.setText("F");
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                gd4.setText("A");
            }else if(get_marks==""){
                gd4.setText("");
            }
            else if(Integer.parseInt((get_marks))>20){
                gd4.setText("Invalid");
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) one_credit_hrs_grades.get(get_index);
                gd4.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                gd4.setText("F");
            }else if(get_marks==""){
                gd4.setText("");
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                gd4.setText("A");
            }else if(Integer.parseInt((get_marks))>40){
                gd4.setText("Invalid");
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) two_credit_hrs_grades.get(get_index);
                gd4.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                gd4.setText("F");
            }else if(get_marks==""){
                gd4.setText("");
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                gd4.setText("A");
            }else if(Integer.parseInt((get_marks))>60){
                gd4.setText("Invalid ");
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) three_credit_hrs_grades.get(get_index);
                gd4.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                gd4.setText("F");
            }else if(get_marks==""){
                gd4.setText("");
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                gd4.setText("A");
            }else if(Integer.parseInt((get_marks))>80){
                gd4.setText("Invalid");
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) four_credit_hrs_grades.get(get_index);
                gd4.setText(get_grade);
            }
        }else if(get_hrs==null){
            gd4.setText("");
        }
        else if(Integer.parseInt(get_hrs)==0){
            gd4.setText("");
        }else if(Integer.parseInt(get_hrs)>4){
            gd4.setText("Invalid");
        }
    }
    public void sub_method_5(){
        String get_hrs = hr5.getText().toString();
        String get_marks = mk5.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                gd5.setText("F");
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                gd5.setText("A");
            }else if(get_marks==""){
                gd5.setText("");
            }
            else if(Integer.parseInt((get_marks))>20){
                gd5.setText("Invalid");
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) one_credit_hrs_grades.get(get_index);
                gd5.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                gd5.setText("F");
            }else if(get_marks==""){
                gd5.setText("");
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                gd5.setText("A");
            }else if(Integer.parseInt((get_marks))>40){
                gd5.setText("Invalid");
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) two_credit_hrs_grades.get(get_index);
                gd5.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                gd5.setText("F");
            }else if(get_marks==""){
                gd5.setText("");
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                gd5.setText("A");
            }else if(Integer.parseInt((get_marks))>60){
                gd5.setText("Invalid");
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) three_credit_hrs_grades.get(get_index);
                gd5.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                gd5.setText("F");
            }else if(get_marks==""){
                gd5.setText("");
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                gd5.setText("A");
            }else if(Integer.parseInt((get_marks))>80){
                gd5.setText("Invalid");
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) four_credit_hrs_grades.get(get_index);
                gd5.setText(get_grade);
            }
        }else if(get_hrs==null){
            gd5.setText("");
        }
        else if(Integer.parseInt(get_hrs)==0){
            gd5.setText("");
        }else if(Integer.parseInt(get_hrs)>4){
            gd5.setText("Invalid");
        }
    }
    public void sub_method_6(){
        String get_hrs = hr6.getText().toString();
        String get_marks = mk6.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                gd6.setText("F");
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                gd6.setText("A");
            }else if(get_marks==""){
                gd6.setText("");
            }
            else if(Integer.parseInt((get_marks))>20){
                gd6.setText("Invalid");
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) one_credit_hrs_grades.get(get_index);
                gd6.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                gd6.setText("F");
            }else if(get_marks==""){
                gd6.setText("");
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                gd6.setText("A");
            }else if(Integer.parseInt((get_marks))>40){
                gd6.setText("Invalid");
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) two_credit_hrs_grades.get(get_index);
                gd6.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                gd6.setText("F");
            }else if(get_marks==""){
                gd6.setText("");
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                gd6.setText("A");
            }else if(Integer.parseInt((get_marks))>60){
                gd6.setText("Invalid");
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) three_credit_hrs_grades.get(get_index);
                gd6.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                gd6.setText("F");
            }else if(get_marks==""){
                gd6.setText("");
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                gd6.setText("A");
            }else if(Integer.parseInt((get_marks))>80){
                gd6.setText("Invalid");
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) four_credit_hrs_grades.get(get_index);
                gd6.setText(get_grade);
            }
        }else if(get_hrs==null){
            gd6.setText("");
        }
        else if(Integer.parseInt(get_hrs)==0){
            gd6.setText("");
        }else if(Integer.parseInt(get_hrs)>4){
            gd6.setText("Invalid");
        }
    }
    public void sub_method_7(){
        String get_hrs = hr7.getText().toString();
        String get_marks = mk7.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                gd7.setText("F");
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                gd7.setText("A");
            }else if(get_marks==""){
                gd7.setText("");
            }
            else if(Integer.parseInt((get_marks))>20){
                gd7.setText("Invalid");
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) one_credit_hrs_grades.get(get_index);
                gd7.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                gd7.setText("F");
            }else if(get_marks==""){
                gd7.setText("");
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                gd7.setText("A");
            }else if(Integer.parseInt((get_marks))>40){
                gd7.setText("Invalid");
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) two_credit_hrs_grades.get(get_index);
                gd7.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                gd7.setText("F");
            }else if(get_marks==""){
                gd7.setText("");
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                gd7.setText("A");
            }else if(Integer.parseInt((get_marks))>60){
                gd7.setText("Invalid");
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) three_credit_hrs_grades.get(get_index);
                gd7.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                gd7.setText("F");
            }else if(get_marks==""){
                gd7.setText("");
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                gd7.setText("A");
            }else if(Integer.parseInt((get_marks))>80){
                gd7.setText("Invalid");
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) four_credit_hrs_grades.get(get_index);
                gd7.setText(get_grade);
            }
        }else if(get_hrs==null){
            gd7.setText("");
        }
        else if(Integer.parseInt(get_hrs)==0){
            gd7.setText("");
        }else if(Integer.parseInt(get_hrs)>4){
            gd7.setText("Invalid");
        }
    }
    public void sub_method_8(){
        String get_hrs = hr8.getText().toString();
        String get_marks = mk8.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                gd8.setText("F");
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                gd8.setText("A");
            }else if(get_marks==""){
                gd8.setText("");
            }
            else if(Integer.parseInt((get_marks))>20){
                gd8.setText("Invalid");
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) one_credit_hrs_grades.get(get_index);
                gd8.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                gd8.setText("F");
            }else if(get_marks==""){
                gd8.setText("");
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                gd8.setText("A");
            }else if(Integer.parseInt((get_marks))>40){
                gd8.setText("Invalid");
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) two_credit_hrs_grades.get(get_index);
                gd8.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                gd8.setText("F");
            }else if(get_marks==""){
                gd8.setText("");
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                gd8.setText("A");
            }else if(Integer.parseInt((get_marks))>60){
                gd8.setText("Invalid");
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) three_credit_hrs_grades.get(get_index);
                gd8.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                gd8.setText("F");
            }else if(get_marks==""){
                gd8.setText("");
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                gd8.setText("A");
            }else if(Integer.parseInt((get_marks))>80){
                gd8.setText("Invalid");
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) four_credit_hrs_grades.get(get_index);
                gd8.setText(get_grade);
            }
        }else if(get_hrs==null){
            gd8.setText("");
        }
        else if(Integer.parseInt(get_hrs)==0){
            gd8.setText("");
        }else if(Integer.parseInt(get_hrs)>4){
            gd8.setText("Invalid");
        }
    }
    public void sub_method_9(){
        String get_hrs = hr9.getText().toString();
        String get_marks = mk9.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                gd9.setText("F");
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                gd9.setText("A");
            }else if(get_marks==""){
                gd9.setText("");
            }
            else if(Integer.parseInt((get_marks))>20){
                gd9.setText("Invalid");
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) one_credit_hrs_grades.get(get_index);
                gd9.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                gd9.setText("F");
            }else if(get_marks==""){
                gd9.setText("");
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                gd9.setText("A");
            }else if(Integer.parseInt((get_marks))>40){
                gd9.setText("Invalid");
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) two_credit_hrs_grades.get(get_index);
                gd9.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                gd9.setText("F");
            }else if(get_marks==""){
                gd9.setText("");
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                gd9.setText("A");
            }else if(Integer.parseInt((get_marks))>60){
                gd9.setText("Invalid");
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) three_credit_hrs_grades.get(get_index);
                gd9.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                gd9.setText("F");
            }else if(get_marks==""){
                gd9.setText("");
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                gd9.setText("A");
            }else if(Integer.parseInt((get_marks))>80){
                gd9.setText("Invalid");
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) four_credit_hrs_grades.get(get_index);
                gd9.setText(get_grade);
            }
        }else if(get_hrs==null){
            gd9.setText("");
        }
        else if(Integer.parseInt(get_hrs)==0){
            gd9.setText("");
        }else if(Integer.parseInt(get_hrs)>4){
            gd9.setText("Invalid");
        }
    }
    public void sub_method_10(){
        String get_hrs = hr10.getText().toString();
        String get_marks = mk10.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                gd10.setText("F");
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                gd10.setText("A");
            }else if(get_marks==""){
                gd10.setText("");
            }
            else if(Integer.parseInt((get_marks))>20){
                gd10.setText("Invalid");
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) one_credit_hrs_grades.get(get_index);
                gd10.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                gd10.setText("F");
            }else if(get_marks==""){
                gd10.setText("");
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                gd10.setText("A");
            }else if(Integer.parseInt((get_marks))>40){
                gd10.setText("Invalid");
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) two_credit_hrs_grades.get(get_index);
                gd10.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                gd10.setText("F");
            }else if(get_marks==""){
                gd10.setText("");
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                gd10.setText("A");
            }else if(Integer.parseInt((get_marks))>60){
                gd10.setText("Invalid");
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) three_credit_hrs_grades.get(get_index);
                gd10.setText(get_grade);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                gd10.setText("F");
            }else if(get_marks==""){
                gd10.setText("");
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                gd10.setText("A");
            }else if(Integer.parseInt((get_marks))>80){
                gd10.setText("Invalid");
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                String get_grade = (String) four_credit_hrs_grades.get(get_index);
                gd10.setText(get_grade);
            }
        }else if(get_hrs==null){
            gd10.setText("");
        }
        else if(Integer.parseInt(get_hrs)==0){
            gd10.setText("");
        }else if(Integer.parseInt(get_hrs)>4){
            gd10.setText("Invalid");
        }
    }

    //Equal Button Methods

    public void equal_method_1(){
        String get_hrs = hr1.getText().toString();
        String get_marks = mk1.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            hrs_array.add(1);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                points_array.add(4.0);
            }else if(Integer.parseInt((get_marks))>20){
                points_array.add(0.0);
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points =  one_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            hrs_array.add(2);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                points_array.add(8.0);
            }else if(Integer.parseInt((get_marks))>40){
                points_array.add(0.0);
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = two_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            hrs_array.add(3);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                points_array.add(12.0);
            }else if(Integer.parseInt((get_marks))>60){
                points_array.add(0.0);
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = three_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            hrs_array.add(4);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                points_array.add(16.0);
            }else if(Integer.parseInt((get_marks))>80){
                points_array.add(0.0);
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = four_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(get_hrs==null){
            hrs_array.add(0);
        }
        else if(Integer.parseInt(get_hrs)==0){
            hrs_array.add(0);
        }else if(Integer.parseInt(get_hrs)>4){
            hrs_array.add(0);
        }
    }

    public void equal_method_2(){
        String get_hrs = hr2.getText().toString();
        String get_marks = mk2.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            hrs_array.add(1);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                points_array.add(4.0);
            }else if(Integer.parseInt((get_marks))>20){
                points_array.add(0.0);
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = one_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            hrs_array.add(2);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                points_array.add(8.0);
            }else if(Integer.parseInt((get_marks))>40){
                points_array.add(0.0);
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = two_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            hrs_array.add(3);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                points_array.add(12.0);
            }else if(Integer.parseInt((get_marks))>60){
                points_array.add(0.0);
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = three_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            hrs_array.add(4);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                points_array.add(16.0);
            }else if(Integer.parseInt((get_marks))>80){
                points_array.add(0.0);
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = four_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(get_hrs==null){
            hrs_array.add(0);
        }
        else if(Integer.parseInt(get_hrs)==0){
            hrs_array.add(0);
        }else if(Integer.parseInt(get_hrs)>4){
            hrs_array.add(0);
        }
    }
    public void equal_method_3(){
        String get_hrs = hr3.getText().toString();
        String get_marks = mk3.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            hrs_array.add(1);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                points_array.add(4.0);
            }else if(Integer.parseInt((get_marks))>20){
                points_array.add(0.0);
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = one_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            hrs_array.add(2);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                points_array.add(8.0);
            }else if(Integer.parseInt((get_marks))>40){
                points_array.add(0.0);
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points =  two_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            hrs_array.add(3);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                points_array.add(12.0);
            }else if(Integer.parseInt((get_marks))>60){
                points_array.add(0.0);
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = three_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            hrs_array.add(4);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                points_array.add(16.0);
            }else if(Integer.parseInt((get_marks))>80){
                points_array.add(0.0);
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = four_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(get_hrs==null){
            hrs_array.add(0);
        }
        else if(Integer.parseInt(get_hrs)==0){
            hrs_array.add(0);
        }else if(Integer.parseInt(get_hrs)>4){
            hrs_array.add(0);
        }
    }
    public void equal_method_4(){
        String get_hrs = hr4.getText().toString();
        String get_marks = mk4.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            hrs_array.add(1);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                points_array.add(4.0);
            }else if(Integer.parseInt((get_marks))>20){
                points_array.add(0.0);
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = one_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            hrs_array.add(2);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                points_array.add(8.0);
            }else if(Integer.parseInt((get_marks))>40){
                points_array.add(0.0);
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points =  two_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            hrs_array.add(3);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                points_array.add(12.0);
            }else if(Integer.parseInt((get_marks))>60){
                points_array.add(0.0);
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = three_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            hrs_array.add(4);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                points_array.add(16.0);
            }else if(Integer.parseInt((get_marks))>80){
                points_array.add(0.0);
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points =  four_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(get_hrs==null){
            hrs_array.add(0);
        }
        else if(Integer.parseInt(get_hrs)==0){
            hrs_array.add(0);
        }else if(Integer.parseInt(get_hrs)>4){
            hrs_array.add(0);
        }
    }
    public void equal_method_5(){
        String get_hrs = hr5.getText().toString();
        String get_marks = mk5.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            hrs_array.add(1);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                points_array.add(4.0);
            }else if(Integer.parseInt((get_marks))>20){
                points_array.add(0.0);
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = one_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            hrs_array.add(2);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                points_array.add(8.0);
            }else if(Integer.parseInt((get_marks))>40){
                points_array.add(0.0);
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = two_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            hrs_array.add(3);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                points_array.add(12.0);
            }else if(Integer.parseInt((get_marks))>60){
                points_array.add(0.0);
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = three_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            hrs_array.add(4);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                points_array.add(16.0);
            }else if(Integer.parseInt((get_marks))>80){
                points_array.add(0.0);
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = four_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(get_hrs==null){
            hrs_array.add(0);
        }
        else if(Integer.parseInt(get_hrs)==0){
            hrs_array.add(0);
        }else if(Integer.parseInt(get_hrs)>4){
            hrs_array.add(0);
        }
    }
    public void equal_method_6(){
        String get_hrs = hr6.getText().toString();
        String get_marks = mk6.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            hrs_array.add(1);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                points_array.add(4.0);
            }else if(Integer.parseInt((get_marks))>20){
                points_array.add(0.0);
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = one_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            hrs_array.add(2);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                points_array.add(8.0);
            }else if(Integer.parseInt((get_marks))>40){
                points_array.add(0.0);
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = two_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            hrs_array.add(3);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                points_array.add(12.0);
            }else if(Integer.parseInt((get_marks))>60){
                points_array.add(0.0);
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = three_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            hrs_array.add(4);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                points_array.add(16.0);
            }else if(Integer.parseInt((get_marks))>80){
                points_array.add(0.0);
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = four_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(get_hrs==null){
            hrs_array.add(0);
        }
        else if(Integer.parseInt(get_hrs)==0){
            hrs_array.add(0);
        }else if(Integer.parseInt(get_hrs)>4){
            hrs_array.add(0);
        }
    }
    public void equal_method_7(){
        String get_hrs = hr7.getText().toString();
        String get_marks = mk7.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            hrs_array.add(1);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                points_array.add(4.0);
            }else if(Integer.parseInt((get_marks))>20){
                points_array.add(0.0);
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = one_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            hrs_array.add(2);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                points_array.add(8.0);
            }else if(Integer.parseInt((get_marks))>40){
                points_array.add(0.0);
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = two_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            hrs_array.add(3);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                points_array.add(12.0);
            }else if(Integer.parseInt((get_marks))>60){
                points_array.add(0.0);
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = three_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            hrs_array.add(4);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                points_array.add(16.0);
            }else if(Integer.parseInt((get_marks))>80){
                points_array.add(0.0);
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = four_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(get_hrs==null){
            hrs_array.add(0);
        }
        else if(Integer.parseInt(get_hrs)==0){
            hrs_array.add(0);
        }else if(Integer.parseInt(get_hrs)>4){
            hrs_array.add(0);
        }
    }
    public void equal_method_8(){
        String get_hrs = hr8.getText().toString();
        String get_marks = mk8.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            hrs_array.add(1);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                points_array.add(4.0);
            }else if(Integer.parseInt((get_marks))>20){
                points_array.add(0.0);
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points =  one_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            hrs_array.add(2);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                points_array.add(8.0);
            }else if(Integer.parseInt((get_marks))>40){
                points_array.add(0.0);
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = two_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            hrs_array.add(3);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                points_array.add(12.0);
            }else if(Integer.parseInt((get_marks))>60){
                points_array.add(0.0);
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = three_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            hrs_array.add(4);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                points_array.add(16.0);
            }else if(Integer.parseInt((get_marks))>80){
                points_array.add(0.0);
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = four_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(get_hrs==null){
            hrs_array.add(0);
        }
        else if(Integer.parseInt(get_hrs)==0){
            hrs_array.add(0);
        }else if(Integer.parseInt(get_hrs)>4){
            hrs_array.add(0);
        }
    }
    public void equal_method_9(){
        String get_hrs = hr9.getText().toString();
        String get_marks = mk9.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            hrs_array.add(1);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                points_array.add(4.0);
            }else if(Integer.parseInt((get_marks))>20){
                points_array.add(0.0);
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = one_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            hrs_array.add(2);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                points_array.add(8.0);
            }else if(Integer.parseInt((get_marks))>40){
                points_array.add(0.0);
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = two_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            hrs_array.add(3);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                points_array.add(12.0);
            }else if(Integer.parseInt((get_marks))>60){
                points_array.add(0.0);
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = three_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            hrs_array.add(4);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                points_array.add(16.0);
            }else if(Integer.parseInt((get_marks))>80){
                points_array.add(0.0);
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = four_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(get_hrs==null){
            hrs_array.add(0);
        }
        else if(Integer.parseInt(get_hrs)==0){
            hrs_array.add(0);
        }else if(Integer.parseInt(get_hrs)>4){
            hrs_array.add(0);
        }
    }
    public void equal_method_10(){
        String get_hrs = hr10.getText().toString();
        String get_marks = mk10.getText().toString();

        if(Integer.parseInt(get_hrs)==1){
            hrs_array.add(1);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<8){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }else if(Integer.parseInt(get_marks)>16&&Integer.parseInt(get_marks)<=20){
                points_array.add(4.0);
            }else if(Integer.parseInt((get_marks))>20){
                points_array.add(0.0);
            }else{
                int get_index = one_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = one_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==2){
            hrs_array.add(2);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<16){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>32&&Integer.parseInt((get_marks))<=40){
                points_array.add(8.0);
            }else if(Integer.parseInt((get_marks))>40){
                points_array.add(0.0);
            }else{
                int get_index = two_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = two_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==3){
            hrs_array.add(3);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<24){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>48&&Integer.parseInt((get_marks))<=60){
                points_array.add(12.0);
            }else if(Integer.parseInt((get_marks))>60){
                points_array.add(0.0);
            }else{
                int get_index = three_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points = three_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(Integer.parseInt(get_hrs)==4){
            hrs_array.add(4);
            if(Integer.parseInt((get_marks))>=0&&Integer.parseInt((get_marks))<32){
                points_array.add(0.0);
            }else if(get_marks==""){
                points_array.add(0.0);
            }
            else if(Integer.parseInt((get_marks))>64&&Integer.parseInt((get_marks))<=80){
                points_array.add(16.0);
            }else if(Integer.parseInt((get_marks))>80){
                points_array.add(0.0);
            }else{
                int get_index = four_credit_hrs_marks.indexOf(Integer.parseInt(get_marks));
                double get_points =  four_credit_hrs_points.get(get_index);
                points_array.add(get_points);
            }
        }else if(get_hrs==null){
            hrs_array.add(0);
        }
        else if(Integer.parseInt(get_hrs)==0){
            hrs_array.add(0);
        }else if(Integer.parseInt(get_hrs)>4){
            hrs_array.add(0);
        }
    }



}
