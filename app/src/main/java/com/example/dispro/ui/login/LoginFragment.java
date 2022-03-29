package com.example.dispro.ui.login;

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
import com.example.dispro.databinding.FragmentLoginBinding;
import com.example.dispro.ui.contacts.ContactViewModel;

import org.json.JSONException;
import org.json.JSONObject;

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
    @Override
    public void onStart() {
        super.onStart();
        Button login_button=(Button) getActivity().findViewById(R.id.submit_button);

        login_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText Phno = (EditText) getActivity().findViewById(R.id.editTextPhone_Number);
            EditText pass = (EditText) getActivity().findViewById(R.id.editTextPassword);
            String ph_text= Phno.getText().toString();
            String pass_text= pass.getText().toString();
            String msg="{\"Frag\": \"Login\", \"ph\":"+ph_text+", \"pass\":"+pass_text+"}";
            msg=new Communicate().communicate(msg);

            Toast.makeText(getActivity(), "Thanks for your valuable feedback", Toast.LENGTH_SHORT).show();
            }
        });
    }
}