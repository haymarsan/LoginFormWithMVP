package hms.com.loginformwithmvp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import hms.com.loginformwithmvp.R;
import hms.com.loginformwithmvp.utils.ConfigUtils;
import hms.com.loginformwithmvp.views.LoginView;

public class HomeActivity extends BaseActivity  {

    private static final String KEY_EMAIL = "KEY_EMAIL";

    public static final Intent newIntent(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        //intent.putExtra(KEY_EMAIL, email);
        return intent;
    }
    @BindView(R.id.txtUserEmail)
    TextView txtUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //txtUserEmail.setText(KEY_EMAIL);

    }

}
