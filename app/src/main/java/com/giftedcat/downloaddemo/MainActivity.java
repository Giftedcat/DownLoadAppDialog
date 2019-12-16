package com.giftedcat.downloaddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.giftedcat.downloadappdialog.listener.DownLoadAppListener;
import com.giftedcat.downloadappdialog.utils.LogUtil;
import com.giftedcat.downloadappdialog.view.DownLoadAppDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    Unbinder unbinder;
    DownLoadAppDialog downLoadAppDialog;
    private List<String> apkUrls;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        mContext = this;

        apkUrls = new ArrayList<>();
        apkUrls.add("http://download.sdk.mob.com/apkbus.apk");
        apkUrls.add("http://img.9553.com/otherhtml/setup001.apk");
        downLoadAppDialog = new DownLoadAppDialog(mContext);
        downLoadAppDialog.setOnDownLoadListener(new DownLoadAppListener() {
            @Override
            public void downloadFinish(boolean installStatus, String path) {
                if (installStatus){
                    //安装成功
                    LogUtil.e( path + "安装成功");
                }else {
                    //安装失败
                    LogUtil.e( path + "安装失败");
                }
            }
        });
    }

    @OnClick({R.id.btn_check_version})
    public void OnCLickView(View view) {
        switch (view.getId()) {
            case R.id.btn_check_version:
                //检查更新
                downLoadAppDialog.show(apkUrls);
                break;
        }
    }

    @Override
    protected void onDestroy()  {
        super.onDestroy();

        unbinder.unbind();
    }
}
