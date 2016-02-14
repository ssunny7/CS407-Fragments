package com.ssunny.cs407.quizapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ssunny.cs407.quizapp.ui.R;

public class ProgressFragment extends Fragment {

    private Button nextButton;
    private ProgressNotifier callBackActivity = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_progress, container, false);

        nextButton = (Button)view.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callBackActivity != null) {
                    callBackActivity.nextClicked();
                }
            }
        });

        return view;
    }

    public interface ProgressNotifier {
        public void nextClicked();
    }

    @Override
    public void onAttach(Context context) {
        try {
            callBackActivity = (ProgressNotifier)context;
        } catch (Exception e) {
            //
        }

        super.onAttach(context);
    }
}