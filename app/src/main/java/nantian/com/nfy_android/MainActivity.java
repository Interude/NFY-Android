package nantian.com.nfy_android;

import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {



    private Toolbar toolbar = null;
    private ListView list = null;

    private CustomAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           toolbar = (Toolbar) findViewById(R.id.toolbar);

            toolbar.setTitle("报修单列表");

            setSupportActionBar(toolbar);

            list = (ListView) findViewById(R.id.lv);

            adapter = new CustomAdapter(this);

        adapter.addFixForm(new Fixform("东风东路455号","13078700711","张三") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","李四") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","王五") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","赵六") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","张费") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","张三") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","李四") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","王五") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","赵六") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","张费") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","张三") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","李四") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","王五") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","赵六") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","张费") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","张三") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","李四") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","王五") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","赵六") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });
        adapter.addFixForm(new Fixform("东风东路455号","13078700711","张费") {
            @Override
            public void action() {
                BaseActivity.instance.setToast("跳转详情页");
            }
        });

        list.setAdapter(adapter);

        list.setOnItemClickListener(this);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.setting:
                    {
                        BaseActivity.instance.setToast("hello");

                    }

            }


        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

      Fixform fixform =  adapter.getItem(position);

        fixform.action();
    }
}
