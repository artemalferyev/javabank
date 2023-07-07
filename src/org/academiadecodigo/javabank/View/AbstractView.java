package org.academiadecodigo.javabank.View;
import org.academiadecodigo.bootcamp.Prompt;

public abstract class AbstractView implements View {
    public Prompt prompt;
    public Prompt getPrompt() {
        return prompt;
    }
    public void setPrompt(Prompt prompt) {

        this.prompt = prompt;
    }
}
