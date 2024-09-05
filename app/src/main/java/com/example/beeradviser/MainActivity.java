package com.example.beeradviser;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner projectTypeSpinner;
    private Spinner interventionSpinner;
    private TextView resultTextView;
    private TextView detailedInterventionsTextView; // New TextView for detailed interventions
    private ProjectAdvisor projectAdvisor = new ProjectAdvisor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        projectTypeSpinner = findViewById(R.id.projectTypeSpinner);
        interventionSpinner = findViewById(R.id.interventionSpinner);
        resultTextView = findViewById(R.id.textView);
        detailedInterventionsTextView = findViewById(R.id.detailedInterventionsTextView); // Initialize new TextView

        projectTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedType = parent.getItemAtPosition(position).toString();
                updateInterventionSpinner(selectedType);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        interventionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedIntervention = parent.getItemAtPosition(position).toString();
                updateDetailedInterventions(selectedIntervention);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void updateInterventionSpinner(String projectType) {
        List<String> interventions = projectAdvisor.getInterventions(projectType);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, interventions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        interventionSpinner.setAdapter(adapter);
    }

    private void updateDetailedInterventions(String intervention) {
        List<String> details = projectAdvisor.getDetailedInterventions(intervention);
        StringBuilder detailedText = new StringBuilder();
        for (String detail : details) {
            detailedText.append(detail).append("\n");
        }
        detailedInterventionsTextView.setText(detailedText.toString());
    }

    public void onClickFindIntervention(View view) {
        String selectedIntervention = interventionSpinner.getSelectedItem() != null ? interventionSpinner.getSelectedItem().toString() : "No interventions selected";
        resultTextView.setText(selectedIntervention);
    }
}
