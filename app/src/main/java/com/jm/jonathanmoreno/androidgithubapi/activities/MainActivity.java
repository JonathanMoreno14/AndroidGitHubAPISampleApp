package com.jm.jonathanmoreno.androidgithubapi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.jm.jonathanmoreno.androidgithubapi.R;
import com.jm.jonathanmoreno.androidgithubapi.adapter.GitHubInfoAdapter;
import com.jm.jonathanmoreno.androidgithubapi.model.GitHubInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindString(R.string.json_url)
    String JSON_URL;
    private JsonArrayRequest jsonArrayRequest;
    private RequestQueue requestQueue;
    private List<GitHubInfo> gitHubInfoArray = new ArrayList<>();
    private RecyclerView recyclerView;
    private GitHubInfoAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView = findViewById(R.id.recyclerview);

        adapter = new GitHubInfoAdapter(this, gitHubInfoArray);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        jsonArrayRequest();

    }


    public void  jsonArrayRequest() {
        jsonArrayRequest = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;


                for (int i = 0 ; i<response.length();i++) {


                    try {

                        jsonObject = response.getJSONObject(i);
                        GitHubInfo gitHubInfo = new GitHubInfo();

                        gitHubInfo.setName(jsonObject.getString("name"));
                        gitHubInfo.setDescription(jsonObject.getString("description"));
                        gitHubInfo.setLanguage(jsonObject.getString("language"));
                        gitHubInfo.setUpdated(jsonObject.getString("updated_at"));
                        //  gitHubInfo.setImg_url(jsonObject.getString("avatar_url"));

                        gitHubInfoArray.add(gitHubInfo);




                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplication(),
                                "JSONException",
                                Toast.LENGTH_LONG).show();
                    }
                }


                adapter.notifyDataSetChanged();



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("onErrorResponse", error.toString());
                error.printStackTrace();
                Toast.makeText(getApplication(),
                        "Oops. Timeout error!",
                        Toast.LENGTH_LONG).show();

            }
        });


        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(jsonArrayRequest);

    }




}
