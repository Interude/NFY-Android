package nantian.com.nfy_android.handler;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import nantian.com.nfy_android.BaseActivity;
import nantian.com.nfy_android.MainActivity;

/**
 * Created by xiaochunyuan on 17/12/1.
 */

public class ActionHandler extends Handler {



    private final String TAG="ActionHandler";

    private boolean isbool = true;
    private boolean isbool2 = true;

    private Context context = null;
    public ActionHandler(Context context)
    {
        this.context = context;



    }


    @Override
    public void handleMessage(Message msg) {

        int flag = (int)msg.obj;
        Log.d(TAG,"flag ==="+flag);
            switch (flag)
            {
                case 1: {
                    //跳转

                    if (isbool)
                    {   isbool = false;
                        isbool2 = true;
                        Intent intent = new Intent(BaseActivity.getBaseActivity(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);

                       // BaseActivity.getBaseActivity().startService(new Intent(BaseActivity.getBaseActivity(),NetService.class));
                        BaseActivity.instance.finish();
                    }




                }
                    break;
                case 2: {

                    Toast.makeText(context,"网络异常!",Toast.LENGTH_SHORT).show();



                    if (isbool2&&MainActivity.getMainActivity()!=null)
                   {
                       isbool2 = false;
                       isbool = true;
                       Intent intent = new Intent(MainActivity.getMainActivity(), BaseActivity.class);

                       intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                       context.startActivity(intent);
                    //   MainActivity.getMainActivity().startService(new Intent(MainActivity.getMainActivity(), NetService.class));

                       MainActivity.instances.finish();
                   }

                }
                    break;

            }




    }
}
