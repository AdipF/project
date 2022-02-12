package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.project.adapter.ConsultationAdapter;
import com.example.project.model.Consultation;
import com.example.project.model.SharedPrefManager;
import com.example.project.model.User;
import com.example.project.remote.ApiUtils;
import com.example.project.remote.ConsultationService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentListActivity extends AppCompatActivity {

    ConsultationService consultationService;
    Context context;
    RecyclerView consultationList;
    ConsultationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        context = this; // get current activity context

        // get reference to the RecyclerView bookList
        consultationList = findViewById(R.id.consultationList);

        // get user info from SharedPreferences
        User user = SharedPrefManager.getInstance(getApplicationContext()).getUser();

        // get book service instance
        consultationService = ApiUtils.getConsultationService();

        // execute the call. send the user token when sending the query
        consultationService.getStudConsultation(user.getToken()).enqueue(new Callback<List<Consultation>>() {
            @Override
            public void onResponse(Call<List<Consultation>> call, Response<List<Consultation>> response) {
                // for debug purpose
                Log.d("MyApp:", "Response: " + response.raw().toString());

                // Get list of book object from response
                List<Consultation> consultations = response.body();

                // initialize adapter
                adapter = new ConsultationAdapter(context, consultations);

                // set adapter to the RecyclerView
                consultationList.setAdapter(adapter);

                // set layout to recycler view
                consultationList.setLayoutManager(new LinearLayoutManager(context));

                // add separator between item in the list
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(consultationList.getContext(),
                        DividerItemDecoration.VERTICAL);
                consultationList.addItemDecoration(dividerItemDecoration);
            }

            @Override
            public void onFailure(Call<List<Consultation>> call, Throwable t) {
                Toast.makeText(context, "Error connecting to the server", Toast.LENGTH_LONG).show();
                Log.e("MyApp:", t.getMessage());
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.consultation_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Consultation selectedBook = adapter.getSelectedItem();
        Log.d("MyApp", "selected "+selectedBook.toString());
        switch (item.getItemId()) {
            //case R.id.menu_details://should match the id in the context menu file
              //  doViewDetails(selectedBook);
              //  break;
            //case R.id.menu_delete://should match the id in the context menu file
              //  doDeleteBook(selectedBook);
               // break;
            //case R.id.menu_update://should match the id in the context menu file
               // doUpdate(selectedBook);
               // break;
        }
        return super.onContextItemSelected(item);
    }


    /**
     * Delete book record. Called by contextual menu "Delete"
     * @param selectedBook - book selected by user
     */
}