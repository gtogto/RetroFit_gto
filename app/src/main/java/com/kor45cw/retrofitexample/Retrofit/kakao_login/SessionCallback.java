package com.kor45cw.retrofitexample.Retrofit.kakao_login;
import android.content.Intent;
import android.util.Log;
import com.kakao.auth.ISessionCallback;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.exception.KakaoException;
import com.kor45cw.retrofitexample.MainActivity;

import static android.content.ContentValues.TAG;

public class SessionCallback implements ISessionCallback{
    // 로그인에 성공한 상태
    @Override
    public void onSessionOpened() {
        requestMe();
    }

    // 로그인에 실패한 상태
    @Override
    public void onSessionOpenFailed(KakaoException exception) {
        Log.e("SessionCallback :: ", "onSessionOpenFailed : " + exception.getMessage());
    }

    // 사용자 정보 요청
    public void requestMe() {
        UserManagement.getInstance().me(new MeV2ResponseCallback() {
            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                Log.d(TAG,"카카오 세션 Close!");
            }

            @Override
            public void onSuccess(MeV2Response result) {
                Log.e("SessionCallback :: ", "onSuccess");

                String nickname = result.getNickname();
                String profileImagePath = result.getProfileImagePath();
                String thumnailPath = result.getThumbnailImagePath();

                long id = result.getId();

                Log.e("Profile : ", nickname + "");
                Log.e("Profile : ", profileImagePath  + "");
                Log.e("Profile : ", thumnailPath + "");
                Log.e("Profile : ", id + "");
            }
        });
    }
}


