#!/bin/bash

if [ $1 ]; then
  if [ -d $1 ]; then 
    echo "There are $(find $1 -type f | wc -l) files in $(pwd)/$1" 
  else
    echo "Directory not found"
  fi
else
  echo "Nothing to find"
fi