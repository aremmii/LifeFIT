package com.thailife.app;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.thailife.app.base.BaseActivity;
import com.thailife.app.databinding.ActivityRegisterBinding;
import com.thailife.app.login.LoginActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainRegister extends BaseActivity implements View.OnClickListener {
    ActivityRegisterBinding binding;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_regis);
        binding = DataBindingUtil.setContentView(MainRegister.this, R.layout.activity_register);

        // Name
        binding.edtRegisName.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    binding.edtRegisName.setHint(R.string.hintName);
                } else if (b) {
                    binding.edtRegisName.setHint("");
                }
            }
        });

        binding.edtRegisName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.edtRegisName.getText().toString().length() > 7 && binding.edtRegisSurname.getText().toString().length() > 7
                        && binding.edtRegisID.getText().toString().length() > 7 && binding.edtRegisTel.getText().toString().length() == 10
                        && binding.edtRegisPass.getText().toString().length() > 7 && binding.edtRegisConPass.getText().toString().length() > 7
                        && binding.edtRegisName.getText().toString().length() < 16 && binding.edtRegisSurname.getText().toString().length() < 16
                        && binding.edtRegisID.getText().toString().length() < 16
                        && binding.edtRegisPass.getText().toString().length() < 16 && binding.edtRegisConPass.getText().toString().length() < 16
                        && binding.checkBox.isChecked()) {
                    setButtonEnable(binding.btnOk, true);
                } else {
                    setButtonEnable(binding.btnOk, false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // Surname
        binding.edtRegisSurname.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    binding.edtRegisSurname.setHint(R.string.hintSurname);
                } else if (b) {
                    binding.edtRegisSurname.setHint("");
                }
            }
        });

        binding.edtRegisSurname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.edtRegisName.getText().toString().length() > 7 && binding.edtRegisSurname.getText().toString().length() > 7
                        && binding.edtRegisID.getText().toString().length() > 7 && binding.edtRegisTel.getText().toString().length() == 10
                        && binding.edtRegisPass.getText().toString().length() > 7 && binding.edtRegisConPass.getText().toString().length() > 7
                        && binding.edtRegisName.getText().toString().length() < 16 && binding.edtRegisSurname.getText().toString().length() < 16
                        && binding.edtRegisID.getText().toString().length() < 16
                        && binding.edtRegisPass.getText().toString().length() < 16 && binding.edtRegisConPass.getText().toString().length() < 16
                        && binding.checkBox.isChecked()) {
                    setButtonEnable(binding.btnOk, true);
                } else {
                    setButtonEnable(binding.btnOk, false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // ID
        binding.edtRegisID.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    binding.edtRegisID.setHint(R.string.hintID);
                } else if (b) {
                    binding.edtRegisID.setHint("");
                }
            }
        });

        binding.edtRegisID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.edtRegisName.getText().toString().length() > 7 && binding.edtRegisSurname.getText().toString().length() > 7
                        && binding.edtRegisID.getText().toString().length() > 7 && binding.edtRegisTel.getText().toString().length() == 10
                        && binding.edtRegisPass.getText().toString().length() > 7 && binding.edtRegisConPass.getText().toString().length() > 7
                        && binding.edtRegisName.getText().toString().length() < 16 && binding.edtRegisSurname.getText().toString().length() < 16
                        && binding.edtRegisID.getText().toString().length() < 16
                        && binding.edtRegisPass.getText().toString().length() < 16 && binding.edtRegisConPass.getText().toString().length() < 16
                        && binding.checkBox.isChecked()) {
                    setButtonEnable(binding.btnOk, true);
                } else {
                    setButtonEnable(binding.btnOk, false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // IDA
        binding.edtRegisIDA.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    binding.edtRegisIDA.setHint(R.string.hintIDA);
                } else if (b) {
                    binding.edtRegisIDA.setHint("");
                }
            }
        });

        binding.edtRegisIDA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.edtRegisName.getText().toString().length() > 7 && binding.edtRegisSurname.getText().toString().length() > 7
                        && binding.edtRegisID.getText().toString().length() > 7 && binding.edtRegisTel.getText().toString().length() == 10
                        && binding.edtRegisPass.getText().toString().length() > 7 && binding.edtRegisConPass.getText().toString().length() > 7
                        && binding.edtRegisName.getText().toString().length() < 16 && binding.edtRegisSurname.getText().toString().length() < 16
                        && binding.edtRegisID.getText().toString().length() < 16
                        && binding.edtRegisPass.getText().toString().length() < 16 && binding.edtRegisConPass.getText().toString().length() < 16
                        && binding.checkBox.isChecked()) {
                    setButtonEnable(binding.btnOk, true);
                } else {
                    setButtonEnable(binding.btnOk, false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // Email
        binding.edtRegisEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    binding.edtRegisEmail.setHint(R.string.hintEmail);
                } else if (b) {
                    binding.edtRegisEmail.setHint("");
                }
            }
        });

        binding.edtRegisEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editText = (EditText) binding.edtRegisEmail;

                if (binding.edtRegisName.getText().toString().length() > 7 && binding.edtRegisSurname.getText().toString().length() > 7
                        && binding.edtRegisID.getText().toString().length() > 7 && binding.edtRegisTel.getText().toString().length() == 10
                        && binding.edtRegisPass.getText().toString().length() > 7 && binding.edtRegisConPass.getText().toString().length() > 7
                        && binding.edtRegisName.getText().toString().length() < 16 && binding.edtRegisSurname.getText().toString().length() < 16
                        && binding.edtRegisID.getText().toString().length() < 16
                        && binding.edtRegisPass.getText().toString().length() < 16 && binding.edtRegisConPass.getText().toString().length() < 16
                        && binding.checkBox.isChecked()) {
                    setButtonEnable(binding.btnOk, true);
                } else {
                    setButtonEnable(binding.btnOk, false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // Tel
        binding.edtRegisTel.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    binding.edtRegisTel.setHint(R.string.hintTel);
                } else if (b) {
                    binding.edtRegisTel.setHint("");
                }
            }
        });

        binding.edtRegisTel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.edtRegisName.getText().toString().length() > 7 && binding.edtRegisSurname.getText().toString().length() > 7
                        && binding.edtRegisID.getText().toString().length() > 7 && binding.edtRegisTel.getText().toString().length() == 10
                        && binding.edtRegisPass.getText().toString().length() > 7 && binding.edtRegisConPass.getText().toString().length() > 7
                        && binding.edtRegisName.getText().toString().length() < 16 && binding.edtRegisSurname.getText().toString().length() < 16
                        && binding.edtRegisID.getText().toString().length() < 16
                        && binding.edtRegisPass.getText().toString().length() < 16 && binding.edtRegisConPass.getText().toString().length() < 16
                        && binding.checkBox.isChecked()) {
                    setButtonEnable(binding.btnOk, true);
                } else {
                    setButtonEnable(binding.btnOk, false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // Pass
        binding.edtRegisPass.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    binding.edtRegisPass.setHint(R.string.hintPass);
                } else if (b) {
                    binding.edtRegisPass.setHint("");
                }
            }
        });

        binding.edtRegisPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.edtRegisName.getText().toString().length() > 7 && binding.edtRegisSurname.getText().toString().length() > 7
                        && binding.edtRegisID.getText().toString().length() > 7 && binding.edtRegisTel.getText().toString().length() == 10
                        && binding.edtRegisPass.getText().toString().length() > 7 && binding.edtRegisConPass.getText().toString().length() > 7
                        && binding.edtRegisName.getText().toString().length() < 16 && binding.edtRegisSurname.getText().toString().length() < 16
                        && binding.edtRegisID.getText().toString().length() < 16
                        && binding.edtRegisPass.getText().toString().length() < 16 && binding.edtRegisConPass.getText().toString().length() < 16
                        && binding.checkBox.isChecked()) {
                    setButtonEnable(binding.btnOk, true);
                } else {
                    setButtonEnable(binding.btnOk, false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // Con Pass
        binding.edtRegisConPass.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    binding.edtRegisConPass.setHint(R.string.hintConPass);
                } else {
                    binding.edtRegisConPass.setHint("");
                }
            }
        });

        binding.edtRegisConPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.edtRegisName.getText().toString().length() > 7 && binding.edtRegisSurname.getText().toString().length() > 7
                        && binding.edtRegisID.getText().toString().length() > 7 && binding.edtRegisTel.getText().toString().length() == 10
                        && binding.edtRegisPass.getText().toString().length() > 7 && binding.edtRegisConPass.getText().toString().length() > 7
                        && binding.edtRegisName.getText().toString().length() < 16 && binding.edtRegisSurname.getText().toString().length() < 16
                        && binding.edtRegisID.getText().toString().length() < 16
                        && binding.edtRegisPass.getText().toString().length() < 16 && binding.edtRegisConPass.getText().toString().length() < 16
                        && binding.checkBox.isChecked()) {
                    setButtonEnable(binding.btnOk, true);
                } else {
                    setButtonEnable(binding.btnOk, false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.scrollViewRegis.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });

        binding.edtRegisName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    binding.edtRegisSurname.requestFocus();
                    return true;
                } else {
                    return false;
                }
            }
        });

        binding.edtRegisSurname.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    binding.edtRegisID.requestFocus();
                    return true;
                } else {
                    return false;
                }
            }
        });

        binding.edtRegisID.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    binding.edtRegisIDA.requestFocus();
                    return true;
                } else {
                    return false;
                }
            }
        });

        binding.edtRegisIDA.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    binding.edtRegisEmail.requestFocus();
                    return true;
                } else {
                    return false;
                }
            }
        });

        binding.edtRegisEmail.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    binding.edtRegisTel.requestFocus();
                    return true;
                } else {
                    return false;
                }
            }
        });

        binding.edtRegisTel.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    binding.edtRegisPass.requestFocus();
                    return true;
                } else {
                    return false;
                }
            }
        });

        binding.edtRegisPass.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    binding.edtRegisConPass.requestFocus();
                    return true;
                } else {
                    return false;
                }
            }
        });
        binding.edtRegisConPass.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    binding.edtRegisConPass.clearFocus();
                    closeKeyboard();
                    return true;
                } else {
                    return false;
                }
            }
        });

        bindView();

        //
    }

    private void bindView() {
        setButtonEnable(binding.btnOk, false);

        binding.ivBack.setFocusableInTouchMode(true);
        binding.ivBack.setClickable(true);
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View ivBack) {
                onBackPressed();
            }
        });

        binding.checkBox.setOnClickListener(this);
        binding.btnCondition.setOnClickListener(this);
        binding.btnOk.setOnClickListener(this);


        binding.loRegis.setClickable(true);
        binding.loRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View loRegis) {
                closeKeyboard();
            }
        });
        binding.viewMainRegis.setClickable(true);
        binding.viewMainRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyboard();
            }
        });
        binding.registerToolbar.setClickable(true);
        binding.registerToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyboard();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnOk:
                binding.btnOk.setFocusable(true);
                Intent intentOk = new Intent(MainRegister.this, LoginActivity.class);
                startActivity(intentOk);
                finish();
                break;
//            case R.id.ivBack:
//                Intent intentBack = new Intent(MainRegister.this, MainRegister.class);
//                startActivity(intentBack);
//                finish();
            case R.id.btnCondition:
                binding.btnCondition.setFocusable(true);
                Intent intentCon = new Intent(MainRegister.this, MainCondition.class);
                startActivity(intentCon);
                break;
            case R.id.checkBox:
                binding.checkBox.setFocusable(true);
                if (binding.edtRegisName.getText().toString().length() > 7 && binding.edtRegisSurname.getText().toString().length() > 7
                        && binding.edtRegisID.getText().toString().length() > 7 && binding.edtRegisTel.getText().toString().length() == 10
                        && binding.edtRegisPass.getText().toString().length() > 7 && binding.edtRegisConPass.getText().toString().length() > 7
                        && binding.edtRegisName.getText().toString().length() < 16 && binding.edtRegisSurname.getText().toString().length() < 16
                        && binding.edtRegisID.getText().toString().length() < 16 && isValidEmail(binding.edtRegisEmail.getText().toString()) == true
                        && binding.edtRegisPass.getText().toString().length() < 16 && binding.edtRegisConPass.getText().toString().length() < 16
                        && binding.checkBox.isChecked()) {
                    setButtonEnable(binding.btnOk, true);
                } else {
                    setButtonEnable(binding.btnOk, false);
                }
                break;
        }

    }


    public void validateEmail(View view) {
        String email = editText.getText().toString();
        if (isValidEmail(email)) {
            Toast.makeText(view.getContext(), "Email is valid", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(view.getContext(), "Email is invalid", Toast.LENGTH_LONG).show();
        }
    }

    public static boolean isValidEmail(String email) {
        String expression = "^[\\w\\.]+@([\\w]+\\.)+[A-Z]{2,7}$";
        CharSequence inputString = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
