# ActiveMQ Artemis AMQP

ActiveMQ Artemis AMQP Java client.

## 1. Introduction.

This repository is based on the following example: [queue](https://github.com/apache/activemq-artemis/tree/master/examples/protocols/amqp/queue).

The following modifications have been made to the code:

- The pom.xml file, and the parent pom.xml file have been replaced with a single pom.xml file.
- Maven default repository has been replaced with Maven Red Hat GA repository.
- Package name has been replaced with example directory.
- Appassembler Maven Plugin has been added.
- User and password authentication has been added.
- AMQPS SSL support has been added.

## 2. AMQP example.

1. Compile the code:

```bash
mvn clean package appassembler:assemble
```

2. Run the example:

```bash
target/appassembler/bin/app
```

Expected output:

```bash
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
message = Hello World!
```

## 3. AMQPS example.

1. Modify ConnectionFactory destination:

```bash
vim src/main/java/example/AMQPQueueExample.java
```

BEFORE:

```java
public class AMQPQueueExample {

   public static void main(String[] args) throws Exception {
      Connection connection = null;
      ConnectionFactory connectionFactory = new JmsConnectionFactory("amqp://localhost:5672");
      // Comment the above line and uncomment the below line for AMQPS SSL connection
      // ConnectionFactory connectionFactory = new JmsConnectionFactory("amqps://localhost:5673?transport.trustAll=true");
```

AFTER:

```java
public class AMQPQueueExample {

   public static void main(String[] args) throws Exception {
      Connection connection = null;
      // ConnectionFactory connectionFactory = new JmsConnectionFactory("amqp://localhost:5672");
      // Comment the above line and uncomment the below line for AMQPS SSL connection
      ConnectionFactory connectionFactory = new JmsConnectionFactory("amqps://localhost:5673?transport.trustAll=true");
```

2. Compile the code:

```bash
mvn clean package appassembler:assemble
```

3. Run the example:

```bash
target/appassembler/bin/app
```

Expected output:

```bash
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
message = Hello World!
```

## 4. Future improvements.

1. The following modifications can be made to the code:

- Externalize configuration to a jndi.properties file.
- Encrypt passwords.

## References.

References:
- [Appassembler Maven Plugin](https://github.com/mojohaus/appassembler).
- [Client configuration](https://qpid.apache.org/releases/qpid-jms-0.24.0/docs/index.html)
