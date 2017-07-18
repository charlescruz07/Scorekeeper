package tech.hyperdev.scorekeeper.fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import tech.hyperdev.scorekeeper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment{

    private String teamName;
    private TextView tvTeamName, tvScore;
    private ImageButton btnPlus,btnMinus;
    private int globalScore;
//    OnDataPass dataPasser;


    public ScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_score,container,false);
        this.teamName = getArguments().getString("team");
        this.globalScore = getArguments().getInt("score");

        tvTeamName = (TextView) rootView.findViewById(R.id.tvTeamName);
        btnPlus = (ImageButton) rootView.findViewById(R.id.btnPlus);
        btnMinus = (ImageButton) rootView.findViewById(R.id.btnMinus);
        tvScore = (TextView) rootView.findViewById(R.id.tvScore);

        if (savedInstanceState != null) {
            globalScore = savedInstanceState.getInt("myScore");
        }

        tvScore.setText(globalScore +"");

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = Integer.parseInt(tvScore.getText().toString());
                int finalScore = score + 1;
                tvScore.setText(String.valueOf(finalScore));
                globalScore = finalScore;
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = Integer.parseInt(tvScore.getText().toString());
                int finalScore = score - 1;
                if(finalScore < 0){
                    tvScore.setText(String.valueOf(0));
                    finalScore = Integer.parseInt(tvScore.getText().toString());
                }
                tvScore.setText(String.valueOf(finalScore));
                globalScore = finalScore;

            }
        });

        tvTeamName.setText(teamName);
        return rootView;
    }

    public static ScoreFragment newInstance(String teamName, int score) {

        Bundle args = new Bundle();
        args.putString("team", teamName);
        args.putInt("score",score);
        ScoreFragment fragment = new ScoreFragment();
        fragment.setArguments(args);
        return fragment;
    }

//    public interface OnDataPass {
//        public void onDataPass(String teamName,int data);
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        dataPasser = (OnDataPass) context;
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        dataPasser.onDataPass(tvTeamName.getText().toString(),globalScore);
//    }
}
