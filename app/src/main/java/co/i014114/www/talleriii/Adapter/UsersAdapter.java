package co.i014114.www.talleriii.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import co.i014114.www.talleriii.ArrayPhotos.Photos;
import co.i014114.www.talleriii.Model.UsersModel;
import co.i014114.www.talleriii.PostsActivity;
import co.i014114.www.talleriii.R;

/**
 * Created by root on 12/10/17.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {


    List<UsersModel> usersModelList = new ArrayList<>();
    Context context;

    // Constructor de la clase
    public UsersAdapter(List<UsersModel> usersList, Context context) {
        this.usersModelList = usersList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Configuracion del ViewAdapter

        // Obtener la vista (item.xml)
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_users, parent, false);

        // Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Photos phothos = new Photos();
        Picasso.with(context).load(phothos.getPhotos()).into((holder.foto));

        // Encargado de trabajar con el item.xml y sus componentes

        holder.id.setText(Integer.toString(usersModelList.get(position).getId()));
        holder.name.setText("Name: " + usersModelList.get(position).getName());
        holder.userName.setText("User name: " + usersModelList.get(position).getUserName());
        holder.email.setText("Email: " + usersModelList.get(position).getEmail());
        holder.address.setText("Address: " + usersModelList.get(position).getAddress());
        holder.company.setText("Company: " + usersModelList.get(position).getCompany());


    }

    @Override
    public int getItemCount() {
        return usersModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView id, name, userName, email, address, company;

        ImageView foto;

        public ViewHolder(View item) {
            super(item);

            item.setOnClickListener(this);
            foto = (ImageView) item.findViewById(R.id.img_Item_Pantalla1);
            name = (TextView) item.findViewById(R.id.txt_pantalla1_name);
            userName = (TextView) item.findViewById(R.id.txt_pantalla1_username);
            id = (TextView) item.findViewById(R.id.txt_Pantalla1_id);
            email = (TextView) item.findViewById(R.id.txt_pantalla1_email);
            address = (TextView) item.findViewById(R.id.txt_pantalla1_address);
            company = (TextView) item.findViewById(R.id.txt_pantalla1_Company);
        }

        @Override
        public void onClick(View view) {

            Context contextItem = view.getContext();
            Intent intent = new Intent(context, PostsActivity.class);
            intent.putExtra("idUser", usersModelList.get(getLayoutPosition()).getId());
            intent.putExtra("nameUser", usersModelList.get(getLayoutPosition()).getUserName());


            contextItem.startActivity(intent);
        }
    }


}
