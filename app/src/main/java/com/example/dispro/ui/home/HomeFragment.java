package com.example.dispro.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dispro.DBM;
import com.example.dispro.R;
import com.example.dispro.Review;
import com.example.dispro.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    DBM dbm;

    Activity Review_act;
    Activity Addition_act;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Review_act=getActivity();
        Addition_act=getActivity();

        dbm = new DBM(getActivity());

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textView7;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    public void onStart() {
        super.onStart();
        Button Review_btn=(Button) Review_act.findViewById(R.id.Review);
        Button Addition_btn=(Button) Addition_act.findViewById(R.id.Addition);
        Review_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Boolean checkinsertdata = dbm.insert("parth", "bansal","05");
//                if(checkinsertdata==true)
//                    Toast.makeText(getActivity(), "New Entry Inserted", Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(getActivity(), "New Entry Not Inserted", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Review_act, Review.class);
                startActivity(intent);
            }
        });


//        String msg="Working";
//        msg=new Communicate().communicate("client msg");

        Addition_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Cursor res = dbm.fetch();
//                if(res.getCount()==0){
//                    Toast.makeText(getActivity(), "No Entry Exists", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                StringBuffer buffer = new StringBuffer();
//                while(res.moveToNext()){
//                    buffer.append("Name :"+res.getString(0)+"\n");
//                    buffer.append("Contact :"+res.getString(1)+"\n");
//                    buffer.append("Date of Birth :"+res.getString(2)+"\n\n");
//                }
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                builder.setCancelable(true);
//                builder.setTitle("User Entries");
//                builder.setMessage(buffer.toString());
//                builder.show();



            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}