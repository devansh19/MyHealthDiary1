package com.example.dispro.ui.logout;

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
import com.example.dispro.databinding.FragmentLogoutBinding;
import com.example.dispro.ui.contacts.ContactViewModel;

public class LogoutFragment extends Fragment {

    private FragmentLogoutBinding binding;
    private LogoutViewModel logoutViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LogoutViewModel logoutViewModel =
                new ViewModelProvider(this).get(LogoutViewModel.class);

        binding = FragmentLogoutBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textLogout;
        logoutViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

}