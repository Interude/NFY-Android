package nantian.com.nfy_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

public class LoginActivity extends FinalActivity {





    @ViewInject(id = R.id.login,click = "btn_login")
    private Button login = null;

    @ViewInject(id = R.id.authorize,click = "btn_authorize")

    private Button authorize = null;



    public static  LoginActivity   LoginActivity_instances = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginActivity_instances  = LoginActivity.this;

      //  System.err.println("oncreate()");


    }



    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onStop() {
        super.onStop();

        //instance = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // stopService(new Intent(instances, NetService.class));
        //instances = null;
    }


    public static LoginActivity getMainActivity()
    {

        return   LoginActivity_instances;
    }



    /**登录按钮监听器**/

    public void btn_login(View v)
    {
        BaseActivity.instance.setToast("@@登录成功@@");

        LoginActivity_instances.startActivity(new Intent(LoginActivity_instances,MainActivity.class));

        LoginActivity.LoginActivity_instances.finish();
    }

    /**授权按钮监听器**/

    public void btn_authorize(View v)
    {

        BaseActivity.instance.setToast("@@授权成功@@");


    }
}
