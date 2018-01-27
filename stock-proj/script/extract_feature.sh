#!/bin/bash

cd `dirname $0`
cd ..
cd featextract*

/bin/rm -rf runDir && sh bin/start.sh > /dev/null 2>&1