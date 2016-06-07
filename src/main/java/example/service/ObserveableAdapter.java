package example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import example.controller.UploadController;
import example.domain.ItemCommand;
import rx.Observable;

/**
 * Adapter to attach an Observer to POSTed commands.
 * Created by ton on 02/06/16.
 */
@Component
public class ObserveableAdapter  {

    private final UploadController uploadController;

    private static final Logger LOG = LoggerFactory.getLogger(ObserveableAdapter.class);

    @Autowired
    public ObserveableAdapter(UploadController uploadController) {
        this.uploadController = uploadController;
        LOG.info("Initialized");
    }

    /**
     * Create an observeable stream of commands.
     * @return an {@link Observable} containing POSTed commands.
     */
    public Observable<ItemCommand> getCommandStream() {
        LOG.info("getCommandStream()");
        return Observable.create(observer -> {
            LOG.info("registering handler for: {}", observer.getClass().getName());
            CommandHandler commandHandler = observer::onNext;
            uploadController.addHandler(commandHandler);
        });
    }

}
