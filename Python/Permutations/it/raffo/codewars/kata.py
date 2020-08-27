'''
Created on 27 ago 2020

@author: raffa
'''

import itertools as it

def permutations(string):
    return [''.join(strn) for strn in
            list(set(it.permutations(string, len(string))))]
    

print(permutations('ab'))