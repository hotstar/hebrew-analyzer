# Hebrew-Analyzers
This is a project that provides language analyzer plugins for Hebrew on search engine OpenSearch.

## How to Install a Plugin


## What is an OpenSearch/ElasticSearch Plugin?
OpenSearch/ElasticSearch plugins are a way to enhance the basic functionality of Elasticsearch in a customized manner. They can include custom mapping types, custom analyzers (in a more built-in fashion), custom script engines, custom discovery, and more.


## Examples:
| Text                        | Analyzer      | Tokens                                                          |
|-----------------------------|---------------|-----------------------------------------------------------------|
| הַכֹּחַ הַאֱמוּנָה יְכוֹל לְהַזְזִים הָרֵים | ngram-3-words | הכח$,הכח,האמונה$,האמ,אמנ,מנה,יכול$,כל,להזזים$,להז,הזז,הרים$,הרם |
| הַכֹּחַ הַאֱמוּנָה יְכוֹל לְהַזְזִים הָרֵים | semi-exact    | הכח$,הכח,האמונה$,האמונה,יכול$,יכול,להזזים$,להזזים,הרים$,הרים    |
## API Examples

```
GET /_analyze
{
  "analyzer": "hebrew-ngram-3-analyzer",
  "text": "אנחנו חברים טובים מאד"
}

GET /_analyze
{
  "analyzer": "hebrew_semi_exact_analyzer",
  "text": "אנחנו חברים טובים מאד"
}

PUT my-hebrew-index
{
  "settings": {},
  "mappings": {
    "properties": {
      "text": {
        "type": "text",
        "analyzer": "hebrew-ngram-3-analyzer"
      }
    }
  }
}


```
