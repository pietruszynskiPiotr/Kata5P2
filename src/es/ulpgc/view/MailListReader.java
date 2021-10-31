package es.ulpgc.view;

import es.ulpgc.model.Mail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class MailListReader {

    public List<Mail> read(String fileName) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(fileName));
        return strings.stream()
                .map(Mail::new)
                .collect(Collectors.toList());
    }

}
