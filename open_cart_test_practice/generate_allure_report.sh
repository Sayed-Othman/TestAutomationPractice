#!/bin/bash
parent_path=$( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )
cd "/Users/yasserali1/.m2/repository/allure/allure-2.13.9/bin/"
bash allure serve "$parent_path/allure-results"
exit