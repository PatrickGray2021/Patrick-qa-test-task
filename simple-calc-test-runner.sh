#!/bin/bash

run_tests() {
    test_type=$1
    destination=$2

    gradle_cmd="./gradlew"

    case "$test_type" in
        unit)
            task="runTestNG"
            report="build/reports/tests/runTestNG/index.html" ;;
        BDD)
            task="runCucumber"
            report="build/reports/tests/runCucumber/index.html" ;;
        *)
            echo "Invalid test type provided: $test_type"
            exit 1 ;;
    esac

    $gradle_cmd "$task"

    if [ ! -d "$destination" ]; then
        mkdir -p "$destination"
    fi
    cp -f "$report" "$destination"


    if [ ! -d logs ]; then
        mkdir -p logs
    fi
    
    $gradle_cmd test > logs/stdout.log 2> logs/stderr.log
}

if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <test_type> <destination>"
    exit 1
fi

run_tests "$1" "$2"