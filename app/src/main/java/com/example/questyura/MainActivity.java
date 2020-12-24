package com.example.questyura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 */
public class MainActivity extends AppCompatActivity {
    TextView subject, text;
    EditText answer;
    Button next;
    Story story;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next = findViewById(R.id.next);
        answer = findViewById(R.id.answer);
        subject = findViewById(R.id.subject);
        text = findViewById(R.id.text);
        createStory(); //создали историю
        subject.setText(story.getCurrentSituation().getSubject());
        text.setText(story.getCurrentSituation().getText());
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int answer = Integer.parseInt(MainActivity.this.answer.getText().toString());
                story.go(answer);
                subject.setText(story.getCurrentSituation().getSubject());
                text.setText(story.getCurrentSituation().getText());
                //меняем рейтинг пользователя - перcонажа
            }
        };
        next.setOnClickListener(listener); // не забудьте для связи кнопки с экшеном
    }
    public void createStory() {
        Situation s1 = new Situation("Hello", "Что ты выберешь? \n1- да\n 2 - нет",
                2, 0, 0, 0);
//        ..определяем первый вопрос
        s1.getDirections()[0] = new Situation("Вы выбрали ответ \"да\"",
                "Что вас заставило ответить так? \n1 - твоя лень \n 2- твоя большая лень",
                2, 10, 10, 10);
            s1.getDirections()[0].getDirections()[0] = new Situation("поздравляем",
                    "Ты лентяй!!!", 0, -2, -2, 2);
            s1.getDirections()[0].getDirections()[1] = new Situation("поздравляем",
                    "Ты большой лентяй!!!", 0, -2, -2, 2);
//        ..определяем второй вопрос
        s1.getDirections()[1] = new Situation("Вы выбрали ответ \"нет\"",
                "Ты хочешь завершить квест? \n1 - да \n 2- нет",
                2, 10, 10, 10);
            s1.getDirections()[1].getDirections()[0] = new Situation("поздравляем",
                    "Ты не лентяй!! ты дошел до конца!", 0, -2, -2, 2);
            s1.getDirections()[1].getDirections()[1] = new Situation("поздравляем",
                    "Тебе не хватило чуть терпения!!!", 0, -2, -2, 2);
        story = new Story(s1, MainActivity.this);
    }
}
