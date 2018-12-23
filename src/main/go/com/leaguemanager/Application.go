package main

import (
	"fmt"
	"io"
	"net/http"
)

func hello(w http.ResponseWriter, r *http.Request) {
	var _, err = io.WriteString(w, "Hello world from go lang!")
	if err != nil {
		fmt.Printf("An error occured: %d", err)
	}
}

func main() {
	http.HandleFunc("/", hello)
	var err = http.ListenAndServe(":8000", nil)

	if err != nil {
		fmt.Printf("An error occurred while starting the server\nErr: %s", err)
	}
}
