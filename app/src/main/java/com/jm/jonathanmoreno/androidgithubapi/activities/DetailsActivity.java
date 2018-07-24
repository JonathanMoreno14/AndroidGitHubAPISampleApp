package com.jm.jonathanmoreno.androidgithubapi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.jm.jonathanmoreno.androidgithubapi.R;
import com.jm.jonathanmoreno.androidgithubapi.model.GitHubInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {


    @BindView(R.id.reponame)
    TextView repoName;
    @BindView(R.id.repodescription)
    TextView repoDescription;
    @BindView(R.id.repolanguage)
    TextView repoLanguage;
    @BindView(R.id.repoupdated)
    TextView repoUpdated;

    //Toolbar Widgets
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindString(R.string.github_user)
    String githubUser;



    @BindString(R.string.json_url)
    String URL_JSON;
    private RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        String name  = getIntent().getExtras().getString("github_name");
        String description  = getIntent().getExtras().getString("github_description");
        String language  = getIntent().getExtras().getString("github_language");
        String update  = getIntent().getExtras().getString("github_update");

        repoName.setText(name);
        repoDescription.setText(description);
        repoLanguage.setText(language);
        repoUpdated.setText(update);
        toolbarTitle.setText(githubUser);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }



}




