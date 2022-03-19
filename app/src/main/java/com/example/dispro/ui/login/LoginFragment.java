package com.example.dispro.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dispro.databinding.FragmentContactBinding;
import com.example.dispro.databinding.FragmentLoginBinding;
import com.example.dispro.ui.contacts.ContactViewModel;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private LoginViewModel loginViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LoginViewModel loginViewModel =
                new ViewModelProvider(this).get(LoginViewModel.class);

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textlogin;
        loginViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

}