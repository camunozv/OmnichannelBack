package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.dtos.createqueja.models.QuejaEmpresaDTO;
import com.proyectopd.omnichannel.models.Empresa;
import com.proyectopd.omnichannel.models.Queja;
import com.proyectopd.omnichannel.models.TipoQueja;
import jakarta.mail.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Properties;

import static com.proyectopd.omnichannel.mappers.QuejaEmpresaDTOMapper.mapQuejaEmpresaDTOToQueja;

/*
Am Besten verwenden wir IMAP, since it leaves our devives synchronized.
* */

@Service
public class EmailManager {

    @Autowired
    private TipoQuejaServiceImplementation tipoQuejaServiceImplementation;

    @Autowired
    private EmpresaServiceImplementation empresaServiceImplementation;

    @Autowired
    private QuejaServiceImplementation quejaServiceImplementation;

    //@Scheduled(cron = "0 0 0 * * ?")// Runs at midnight every day
    //@Scheduled(initialDelay = 300000) // For testing the method
    @Scheduled(fixedRate = 120000) // Executes the method every 2 minutes
    public void readEmails() {
        Properties props = new Properties();

        props.put("mail.store.protocol", "imaps"); // Use "imaps" for secure IMAP
        props.put("mail.imaps.host", "imap.gmail.com");
        props.put("mail.imaps.port", 993);
        props.put("mail.imaps.ssl.enable", "true"); // Enable SSL for IMAP

        Session session = Session.getDefaultInstance(props);

        QuejaEmpresaDTO quejaFromMail = new QuejaEmpresaDTO();

        try {
            // Connection
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", "quejasomnichannel@gmail.com", "");

            // Inbox opening
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE);

            Message[] messages = inbox.getMessages();

            if (messages.length == 0) {
                System.out.println("There are no messages.");
            } else {
                for (Message message : messages) {

                    Multipart multiPart = (Multipart) message.getContent();

                    String [] typeComplainAndCompany = message.getSubject().split(",");
                    String typeComplain = typeComplainAndCompany[0].trim();
                    String company = typeComplainAndCompany[1].trim();

                    quejaFromMail.setTipoQueja(typeComplain);
                    quejaFromMail.setNombreEmpresa(company);
                    quejaFromMail.setEstado("SIN RESOLVER");

                    TipoQueja tipoQueja = tipoQuejaServiceImplementation.getTipoQuejaById(typeComplain);
                    Empresa empresa = empresaServiceImplementation.getEmpresaByName(company);

                    String inputDateString = message.getSentDate().toInstant().toString();
                    String[] separated = inputDateString.split("T");

                    quejaFromMail.setTiempoMinimoRespuesta(LocalDate.parse(separated[0]));

                    for (int k = 0; k < multiPart.getCount(); k++) {
                        BodyPart bodyPart = multiPart.getBodyPart(k);
                        // With other conditions we can handle multiple content types.
                        if (bodyPart.isMimeType("text/plain")) {
                            quejaFromMail.setDescripcion((String) bodyPart.getContent());
                        }
                    }

                    Queja quejaToSave = mapQuejaEmpresaDTOToQueja(quejaFromMail);
                    quejaToSave.setTiempoMinimoRespuesta(quejaFromMail.getTiempoMinimoRespuesta().plusDays(tipoQueja.getDias()));
                    quejaToSave.setEmpresa(empresa);
                    quejaToSave.setTipoQueja(tipoQueja);

                    Queja created = quejaServiceImplementation.createQueja(quejaToSave);

                    if (created != null) {
                        // Email answering good
                        System.out.println("Queja created successfully!");
                    } else {
                        // Email fucking the usere
                        System.out.println("Go fuck yourself!");
                    }

                    message.setFlag(Flags.Flag.DELETED, true);
                }
            }
            inbox.close(true);
            store.close();
        } catch (Exception e) {
            System.out.println("Message couldn't be read.");
            e.printStackTrace();
        }
    }
}