package zhangchaofei.mydianshang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zhangchaofei.mydianshang.R;
import zhangchaofei.mydianshang.cart.view.CartFragment;
import zhangchaofei.mydianshang.home.view.HomeFragment;
import zhangchaofei.mydianshang.mine.view.UserFragment;
import zhangchaofei.mydianshang.sort.view.ClassFragment;
import zhangchaofei.mydianshang.utils.Constant;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.mainRadioGroup)
    RadioGroup mainRadioGroup;
    @BindView(R.id.homeRadioButton)
    RadioButton homeRadioButton;
    @BindView(R.id.classRadioButton)
    RadioButton classRadioButton;
    @BindView(R.id.cartRadioButton)
    RadioButton cartRadioButton;
    @BindView(R.id.userRadioButton)
    RadioButton userRadioButton;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    private HomeFragment mHomeFragment;
    private ClassFragment mClassFragment;
    private CartFragment mCartFragment;
    private UserFragment mUserFragment;
    private String saveName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mHomeFragment = new HomeFragment();
        mClassFragment = new ClassFragment();
        mCartFragment = new CartFragment();
        mUserFragment = new UserFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.tabcontent, mHomeFragment, "homeFragment").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.tabcontent, mClassFragment, "classFragment").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.tabcontent, mCartFragment, "cartFragment").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.tabcontent, mUserFragment, "userFragment").commit();
        getSupportFragmentManager().beginTransaction().show(mHomeFragment).hide(mCartFragment).hide(mClassFragment).hide(mUserFragment).commit();
        Constant.init(this);
    }

    @OnClick({R.id.homeRadioButton, R.id.classRadioButton, R.id.cartRadioButton, R.id.userRadioButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.homeRadioButton:
                getSupportFragmentManager().beginTransaction().show(mHomeFragment).hide(mCartFragment).hide(mClassFragment).hide(mUserFragment).commit();
                Toast.makeText(this, "这是首页", Toast.LENGTH_SHORT).show();
                break;
            case R.id.classRadioButton:
                getSupportFragmentManager().beginTransaction().show(mClassFragment).hide(mCartFragment).hide(mHomeFragment).hide(mUserFragment).commit();
                Toast.makeText(this, "这是分类", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cartRadioButton:
                getSupportFragmentManager().beginTransaction().show(mCartFragment).hide(mHomeFragment).hide(mClassFragment).hide(mUserFragment).commit();
                Toast.makeText(this, "这是购物车", Toast.LENGTH_SHORT).show();
                break;
            case R.id.userRadioButton:
                getSupportFragmentManager().beginTransaction().show(mUserFragment).hide(mCartFragment).hide(mClassFragment).hide(mHomeFragment).commit();
                Toast.makeText(this, "这是我的页面", Toast.LENGTH_SHORT).show();
                break;
        }

    }
    @Override
    protected void onResume() {
        //  显示我的工单列表
        if (getIntent().getStringExtra("showMyItem") != null) {
            if (getIntent().getStringExtra("showMyItem").equals("showMyItem")) {
                saveName = mCartFragment.getClass().getName();
                //显示需要显示的fragment
                showMyWorkFragment();
            }
        }
        super.onResume();
    }

    private void showMyWorkFragment() {
        getSupportFragmentManager().beginTransaction().show(mCartFragment).hide(mHomeFragment).hide(mClassFragment).hide(mUserFragment).commit();
    }

}
