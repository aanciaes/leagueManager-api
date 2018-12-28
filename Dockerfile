FROM golang:1.11.4

ENV GOPATH /go

ENV PROJECT_NAME leagueManager-api
ENV PROJECT github.com/aanciaes/$PROJECT_NAME
ENV LM_API_ENV staging

COPY . /go/src/$PROJECT

WORKDIR /go/src/$PROJECT

RUN chmod +x setup.sh

EXPOSE 8000

CMD ./setup.sh \
    && go install /go/src/$PROJECT \
    && $GOPATH/bin/$PROJECT_NAME