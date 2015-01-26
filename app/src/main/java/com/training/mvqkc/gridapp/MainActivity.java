package com.training.mvqkc.gridapp;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    GridView gridview;
    ArrayList gridarray = new ArrayList(8);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i<8; i++)
            gridarray.add(i);

        gridview = (GridView)findViewById(R.id.gridView);
        ArrayAdapter<Integer> adp = new ArrayAdapter<Integer>(this,android.R.layout.simple_dropdown_item_1line, gridarray){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View view = super.getView(position, convertView, parent);
                //int color = 0x00FFFFFF; // Transparent
                int color = 0xFF0000FF;
                if(position == 1)
                    color = 0xFF01FFFF;

                switch (position){
                    case 0:
                        color = 0xFF01FFFF;
                        break;
                    case 1:
                        color = 0xFF0000FF;
                        break;
                    case 2:
                        color = 0xEFff12FF;
                        break;
                    case 3:
                        color = 0x123456FF;
                        break;
                    case 4:
                        color = 0x854569FF;
                        break;
                    case 5:
                        color = 0x432586FF;
                        break;
                    case 6:
                        color = 0x254695FF;
                        break;
                    case 7:
                        color = 0x482621FF;
                        break;

                    default:
                        color = 0xFFFFFFFF;
                        break;
                }
                view.setBackgroundColor(color);
                return view;
            }
        };

        gridview.setAdapter(adp);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,""+position,Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
