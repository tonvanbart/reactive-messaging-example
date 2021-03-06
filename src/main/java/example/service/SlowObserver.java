package example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.domain.ItemCommand;
import rx.schedulers.Schedulers;

/**
 * Simulate slow handling of a command.
 * Created by ton on 07/06/16.
 */
@Service
public class SlowObserver {

    private static final Logger LOG = LoggerFactory.getLogger(SlowObserver.class);

    @Autowired
    public SlowObserver(ControllerObservableAdapter observeableAdapter) {
        observeableAdapter.getCommandStream()
                .observeOn(Schedulers.computation())
                .subscribe(command -> slowLogging(command));
    }

    private void slowLogging(ItemCommand command) {
        LOG.info("slow... on '{}'", command);
        try {
            Thread.sleep(2000);
            LOG.info("...finished slow processing {}", command);
        } catch (InterruptedException e) {
            LOG.warn("Interrupted");
        }
    }
}
