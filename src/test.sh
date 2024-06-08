#!/bin/zsh

# UTF-8 인코딩 설정
export LANG=ko_KR.UTF-8
export LC_ALL=ko_KR.UTF-8

CHANGED_FILES=$(git diff --name-only)

git add .

# 문제 이름 추출 (폴더 구조에 따라 조정 필요)
PROBLEM_NAME=$(echo "$CHANGED_FILES" | awk -F'/' '{ for (i=2; i<NF; i++) print $i }' | tr '\n' '.' | sed 's/\.$//')

# 커밋 메시지 생성
COMMIT_MESSAGE="Solve: $PROBLEM_NAME"

# Git 환경 설정을 통해 UTF-8 인코딩 사용
git config --global i18n.commitEncoding utf-8
git config --global core.quotepath false

# 커밋 및 푸시
git commit -m "$COMMIT_MESSAGE"
git push -u origin main
