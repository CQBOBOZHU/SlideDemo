package melonmobile.cn.slidedemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhubo on 2019/5/17.
 * Supported By 甜瓜移动.
 * Official Website: www.melonmobile.cn.
 *
 * @author zhubo
 */
public class DemoFragment extends Fragment {

    SmartRefreshLayout refreshLayout;

    static Map<Integer, Fragment> map = new HashMap<>();

    public static DemoFragment newInstance(int type) {
        Fragment fragment1 = map.get(type);
        if (fragment1 == null) {
            Bundle args = new Bundle();
            args.putInt("type", type);
            fragment1 = new DemoFragment();
            fragment1.setArguments(args);
            map.put(type, fragment1);
        }
        return (DemoFragment) fragment1;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_demo, null);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        final int type = arguments.getInt("type");
        WebView webView = view.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
//        switch (type%7) {
//            case 0:
            webView.loadUrl("http://mayixiaodai.6699xt.com/register/html/2/index.html?channel=g3D6ZV/wC/ltxQ");
//            break;
//            case 1:
//                webView.loadUrl("http://mayixiaodai.6699xt.com/register/html/2/index.html?channel=g3D6ZV/wC/ltxQ");
//                break;
//            case 2:
//                webView.loadUrl("http://mayixiaodai.6699xt.com/register/html/2/index.html?channel=g3D6ZV/wC/ltxQ");
//                break;
//            case 3:
//                webView.loadUrl("https://www.baidu.com/");
//                break;
//            case 4:
//                webView.loadUrl("https://www.weibo.com/");
//                break;
//            case 5:
//                webView.loadUrl("https://www.wangyi.com/");
//                break;
//            case 6:
//                webView.loadUrl("https://www.alibaba.com/");
//                break;
//             default:
//                 webView.loadUrl("https://docs.nativebase.io/Components.html#title-header-headref");
//        }
        refreshLayout = view.findViewById(R.id.smartRefreshLayout);
        refreshLayout.setEnableOverScrollBounce(false);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout1) {
                refreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefresh();
                        ((MainActivity) getActivity()).changFragment(type + 1);
                    }
                }, 300);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout1) {
                refreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishLoadMore();
                        ((MainActivity) getActivity()).returnFragment(type - 1);
                    }
                }, 300);
            }
        });
    }


}
