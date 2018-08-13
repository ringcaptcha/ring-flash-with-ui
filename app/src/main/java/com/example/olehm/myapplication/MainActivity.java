package com.example.olehm.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.thrivecom.ringcaptcha.RingcaptchaApplication;
import com.thrivecom.ringcaptcha.RingcaptchaApplicationHandler;
import com.thrivecom.ringcaptcha.RingcaptchaVerification;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private final int PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (this.checkSelfPermission(Manifest.permission.READ_PHONE_STATE)
                    != PackageManager.PERMISSION_GRANTED) {
                List<String> permissions = new ArrayList<>();
                permissions.add(Manifest.permission.READ_PHONE_STATE);
                permissions.add(Manifest.permission.INTERNET);
                permissions.add(Manifest.permission.CALL_PHONE);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    permissions.add(Manifest.permission.ANSWER_PHONE_CALLS);
                }
                this.requestPermissions(permissions.toArray(new String[0]), PERMISSIONS);
            }
            if (this.checkSelfPermission(Manifest.permission.READ_PHONE_STATE)
                    == PackageManager.PERMISSION_GRANTED) {
                verify();
            }
        } else {
            verify();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS:
                if (grantResults.length >= 1
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    verify();
                } else {
                    Toast.makeText(this, "Rejected permissions", Toast.LENGTH_LONG).show();
                }
        }
    }

    private void verify() {
        RingcaptchaApplication.verifyPhoneNumberViaFlashCall(getApplicationContext(), "APP_KEY", "SECRET_KEY", new RingcaptchaApplicationHandler() {
            @Override
            public void onSuccess(RingcaptchaVerification ringObj) {
                Toast.makeText(getApplicationContext(), "Successfully verified!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel() {
            }
        });
    }
}
