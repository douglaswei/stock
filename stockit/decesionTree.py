#! /usr/bin/python
# coding:utf-8

import sys
import os
import gc
import pickle
import numpy as np
import sklearn as sk
from sklearn.cluster import KMeans
import common


######################################################

class DecesionTree(object):
    def __init__(self, config = common.config()):
