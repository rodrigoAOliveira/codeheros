package rodrigo.provatecnica.codeheros.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.Serializable;
import java.util.List;

import rodrigo.provatecnica.codeheros.Models.Items;
import rodrigo.provatecnica.codeheros.R;

public class DetailHerosActivity extends AppCompatActivity {
    BottomNavigationView bottom;
    FrameLayout fragment_content;
    private static final String EVENTS = "rodrigo.provatecnica.codeheros.view.EVENTS";
    private static final String SERIES = "rodrigo.provatecnica.codeheros.view.SERIES";
    private List<Items> events;
    private List<Items> series;
    Fragment eventsFragment;
    Fragment seriesFragment;

    public static void startActivity(Context context, List<Items> events, List<Items> series) {
        Intent intent = new Intent(new Intent(context, DetailHerosActivity.class));
        intent.putExtra(EVENTS, (Serializable) events);
        intent.putExtra(SERIES, (Serializable) series);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        initViews();

        Intent intent = getIntent();

        events = (List<Items>) intent.getSerializableExtra(EVENTS);
        series = (List<Items>) intent.getSerializableExtra(SERIES);
    }

    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getSupportFragmentManager().popBackStack();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume() {
        viewEvents();
        super.onResume();
        bottom.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.nav_event:
                            getSupportFragmentManager().popBackStack();
                            viewEvents();

                            break;

                        case R.id.nav_serie:
                            getSupportFragmentManager().popBackStack();
                            viewsSerie();

                            break;
                    }
                    return true;
                });
    }

    private void viewsSerie() {
        if (seriesFragment == null)
            seriesFragment = new DetailSeriesFragment(series);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_content, seriesFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void viewEvents() {
        if (eventsFragment == null)
            eventsFragment = new DetailsEventsFragment(events);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_content, eventsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    private void initViews() {
        bottom = findViewById(R.id.bottom);
        fragment_content = findViewById(R.id.fragment_content);
    }
}
