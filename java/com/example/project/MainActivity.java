package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.model.ErrorResponse;
import com.example.project.model.SharedPrefManager;
import com.example.project.model.User;
import com.example.project.remote.ApiUtils;
import com.example.project.remote.UserService;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;

    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get references to form elements
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // get UserService instance
        userService = ApiUtils.getUserService();

        // set onClick action to btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get username and password entered by user
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                // validate form, make sure it is not empty
                if (validateLogin(username, password)) {
                    // do login
                    doLogin(username, password);
                }
            }
        });
    }

    /**
     * Validate value of username and password entered. Client side validation.
     *
     * @param username
     * @param password
     * @return
     */
    private boolean validateLogin(String username, String password) {
        if (username == null || username.trim().length() == 0) {
            displayToast("Username is required");
            return false;
        }
        if (password == null || password.trim().length() == 0) {
            displayToast("Password is required");
            return false;
        }
        return true;
    }

    /**
     * Call REST API to login
     *
     * @param username
     * @param password
     */
    private void doLogin(String username, String password) {

        Call call = userService.login(username, password);

        call.enqueue(new Callback() {

            @Override
            public void onResponse(Call call, Response response) {

                // received reply from REST API
                if (response.isSuccessful()) {
                    // parse response to POJO
                    User user = (User) response.body();
                    if (user.getToken() != null) {
                        // successful login. server replies a token value
                        displayToast("Login successful");
                        displayToast("Token: " + user.getToken());
                        // store value in Shared Preferences
                        SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);

                        // forward user to MainActivity
                        finish();
                        if(user.getRole().equalsIgnoreCase("student"))
                            startActivity(new Intent(getApplicationContext(), StudentMenuActivity.class));
                        if(user.getRole().equalsIgnoreCase("lecturer"))
                            startActivity(new Intent(getApplicationContext(), LecturerMenuActivity.class));

                    }
                } else if (response.errorBody() != null) {
                    // parse response to POJO
                    String errorResp = null;
                    try {
                        errorResp = response.errorBody().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ErrorResponse e = new Gson().fromJson(errorResp, ErrorResponse.class);
                    displayToast(e.getError().getMessage());
                }

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                displayToast("Error connecting to server.");
                displayToast(t.getMessage());
            }

        });


    }

    /**
     * Display a Toast message
     * @param message
     */
    public void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


}