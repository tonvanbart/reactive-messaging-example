package example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import example.domain.ItemCommand;

/**
 * Sender class which reads an ItemCommand from an Observable and forwards it on a JMS queue.
 * Created by ton on 06/07/16.
 */
@Service
public class CommandSender {

    private final JmsTemplate jmsTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(CommandSender.class);

    @Autowired
    public CommandSender(JmsTemplate jmsTemplate, ControllerObservableAdapter observableAdapter) {
        this.jmsTemplate = jmsTemplate;
        observableAdapter.getCommandStream().subscribe(this::forwardCommand);
        LOG.info("subscribed");
    }

    private void forwardCommand(ItemCommand itemCommand) {
        LOG.info("forwardCommand({})", itemCommand);
        jmsTemplate.convertAndSend("commandQueue", itemCommand);
    }
}
