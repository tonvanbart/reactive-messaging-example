## Reactive web application example

Proof of concept for a webapplication where POSTed JSON payloads are converted to a RX `Observable`
to which handler services can subscribe.

To run use Gradle: `gradle clean bootRun` in the root of the project; the application will start on port 8080.

To upload example payload `threeitems.json` using HTTPie: `http POST localhost:8080/command < threeitems.json`, the
example observer should log the command it just saw.

The `SlowObserver` class demonstrates observing on a different thread; when a command package is uploaded, the POST
 will return immediately, even though the SlowObserver takes a few seconds to complete its processing.