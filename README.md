## Reactive web application / JMS example

Proof of concept for a webapplication where POSTed JSON payloads are converted to a RX `Observable`
to which handler services can subscribe.

Upload example payload `threeitems.json` using HTTPie as follows: `http POST localhost:8080/command < threeitems.json`