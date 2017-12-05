package nantian.com.nfy_android;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

import nantian.com.nfy_android.dialogaction.ActionForDialog;
import nantian.com.nfy_android.handler.ActionHandler;


/**
 *基础Activity
 * **/

public class BaseActivity extends FinalActivity {

    private final String TAG = "BaseActivity";

    //进度条
    @ViewInject(id = R.id.progressBar)
    private ProgressBar progressBar = null;

     //提示信息
    private Toast toast = null;

    //BaseActivity 实例

    public static BaseActivity instance = null ;


    //ActionHandler 实例

    private ActionHandler actionHandler = null;

    private int netState ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);


        instance = BaseActivity.this;

        jumpToLogin();

    }

    public void setToast(String msg )
    {
        if (toast == null)
        {
            toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
            toast.show();

        }

        toast.setText(msg);
        toast.show();



    }


    /**
     * 消息提示
     * **/

    public void setDiaLog(Context context, String msg, final ActionForDialog action)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(context,1);

        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle(msg);

        //builder.setMessage(msg);

        builder.setCancelable(false);

        builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                    action.action();

            }
        });

        builder.show();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart()");


        //jumpToLogin();




       // Log.d(TAG,getNetworkState()+"");

    }

    @Override
    protected void onStop() {
        super.onStop();
        //stopService(new Intent(instance, NetService.class));
      //  instance = null;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        //instance = null;



    }


    public static BaseActivity getBaseActivity()
    {

        return  instance;

    }


    /**
     * 获取网络信息
     * @return
     *          1.-1 无网络连接
     *          2.1 当前网络为wifi
     *          3.0当前网络为gprs
     *          4.-2参数context为null
     */
    public int getNetworkState()
    {
        int state = -2;
        if(instance!=null) {
            ConnectivityManager cm = (ConnectivityManager) instance.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = cm.getActiveNetworkInfo();
            if (ni != null) {
                state = ni.getType();
            } else
            {
                state = -1;
            }
        }
        else {
            Log.e("网络判断失败","没有上下文");
        }
        return state;
    }


    /**
     * 判断网络状态，是否跳转登录页面
     * **/

    private  void jumpToLogin()
    {

        netState = getNetworkState();

        if (netState==1||netState==0)
        {

            // setToast("网络可用");



            instance.startActivity(new Intent(instance,LoginActivity.class));
            finish();
        }
        else
        {
            setDiaLog(instance, "无可用网络", new ActionForDialog() {
                @Override
                public void action() {
                    finish();
                }
            });

        }



    }



}
