#!/usr/bin/env bash

COMMIT_MSG_FILE=$1

branch_name=`git rev-parse --abbrev-ref HEAD`
issue_number=`echo ${branch_name} | cut -d '-' -f2` # ex) feature/DL-3-apply-react-router
first_line=`head -n1 ${COMMIT_MSG_FILE}`

if [ -z "$first_line" ]; then
  sed -i ".bak" -e "1s/^/type some message (#$issue_number) /" -e "1G" ${COMMIT_MSG_FILE}
fi
