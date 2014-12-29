#! /bin/sh

LOGFILE="log"
LOGFILE_WF="log.wf"

execute()
{
    date
    echo $@
    `$@`
}
