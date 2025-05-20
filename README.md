# Minimal Reproduction: KurrentDB + Quarkus Bug

This repository demonstrates an issue when using the Java KurrentDB (EventStoreDB) gRPC client within a Quarkus application.

## Steps to Reproduce

1. Start KurrentDB via Docker Compose:
2. Start the Quarkus application:
3. Trigger the endpoint:


## Expected

- Event should be written to KurrentDB stream

## Actual

- Call hangs indefinitely or times out, event is not written

---

**KurrentDB Version:** [see `docker-compose.yml`]  
**Quarkus Version:** [see `pom.xml`]  
**KurrentDB Java Client:** [see `pom.xml`]

## Minimal Source

See `src/main/java/org/example/`


