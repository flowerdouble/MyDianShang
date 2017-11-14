package zhangchaofei.mydianshang.mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zhangchaofei.mydianshang.R;
import zhangchaofei.mydianshang.mine.presenter.PresenterLogin;
import zhangchaofei.mydianshang.utils.SharedPreferencesUtils;
import zhangchaofei.mydianshang.utils.ToastUtils;

/**
 * Created by 张超飞 on 2017/11/13.
 */

public class LoginActivity extends AppCompatActivity implements IViewLogin{
    @BindView(R.id.leftImageView)
    ImageView leftImageView;
    @BindView(R.id.titleTextView)
    TextView titleTextView;
    @BindView(R.id.rightImageView)
    ImageView rightImageView;
    @BindView(R.id.usernameEditText)
    EditText usernameEditText;
    @BindView(R.id.passwordEditText)
    EditText passwordEditText;
    @BindView(R.id.contentLinearLayout)
    LinearLayout contentLinearLayout;
    @BindView(R.id.loginTextView)
    TextView loginTextView;
    @BindView(R.id.regTextView)
    TextView regTextView;
    @BindView(R.id.backTextView)
    TextView backTextView;
    @BindView(R.id.mainLinearLayout)
    LinearLayout mainLinearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.loginTextView, R.id.regTextView, R.id.backTextView})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.loginTextView:
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if("".equals(username)||"".equals(password)){
                    ToastUtils.showLong(LoginActivity.this,"信息不完成");
                }else{
                    new PresenterLogin(this).setLoginUrl(username,password);

                }
                break;
            case R.id.regTextView:
                startActivity(new Intent(LoginActivity.this, SignActivity.class));
                break;
            case R.id.backTextView:
                break;
        }
    }

    @Override
    public void success(String code) {
        if("0".equals(code)){
            SharedPreferencesUtils.put(LoginActivity.this,"IsLogin",true);
            startActivity(new Intent(LoginActivity.this,MessageActivity.class));
            finish();
        }else{
            ToastUtils.showLong(LoginActivity.this,"账号或密码不正确");
        }
    }
}
