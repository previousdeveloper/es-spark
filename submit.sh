#!/bin/bash
spark-submit \
  --class "EsExample" \
  --master local[*] \
  --packages org.elasticsearch:elasticsearch-spark_2.10:2.3.2 \
  target/scala-2.10/es-example_2.10-1.0.jar
