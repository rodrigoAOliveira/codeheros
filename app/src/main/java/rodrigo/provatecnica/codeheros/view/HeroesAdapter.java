package rodrigo.provatecnica.codeheros.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.List;

import rodrigo.provatecnica.codeheros.Models.Result;
import rodrigo.provatecnica.codeheros.R;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {

    private List<Result> herosList = new ArrayList<>();
    private List<Result> herosListFilter = new ArrayList<>();

    public void updateList(List<Result> herosList) {
        this.herosList = herosList;
        this.herosListFilter = herosList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txName.setText(herosList.get(position).getName());
        Picasso.get().load(herosList.get(position).getThumbnail().getPath() + "." + herosList.get(position).getThumbnail().getExtension()
        ).into(holder.img);

        holder.itemView.setOnClickListener(v -> {
            DetailHerosActivity.startActivity(holder.itemView.getContext(), herosList.get(position).getEvents().getItems(),
                    herosList.get(position).getSeries().getItems());
        });
    }

    @Override
    public int getItemCount() {
        return herosList == null ? 0 : herosList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txName;
        public ImageView img;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            txName = itemView.findViewById(R.id.txName);
            img = itemView.findViewById(R.id.img);
        }
    }


    public Filter getFilter() {
        Filter filter = new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence filtro) {
                FilterResults results = new FilterResults();

                if (filtro == null || filtro.length() == 0) {
                    results.count = herosListFilter.size();
                    results.values = herosListFilter;
                } else {

                    List<Result> itens_filtrados = new ArrayList<Result>();


                    for (int i = 0; i < herosListFilter.size(); i++) {
                        Result data = herosListFilter.get(i);

                        filtro = filtro.toString().toLowerCase();
                        String condicao = data.getName().toLowerCase();

                        if (condicao.contains(filtro)) {

                            itens_filtrados.add(data);
                        }
                    }

                    results.count = itens_filtrados.size();
                    results.values = itens_filtrados;
                }
                return results;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
                herosList = (List<Result>) results.values;
                notifyDataSetChanged();
            }

        };
        return filter;
    }
}
