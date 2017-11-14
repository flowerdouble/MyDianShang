package zhangchaofei.mydianshang.sort.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import zhangchaofei.mydianshang.R;

/**
 * Created by 张超飞 on 2017/11/13.
 */

public class ClassFragment extends Fragment {
    @BindView(R.id.leftImageView)
    ImageView leftImageView;
    @BindView(R.id.rightImageView)
    ImageView rightImageView;
    @BindView(R.id.titleEditText)
    EditText titleEditText;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.class_elv)
    ExpandableListView classElv;
    Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_class, null);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
