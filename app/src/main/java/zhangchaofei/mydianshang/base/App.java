package zhangchaofei.mydianshang.base;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 张超飞 on 2017/11/9.
 */

public class App extends Application {
    @Override
    public void onCreate() {

        super.onCreate();
        Fresco.initialize(this);
    }
}
