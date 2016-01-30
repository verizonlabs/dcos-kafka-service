#!/bin/sh

DIST_PATH="$(dirname $0)"

# AWS settings:
AWS_REGION="us-west-2"
S3_BUCKET="infinity-artifacts"
DATE=$(date +"%Y%m%d")
UUID=$(cat /dev/urandom | tr -dc 'a-zA-Z0-9' | fold -w 16 | head -n 1)
S3_PATH="autodelete7d/kafka/${DATE}-${UUID}"
S3_PATH_URL="https://s3-${AWS_REGION}.amazonaws.com/${S3_BUCKET}/${S3_PATH}"

upload_to_aws() {
CMD="aws s3 \
--region=${AWS_REGION} \
cp \
--acl public-read \
$1 \
s3://${S3_BUCKET}/${S3_PATH}/$(basename $1)"
echo "AWS: ${CMD}"
${CMD}
}

# Generate container hook and stub universe

echo "Using S3 path: ${S3_PATH_URL}"

sh ${DIST_PATH}/build-container-hook.sh
sh ${DIST_PATH}/build-stub-universe.sh ${S3_PATH_URL}

# Upload jar, container hook package, and stub universe

JAR_PATH=$(ls ${DIST_PATH}/../kafka-scheduler/build/libs/kafka-scheduler-*-uber.jar)
if [ "${JAR_PATH}" = "" ]; then
    echo "Scheduler jar not found. Contents of kafka-scheduler/build/:"
    find ${DIST_PATH}/../kafka-scheduler/build
    exit 1
fi

upload_to_aws $JAR_PATH
if [ $? -ne 0 ]; then
    echo "Failed to upload scheduler jar. Contents of kafka-scheduler/build/:"
    find ${DIST_PATH}/../kafka-scheduler/build
    exit 1
fi

upload_to_aws $(ls ${DIST_PATH}/build/container-hook-*.tgz)
if [ $? -ne 0 ]; then
    echo "Failed to upload container hook. Contents of dist/:"
    find ${DIST_PATH}
    exit 1
fi

upload_to_aws ${DIST_PATH}/build/stub-universe.zip
if [ $? -ne 0 ]; then
    echo "Failed to upload stub universe. Contents of dist/:"
    find ${DIST_PATH}
    exit 1
fi
