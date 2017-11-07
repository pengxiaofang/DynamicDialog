package com.zyl.widget.dynamicdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by zhaoyongliang on 2017/9/4.
 */

public class DynamicDialog extends Dialog {

    private Context context;

    // 窗体类型：NORMAL（常规）、LOADING（加载中）、ERROR（错误）、SUCCESS（成功）、WARNING（警告）
    private DynamicDialogType type = DynamicDialogType.NORMAL;

    // 窗体 消息美容
    private String message;

    // 窗体成功提示图片资源
    private int successIcon = R.mipmap.success;

    // 窗体错误提示图片资源
    private int errorIcon = R.mipmap.error;

    // 窗体警告提示图片资源
    private int warningIcon = R.mipmap.warning;

    // 长度按照屏幕宽度的缩放
    private float scale = 0.9f;

    // 窗体显示的位置
    private int gravity = Gravity.CENTER;

    public void setType(DynamicDialogType type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccessIcon(int successIcon) {
        this.successIcon = successIcon;
    }

    public void setErrorIcon(int errorIcon) {
        this.errorIcon = errorIcon;
    }

    public void setWarningIcon(int warningIcon) {
        this.warningIcon = warningIcon;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    private ImageView alertIcon;

    private ProgressBar alertLoading;

    private TextView alertLabel;

    public DynamicDialog(@NonNull Context context) {
        super(context, R.style.custom_dialog);
        this.context = context;
    }

    public DynamicDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    protected DynamicDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
    }

    public DynamicDialog(@NonNull Context context, @StyleRes int themeResId, DynamicDialogType type, String message) {
        super(context, themeResId);
        this.context = context;
        this.type = type;
        this.message = message;
    }

    public DynamicDialog(@NonNull Context context, @StyleRes int themeResId, DynamicDialogType type,
                         String message, int successIcon, int errorIcon, int warningIcon) {
        super(context, themeResId);
        this.context = context;
        this.type = type;
        this.message = message;
        this.successIcon = successIcon;
        this.errorIcon = errorIcon;
        this.warningIcon = warningIcon;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_dynamic);
        init();
    }

    private void init() {
        initField();
        initView();
    }

    private void initView() {
        alertLabel.setText(message);
        switch (type) {
            case LOADING:
                showLoading();
                break;
            case ERROR:
                showError();
                break;
            case SUCCESS:
                showSuccess();
                break;
            case NORMAL:
                showNormal();
                break;
            case WARNING:
                showWarning();
                break;
        }
    }

    private void resetLayout() {
        alertIcon.setVisibility(View.GONE);
        alertLoading.setVisibility(View.GONE);
    }

    private void showLoading() {
        resetLayout();
        alertLoading.setVisibility(View.VISIBLE);
    }

    private void showError() {
        resetLayout();
        alertIcon.setVisibility(View.VISIBLE);
        alertIcon.setImageResource(errorIcon);
    }

    private void showSuccess() {
        resetLayout();
        alertIcon.setVisibility(View.VISIBLE);
        alertIcon.setImageResource(successIcon);
    }

    private void showWarning() {
        resetLayout();
        alertIcon.setVisibility(View.VISIBLE);
        alertIcon.setImageResource(warningIcon);
    }

    private void showNormal() {
        resetLayout();
    }

    private void initField() {
        alertIcon = findViewById(R.id.alert_icon);
        alertLoading =  findViewById(R.id.alert_loading);
        alertLabel = findViewById(R.id.alert_label);
    }

    @Override
    public void show() {
        super.show();
        setWindowStyle();
    }

    private void setWindowStyle() {
        Activity act = (Activity) context;
        DisplayMetrics dm = new DisplayMetrics();
        act.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = (int) (width * scale);
        lp.gravity = gravity;
        getWindow().setAttributes(lp);
    }
}
