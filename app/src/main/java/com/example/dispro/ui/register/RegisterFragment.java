package com.example.dispro.ui.register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dispro.Communicate;
import com.example.dispro.R;
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
    @Override
    public void onStart() {
        super.onStart();
        Button login_button=(Button) getActivity().findViewById(R.id.submit_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Usesrname = (EditText) getActivity().findViewById(R.id.UserName_ET);
                EditText Email = (EditText) getActivity().findViewById(R.id.EmailAdd_ET);
                EditText Pass = (EditText) getActivity().findViewById(R.id.Pass_ET);
                EditText Phno = (EditText) getActivity().findViewById(R.id.Phno_ET);
                String Usesrname_text= Pass.getText().toString();
                String Email_text= Pass.getText().toString();
                String Pass_text= Pass.getText().toString();
                String Phno_text= Phno.getText().toString();
                String msg="{\"Frag\": \"Register\", \"Usesrname\":"+Usesrname_text+", \"Email\":"+Email_text+", \"Pass\":"+Pass_text+", \"Phno\":"+Phno_text+"}";
                msg=new Communicate().communicate(msg);

                Toast.makeText(getActivity(), "Thanks for your valuable feedback", Toast.LENGTH_SHORT).show();
            }
        });
    }
}