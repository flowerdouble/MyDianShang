package zhangchaofei.mydianshang.mine.model;

import java.util.HashMap;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhangchaofei.mydianshang.mine.bean.SignBase;
import zhangchaofei.mydianshang.utils.RetroFactoryPost;

/**
 * Created by 张超飞 on 2017/11/14.
 */

public class ModelSign  implements IModelSign{
    private String code;
    private OnSignFinish onSignFinish;
    public interface OnSignFinish{
        void signFinish(String code);
    }
    public void setOnSignFinish(OnSignFinish onSignFinish){
        this.onSignFinish = onSignFinish;
    }
    @Override
    public void getUrl(String signname, String signpass) {
        HashMap<String,String> map = new HashMap<>();
        map.put("signname",signname);
        map.put("signpass",signpass);
        RetroFactoryPost.getInstance().getSign("user/reg",map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SignBase>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(SignBase signBase) {
                        code = signBase.getCode();
                        onSignFinish.signFinish(code);
                    }
                });
    }
}

