package main

import (
	"./config/database"
	"./users"
	"github.com/gorilla/mux"
	"log"
	"net/http"
)

func setHandlers (r *mux.Router) {
	r.HandleFunc("/", users.Hello)
}

func main() {
	r := mux.NewRouter()
	setHandlers(r)

	_, err := database.ConfigDatabase()

	if err == nil {
		log.Println("Starting server, listening at port 8000")
		log.Fatal(http.ListenAndServe(":8000", r))
	} else {
		log.Fatal(err)
	}
}