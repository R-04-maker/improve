package astratech.myapplication.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import astratech.myapplication.R;

public class PoinFragment extends Fragment {

    private Button mBtnLogin;

    public PoinFragment(){

    }

    public static PoinFragment newInstance(){
        return new PoinFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_point, container, false);

//        mBtnLogin = (Button) view.findViewById(R.id.btn_login);
//
//        mBtnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), HomeActivity.class);
//                startActivity(intent);
//            }
//        });

        return view;
    }
}
