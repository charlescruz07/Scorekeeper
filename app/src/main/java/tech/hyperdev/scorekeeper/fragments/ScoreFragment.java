package tech.hyperdev.scorekeeper.fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextThemeWrapper;
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
    private int theme;


    public ScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.theme = getArguments().getInt("theme");
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), theme);
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        // Inflate the layout for this fragment
        View rootView = localInflater.inflate(R.layout.fragment_score,container,false);
        this.teamName = getArguments().getString("team");


        tvTeamName = (TextView) rootView.findViewById(R.id.tvTeamName);
        btnPlus = (ImageButton) rootView.findViewById(R.id.btnPlus);
        btnMinus = (ImageButton) rootView.findViewById(R.id.btnMinus);
        tvScore = (TextView) rootView.findViewById(R.id.tvScore);


        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = Integer.parseInt(tvScore.getText().toString());
                int finalScore = score + 1;
                tvScore.setText(String.valueOf(finalScore));
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
            }
        });

        tvTeamName.setText(teamName);
        return rootView;
    }

    public static ScoreFragment newInstance(String teamName, int theme) {

        Bundle args = new Bundle();
        args.putString("team", teamName);
        args.putInt("theme",theme);
        ScoreFragment fragment = new ScoreFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
