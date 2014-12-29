#! /usr/bin/python
# -*- coding: UTF-8 -*-

import sys
import os
import numpy as np  
  
import matplotlib
matplotlib.use('Agg')
import matplotlib.pyplot as plt


def drawLines(line_names, line_values, pic_fielanme):
    fig = plt.figure(pic_fielanme)
    colors = "rbgcmky"
    styles = ["-", "--", "-."]
    ax = plt.axes([0.05, 0.05, 0.7, 0.9])
    line_styles = [ color+style for style in styles for color in colors]
    x = range(line_values.shape[1])
    for name, items, line_style in zip(line_names, line_values, line_styles):
        ax.plot(x, items, line_style, label=name)
    plt.legend(loc='best',bbox_to_anchor=(1.02, 1), fontsize='x-small')
    plt.savefig(pic_fielanme)
    plt.close(fig)


if __name__ == "__main__":
    names=[str(idx) for idx in range(10)]
    x=np.linspace(0,4,100)
    y=np.asarray([
    np.abs(x),
    np.cos(x),
    np.sin(x),
    np.abs(x) / 2,
    np.cos(x) / 2,
    np.sin(x) / 2,
    np.abs(x) / 3,
    np.cos(x) / 3,
    np.sin(x) / 3,
    np.sin(x) / 4,
    ])

    drawLines(names, y, "test.jpg")

