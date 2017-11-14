package zhangchaofei.mydianshang.utils;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;
import zhangchaofei.mydianshang.home.bean.HomeBase;
import zhangchaofei.mydianshang.mine.bean.LoginBase;
import zhangchaofei.mydianshang.mine.bean.MessBase;
import zhangchaofei.mydianshang.mine.bean.SignBase;

/**
 * Created by 张超飞 on 2017/11/9.
 */


public interface ApiServer {

    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<HomeBase> getHome();

    @POST
    Observable<LoginBase> getLogin(@Url String url, @QueryMap Map<String, String> map);

    @POST
    Observable<SignBase> getSign(@Url String url, @QueryMap Map<String, String> map);

    @POST
    Observable<MessBase> getMess(@Url String url, @QueryMap Map<String, String> map);
}
