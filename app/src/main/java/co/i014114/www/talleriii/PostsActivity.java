package co.i014114.www.talleriii;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import co.i014114.www.talleriii.Adapter.PostsAdapter;
import co.i014114.www.talleriii.Connection.HttpConnection;
import co.i014114.www.talleriii.Model.PostsModel;
import co.i014114.www.talleriii.Parser.PostsJson;

public class PostsActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private List<PostsModel> postsModelList;
    private PostsAdapter postsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);


        toolbar = (Toolbar) findViewById(R.id.Tolbar);
        showToolbar(getResources().getString(R.string.Pantalla2), true);


        progressBar = (ProgressBar) findViewById(R.id.id_pv_Pantalla2);
        recyclerView = (RecyclerView) findViewById(R.id.id_rv_Pantalla2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        loadData2(Integer.toString(getIntent().getExtras().getInt("idUser")));

        Bundle us = getIntent().getExtras();


        Toast.makeText(this, us.getString("nameUser"), Toast.LENGTH_LONG).show();
    }

    public void showToolbar(String titulo, boolean upButton) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu mimenu) {
        getMenuInflater().inflate(R.menu.mi_menu2, mimenu);

        return super.onCreateOptionsMenu(mimenu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
            case R.id.MiMenu2salir: {
                finish();
                break;
            }
            case R.id.MiMenu2actualizar: {
                loadData2(Integer.toString(getIntent().getExtras().getInt("idUser")));
                break;
            }
            default:
                return super.onOptionsItemSelected(item);

        }


        return super.onOptionsItemSelected(item);
    }


    public void layoutChange() {

        Intent intent = new Intent(getApplicationContext(), UsersActivity.class);
        startActivity(intent);

    }


    // Metodo para validar la conexion a internet
    public Boolean isOnLine() {
        // Hacer llamado al servicio de conectividad utilizando el ConnectivityManager
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        // Obtener el estado de la conexion a internet en el dispositivo
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        // Validar el estado obtenido de la conexion
        if (networkInfo != null) {
            return true;
        } else {
            return false;
        }
    }

    public void loadData2(String idUsuario) {
        if (isOnLine()) {
            TaskCountry2 taskCountry = new TaskCountry2();
            taskCountry.execute("https://jsonplaceholder.typicode.com/posts?userId=" + idUsuario);
        } else {
            Toast.makeText(this, "Sin conexion", Toast.LENGTH_SHORT).show();
        }
    }

    public void processData() {
        //adapterCountry = new AdapterCountry(countryList, getApplicationContext());
        //recyclerView.setAdapter(adapterCountry);
        postsAdapter = new PostsAdapter(postsModelList, getApplicationContext());
        recyclerView.setAdapter(postsAdapter);
    }

    public class TaskCountry2 extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            String content = null;
            try {
                content = HttpConnection.getData(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                //countryList = JsonCountry.getData(s);
                postsModelList = PostsJson.getData(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            processData();

            progressBar.setVisibility(View.GONE);
        }
    }


}
