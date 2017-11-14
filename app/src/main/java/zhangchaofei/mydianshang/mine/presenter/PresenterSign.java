package zhangchaofei.mydianshang.mine.presenter;

import zhangchaofei.mydianshang.mine.model.ModelSign;
import zhangchaofei.mydianshang.mine.view.IViewSign;

/**
 * Created by 张超飞 on 2017/11/14.
 */

public class PresenterSign implements ModelSign.OnSignFinish {
    private final IViewSign iViewSign;
    private final ModelSign modelSign;

    public PresenterSign(IViewSign iViewSign) {
        this.iViewSign = iViewSign;
        modelSign=new ModelSign();
        modelSign.setOnSignFinish(this);

    }
    public void setUrl(String signname,String signpass){
        modelSign.getUrl(signname,signpass);
    }

    @Override
    public void signFinish(String code) {
        iViewSign.signsuccess(code);
    }
}