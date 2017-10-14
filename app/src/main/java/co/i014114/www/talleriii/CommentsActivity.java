package co.i014114.www.talleriii;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class CommentsActivity extends AppCompatActivity {
private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        toolbar =  (Toolbar)findViewById(R.id.Tolbar);
        showToolbar(getResources().getString(R.string.Pantalla3 ),true);


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

}
