package astratech.myapplication.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import astratech.myapplication.R;
import astratech.myapplication.ui.activity.HomeActivity;
import astratech.myapplication.ui.activity.PeminatanActivity;

public class LoginFragment extends Fragment {

    private EditText mTxtUname;
    private EditText mTxtPassword;
    private Button mBtnLogin;

    public LoginFragment(){

    }

    public static LoginFragment newInstance(){
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login, container, false);

        mBtnLogin = (Button) view.findViewById(R.id.buttonloginya);
        mTxtUname = (EditText) view.findViewById(R.id.loginnim);
        mTxtPassword = (EditText) view.findViewById(R.id.loginpass);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(mTxtUname, mTxtPassword);
            }
        });

        return view;
    }

    private boolean validate(EditText mTxtEmail,EditText mTxtPassword){

        boolean valid = true;
        if(mTxtEmail.getText().toString().length() != 0 && mTxtPassword.getText().toString().length() == 0 ){
            mTxtPassword.setError("Required");
            valid = false;
        }
        else if(mTxtEmail.getText().toString().length() == 0){
            mTxtEmail.setError("Required");
            valid = false;
        }
        else if(mTxtPassword.getText().toString().length() == 0){
            mTxtPassword.setError("Required");
            valid = false;
        }else{
            Intent intent = new Intent(getContext(), PeminatanActivity.class);
            startActivity(intent);
            Toast.makeText(getContext(), "Selamat Datang, Nazwa", Toast.LENGTH_SHORT).show();
        }
        return valid;
    }
}
