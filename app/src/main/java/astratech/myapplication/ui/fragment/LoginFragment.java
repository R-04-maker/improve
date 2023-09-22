package astratech.myapplication.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import astratech.myapplication.R;
import astratech.myapplication.ui.activity.PeminatanActivity;
import smartdevelop.ir.eram.showcaseviewlib.GuideView;
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType;
import smartdevelop.ir.eram.showcaseviewlib.config.Gravity;
import smartdevelop.ir.eram.showcaseviewlib.listener.GuideListener;

public class LoginFragment extends Fragment {

    private EditText mTxtUname;
    private EditText mTxtPassword;
    private Button mBtnLogin;
    private ConstraintLayout mConstraintLayout;

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
        mConstraintLayout = view.findViewById(R.id.constraintLayout6);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new GuideView.Builder(getContext())
                .setTitle("Masuk")
                .setContentText("Gunakan akun Sistem \n Informasi Akademik (SIA) anda \n Untuk masuk ke aplikasi")
                .setTargetView(mConstraintLayout)
                .setGravity(Gravity.center)
                .setDismissType(DismissType.anywhere)
                .setGuideListener(new GuideListener() {
                    @Override
                    public void onDismiss(View view) {
                        new GuideView.Builder(getContext())
                                .setContentText("Saat ini masukkan nilai apapun")
                                .setTargetView(mTxtUname)
                                .setGravity(Gravity.center)
                                .setDismissType(DismissType.anywhere)
                                .build()
                                .show();
                    }
                })
                .build()
                .show();
    }

    private boolean validate(EditText mTxtEmail, EditText mTxtPassword){

        boolean valid = true;
        if(mTxtEmail.getText().toString().length() == 0 && mTxtPassword.getText().toString().length() == 0 ){
            mTxtEmail.setError("Wajib diisi !");
            mTxtPassword.setError("Wajib diisi !");
            valid = false;
        }
        if(mTxtEmail.getText().toString().length() != 0 && mTxtPassword.getText().toString().length() == 0 ){
            mTxtPassword.setError("Wajib diisi !");
            valid = false;
        }
        else if(mTxtEmail.getText().toString().length() == 0){
            mTxtEmail.setError("Wajib diisi !");
            valid = false;
        }
        else if(mTxtPassword.getText().toString().length() == 0){
            mTxtPassword.setError("Wajib diisi !");
            valid = false;
        }else{
            Intent intent = new Intent(getContext(), PeminatanActivity.class);
            startActivity(intent);
//            Toast.makeText(getContext(), "Selamat Datang, Nazwa", Toast.LENGTH_SHORT).show();
        }
        return valid;
    }
}
