package com.nabin.onlinespareparts.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.nabin.onlinespareparts.R;
import com.nabin.onlinespareparts.controller.ControllerClass;
import com.nabin.onlinespareparts.model.UserData;
import com.nabin.onlinespareparts.ui.MainWindow;

public class MainActivity extends AppCompatActivity {
    Button btn_login;
    EditText log_name, log_password;
    ImageView log_name_img, log_pass_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = findViewById(R.id.btnLogin);
        log_name = findViewById(R.id.LGName);
        log_password = findViewById(R.id.LGPassword);
        log_name_img = findViewById(R.id.LGNameimg);
        log_pass_img = findViewById(R.id.LGPassimg);
        log_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0) {
                    log_name_img.setImageResource(R.drawable.ic_check_box_black_24dp);
                } else if(start==0) {
                    log_name_img.setImageResource(R.drawable.ic_not_interested_black_24dp);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        log_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0) {
                    log_pass_img.setImageResource(R.drawable.ic_check_box_black_24dp);
                } else if(start==0) {
                    log_pass_img.setImageResource(R.drawable.ic_not_interested_black_24dp);


                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.nabin.onlinespareparts.model.UserData dataSet = new UserData();
                if (!TextUtils.isEmpty(log_name.getText().toString())) {
                    dataSet.setName(log_name.getText().toString());
                    if (!TextUtils.isEmpty(log_password.getText().toString())) {
                        dataSet.setPassword(log_password.getText().toString());
                        boolean result = new ControllerClass().CheckUser(dataSet);
                        if (result) {
                            Intent intent = new Intent(com.nabin.onlinespareparts.ui.MainActivity.this, MainWindow.class);
                            startActivity(intent);
                            log_name.setText("");
                            log_password.setText("");
                        } else {
                            Toast.makeText(com.nabin.onlinespareparts.ui.MainActivity.this, "user name or password mistake", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        log_password.setError("please enter password");
                        log_pass_img.setImageResource(R.drawable.ic_not_interested_black_24dp);
                    }
                } else {
                    log_name.setError("please enter user name");
                    log_name_img.setImageResource(R.drawable.ic_not_interested_black_24dp);

                }
            }
        });
    }
}

