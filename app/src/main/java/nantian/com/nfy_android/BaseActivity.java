package nantian.com.nfy_android;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
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

    public void setDiaLog(Context context, String msg,final ActionForDialog action)
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
     int flag = 1;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void runningNotification()
    {

        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//
//        manager.notify(1,notification);

        PendingIntent pendingIntent3 = PendingIntent.getActivity(instance, 0,
                new Intent(instance, MainActivity.class), 0);


        // 通过Notification.Builder来创建通知，注意API Level
        // API16之后才支持
        Notification notify3 = new Notification.Builder(instance)
                .setSmallIcon(android.R.drawable.ic_menu_manage)
                .setTicker("您有"+flag+"新的报修单，请注意查收")
                .setContentTitle("新的报修单")
                .setContentText("姓名:张三,电话:13078700711,地址:火车北站")
                .setContentIntent(pendingIntent3)
                .setDefaults(Notification.DEFAULT_SOUND)
                .build();
        notify3.flags = Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL表明当通知被用户点击时，通知将被清除。

        // notify3.flags = Notification.DEFAULT_ALL;
//        notify3.flags=   Notification.FLAG_ONLY_ALERT_ONCE ; //发起Notification后，铃声和震动均只执行一次
//        notify3.flags= Notification.FLAG_AUTO_CANCEL;
//        notify3.flags= Notification.FLAG_SHOW_LIGHTS;
        manager.notify(0, notify3);// 步骤4：

        flag++;


          //  MainActivity.instance.finish();
    }



}
