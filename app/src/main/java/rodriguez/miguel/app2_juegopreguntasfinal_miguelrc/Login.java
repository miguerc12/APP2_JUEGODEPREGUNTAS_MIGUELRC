package rodriguez.miguel.app2_juegopreguntasfinal_miguelrc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;
import android.os.Bundle;

public class Login extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private static final String VALID_USERNAME = "Miguel";
    private static final String VALID_PASSWORD = "120809";
    private int loginAttempts = 0;
    private static final int MAX_LOGIN_ATTEMPTS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    loginAttempts++;
                    if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
                        buttonLogin.setEnabled(false);
                        Toast.makeText(Login.this, "Se han excedido los intentos de inicio de sesión", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Login.this, "Credenciales inválidas", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


}