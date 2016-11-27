package com.example.a5alumno.ejercicio8_fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements FragmentOne.OnFirstFragmentInterface, SecondFragment.getDataInterface, View.OnClickListener {

    FragmentManager fm = getSupportFragmentManager();
    SecondFragment mySecondFragment = (SecondFragment) fm.findFragmentById(R.id.fragment_second);

    private boolean mTwoPanel;
    private boolean isFragmentOne;
    long randNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTwoPanel = this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;

        if (!mTwoPanel) {
            FragmentManager fragManager = this.getSupportFragmentManager();
            FragmentTransaction fragTransaction = fragManager.beginTransaction();
            fragTransaction.replace(R.id.linearLayoutMainLandscape, new FragmentOne(), "first_fragment");
            isFragmentOne=true;
            fragTransaction.commit();
            final Button swapBtn = (Button)this.findViewById(R.id.btnSwapFragment);
            swapBtn.setOnClickListener(this);
        }

    }

    @Override
    public void onCommFromFragmentOne(long rNumber) {

        if(mTwoPanel) {
            FragmentManager fm = getSupportFragmentManager();

            SecondFragment mySecondFragment = (SecondFragment) fm.findFragmentById(R.id.fragment_second);
            mySecondFragment.setRnumberText(rNumber);
        }
        else{
            this.randNumber = rNumber;
            Log.e("TAG","random number "+this.randNumber);
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnSwapFragment){
            FragmentManager fragm = this.getSupportFragmentManager();
            FragmentTransaction fragTransaction = fragm.beginTransaction();
            if(isFragmentOne) {
                fragTransaction.replace(R.id.linearLayoutMainLandscape, new SecondFragment(),"second_fragment");
                fragTransaction.commit();




                //while(mySecondFragment.datatxt==null);
                //mySecondFragment.setRnumberText(randNumber);
               //mySecondFragment.getData(this.randNumber);
                isFragmentOne = false;
            }
            else
            {
                fragTransaction.replace(R.id.linearLayoutMainLandscape, new FragmentOne(),"first_fragment");
                fragTransaction.commit();
                isFragmentOne = true;
            }
        }
    }

    @Override
    public long setTextNumber() {
        return randNumber;
    }
}
