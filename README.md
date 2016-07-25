# Simple Elasticsearch Spark Example

# Vagrant

Create development environment (requires Vagrant and VirtualBox) and login:

```
vagrant up && vagrant ssh
```

# Build

Use Scala Build Tool:

```
sbt package
```

This builds a jar in the target directory.

# Elasticsearch

Start elasticsearch docker container:

```
docker-compose up -d
```

# Run

Use spark-shell to to run the example:

```
spark-shell \
  --class "EsExample" \
  --master local[*] \
  --packages org.elasticsearch:elasticsearch-spark_2.10:2.3.2 \
  --jars target/scala-2.10/es-example_2.10-1.0.jar
```

This will send a map to elasticsearch from spark.

To see the results open elasticsearch-head: http://localhost:9200/_plugin/head