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

import example.domain.ItemCommand;

import static org.springframework.http.HttpStatus.OK;

/**
 * Created by ton on 30/05/16.
 */
@Controller
public class UploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    public UploadController() {
        LOGGER.info("Initialized");
    }

    /**
     *
     */
    @RequestMapping(value = "/command", method = RequestMethod.POST)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ResponseBody
    public HttpEntity<String> handleCommand(@RequestBody ItemCommand itemCommand) {
        LOGGER.info("handleCommand({})", itemCommand);

        int nr = itemCommand.getTail().size();
        LOGGER.info("{} items in tail", nr);

        String response = String.format("Command uploaded with %s items in tail", nr);
        return new ResponseEntity<>(response, OK);

    }

}
