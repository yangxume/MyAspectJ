package k.xy.myaspectj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener ,AdapterView.OnItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private LinearLayout ll_main;
    private Button btn01;
    private Button btn02;
    private ListView listview;

    View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_main = (LinearLayout) findViewById(R.id.ll_main);
        ll_main.invalidate();

        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);
        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);

        listview = findViewById(R.id.listview);
        listview.setOnItemClickListener(this);

        listview.setAdapter(
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        new String []{"a","b","c","d","e","f"}));

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn01:

                Log.e(TAG, "btn is click");

                break;

            case R.id.btn02:

                Log.e(TAG, "btn is click");

                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {




    }
}
