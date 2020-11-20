package com.lilac.lilacstory.Register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.lilac.lilacstory.Login.LoginActivity;
import com.lilac.lilacstory.R;

public class RegisterAcitivity extends AppCompatActivity implements Contract.View {
    EditText edt_Name,edt_Email,edt_Passwd,edt_CheckPasswd;
    Contract.Presenter presenter;
    Button btn_Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new RegisterPresenter(this);
        initializeView();
        initializeViewListener();
    }

    @Override
    public void MoveToLoginActivity() {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

    @Override
    public void initializeView() {
        setContentView(R.layout.activity_register);
        edt_Name = findViewById(R.id.edt_Nickname);
        edt_Email = findViewById(R.id.edt_Email); edt_Passwd = findViewById(R.id.edt_passwd);
        edt_CheckPasswd = findViewById(R.id.edt_checkpasswd);

        btn_Register = findViewById(R.id.btn_register_submit);
    }

    @Override
    public void initializeViewListener() {
        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.RegisterUserData(edt_Email.getText().toString(),edt_Passwd.getText().toString());
            }
        });
    }

}
