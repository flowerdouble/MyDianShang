package zhangchaofei.mydianshang.mine.model;

import java.util.HashMap;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhangchaofei.mydianshang.mine.bean.MessBase;
import zhangchaofei.mydianshang.utils.RetroFactoryPost;

/**
 * Created by 张超飞 on 2017/11/14.
 */

public class ModelMess implements IModelMessage {
   private MessBase.DataBean data;
    public void setOnMessFinish(OnMessFinish onMessFinish) {
        this.onMessFinish = onMessFinish;
    }
    public interface OnMessFinish {
        void Finish(MessBase.DataBean data);
    }
    private OnMessFinish onMessFinish;
    @Override
    public void getUrl(String uid) {
        HashMap<String, String> map = new HashMap<>();
        map.put("UID", uid);
       RetroFactoryPost.getInstance().getMess("user/getUserInfo", map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MessBase>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(MessBase messBase) {
                        data = messBase.getData();
                        onMessFinish.Finish(data);
                    }
                });
    }
}