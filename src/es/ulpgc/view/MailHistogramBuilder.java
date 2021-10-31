package es.ulpgc.view;

import es.ulpgc.model.Histogram;
import es.ulpgc.model.Mail;

import java.util.List;

public class MailHistogramBuilder {

    public Histogram<String> build(List<Mail> mails) {
        Histogram<String> histogram = new Histogram<>();
        mails.forEach(m -> histogram.increment(m.getDomain()));
        return histogram;
    }

}
