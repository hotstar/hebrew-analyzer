# Hebrew-Analyzers
This is a project that provides language analyzer plugins for Hebrew on search engine OpenSearch.

## What is an OpenSearch/ElasticSearch Plugin?
OpenSearch/ElasticSearch plugins are a way to enhance the basic functionality of Elasticsearch in a customized manner. They can include custom mapping types, custom analyzers (in a more built-in fashion), custom script engines, custom discovery, and more.

## Examples:
| Text                        | Analyzer      | Tokens                                                          |
|-----------------------------|---------------|-----------------------------------------------------------------|
| הַכֹּחַ הַאֱמוּנָה יְכוֹל לְהַזְזִים הָרֵים | ngram-3-words | הכח$,הכח,האמונה$,האמ,אמנ,מנה,יכול$,כל,להזזים$,להז,הזז,הרים$,הרם |
| הַכֹּחַ הַאֱמוּנָה יְכוֹל לְהַזְזִים הָרֵים | semi-exact    | הכח$,הכח,האמונה$,האמונה,יכול$,יכול,להזזים$,להזזים,הרים$,הרים    |

Ton run via api call:

```shell
curl 'http://localhost:9200/_analyze' \
-H 'Content-Type: application/json' \
-d '{
  "analyzer": "hebrew-ngram-3-analyzer",
  "text": "הכוח האמונה יכול להזיז הרים"
}'

curl 'http://localhost:9200/_analyze' \
-H 'Content-Type: application/json' \
-d '{
  "analyzer": "hebrew_semi_exact_analyzer",
  "text": "הכוח האמונה יכול להזיז הרים"
}'
```

## How to Install the Plugin

Build the plugin, directly from the source, you will get the zip artifact at `build/distributions/opensearch-hebrew-analyzers-<version>.zip`

```shell
cd opensearch-hebrew-analyzers
./gradlew --no-daemon clean assemble -x test
```

Or using docker:

```shell
docker build -t opensearch-hebrew-analyzers .
docker create --name opensearch-hebrew-analyzers opensearch-hebrew-analyzers
docker cp opensearch-hebrew-analyzers:/src/build/distributions/opensearch-analysis-hebrew-<version>.zip .
```

Install the plugin via OpenSearch CLI:

```shell
./opensearch-plugin install file:///path/to/opensearch-hebrew-analyzers-<version>.zip
```
