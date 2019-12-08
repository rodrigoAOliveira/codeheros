package rodrigo.provatecnica.codeheros.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import rodrigo.provatecnica.codeheros.Models.Result;
import rodrigo.provatecnica.codeheros.R;
import rodrigo.provatecnica.codeheros.ViewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    MainViewModel viewModel;
    private HeroesAdapter adapter;
    private RecyclerView recyclerHeroes;
    private ImageView imgBack, imgAvanced;
    private EditText edtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initViewModel();
        initViews();
        setupList();
        viewModel.setApikey(getString(R.string.apikey));
        viewModel.setHash(getString(R.string.hash));
        viewModel.getHeroes();
        viewModel.loadHeros().observe(this, this::updateAdapter);

        imgBack.setOnClickListener(v -> viewModel.minus(4));
        imgAvanced.setOnClickListener(v -> viewModel.more(4));
        filterHeros();
    }

    private void filterHeros() {
        edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void updateAdapter(List<Result> heros) {
        adapter.updateList(heros);
    }

    private void initViews() {
        recyclerHeroes = findViewById(R.id.recyclerHeroes);
        imgBack = findViewById(R.id.imgBack);
        imgAvanced = findViewById(R.id.imgAvanced);
        edtName = findViewById(R.id.edtName);
    }

    private void setupList() {
        if (adapter == null) {
            adapter = new HeroesAdapter();
        }
        recyclerHeroes.setVisibility(View.VISIBLE);
        recyclerHeroes.setAdapter(adapter);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerHeroes.setLayoutManager(layout);

    }


    private void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }
}
