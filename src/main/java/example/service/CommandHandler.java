package example.service;

import example.domain.ItemCommand;

/**
 * Adapter interface.
 * Created by ton on 07/06/16.
 */
public interface CommandHandler {

    void handle(ItemCommand command);

}
