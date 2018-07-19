#!/usr/bin/env bash

rm -rf ../target/universal/hawkthorne/*
unzip ../target/universal/hawkthorne-1.0.0.zip -d ../target/universal/hawkthorne

rsync -zrv --delete ../target/universal/hawkthorne/* kyle@hawkthorne.net:~/apps/hawkthorne.net
