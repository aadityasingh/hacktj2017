package jongwankim.connectme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidtutorialpoint.googlemapsapp.R;
import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {
    private EditText firstName;
    private EditText lastName;
    private EditText username;
    private EditText password;
    private EditText confirmPassword;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        submit = (Button) findViewById(R.id.Register);
        Firebase.setAndroidContext(this);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                firstName = (EditText) findViewById(R.id.first);
                lastName = (EditText) findViewById(R.id.last);
                username = (EditText) findViewById(R.id.username);
                password = (EditText) findViewById(R.id.password);
                confirmPassword = (EditText) findViewById(R.id.confirm);
                String pass = password.getText().toString();
                String cPass = confirmPassword.getText().toString();
                if (!pass.equals(cPass)) {
                    Toast.makeText(getApplicationContext(), "Passwords don't match", Toast.LENGTH_SHORT).show();
                }
                else if(firstName.getText().toString() == null){
                    Toast.makeText(getApplicationContext(), "Empty First Name", Toast.LENGTH_SHORT).show();
                }
                else if(lastName.getText().toString() == null){
                    Toast.makeText(getApplicationContext(), "Empty Last Name", Toast.LENGTH_SHORT).show();
                }
                else if(username.getText().toString() == null){
                    Toast.makeText(getApplicationContext(), "Empty Username", Toast.LENGTH_SHORT).show();
                }
                else if(password.getText().toString() == null){
                    Toast.makeText(getApplicationContext(), "Empty Password", Toast.LENGTH_SHORT).show();
                }
                else if(confirmPassword.getText().toString() == null){
                    Toast.makeText(getApplicationContext(), "Confirm Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    DatabaseReference data = FirebaseDatabase.getInstance().getReference();
                    data.child("Person").child(username.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                Toast.makeText(getApplicationContext(), "Username Already Existing", Toast.LENGTH_SHORT);
                            }
                            else {
                                Firebase ref = new Firebase(Config.FIREBASE_URL)
                                Person person = new Person();
                                person.setFirstName(firstName.getText().toString().trim());
                                person.setLastName(lastName.getText().toString().trim());
                                person.setUserName(username.getText().toString().trim());
                                person.setPassword(password.getText().toString());
                                ref.child(username.getText().toString()).push();
                                ref.setValue(person);
                                Intent intent = new Intent(getApplicationContext(), Register.class);
                                startActivity(intent);
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
        });
    }
}
