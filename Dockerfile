FROM ubuntu:latest
LABEL authors="joaogabriel"

ENTRYPOINT ["top", "-b"]