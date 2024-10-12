package com.example.listviewrecording;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listviewrecording.Adapter.UserAdapter;
import com.example.listviewrecording.Model.UserModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BottomSheetDialog bottomSheetDialog;
    FloatingActionButton floatingActionButton;
    ArrayList<UserModel> arrayList = new ArrayList<>();
    ListView listView;
    EditText edtName,edtEmail;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.fab);
        listView = findViewById(R.id.listView);

        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.show();
            }
        });
        UserAdapter userAdapter = new UserAdapter(MainActivity.this,arrayList);
        listView.setAdapter(userAdapter);

        edtName = bottomSheetDialog.findViewById(R.id.edtName);
        edtEmail = bottomSheetDialog.findViewById(R.id.edtEmail);
        btnAdd = bottomSheetDialog.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtName.getText().toString().isEmpty() && !edtEmail.getText().toString().isEmpty()) {
                    UserModel userModel = new UserModel();
                    userModel.setEmail(edtEmail.getText().toString());
                    userModel.setName(edtName.getText().toString());
                    arrayList.add(userModel);

                    userAdapter.notifyDataSetChanged();

                    edtEmail.setText("");
                    edtName.setText("");

                    bottomSheetDialog.dismiss();
                }
            }
        });




    }
}