#!/bin/bash

cd `dirname $0`
cd ..
cd com.douglas.stock.crawler*

/bin/rm -rf runDir && sh bin/start.sh spiders-daily.xml > /dev/null 2>&1