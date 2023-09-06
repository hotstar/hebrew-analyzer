# Sefaria-ElasticSearch
various ElasticSearch analyzer plugins useful for analyzing ancient Hebrew

## How to install a plugin
This repo contains a few ElasticSearch plugins. Each folder in the root is another plugin.
To install:

First you need to locate the `bin` folder in your ES installation (henceforth `$ES_BIN`). This can be in one of two places:

1. If you installed ES as a service: `/usr/share/elasticsearch/bin`
2. If you downloaded the source: `$SRC_ROOT/bin`

docs reference: https://hotstar.atlassian.net/wiki/spaces/HP2/pages/3793190931/ElasticSearch+customized+plugins

plugins directory: 
1. Hebrew-ElasticSearch-ngrams-3-words/out/artifacts/elasticsearch-hebrew
2. Hebrew-ElasticSearch-semi-exact/out/artifacts/elasticsearch-hebrew