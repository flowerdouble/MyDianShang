package zhangchaofei.mydianshang.mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zhangchaofei.mydianshang.R;
import zhangchaofei.mydianshang.mine.presenter.PresenterSign;
import zhangchaofei.mydianshang.utils.ToastUtils;

/**
 * Created by 张超飞 on 2017/11/13.
 */

public class SignActivity extends AppCompatActivity implements IViewSign {
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
    @BindView(R.id.passwordRepeatEditText)
    EditText passwordRepeatEditText;
    @BindView(R.id.emailEditText)
    EditText emailEditText;
    @BindView(R.id.contentLinearLayout)
    LinearLayout contentLinearLayout;
    @BindView(R.id.regTextView)
    TextView regTextView;
    @BindView(R.id.mainLinearLayout)
    LinearLayout mainLinearLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.regTextView)
    public void onViewClicked() {
        String signusername = usernameEditText.getText().toString();
        String signpassword = passwordEditText.getText().toString();
        String signarginpass = passwordRepeatEditText.getText().toString();
        String signemail = emailEditText.getText().toString();

        if("".equals(signusername)||"".equals(signpassword)||"".equals(signarginpass)||"".equals(signemail)){
            ToastUtils.showLong(SignActivity.this,"信息不完整");
        }else{
            if(signpassword.equals(signarginpass)){
                new PresenterSign(this).setUrl(signusername,signpassword);
            }else{
                ToastUtils.showLong(SignActivity.this,"两次密码不一致");
            }
        }
    }
    @Override
    public void signsuccess(String code) {
        if("0".equals(code)){
            startActivity(new Intent(SignActivity.this,LoginActivity.class));
        }else{
            ToastUtils.showLong(SignActivity.this,"账号已注册");
        }
    }

}
