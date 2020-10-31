# ActiveMQ Artemis Workshop
Introduction to ActiveMQ Artemis.

## 1. Download ActiveMQ Artemis.

Create an activemq-artemis-workshop directory:
```bash
mkdir activemq-artemis-workshop && cd activemq-artemis-workshop
```

Download latest ActiveMQ Artemis:
```bash
wget http://apache.uvigo.es/activemq/activemq-artemis/2.12.0/apache-artemis-2.12.0-bin.zip
```

Unzip ActiveMQ Artemis:
```bash
unzip apache-artemis-2.12.0-bin.zip
```

Create a symbolic link:
```bash
ln -s apache-artemis-2.12.0 artemis
```

## 2. Hands-on.
Table of Contents:
1. [Create a Broker](2-hands-on/1-create-a-broker.md).
2. [Send and Consume Messages](2-hands-on/2-send-and-consume-messages.md).

Broker.xml Parameters: https://activemq.apache.org/components/artemis/documentation/latest/configuration-index.html

## 3. Cluster Setup.
Table of Contents:
1. Replication.
2. Shared Store.

Shared Store: https://activemq.apache.org/components/artemis/documentation/latest/ha.html#shared-store

## References.

References:
- [Product Documentation for Red Hat AMQ](https://access.redhat.com/documentation/en-us/red_hat_amq)
