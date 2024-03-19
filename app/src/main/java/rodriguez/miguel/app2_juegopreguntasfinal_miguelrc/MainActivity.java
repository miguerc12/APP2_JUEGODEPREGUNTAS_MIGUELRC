package rodriguez.miguel.app2_juegopreguntasfinal_miguelrc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TextView preguntaTextView, resultadosTextView;
    private RadioGroup opcionesRadioGroup;
    private RadioButton opcion1RadioButton, opcion2RadioButton, opcion3RadioButton;
    private Button siguienteButton, volverIntentarButton, salirButton;

    private String[] preguntas = {
            "¿Quién es considerado el padre de la computación?",
            "¿Qué significa la sigla HTML?",
            "¿Qué es un algoritmo?",
            "¿Qué empresa desarrolló el sistema operativo Windows?",
            "¿Cuál de las siguientes no es una red social?",
            "¿Qué es un virus informático?",
            "¿Qué es un algoritmo de búsqueda?",
            "¿Qué es la inteligencia artificial?",
            "¿Qué lenguaje de programación es conocido por su simplicidad y legibilidad?",
            "¿Qué es un sistema de gestión de bases de datos?"
    };
    private String[][] opciones = {
            {"Charles Babbage", "Alan Turing", "Bill Gates"}, // Pregunta 1
            {"HyperText Markup Language", "High Transfer Machine Language", "Hyper Transfer Machine Language"}, // Pregunta 2
            {"Un componente de hardware", "Una serie de pasos para realizar una tarea", "Un tipo de virus"}, // Pregunta 3
            {"Apple", "Microsoft", "Google"}, // Pregunta 4
            {"Facebook", "WhatsApp", "Twitter"}, // Pregunta 5
            {"Un componente de hardware", "Un programa diseñado para dañar o alterar el funcionamiento de una computadora", "Una página web"}, // Pregunta 6
            {"Un método para encontrar información en una base de datos", "Un tipo de virus", "Un algoritmo de búsqueda"}, // Pregunta 7
            {"La capacidad de las máquinas para realizar tareas que requieren inteligencia humana", "Un lenguaje de programación", "Un tipo de virus"}, // Pregunta 8
            {"Python", "Java", "C++"}, // Pregunta 9
            {"Un software para almacenar y gestionar grandes cantidades de datos", "Un componente de hardware", "Un lenguaje de programación"} // Pregunta 10
    };
    private int[] respuestas = {1, 0, 1, 0, 1, 0, 0, 0, 0, 0};
    private int preguntaActual = 0;
    private int respuestasCorrectas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preguntaTextView = findViewById(R.id.preguntaTextView);
        resultadosTextView = findViewById(R.id.resultadosTextView);
        opcionesRadioGroup = findViewById(R.id.opcionesRadioGroup);
        opcion1RadioButton = findViewById(R.id.opcion1RadioButton);
        opcion2RadioButton = findViewById(R.id.opcion2RadioButton);
        opcion3RadioButton = findViewById(R.id.opcion3RadioButton);
        siguienteButton = findViewById(R.id.siguienteButton);
        volverIntentarButton = findViewById(R.id.volverIntentarButton);
        salirButton = findViewById(R.id.salirButton);

        mostrarPregunta();
        siguienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta();
                if (preguntaActual < preguntas.length) {
                    mostrarPregunta();
                } else {
                    mostrarResultados();
                }
            }
        });

        volverIntentarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciarJuego();
            }
        });

        salirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void reiniciarJuego() {
        preguntaActual = 0;
        respuestasCorrectas = 0;
        mostrarPregunta();
        resultadosTextView.setText("");
        siguienteButton.setVisibility(View.VISIBLE);
    }

    private void mostrarPregunta() {
        preguntaTextView.setText(preguntas[preguntaActual]);
        opcion1RadioButton.setText(opciones[preguntaActual][0]);
        opcion2RadioButton.setText(opciones[preguntaActual][1]);
        opcion3RadioButton.setText(opciones[preguntaActual][2]);
        opcionesRadioGroup.clearCheck();
        preguntaActual++;
    }

    private void comprobarRespuesta() {
        int idSeleccionado = opcionesRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButtonSeleccionado = findViewById(idSeleccionado);
        int indiceRespuesta = opcionesRadioGroup.indexOfChild(radioButtonSeleccionado);
        if (indiceRespuesta == respuestas[preguntaActual - 1]) {
            respuestasCorrectas++;
        }
    }

    private void mostrarResultados() {
        double promedio = (double) respuestasCorrectas / preguntas.length * 10;
        String mensaje = "";

        if (promedio >= 1 && promedio <= 3) {
            mensaje = "Dedicate a otra cosa :)";
        } else if (promedio >= 4 && promedio <= 5) {
            mensaje = "Estudia un poco mas :(";
        } else if (promedio >= 6 && promedio <= 7) {
            mensaje = "De panzaso :,)";
        } else if (promedio >= 8 && promedio <= 9) {
            mensaje = "Bien, pero puedes mejorar aun mas";
        } else if (promedio == 10) {
            mensaje = " wow! Eres todo un Niño rata";
        }

        resultadosTextView.setText("Resultados: " + respuestasCorrectas + " respuestas correctas de 10.\nPromedio: " + promedio + "\nMensaje: " + mensaje);
        siguienteButton.setVisibility(View.GONE);
    }

}