package com.example.a5alumno.ejercicio8_fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * Created by A5Alumno on 25/11/2016.
 */
public class SecondFragment extends Fragment{

    public interface getDataInterface{
        long setTextNumber();
    }

    private getDataInterface mDataInterface;
    public TextView datatxt;
    private long num=0;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            this.mDataInterface = (getDataInterface) context;
        }catch(ClassCastException e){
            throw new ClassCastException(this.getActivity().toString()+" must implement OnSecondFragmentInterface");
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //private final Random numGenerator = new Random();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.second_fragment,container,false);


        datatxt = (TextView) fragView.findViewById(R.id.randomNumber);
        return fragView;
    }

    public void setRnumberText(long number){

        //this.num=number;
        datatxt.setText(Long.toString(number));
       /* while(this.datatxt==null){

        }
       datatxt.setText(Long.toString(number));*/

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       //datatxt.setText(Long.toString(this.num));
        this.num=mDataInterface.setTextNumber();
        datatxt.setText(Long.toString(this.num));
    }
}
