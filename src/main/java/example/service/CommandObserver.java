package example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.domain.ItemCommand;

/**
 * Created by ton on 07/06/16.
 */
@Service
public class CommandObserver {

    private final ObserveableAdapter observeableAdapter;

    private static final Logger LOG = LoggerFactory.getLogger(CommandObserver.class);

    @Autowired
    public CommandObserver(ObserveableAdapter observeableAdapter) {
        this.observeableAdapter = observeableAdapter;
        observeableAdapter.getCommandStream().subscribe(command -> reportObserved(command));
        LOG.info("Initialized");
    }

    private void reportObserved(ItemCommand command) {
        LOG.info("reportObserved({})", command);
    }
}
