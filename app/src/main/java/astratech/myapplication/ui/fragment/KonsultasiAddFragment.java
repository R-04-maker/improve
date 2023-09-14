package astratech.myapplication.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import astratech.myapplication.R;

public class KonsultasiAddFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_konsultasi, container, false);

        Spinner spinner = view.findViewById(R.id.spinner_pilih_lomba_konsultasi);

        // Buat adapter untuk Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.data_lomba, R.layout.custom_spinner_item);
        adapter.setDropDownViewResource(R.layout.custom_spinner_item);

        // Atur adapter ke Spinner
        spinner.setAdapter(adapter);


        Spinner spinnerDosen = view.findViewById(R.id.spinner_pilih_dosen_konsultasi);
        // Buat adapter untuk Spinner
        ArrayAdapter<CharSequence> adapterDosen = ArrayAdapter.createFromResource(requireContext(),
                R.array.data_dosen, R.layout.custom_spinner_item);
        adapter.setDropDownViewResource(R.layout.custom_spinner_item);

        // Atur adapter ke Spinner
        spinnerDosen.setAdapter(adapterDosen);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

    }
}
