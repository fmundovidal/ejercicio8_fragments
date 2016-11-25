package com.example.a5alumno.ejercicio8_fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment implements View.OnClickListener{

    public interface OnFirstFragmentInterface{
        void onCommFromFragmentOne(long rNumber);
    }
    private OnFirstFragmentInterface mFirstFragCallback;

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            this.mFirstFragCallback = (OnFirstFragmentInterface) context;
        }catch(ClassCastException e){
            throw new ClassCastException(this.getActivity().toString()+" must implement OnFirstFragmentInterface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.first_fragment,container,false);
        final Button btn = (Button) fragView.findViewById(R.id.updateBtn);
        btn.setOnClickListener(this);

        return fragView;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.updateBtn){
            this.mFirstFragCallback.onCommFromFragmentOne(new Random().nextInt(100));
        }
    }

    public long firstCallback(){
        return new Random().nextInt(100);
    }

}
