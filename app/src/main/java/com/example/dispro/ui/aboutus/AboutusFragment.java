package com.example.dispro.ui.aboutus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dispro.databinding.FragmentAboutusBinding;
import com.example.dispro.databinding.FragmentContactBinding;
import com.example.dispro.ui.contacts.ContactViewModel;

public class AboutusFragment extends Fragment {

    private FragmentAboutusBinding binding;
    private AboutusViewModel aboutusViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AboutusViewModel aboutusViewModel =
                new ViewModelProvider(this).get(AboutusViewModel.class);

        binding = FragmentAboutusBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textAboutus;
        aboutusViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

}