package example.service;

import example.domain.ItemCommand;
import rx.Observable;

/**
 * An interface for classes that provide an Observable of ItemCommands.
 * Created by ton on 23/06/16.
 */
public interface ObservableAdapter {

    /**
     * Return the Observable of ItemCommands.
     * @return the Observable.
     */
    Observable<ItemCommand> getCommandStream();
}
