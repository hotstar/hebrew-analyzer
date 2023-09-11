# Hebrew-Analyzers
language analyzer plugins for Hebrew on different search engines such as ElasticSearch/OpenSearch.  

## How to install a plugin
This repo contains a few plugins. Each folder in the root is one separate plugin.
To install:
For example on ElasticSearch:
First you need to locate the `bin` folder in your ES installation (henceforth `$ES_BIN`). This can be in one of two places:

1. If you installed ES as a service: `/usr/share/elasticsearch/bin`
2. If you downloaded the source: `$SRC_ROOT/bin`

plugins directory: 
1. Hebrew-ElasticSearch-ngrams-3-words/out/artifacts/elasticsearch-hebrew
2. Hebrew-ElasticSearch-semi-exact/out/artifacts/elasticsearch-hebrew

Reference doc: Third-party language analyzers:https://logz.io/blog/language-analyzers-tokenizers-not-built-elasticsearch-where-find-them/

## What is OpenSearch/ElasticSearch plugin?

OpenSearch/ElasticSearch Plugins are a way to enhance the basic Elasticsearch functionality in a custom manner. They range from adding custom mapping types, custom analyzers (in a more built in fashion), custom script engines, custom discovery and more.

## How to write a customized plugin?

Basically, I took the following docs for reference.

https://www.elastic.co/guide/en/elasticsearch/plugins/current/plugin-authors.html

https://github.com/Sefaria/Sefaria-ElasticSearch

I took the following steps:

1. Download an official analysis plugin using the same es version. That’s to say, if you want to upload a plugin to your 8.5.3 version ElasticSearch cluster, I would suggest downloading a local 8.5.3 package and test locally. Download link: https://www.elastic.co/downloads/elasticsearch

2. After downloading the ElasticSearch pkg, install it. And run the following command to check: ```${YOUR_ES_DOWNLOAD_PATH}/bin/elasitcsearch```
 And if installed successfully, you can see es service working.

3. Check an official plugin to see the implementation. For example, smartcn https://www.elastic.co/guide/en/elasticsearch/plugins/8.6/analysis-smartcn.html is a language analysis plugin having similar function with Hebrew analyzer. So install this plugin using command: ```sudo ${YOUR_ES_DOWNLOAD_PATH}/bin/elasticsearch-plugin install analysis-smartcn``` And you can see ```${YOUR_ES_DOWNLOAD_PATH}/plugins/analysis-smartcn```.

4. We can see that under ${YOUR_ES_DOWNLOAD_PATH}/plugins/analysis-smartcn, there is a file named as plugin-descriptor.properties, which is a configuration file to defined executing file. For detailed usage, pls take https://github.com/hotstar/search-side-projects/blob/main/hebrew-analyzer/Sefaria-ElasticSearch-aggresive-ngrams/plugin-descriptor.properties  for reference.

5. Write your plugins and build to jar file. This step would be customized.

6. Test locally and upload to es cluster. I have enabled all access to upload plugins to es cluster.