#! /bin/sh

STOCK_DIR="/Users/wgz/proj/stock"
cd $STOCK_DIR"/crawler"

execute()
{
    echo $@
    `$@`
}

execute scrapy crawl stock_bestgo
execute scrapy crawl stock_ifeng

