package com.zmt.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.baidu.mobads.AdView;
import com.baidu.mobads.rewardvideo.RewardVideoAd;

public class MainActivity extends AppCompatActivity {

//    SDK
//            LT爱锁屏
//    应用ID：bc4d63ba
//    动盟伙伴_LT爱锁屏_1_开屏	6318652
//    动盟伙伴_LT爱锁屏_1_插屏	6318653
//    动盟伙伴_LT爱锁屏_1_横幅	6318654
//    动盟伙伴_LT爱锁屏_1_激励视频	6318660
    private RewardVideoAd mRewardVideoAd;
    private String TAG = "xiaoding";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRewardVideoAd = new RewardVideoAd(this, "6318660", new RewardVideoAd.RewardVideoAdListener() {
            @Override
            public void onVideoDownloadSuccess() {
                // 视频缓存成功
                // 说明：如果想一定走本地播放，那么收到该回调之后，可以调用show
                Log.i(TAG, "onVideoDownloadSuccess,isReady=" + mRewardVideoAd.isReady());
                mRewardVideoAd.show();
            }

            @Override
            public void onVideoDownloadFailed() {
                // 视频缓存失败，如果想走本地播放，可以在这儿重新load下一条广告，最好限制load次数（4-5次即可）。
                Log.i(TAG, "onVideoDownloadFailed");
            }

            @Override
            public void playCompletion() {
                // 播放完成回调，媒体可以在这儿给用户奖励
                Log.i(TAG, "playCompletion");
            }

            @Override
            public void onAdShow() {
                // 视频开始播放时候的回调
                Log.i(TAG, "onAdShow");
//                if (adListener != null) {
//                    adListener.onADClicked();
//                }
//                new ActionShow(activity, Type.c, posId);
            }

            @Override
            public void onAdClick() {
                // 广告被点击的回调
                Log.i(TAG, "onAdClick");
//                if (adListener != null) {
//                    adListener.onADClicked();
//                }
//                new ActionClick(activity, Type.c, posId);
            }

            @Override
            public void onAdClose(float playScale) {
                // 用户关闭了广告
                // 说明：关闭按钮在mssp上可以动态配置，媒体通过mssp配置，可以选择广告一开始就展示关闭按钮，还是播放结束展示关闭按钮
                // 建议：收到该回调之后，可以重新load下一条广告,最好限制load次数（4-5次即可）
                // playScale[0.0-1.0],1.0表示播放完成，媒体可以按照自己的设计给予奖励
                Log.i(TAG, "onAdClose" + playScale);
//                if (adListener != null) {
//                    adListener.onADDismissed();
//                }
            }

            @Override
            public void onAdFailed(String arg0) {
                // 广告失败回调 原因：广告内容填充为空；网络原因请求广告超时
                // 建议：收到该回调之后，可以重新load下一条广告，最好限制load次数（4-5次即可）
                Log.i(TAG, "onAdFailed --> ");
                mRewardVideoAd.load();
//                if (load_count < 100) {
//                    mRewardVideoAd.load();
//                    load_count ++;
//                } else {
//                    AdError adError = new AdError();
//                    adError.setErrorCode(10020);
//                    adError.setErrorMsg("没有广告");
//                    adListener.onNoAD(adError);
//                }
            }
        }, false);
        Log.e("xiaoding", "mRewardVideoAd --> " + mRewardVideoAd);
        mRewardVideoAd.load();
    }

}
