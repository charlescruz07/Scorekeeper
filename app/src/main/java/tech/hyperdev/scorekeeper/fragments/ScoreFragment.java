package tech.hyperdev.scorekeeper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tech.hyperdev.scorekeeper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {

    private String teamName;
    private TextView tvTeamName;

    public ScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_score,container,false);
        this.teamName = getArguments().getString("team");

        tvTeamName = (TextView) rootView.findViewById(R.id.tvTeamName);
        tvTeamName.setText(teamName);
        return rootView;
    }

    public static ScoreFragment newInstance(String teamName) {

        Bundle args = new Bundle();
        args.putString("team", teamName);
        ScoreFragment fragment = new ScoreFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
