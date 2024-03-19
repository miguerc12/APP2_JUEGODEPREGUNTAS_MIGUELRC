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


}