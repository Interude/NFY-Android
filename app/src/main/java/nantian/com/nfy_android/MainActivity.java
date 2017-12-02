package nantian.com.nfy_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.tsz.afinal.annotation.view.ViewInject;

public class MainActivity extends BaseActivity {



    @ViewInject(id = R.id.button,click = "btn")
    private Button btn = null ;

    public static  MainActivity instances = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instances  = MainActivity.this;

      //  System.err.println("oncreate()");


    }
    public void btn(View v)
    {

        setToast("hello");
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


    public static MainActivity getMainActivity()
    {

        return instances;
    }

}
