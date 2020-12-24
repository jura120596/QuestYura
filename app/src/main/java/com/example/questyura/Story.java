package com.example.questyura;

import android.content.Context;
import android.widget.Toast;

public class Story {
    private Situation currentSituation;
    private Situation startSituation;
    private Context context;

    public Story(Situation startSituation, Context context) {
        this.startSituation = startSituation; //сохраняем ситуацию для лбъекта
        currentSituation = startSituation;
        this.context = context; // сохраняе контекст для объекта
    }
    public Story(Situation startSituation) {
        this(startSituation, null);
    }

    public void go(int answer) {
        if (answer > currentSituation.getDirections().length || answer <= 0 ) {
            if (context != null) { // если мы запустили с контекстом, т.е. на телефоне
                Toast.makeText(context, "Пожалуйста введите правильный ответ",
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            currentSituation = currentSituation.getDirections()[ answer - 1 ];
        }
    }
     public boolean isEnd() {
        return currentSituation.getDirections().length == 0;
        // вернем результат сравнения с 0 (ДА или НЕТ) true or false
     }

    public Situation getCurrentSituation() {
        return currentSituation;
    }

    public void setCurrentSituation(Situation currentSituation) {
        this.currentSituation = currentSituation;
    }

    public Situation getStartSituation() {
        return startSituation;
    }

    public void setStartSituation(Situation startSituation) {
        this.startSituation = startSituation;
    }
}
