FROM ubuntu:latest
LABEL authors="supam"

ENTRYPOINT ["top", "-b"]