#!/bin/bash

CHANGED_FILES=$(git diff --name-only)

git add .

PROBLEM_NAME=$(echo "$CHANGED_FILES" | awk -F'/' '{ for (i=2; i<NF; i++) print $i }' | tr '\n' '.' | sed 's/\.$//')

COMMIT_MESSAGE="Solve: $PROBLEM_NAME"

git commit -m "$COMMIT_MESSAGE"

git push -u origin main
