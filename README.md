# Hebrew-Analyzers
This is a project that provides language analyzer plugins for Hebrew on different search engines such as ElasticSearch/OpenSearch.

## How to Install a Plugin
This repository contains several plugins. Each folder in the root directory represents a separate plugin. To install a plugin:

For example, on ElasticSearch:

First, locate the bin folder in your ES installation (referred to as $ES_BIN hereafter). This folder can be found in one of two places:

If you installed ES as a service: `/usr/share/elasticsearch/bin`
If you downloaded the source: `$SRC_ROOT/bin` https://www.elastic.co/downloads/elasticsearch
Navigate to the plugins directory:

`Hebrew-ElasticSearch-ngrams-3-words/out/artifacts/elasticsearch-hebrew`
`Hebrew-ElasticSearch-semi-exact/out/artifacts/elasticsearch-hebrew`

## What is an OpenSearch/ElasticSearch Plugin?
OpenSearch/ElasticSearch plugins are a way to enhance the basic functionality of Elasticsearch in a customized manner. They can include custom mapping types, custom analyzers (in a more built-in fashion), custom script engines, custom discovery, and more.

## How to Write a Customized Plugin?
To write a customized plugin, you can follow these steps:

Download an official analysis plugin that matches your ES version. For example, if you want to upload a plugin to your ElasticSearch 8.5.3 version cluster, it is recommended to download a local package of version 8.5.3 and test it locally. You can download the package from this link: ElasticSearch Downloads

After downloading the ElasticSearch package, install it. Then, run the following command to check if it is installed successfully: `${YOUR_ES_DOWNLOAD_PATH}/bin/elasticsearch`

Examine an official plugin to understand its implementation. For example, the smartcn plugin https://www.elastic.co/guide/en/elasticsearch/plugins/8.6/analysis-smartcn.html is a language analysis plugin that has similar functionality to the Hebrew analyzer. Install this plugin using the command: `sudo ${YOUR_ES_DOWNLOAD_PATH}/bin/elasticsearch-plugin install analysis-smartcn`. You will find the plugin installed at `${YOUR_ES_DOWNLOAD_PATH}/plugins/analysis-smartcn`.

Under `${YOUR_ES_DOWNLOAD_PATH}/plugins/analysis-smartcn`, you will find a file named plugin-descriptor.properties. This file is a configuration file that defines the execution file. For detailed usage, you can refer to this example: `plugin-descriptor.properties`.

Write your own plugins and build them into a JAR file. This step will be customized based on your requirements.

Test the plugin locally and upload it to your ES cluster. Make sure you have the necessary permissions to upload plugins to the ES cluster.

Please note that the above instructions assume a basic understanding of ElasticSearch and plugin development.

## Examples:
| Text                        | Analyzer      | Tokens                                                          |
|-----------------------------|---------------|-----------------------------------------------------------------|
| הַכֹּחַ הַאֱמוּנָה יְכוֹל לְהַזְזִים הָרֵים | ngram-3-words | הכח$,הכח,האמונה$,האמ,אמנ,מנה,יכול$,כל,להזזים$,להז,הזז,הרים$,הרם |
| הַכֹּחַ הַאֱמוּנָה יְכוֹל לְהַזְזִים הָרֵים | semi-exact    | הכח$,הכח,האמונה$,האמונה,יכול$,יכול,להזזים$,להזזים,הרים$,הרים    |

## Reference:
https://github.com/Sefaria/Sefaria-ElasticSearch
https://www.elastic.co/guide/en/elasticsearch/plugins/current/plugin-authors.html