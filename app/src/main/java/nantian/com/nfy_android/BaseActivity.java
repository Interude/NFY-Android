package nantian.com.nfy_android;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

import nantian.com.nfy_android.dialogaction.ActionForDialog;
import nantian.com.nfy_android.handler.ActionHandler;
import nantian.com.nfy_android.service.NetService;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);


        instance = BaseActivity.this;
        startService(new Intent(instance, NetService.class));





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

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage(msg);

        builder.setCancelable(true);

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





}
