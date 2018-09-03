package hms.com.loginformwithmvp.presenter;

import android.content.Context;

import hms.com.loginformwithmvp.views.LoginView;

public class LoginPresenter extends BasePresenter<LoginView> {

    @Override
    public void onCreate(LoginView view) {
        super.onCreate(view);


    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    public void onLogin(String a, String b) {
        mView.showSuccessLogin();
//        mView.showUserEmail();
         mView.showPrompt(" ");
    }
}
