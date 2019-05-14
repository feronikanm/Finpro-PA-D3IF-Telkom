package org.d3ifcool.koor.activities.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.d3ifcool.base.models.Judul;
import org.d3ifcool.koor.R;

public class KoorJudulPaArsipDetailActivity extends AppCompatActivity {

    public static final String EXTRA_JUDUL = "extra_judul";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koor_judul_pa_arsip_detail);

        setTitle(getString(org.d3ifcool.dosen.R.string.title_judulpa_detail));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Judul extraJudul = getIntent().getParcelableExtra(EXTRA_JUDUL);
        String extraJudulNama = extraJudul.getJudul();
        String extraJudulKategori = extraJudul.getKategori_nama();
        String extraJudulDeskripsi = extraJudul.getDeskripsi();

        TextView textViewJudul = findViewById(R.id.frg_koor_pa_textview_judulpa);
        TextView textViewKategori = findViewById(R.id.frg_koor_pa_textview_kategoripa);
        TextView textViewDeskripsi = findViewById(R.id.frg_dsn_pa_textview_deskripsi);

        textViewJudul.setText(extraJudulNama);
        textViewKategori.setText(extraJudulKategori);
        textViewDeskripsi.setText(extraJudulDeskripsi);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if (i == android.R.id.home) {
            finish();

        }
        return super.onOptionsItemSelected(item);
    }

}