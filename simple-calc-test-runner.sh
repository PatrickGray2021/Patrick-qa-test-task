#!/bin/bash

run_tests() {
    test_type=""
    destination=""

    while [[ $# -gt 0 ]]; do
        key="$1"
        case $key in
            --test-type)
                test_type="$2"
                shift
                shift
                ;;
            --report-dir)
                destination="$2"
                shift
                shift
                ;;
            *)
                echo "Unknown option: $1"
                shift
                ;;
        esac
    done

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

run_tests "$@"