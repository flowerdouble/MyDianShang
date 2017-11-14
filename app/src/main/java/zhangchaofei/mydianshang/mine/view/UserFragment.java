package zhangchaofei.mydianshang.mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import zhangchaofei.mydianshang.R;

/**
 * Created by 张超飞 on 2017/11/13.
 */

public class UserFragment extends Fragment {
  Unbinder unbinder;
    @BindView(R.id.headImageView)
    ImageView headImageView;
    @BindView(R.id.usernameTextView)
    TextView usernameTextView;
    @BindView(R.id.collectionGoodsTextView)
    TextView collectionGoodsTextView;
    @BindView(R.id.collectionStoreTextView)
    TextView collectionStoreTextView;
    @BindView(R.id.myFootprintTextView)
    TextView myFootprintTextView;
    @BindView(R.id.userRelativeLayout)
    RelativeLayout userRelativeLayout;
    @BindView(R.id.orderTextView)
    TextView orderTextView;
    @BindView(R.id.orderWaitPayTextView)
    TextView orderWaitPayTextView;
    @BindView(R.id.orderWaitDriveTextView)
    TextView orderWaitDriveTextView;
    @BindView(R.id.orderWaitReceiptTextView)
    TextView orderWaitReceiptTextView;
    @BindView(R.id.orderWaitCommentTextView)
    TextView orderWaitCommentTextView;
    @BindView(R.id.orderWaitRefundTextView)
    TextView orderWaitRefundTextView;
    @BindView(R.id.orderLinearLayout)
    LinearLayout orderLinearLayout;
    @BindView(R.id.propertyTextView)
    TextView propertyTextView;
    @BindView(R.id.propertyMoneyTextView)
    TextView propertyMoneyTextView;
    @BindView(R.id.propertyCardTextView)
    TextView propertyCardTextView;
    @BindView(R.id.propertyVouchersTextView)
    TextView propertyVouchersTextView;
    @BindView(R.id.propertyRedTextView)
    TextView propertyRedTextView;
    @BindView(R.id.propertyIntegralTextView)
    TextView propertyIntegralTextView;
    @BindView(R.id.propertyLinearLayout)
    LinearLayout propertyLinearLayout;
    @BindView(R.id.addressTextView)
    TextView addressTextView;
    @BindView(R.id.settingTextView)
    TextView settingTextView;
    @BindView(R.id.mainLinearLayout)
    LinearLayout mainLinearLayout;
    @BindView(R.id.mainScrollView)
    ScrollView mainScrollView;
    private boolean mUser_login;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    @OnClick({R.id.headImageView, R.id.usernameTextView, R.id.addressTextView})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.headImageView:
                if (mUser_login) {
                    Intent user = new Intent(getActivity(), MessageActivity.class);
                    startActivity(user);
                } else {
                    Intent login = new Intent(getActivity(), LoginActivity.class);
                    startActivity(login);
                }
                break;
            case R.id.usernameTextView:
                if (mUser_login) {
                    Intent user = new Intent(getActivity(), MessageActivity.class);
                    startActivity(user);
                } else {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.addressTextView:
                Intent intent = new Intent(getActivity(), AddressActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
