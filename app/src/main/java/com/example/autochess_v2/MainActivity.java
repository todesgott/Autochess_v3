package com.example.autochess_v2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    String urlGetData = "http://192.168.1.71/androidwebservice/getdata.php";

    ListView lvhero;
    ArrayList<Hero> arrayHero;
    HeroAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        lvhero = (ListView) findViewById(R.id.listviewhero);
        arrayHero = new ArrayList<>();

        adapter = new HeroAdapter(this, R.layout.list_hero, arrayHero);
        lvhero.setAdapter(adapter);

        GetData(urlGetData);



    }


    private void GetData(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                        public void onResponse(JSONArray response) {
                            for ( int i = 0;  i < response.length(); i++){
                              try {
                                  JSONObject object = response.getJSONObject(i);
                                  arrayHero.add(new Hero(
                                          object.getString("HeroName"),
                                          object.getString("HeroSpec"),
                                          object.getString("HeroClass"),
                                          object.getInt("HeroCost")
                        ));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();

                    }
                }


        );
        requestQueue.add(jsonArrayRequest);
    }



}

