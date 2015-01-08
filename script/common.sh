#! /bin/sh

execute()
{
    date
    echo $@
    `$@`
}

DATE=`date +%Y%m%d_%H%M`
DATA_DIR='data'

