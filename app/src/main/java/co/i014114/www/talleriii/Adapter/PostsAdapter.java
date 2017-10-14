package co.i014114.www.talleriii.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.i014114.www.talleriii.CommentsActivity;
import co.i014114.www.talleriii.Model.PostsModel;
import co.i014114.www.talleriii.PostsActivity;
import co.i014114.www.talleriii.R;

/**
 * Created by root on 12/10/17.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {


    List<PostsModel> postsModelList = new ArrayList<>();
    Context context;

    // Constructor de la clase
    public PostsAdapter(List<PostsModel> postsLits, Context context) {
        this.postsModelList = postsLits;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Configuracion del ViewAdapter

        // Obtener la vista (item.xml)
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_posts, parent, false);

        // Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //  Photos phothos = new Photos();
        //     Picasso.with(context).load(phothos.getUrlPhoto()).into((holder.foto));

        // Encargado de trabajar con el item.xml y sus componentes
        holder.userId.setText(Integer.toString(postsModelList.get(position).getUserId()));;
        holder.id.setText(Integer.toString(postsModelList.get(position).getId()));
        holder.title.setText("Title: " + postsModelList.get(position).getTitle());
        holder.body.setText("Body: " + postsModelList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return postsModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView userId, userName, id, title, body;
        ImageView foto;

        public ViewHolder(View item) {
            super(item);

            item.setOnClickListener(this);

            foto = (ImageView) item.findViewById(R.id.img_Item_Pantalla2);
            userId = (TextView) item.findViewById(R.id.txt_Pantalla2_id_user);
            userName = (TextView) item.findViewById(R.id.txt_pantalla2_name_user);
            id = (TextView) item.findViewById(R.id.txt_pantalla2_Id);
            title = (TextView) item.findViewById(R.id.txt_pantalla2_title);
            body = (TextView) item.findViewById(R.id.txt_pantalla2_body);
        }

        @Override
        public void onClick(View view) {

            Context contextItem = view.getContext();
            Intent intent = new Intent(context, CommentsActivity.class);
            intent.putExtra("idPosts", postsModelList.get(getLayoutPosition()).getId());
            contextItem.startActivity(intent);
        }
    }
}
