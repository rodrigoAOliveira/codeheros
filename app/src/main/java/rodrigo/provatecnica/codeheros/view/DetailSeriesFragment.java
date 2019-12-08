package rodrigo.provatecnica.codeheros.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import rodrigo.provatecnica.codeheros.Models.Items;
import rodrigo.provatecnica.codeheros.R;

public class DetailSeriesFragment extends Fragment {
    private DetailsAdapter adapter;
    private List<Items> items;
    private RecyclerView recyclerEvents;

    public DetailSeriesFragment(List<Items> items) {
        this.items = items;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        initViews(view);
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        setupList();
    }

    private void initViews(View view) {
        recyclerEvents = view.findViewById(R.id.recyclerEvents);
    }


    private void setupList() {
        if (adapter == null) {
            adapter = new DetailsAdapter(items);
        }
        recyclerEvents.setVisibility(View.VISIBLE);
        recyclerEvents.setAdapter(adapter);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerEvents.setLayoutManager(layout);

    }
}
