FROM ubuntu:latest
LABEL authors="erika"

ENTRYPOINT ["top", "-b"]