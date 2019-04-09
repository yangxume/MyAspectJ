package k.xy.myaspectj

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

public class KotlinActivity: AppCompatActivity(),View.OnClickListener,
    AdapterView.OnItemClickListener{

    lateinit var btn1 : Button
    lateinit var btn2 : Button
    lateinit var listview : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn01)
        btn2 = findViewById(R.id.btn02)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)

        listview = findViewById(R.id.listview)



    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onClick(v: View?) {

    }

}