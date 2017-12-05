package nantian.com.nfy_android.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import nantian.com.nfy_android.handler.ActionHandler;

public class NetService extends Service {

  private  final String TAG = "NetService";

  private ActionHandler handler  = null;

  private boolean running = false;
    public NetService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"NetService服务启动");
        handler = new ActionHandler(this);
        running = true;

        new Thread()
        {
            @Override
            public void run() {

                while (running)
                {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    netHandler();


                }



            }
        }.start();



    }






    /**
     * 判断网络连接
     * @create at 17/11/30 18:44
     * @author xiaochunyuan
     * @return
     * @param
     *
     * **/


    public  boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected())
            {
                // 当前网络是连接的
                Log.e("TAG","连接的");
                if (info.getState() == NetworkInfo.State.CONNECTED)
                {
                    // 当前所连接的网络可用

                    Log.e("TAG","可用");


                    //setToast("网络可用");

                    // progressBar.setVisibility(View.GONE);




                    return true;
                }
            }
        }

       // setToast("网络不可用,请检查网络连接！！");
        //结束activity

        return false;
    }



    private void netHandler()
    {
        if (isNetworkAvailable(this))
        {

            Message mes = new Message();

            mes.obj = 1;

            handler.sendMessage(mes);


        }else
        {
            //BaseActivity.instance.setToast("网络异常！");
            Message mes = new Message();

            mes.obj = 2;

            handler.sendMessage(mes);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        running = false;
    }
}
