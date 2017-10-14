package co.i014114.www.talleriii.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.i014114.www.talleriii.Model.CommentsModel;
import co.i014114.www.talleriii.R;


/**
 * Created by root on 12/10/17.
 */

public class CommentsAdapter   extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {


    List<CommentsModel> commentsModelList = new ArrayList<>();
    Context context;

    // Constructor de la clase
    public CommentsAdapter(List<CommentsModel> postsLits, Context context) {
        this.commentsModelList = postsLits;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Configuracion del ViewAdapter

        // Obtener la vista (item.xml)
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comments, parent, false);

        // Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //  Photos phothos = new Photos();
        //     Picasso.with(context).load(phothos.getUrlPhoto()).into((holder.foto));

        // Encargado de trabajar con el item.xml y sus componentes
        TextView postId, id, name,email,body;


        holder.postId.setText("postId: "+Integer.toString(commentsModelList.get(position).getPostId()));
        holder.id.setText("Id: " + commentsModelList.get(position).getId());
        holder.name.setText("Name: "+commentsModelList.get(position).getName());
        holder.email.setText("Email: " + commentsModelList.get(position).getEmail());
        holder.body.setText("Body: " + commentsModelList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return commentsModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView postId, id, name,email,body;

        public ViewHolder(View item) {
            super(item);

            postId = (TextView) item.findViewById(R.id.txt_pantalla3_postId);
            id = (TextView) item.findViewById(R.id.txt_pantalla3_id);
            name = (TextView) item.findViewById(R.id.txt_pantalla3_name);
            email = (TextView) item.findViewById(R.id.txt_pantalla3_email);
            body = (TextView) item.findViewById(R.id.txt_pantalla3_body);
        }


    }
}
