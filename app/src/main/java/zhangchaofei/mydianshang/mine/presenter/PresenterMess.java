package zhangchaofei.mydianshang.mine.presenter;

import zhangchaofei.mydianshang.mine.bean.MessBase;
import zhangchaofei.mydianshang.mine.model.ModelMess;
import zhangchaofei.mydianshang.mine.view.IViewMess;

/**
 * Created by 张超飞 on 2017/11/14.
 */

public class PresenterMess implements ModelMess.OnMessFinish{
    private final IViewMess iViewMess;
    private final ModelMess modelMess;

    public PresenterMess(IViewMess iViewMess) {
        this.iViewMess = iViewMess;
        modelMess=new ModelMess();
        modelMess.setOnMessFinish(this);
    }
    public void setUrl(String uid){
        modelMess.getUrl(uid);
    }

    @Override
    public void Finish(MessBase.DataBean data) {
        iViewMess.success(data);
    }
}