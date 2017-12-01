package nantian.com.nfy_android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;


/**
 *基础Activity
 * **/

public class BaseActivity extends FinalActivity {

    //进度条
    @ViewInject(id = R.id.progressBar)
    private ProgressBar progressBar = null;

     //提示信息
    private Toast toast = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        isNetworkAvailable(this);



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


                    setToast("网络可用");
                    progressBar.setVisibility(View.GONE);

                    return true;
                }
            }
        }

            setToast("网络不可用,请检查网络连接！！");
        finish();
        return false;
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


}
