import sys

for line in sys.stdin.readlines():
    fields = line[:-1].split('\t')
    for field in fields:
        k,v = field.split(":")[:2]
        if k == 'records':
            for item in v.split('|'):
                item = filter(lambda sin: sin in '0123456789.-', item)
                try:
                    print float(item)
                except Exception,e:
                    print str(e)
                    print line
                    sys.exit(-1)
