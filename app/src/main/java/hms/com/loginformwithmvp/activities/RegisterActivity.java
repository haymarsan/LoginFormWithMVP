package hms.com.loginformwithmvp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import hms.com.loginformwithmvp.R;
import hms.com.loginformwithmvp.utils.ConfigUtils;
import hms.com.loginformwithmvp.utils.ScreenUtils;

public class RegisterActivity extends Activity implements View.OnClickListener {

    public static final Intent newIntent(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        return intent;
    }

    @BindView(R.id.edRegEmail)
    EditText etEmail;

    @BindView(R.id.etRegPW)
    EditText etPassword;

    @BindView(R.id.edtConPW)
    EditText etConfirmPassword;

    @BindView(R.id.btnRegister)
    Button btnRegister;

    @BindView(R.id.txtLoginAgain)
    TextView tvLoginAgain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this, this);

        btnRegister.setOnClickListener(this);
        tvLoginAgain.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnRegister:
                String email = etEmail.getText().toString();
                String pass = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();
                if (!email.equals("")) {
                    if (ScreenUtils.getInstance().validateEmailAddress(email)) {
                        if (!pass.equals("")) {
                            if (!confirmPassword.equals("")) {
                                if (pass.equals(confirmPassword)) {
                                    ConfigUtils.getInstance().saveCurrentUser(email);
                                    Intent intentToLogin = LoginActivity.newIntent(RegisterActivity.this);
                                    startActivity(intentToLogin);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Passwords don't match.", Toast.LENGTH_SHORT).show();
                                    etConfirmPassword.setText("");
                                }
                            } else {
                                etConfirmPassword.setError("Confirm Password.");
                            }

                        } else {
                            etPassword.setError("Enter password.");
                        }
                    } else {
                        etEmail.setError("Invalid email.");
                    }
                } else {
                    etEmail.setError("Enter email.");
                }
                break;
            case R.id.txtLoginAgain:
                Intent intentToLogin = LoginActivity.newIntent(RegisterActivity.this);
                startActivity(intentToLogin);
                break;
        }
    }

}
