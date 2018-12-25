package users

import (
	"fmt"
	"io"
	"net/http"
)

func Hello(w http.ResponseWriter, r *http.Request) {
	var _, err = io.WriteString(w, "Hello world from go lang!")
	if err != nil {
		fmt.Printf("An error occured: %d", err)
	}
}
