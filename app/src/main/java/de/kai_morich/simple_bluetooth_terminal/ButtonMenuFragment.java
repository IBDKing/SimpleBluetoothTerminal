package de.kai_morich.simple_bluetooth_terminal;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ButtonMenuFragment extends Fragment {



    private String deviceAddress;




    public ButtonMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        deviceAddress = getArguments().getString("device");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        View sendBtn = view.findViewById(R.id.terminal_start_btn);
        sendBtn.setOnClickListener(v -> startTerminal());
        return view;
    }

    public void startTerminal() {
        Bundle args = new Bundle();
        args.putString("device", deviceAddress);
        Fragment fragment = new TerminalFragment();
        fragment.setArguments(args);
        getFragmentManager().beginTransaction().replace(R.id.fragment, fragment, "terminal").addToBackStack(null).commit();
    }
}