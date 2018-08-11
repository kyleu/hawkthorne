#!/usr/bin/env bash

rsync -zrv --delete ../target/universal/stage/* kyle@hawkthorne.net:~/apps/hawkthorne.net
