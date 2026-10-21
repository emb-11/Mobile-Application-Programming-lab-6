package com.example.lab6;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {
    ImageView pop;
    TextView t, t2, t3;
    Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        
        pop = findViewById(R.id.more_icon);

        t = findViewById(R.id.textView);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);
        pay = findViewById(R.id.button);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = createDialogue();
                dialog.show();
            }
        });

        // clicking on the text
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFloating(v);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFloating(v);
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFloating(v);
            }
        });

        // clicking on menu icon
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });
    }

    // floating menu
    private void showFloating(View v) {
        PopupMenu pop = new PopupMenu(MainActivity.this, v);
        pop.getMenuInflater().inflate(R.menu.floating_menu, pop.getMenu());
        pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.edit) {
                    Toast.makeText(MainActivity.this, "edit clicked", Toast.LENGTH_LONG).show();
                }
                if (item.getItemId() == R.id.share) {
                    Toast.makeText(MainActivity.this, "share clicked", Toast.LENGTH_LONG).show();
                }
                if (item.getItemId() == R.id.like) {
                    Toast.makeText(MainActivity.this, "like clicked", Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });
        pop.show();
    }

    // pop up menu
    private void showMenu(View v) {
        // popup object
        PopupMenu pop = new PopupMenu(MainActivity.this, v);
        pop.getMenuInflater().inflate(R.menu.popup_menu, pop.getMenu());
        pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // if an item is selected
                if (item.getItemId() == R.id.favorite) {
                    Toast.makeText(MainActivity.this, "favorite clicked", Toast.LENGTH_LONG).show();
                }
                if (item.getItemId() == R.id.info) {
                    Toast.makeText(MainActivity.this, "info clicked", Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });
        pop.show();
    }

    // alert Dialogue
    AlertDialog createDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Confirm your order");


        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "payment successful", Toast.LENGTH_LONG).show();
            }
        });


        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "payment canceled", Toast.LENGTH_LONG).show();
            }
        });
        return builder.create();
    }
}
