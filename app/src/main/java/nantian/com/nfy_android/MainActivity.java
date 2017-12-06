package nantian.com.nfy_android;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import nantian.com.nfy_android.adapter.CustomAdapter;
import nantian.com.nfy_android.dto.Fixform;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, NavigationView.OnNavigationItemSelectedListener {


    /**
     * 工具条
     **/
    private Toolbar toolbar = null;
    /**
     * 订单列表布局
     **/
    private ListView list = null;
    /**
     * 侧边栏
     **/
    private NavigationView navigationView = null;

    /**
     * 抽屉布局
     **/

    private DrawerLayout drawerLayout = null;

    /**
     * 自定义适配器
     **/
    private CustomAdapter adapter = null;

    public static MainActivity instance = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instance = MainActivity.this;
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.navigation);


        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("报修单列表");

        /**设置toolbar**/
        setSupportActionBar(toolbar);


        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.open, R.string.close);

        drawerToggle.syncState();

        drawerLayout.setDrawerListener(drawerToggle);


        navigationView.setNavigationItemSelectedListener(this);


        list = (ListView) findViewById(R.id.lv);

        adapter = new CustomAdapter(this);


        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "张三") {
            @Override
            public void action() {
               // BaseActivity.instance.setToast("跳转详情页");
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});


            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "李四") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "王五") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "赵六") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "张费") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "张三") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "李四") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "王五") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "赵六") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "张费") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "张三") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "李四") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "王五") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "赵六") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "张费") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "张三") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "李四") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "王五") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "赵六") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号", "13078700711", "张费") {
            @Override
            public void action() {
                setFixDiaLog(new String[]{"xxx","xxxx","xxxx"});
            }
        });

        list.setAdapter(adapter);

        list.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.setting: {
                BaseActivity.instance.setToast("hello");

            }

        }


        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Fixform fixform = adapter.getItem(position);

        fixform.action();
    }


    /**
     * 抽屉菜单监听器
     **/
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.history:
                    {
                        BaseActivity.instance.setToast("历史记录");
                    }

                    break;

                case R.id.self:
                    {

                        BaseActivity.instance.setToast("个人信息");

                    }

                        break;



            }
        return true;
    }



    private void setFixDiaLog(String ...arr)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this,1);

        builder.setIcon(android.R.drawable.ic_menu_manage);
        builder.setTitle("报修单明细");

        builder.setItems(arr,null);
        builder.setPositiveButton("立即接单", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });



        builder.setCancelable(false);

        builder.show();

    }


    @Override
    protected void onStart() {
        super.onStart();

       /**将notifcation 的标准位重置为1**/
        BaseActivity.instance.flag = 1;

    }
}
