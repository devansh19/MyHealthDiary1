package com.example.dispro.ui.feedback;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.dispro.Communicate;
import com.example.dispro.R;
import com.example.dispro.databinding.FragmentContactBinding;
import com.example.dispro.databinding.FragmentFeedbackBinding;
import com.example.dispro.ui.contacts.ContactViewModel;
import com.example.dispro.ui.home.HomeFragment;

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
    @Override
    public void onStart() {
        super.onStart();
        Button submit_button=(Button) getActivity().findViewById(R.id.submit_button);
        EditText feedback=(EditText) getActivity().findViewById(R.id.editTextFeedback);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String feedback_text= feedback.getText().toString();
                String msg="{\"Frag\": \"Feedback\", \"text\":"+feedback_text+"}";
                msg=new Communicate().communicate(msg);
                Toast.makeText(getActivity(), "Thanks for your valuable feedback", Toast.LENGTH_SHORT).show();
//                Fragment fragment= new tasks();
//                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.nav_host_fragment_content_main,R.id.HomeFragment);


            }
        });
    }
}