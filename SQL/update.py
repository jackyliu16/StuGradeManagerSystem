#!/usr/bin/python
# -*- encoding: utf-8 -*-
'''
@File    :   update.py
@Time    :   2022/11/18 13:59:24
@Author  :   jackyliu
@Version :   1.0
@Contact :   18922251299@163.com
@github  :   https://github.com/jackyliu16
'''
import logging
import csv
from logging.handlers import RotatingFileHandler

def log_config(level=logging.INFO):
  LOG_FORMAT = '[%(asctime)s][%(levelname)s]: %(message)s'
  logging.basicConfig(level=level, format=LOG_FORMAT)
  #创建RotatingFileHandler对象,满2MB为一个文件，共备份3个文件
  log_file_handler = RotatingFileHandler(filename='test.log', maxBytes=2*1024*1024, backupCount=3)
  # 设置日志打印格式
  formatter = logging.Formatter(LOG_FORMAT)
  log_file_handler.setFormatter(formatter)
  logging.getLogger('').addHandler(log_file_handler)

def main(file, level):
    log_config(level)

def read_head(file) -> List[str]:
    

    

if __name__ == '__main__':
    main(level=logging.DEBUG)

