package com.zyl.widget.dynamicdialog;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showLoadingDialog(View view) {
        DynamicDialog dialog = new DynamicDialog(this);
        dialog.setMessage("DynamicDailog 测试");
        dialog.setType(DynamicDialogType.LOADING);
        dialog.show();
        delayDismiss(dialog);
    }

    public void showNormalDialog(View view) {
        DynamicDialog dialog = new DynamicDialog(this);
        dialog.setMessage("DynamicDailog 测试");
        dialog.show();
        delayDismiss(dialog);
    }

    public void showSuccessDialog(View view) {
        DynamicDialog dialog = new DynamicDialog(this);
        dialog.setMessage("DynamicDailog 测试");
        dialog.setType(DynamicDialogType.SUCCESS);
        dialog.show();
        delayDismiss(dialog);
    }

    public void showErrorDialog(View view) {
        DynamicDialog dialog = new DynamicDialog(this);
        dialog.setMessage("DynamicDailog 测试");
        dialog.setType(DynamicDialogType.ERROR);
        dialog.show();
        delayDismiss(dialog);
    }

    public void showWarningDialog(View view) {
        DynamicDialog dialog = new DynamicDialog(this);
        dialog.setMessage("DynamicDailog 测试");
        dialog.setType(DynamicDialogType.WARNING);
        dialog.show();
        delayDismiss(dialog);
    }

    private void delayDismiss(final DynamicDialog dialog) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 2000);
    }


}
