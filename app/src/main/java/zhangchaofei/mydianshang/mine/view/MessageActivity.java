package zhangchaofei.mydianshang.mine.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import zhangchaofei.mydianshang.R;
import zhangchaofei.mydianshang.mine.bean.MessBase;

/**
 * Created by 张超飞 on 2017/11/14.
 */

public class MessageActivity extends AppCompatActivity implements IViewMess{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_out);

    }


    @Override
    public void success(MessBase.DataBean data) {

    }
}
