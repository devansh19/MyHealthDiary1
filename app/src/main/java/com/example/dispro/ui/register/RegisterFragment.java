package com.example.dispro.ui.register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dispro.databinding.FragmentContactBinding;
import com.example.dispro.databinding.FragmentRegisterBinding;
import com.example.dispro.ui.contacts.ContactViewModel;

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;
    private RegisterViewModel registerViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RegisterViewModel registerViewModel =
                new ViewModelProvider(this).get(RegisterViewModel.class);

        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textregister;
        registerViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
}