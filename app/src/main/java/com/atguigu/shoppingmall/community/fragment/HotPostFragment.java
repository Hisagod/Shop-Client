package com.atguigu.shoppingmall.community.fragment;

import android.view.View;
import android.widget.ListView;
import com.atguigu.shoppingmall.R;
import com.atguigu.shoppingmall.base.BaseFragment;
import com.atguigu.shoppingmall.community.bean.HotPostBean;
import com.google.gson.Gson;
import java.util.List;

/**
 * Created by Administrator on 2016/10/6.
 */
public class HotPostFragment extends BaseFragment {
    private ListView lv_hot_post;
    private List<HotPostBean.ResultBean> result;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_hot_post, null);
        lv_hot_post = (ListView) view.findViewById(R.id.lv_hot_post);
        return view;
    }

    @Override
    public void initData() {
        getDataFromNet();
    }

    public void getDataFromNet() {
//        by hlp
//        OkHttpUtils
//                .get()
//                .url(Constants.HOT_POST_URL)
//                .id(100)
//                .build()
//                .execute(new MyStringCallback());
    }

//    by hlp
//    public class MyStringCallback extends StringCallback {
//
//
//        @Override
//        public void onBefore(Request request, int id) {
//        }
//
//        @Override
//        public void onAfter(int id) {
//        }
//
//        @Override
//        public void onError(Call call, Exception e, int id) {
//            Log.e("TAG", "联网失败" + e.getMessage());
//        }
//
//        @Override
//        public void onResponse(String response, int id) {
//
//            switch (id) {
//                case 100:
////                    Toast.makeText(mContext, "http", Toast.LENGTH_SHORT).show();
//                    if (response != null) {
//                        processData(response);
//                        HotPostListViewAdapter adapter = new HotPostListViewAdapter(mContext, result);
//                        lv_hot_post.setAdapter(adapter);
//                    }
//                    break;
//                case 101:
//                    Toast.makeText(mContext, "https", Toast.LENGTH_SHORT).show();
//                    break;
//            }
//        }
//
//    }

    private void processData(String json) {
        Gson gson = new Gson();
        HotPostBean hotPostBean = gson.fromJson(json, HotPostBean.class);
        result = hotPostBean.getResult();
    }
}
