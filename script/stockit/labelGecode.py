#! /usr/bin/python
# coding:utf-8

import sys
import os
import gc
import pickle
import numpy as np
import sklearn as sk
import common

def gecodeLabel01(label):
    if isinstance(label, str):
        label = float(label)
    if label > 0:
        return 1
    return -1

def gecodeLabelN(label):
