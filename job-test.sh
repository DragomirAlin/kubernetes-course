#!/bin/bash

if [ $URL ]
then
  echo "Test Request to ${URL}"
  curl -X http://$URL
fi
