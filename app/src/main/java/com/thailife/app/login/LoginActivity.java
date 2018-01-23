package com.thailife.app.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.thailife.app.main.MainActivity;
import com.thailife.app.MainRegister;
import com.thailife.app.R;
import com.thailife.app.SharedPref;
import com.thailife.app.base.BaseActivity;
import com.thailife.app.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    ActivityLoginBinding binding;
    private TextView info;
    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private SharedPreferences sharedPreferences;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);
        //Facebook
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        binding = DataBindingUtil.setContentView(LoginActivity.this, R.layout.activity_login);

        info = (TextView) findViewById(R.id.info);
        loginButton = (LoginButton) findViewById(R.id.btnLoginFace);


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                SharedPref.setIsLogin(LoginActivity.this, true);
                Intent intentLogin = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intentLogin);
                Log.d("Get Token", loginResult.getAccessToken().getToken());
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
//                Log.d(TAG, "onError: "+error.getMessage());
            }
        });

        bindView();

        binding.textForgotpassword.setPaintFlags(binding.textForgotpassword.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        // Username
        binding.edtUsername.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    binding.ivUsername.setVisibility(View.VISIBLE);
                    binding.edtUsername.setHint(R.string.hintUsername);
                } else {
                    binding.ivUsername.setVisibility(View.GONE);
                    binding.edtUsername.setHint("");
                }
                if (binding.edtUsername.length() != 0) {
                    binding.ivUsername.setVisibility(View.GONE);
                }
            }
        });

        binding.edtUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (binding.edtUsername.getText().toString().length() > 7 && binding.edtPassword.getText().toString().length() > 7
                        && binding.edtUsername.getText().toString().length() < 16 && binding.edtPassword.getText().toString().length() < 16) {

                    setButtonEnable(binding.btnLogin, true);
                } else {
                    setButtonEnable(binding.btnLogin, false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.edtUsername.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    binding.edtPassword.requestFocus();
                    return true;
                } else {
                    return false;
                }

            }
        });


        binding.edtPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    closeKeyboard();
                    binding.edtPassword.clearFocus();
                    return true;
                } else {
                    return false;
                }
            }
        });


        //Password
        binding.edtPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    binding.ivPassword.setVisibility(View.VISIBLE);
                    binding.edtPassword.setHint(R.string.hintPassword);
                } else {
                    binding.ivPassword.setVisibility(View.GONE);
                    binding.edtPassword.setHint("");
                }
                if (binding.edtPassword.length() != 0) {
                    binding.ivPassword.setVisibility(View.GONE);
                }
            }
        });

        binding.edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.edtUsername.getText().toString().length() > 7 && binding.edtPassword.getText().toString().length() > 7
                        && binding.edtUsername.getText().toString().length() < 16 && binding.edtPassword.getText().toString().length() < 16) {

                    setButtonEnable(binding.btnLogin, true);
                } else {
                    setButtonEnable(binding.btnLogin, false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


// Set Password
        binding.edtPassword.setTransformationMethod(new PasswordTransformationMethod());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void bindView() {
        setButtonEnable(binding.btnLogin, false);
        setButtonEnable(binding.btnRegis, true);
        binding.btnLogin.setOnClickListener(this);
        binding.btnRegis.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                SharedPref.setIsLogin(LoginActivity.this, true);
                Intent intentLogin = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intentLogin);
                finish();
            case R.id.btnRegis:
                Intent intentRegis = new Intent(LoginActivity.this, MainRegister.class);
                startActivity(intentRegis);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        closeKeyboard();
        binding.viewLogin.setFocusableInTouchMode(true);
        binding.viewLogin.requestFocus();

        return super.onTouchEvent(event);
    }
}
