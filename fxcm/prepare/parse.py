# coding=utf-8

import struct
import time
import os, sys


def parse_hst_csv(src_path, des_path, time_from=None, time_to=None):
  content = open(src_path, 'rb').read()

  # 读取头文件结构信息

  # 基础版本
  print "basic verison: %i" % struct.unpack("i", content[0:4])[0]

  # 版本信息
  print "versoin: %s" % "".join(struct.unpack("64c", content[4:68]))

  # 货币对名称
  print "detail: %s" % "".join(struct.unpack("12c", content[68:80]))

  # 周期 (单位分钟)
  print "period: %i min" % struct.unpack("i", content[80:84])[0]

  # 小数点位数
  # print struct.unpack("i", content[84:88])

  # 基准报时
  # print struct.unpack("i", content[88:92])

  # 同步时间
  # print struct.unpack("i", content[92:96])

  # 将来应用
  # print struct.unpack("13i", content[96:148])

  # 循环结构
  content_len = len(content)

  time_f = None if time_from is None else time.strptime(time_from, "%Y-%m-%d %H:%M")
  time_t = None if time_to is None else time.strptime(time_to, "%Y-%m-%d %H:%M")

  with open(des_path, "w") as des_file:
    des_file.write("time,open,high,low,close,vol\n")
    for tip in range(148, content_len, 60):
      time_d = time.gmtime(struct.unpack("i", content[tip:tip + 4])[0])
      # time_raw = time.strptime(time_d, "%a %b %d %H:%M:%S %Y")

      if time_f is not None and time_f >= time_d:
        continue

      if time_to is not None and time_t < time_d:
        continue

      beg = struct.unpack("d", content[tip + 8:tip + 16])[0]
      high = struct.unpack("d", content[tip + 16:tip + 24])[0]
      low = struct.unpack("d", content[tip + 24:tip + 32])[0]
      close = struct.unpack("d", content[tip + 32:tip + 40])[0]
      vol = struct.unpack("i", content[tip + 40:tip + 44])[0]

      des_file.write("%s,%f,%f,%f,%f,%d\n" % (time.strftime("%Y-%m-%d %H:%M:%S", time_d), beg, high, low, close, vol))

      # print time.strftime("%Y-%m-%d-%H:%M", time_r), beg, high, low, close, vol


def process_data_dir(src_dir, des_dir, time_from=None, time_to=None):
  for filename in os.listdir(src_dir):
    if os.path.isfile(os.path.join(src_dir, filename)) and filename.endswith(".hst"):
      src_file_path = os.path.join(src_dir, filename)
      des_file_path = os.path.join(des_dir, filename.replace('.hst', '.csv'))
      parse_hst_csv(src_file_path, des_file_path, time_from, time_to)
