package com.example.dispro.ui.reward;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dispro.databinding.FragmentContactBinding;
import com.example.dispro.databinding.FragmentRewardBinding;
import com.example.dispro.ui.contacts.ContactViewModel;

public class RewardFragment extends Fragment {

    private FragmentRewardBinding binding;
    private RewardViewModel rewardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RewardViewModel rewardViewModel =
                new ViewModelProvider(this).get(RewardViewModel.class);

        binding = FragmentRewardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textReward;
        rewardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

}