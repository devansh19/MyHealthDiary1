package com.example.dispro.ui.dropzone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dispro.databinding.FragmentContactBinding;
import com.example.dispro.databinding.FragmentDropzoneBinding;
import com.example.dispro.ui.contacts.ContactViewModel;

public class DropzoneFragment extends Fragment {

    private FragmentDropzoneBinding binding;
    private DropzoneViewModel dropzoneViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DropzoneViewModel dropzoneViewModel =
                new ViewModelProvider(this).get(DropzoneViewModel.class);

        binding = FragmentDropzoneBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDropzone;
        dropzoneViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

}