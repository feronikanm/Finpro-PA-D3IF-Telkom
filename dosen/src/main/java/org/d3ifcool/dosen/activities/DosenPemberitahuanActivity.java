package org.d3ifcool.dosen.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.d3ifcool.dosen.R;
import org.d3ifcool.dosen.adapters.recyclerview.DosenPemberitahuanViewAdapter;
import org.d3ifcool.service.interfaces.lists.NotifikasiListView;
import org.d3ifcool.service.models.Notifikasi;
import org.d3ifcool.service.presenters.NotifikasiPresenter;

import java.util.ArrayList;
import java.util.List;

public class DosenPemberitahuanActivity extends AppCompatActivity implements NotifikasiListView {

    private RecyclerView recyclerView;
    private NotifikasiPresenter notifikasiPresenter;
    private ProgressDialog progressDialog;
    private ArrayList<Notifikasi> notifikasiArrayList = new ArrayList<>();
    private View empty_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_pemberitahuan);

        setTitle(getString(R.string.title_pemberitahuan));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.act_dsn_pemberitahuan_recyclerview);
        empty_view = findViewById(R.id.view_emptyview);
        progressDialog = new ProgressDialog(this);
        notifikasiPresenter = new NotifikasiPresenter(this);
        progressDialog.setMessage(getString(org.d3ifcool.mahasiswa.R.string.text_progress_dialog));

        notifikasiPresenter.getNotifikasi();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.hide();
    }

    @Override
    public void onGetListNotifikasi(List<Notifikasi> notifikasiList) {
        notifikasiArrayList.clear();
        notifikasiArrayList.addAll(notifikasiList);

        if (notifikasiArrayList.size() != 0){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            DosenPemberitahuanViewAdapter adapter = new DosenPemberitahuanViewAdapter(this, notifikasiArrayList);
            DividerItemDecoration itemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());

            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.addItemDecoration(itemDecoration);
            recyclerView.setAdapter(adapter);

            empty_view.setVisibility(View.VISIBLE);

        } else {

            empty_view.setVisibility(View.VISIBLE);

        }

    }

    @Override
    public void onFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
