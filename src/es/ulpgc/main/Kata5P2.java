/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.ulpgc.main;

import es.ulpgc.view.DisplayHistogram;
import es.ulpgc.model.Histogram;
import es.ulpgc.model.Mail;
import es.ulpgc.view.MailHistogramBuilder;
import es.ulpgc.view.MailListReaderBD;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author piotrgit 
 */
public class Kata5P2 {

       public static void main(String[] args) throws IOException {
        new Kata5P2().execute();
    }

    public void execute() throws IOException {
        List<Mail> input = input();
        Histogram<String> process = process(input);
        output(process);
    }

    private List<Mail> input() throws IOException {
        return new MailListReaderBD().read();
    }

    private Histogram<String> process(List<Mail> mails) {
        MailHistogramBuilder mailHistogramBuilder = new MailHistogramBuilder();
        return mailHistogramBuilder.build(mails);
    }

    private void output(Histogram<String> process) {
        java.awt.EventQueue.invokeLater(() -> {
            new DisplayHistogram("Histogram", process).execute();
        });
    }
    
}
