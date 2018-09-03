package hms.com.loginformwithmvp.data.vo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class LoginVO extends RealmObject {

    @Required
    @PrimaryKey
    private String email;

    private String password;

    public LoginVO() {
    }

    public LoginVO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
