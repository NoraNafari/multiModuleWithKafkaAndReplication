## Multi-Module With Kafka And Database Replication

This is a sample multi-module maven project.

Kafka is used for communication between modules. The Dockerfile for creating a local Kafka cluster is located
in the root of the repository.

Serialized messages use Protobuf for schema serialization and deserialization.

The maven plugin for compiling protobuf messages (protoc-jar-maven-plugin) is used.

The database for storing data is Postgres. There is also one Dockerfile in the root of the project to run a Postgres instance.

There are two .sql files in the root of the modules to create related tables and schemas.
