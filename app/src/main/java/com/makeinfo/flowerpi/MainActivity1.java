package com.makeinfo.flowerpi;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.makeinfo.flowerpi.API.gitapi;
import com.makeinfo.flowerpi.model.Flower;
import com.makeinfo.flowerpi.model.gitmodel;
import com.makeinfo.flowerpi.network.api;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import java.util.List;
import android.widget.ListView;
import com.makeinfo.flowerpi.R;

/*
* STUDTY URL:http://themakeinfo.com/2015/04/android-retrofit-images-tutorial/
* */
public class MainActivity1 extends ActionBarActivity {
    List<Flower> flowerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);


        final RestAdapter restadapter = new RestAdapter.Builder().setEndpoint("http://services.hanselandpetal.com").build();

        api flowerapi = restadapter.create(api.class);

        flowerapi.getData(new Callback<List<Flower>>() {
            @Override
            public void success(List<Flower> flowers, Response response) {
                flowerList = flowers;
                adapter adapt = new adapter(getApplicationContext(),R.layout.item_file,flowerList);
                ListView listView = (ListView) findViewById(R.id.list);
                listView.setAdapter(adapt);
               // setListAdapter(adapt);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
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



