package edu.java.bot;

import com.github.pengrad.telegrambot.model.Message;
import com.github.pengrad.telegrambot.model.User;
import com.github.pengrad.telegrambot.model.Update;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private final Map<String, Command> commands;

    public CommandHandler() {
        this.commands = new HashMap<>();
        initializeCommands();
    }

    private void initializeCommands() {
        commands.put("/start", (message, user) -> {});
        commands.put("/help", (message, user) -> {});
        commands.put("/track", (message, user) -> {});
        commands.put("/untrack", (message, user) -> {});
        commands.put("/list", (message, user) -> {});
        commands.put("/menu", this::sendMenu);
    }

    private void sendMenu(long chatId) {
        // Логика для отображения меню команд
    }

    public void handleUpdate(Update update) {
        if (update.message() != null && update.message().text() != null) {
            Message message = update.message();
            User user = message.from();

            String commandText = message.text();
            if (commands.containsKey(commandText)) {
                Command command = commands.get(commandText);
                command.execute(message, user);
            } else {

            }
        }
    }

    private interface Command {
        void execute(Message message, User user);
    }
}
