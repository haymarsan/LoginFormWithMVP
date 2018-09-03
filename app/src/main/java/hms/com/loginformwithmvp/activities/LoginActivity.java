package hms.com.loginformwithmvp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hms.com.loginformwithmvp.R;
import hms.com.loginformwithmvp.presenter.LoginPresenter;
import hms.com.loginformwithmvp.utils.ConfigUtils;
import hms.com.loginformwithmvp.utils.ScreenUtils;
import hms.com.loginformwithmvp.views.LoginView;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginView {

    public static final Intent newIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @BindView(R.id.edtEmail)
    TextInputLayout etLoginEmail;

    @BindView(R.id.edtPassword)
    EditText etLoginPassword;

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.txtNewUser)
    TextView txtNewUser;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        if (!ConfigUtils.getInstance().loadCurrentUser().equals("")) {
            String email = ConfigUtils.getInstance().loadCurrentUser();
            if (email.equals("abc@gmail.com")) {
                Intent intentToHome = HomeActivity.newIntent(LoginActivity.this);
                startActivity(intentToHome);
            }
        }

        ButterKnife.bind(this, this);
        setSupportActionBar(toolbar);
        btnLogin.setOnClickListener(this);
        txtNewUser.setOnClickListener(this);

        mPresenter = new LoginPresenter();
        mPresenter.onCreate(this);

        mPresenter.onLogin("a","b");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                String email = etLoginEmail.getEditText().toString();
                String pass = etLoginPassword.getText().toString();
                if (!email.equals("")) {
                    if (ScreenUtils.getInstance().validateEmailAddress(email)) {
                        if (!pass.equals("")) {
                            if (email.equals("abc@gmail.com")) {
                                ConfigUtils.getInstance().saveCurrentUser(email);
                                Intent intentToHome = HomeActivity.newIntent(LoginActivity.this);
                                startActivity(intentToHome);
                            } else {
                                ScreenUtils.getInstance().showToast(getApplicationContext(), "No Account Found!");
                            }

                        } else {
                            etLoginPassword.setError("Enter password.");
                        }
                    } else {
                        etLoginEmail.setError("Invalid email.");
                    }
                } else {
                    etLoginEmail.setError("Enter email.");
                }
                break;
            case R.id.txtNewUser:
                Intent intentToRegister = RegisterActivity.newIntent(LoginActivity.this);
                startActivity(intentToRegister);
                break;
        }
    }


    @OnClick(R.id.fab)
    public void onClickFab(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }

    @Override
    public void showSuccessLogin() {
        String email = etLoginEmail.getEditText().toString();
        if (email.equals("")){
            Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_LONG ).show();
        }
    }

    @Override
    public void showPrompt(String message) {
        String email = etLoginEmail.getEditText().toString();
        if (!email.equals("")){
            Toast.makeText(getApplicationContext(),"Please Register if new user", Toast.LENGTH_LONG ).show();
        }
    }


//    @Override
//    public void showSuccessLogin() {
//        Toast.makeText(getApplicationContext(),"Registration Successful", Toast.LENGTH_LONG ).show();
//    }
//
//    @Override
//    public void showUserEmail() {
//        Toast.makeText(getApplicationContext(), "User Email =" + etLoginEmail.getEditText().toString(),Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void showPrompt(String message) {
//
//        Toast.makeText(getApplicationContext(),"Login Error!", Toast.LENGTH_LONG).show();
//    }
}
