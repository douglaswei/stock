import sys

from stockit.Common import get_current_info


__author__ = 'wgz'

if __name__ == '__main__':
    while True:
        line = sys.stdin.readline()
        if not line or len(line) == 0:
            break
        code = line[:-1]
        try:
            res = get_current_info(line[:-1])
            print code, '\t', '\t'.join(res)
        except Exception, e:
            pass