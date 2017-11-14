package zhangchaofei.mydianshang.mine.presenter;

import zhangchaofei.mydianshang.mine.model.ModelLogin;
import zhangchaofei.mydianshang.mine.view.IViewLogin;

/**
 * Created by 张超飞 on 2017/11/14.
 */

public class PresenterLogin  implements ModelLogin.OnLoginFinish{
    private final IViewLogin iViewLogin;
    private final ModelLogin modelLogin;

    public PresenterLogin(IViewLogin iViewLogin) {
        this.iViewLogin = iViewLogin;
        modelLogin=new ModelLogin();
        modelLogin.setOnLoginFinish(this);
    }
    public  void setLoginUrl(String username,String password){
        modelLogin.getLoginUrl(username,password);
    }

    @Override
    public void LoginFinish(String code) {
        iViewLogin.success(code);
    }
}
