package example.controller;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import example.domain.ItemCommand;
import example.service.CommandHandler;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * Created by ton on 30/05/16.
 */
@Controller
public class UploadController {

    private static final Logger LOG = LoggerFactory.getLogger(UploadController.class);

    public UploadController() {
        LOG.info("Initialized");
    }

    private List<CommandHandler> commandHandlers = new ArrayList<>();

    /**
     *
     */
    @RequestMapping(value = "/command", method = RequestMethod.POST)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ResponseBody
    public HttpEntity<String> handleCommand(@RequestBody ItemCommand itemCommand) {
        LOG.info("handleCommand({})", itemCommand);

        int nr = itemCommand.getTail().size();
        LOG.info("{} items in tail", nr);

        for (CommandHandler commandHandler : commandHandlers) {
            commandHandler.handle(itemCommand);
        }

        return new ResponseEntity<>("Forwarded", CREATED);
    }

    public void addHandler(CommandHandler handler) {
        LOG.info("addHandler({})", handler);
        commandHandlers.add(handler);
    }

    public void removeHandler(CommandHandler handler) {
        commandHandlers.remove(handler);
    }

}
