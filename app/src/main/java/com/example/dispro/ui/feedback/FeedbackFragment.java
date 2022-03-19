package com.example.dispro.ui.feedback;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dispro.databinding.FragmentContactBinding;
import com.example.dispro.databinding.FragmentFeedbackBinding;
import com.example.dispro.ui.contacts.ContactViewModel;

public class FeedbackFragment extends Fragment {

    private FragmentFeedbackBinding binding;
    private FeedbackViewModel feedbackViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FeedbackViewModel feedbackViewModel =
                new ViewModelProvider(this).get(FeedbackViewModel.class);

        binding = FragmentFeedbackBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textFeedback;
        feedbackViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
}