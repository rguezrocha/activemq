# 2. Send and Consume Messages.
ActiveMQ Artemis is an asynchronous messaging system, let's see how it works.

Table of Contents:
1. [Using the artemis script](#1-using-the-artemis-script).
2. [Using Java and AMQP](#2-using-java-and-amqp).
3. [Routing types](#3-routing-types).

## 1. Using artemis script

1. Send one message:

```bash
brokers/broker-1/bin/artemis producer --user user --password user-password --destination myapp.exampleQueue --message "Hello World!" --message-count 1
```

Expected output:

```bash
Connection brokerURL = tcp://localhost:61616
Producer ActiveMQQueue[myapp.exampleQueue], thread=0 Started to calculate elapsed time ...

Producer ActiveMQQueue[myapp.exampleQueue], thread=0 Produced: 1 messages
Producer ActiveMQQueue[myapp.exampleQueue], thread=0 Elapsed time in second : 0 s
Producer ActiveMQQueue[myapp.exampleQueue], thread=0 Elapsed time in milli second : 32 milli seconds
```

2. Consume the message:

```bash
brokers/broker-1/bin/artemis consumer --user user --password user-password --destination myapp.exampleQueue --message-count 1 --verbose
```

Expected output:
```bash
...
Consumer ActiveMQQueue[myapp.exampleQueue], thread=0 Received Hello World!
Received text sized at 12
Consumer ActiveMQQueue[myapp.exampleQueue], thread=0 Consumed: 1 messages
...
```

## 2. Using Java and AMQP.

This section is covered in the following example: [ActiveMQ Artemis AMQP](https://github.com/franaerospace/activemq-artemis-amqp).

## 3. Routing types.

A routing type determines how messages are sent to the queues associated with an address.

Routing types:

- **anycast:** A single queue within the matching address, in a point-to-point manner.
- **multicast:** Every queue within the matching address, in a publish-subscribe manner.

## References.

References:

- [Routing Types](https://activemq.apache.org/components/artemis/documentation/latest/address-model.html#routing-types).


Send and consume messages (JMS, AMQP, Spring), web console, topics, virtual-topics.
