package src

import (
	"./config/database/database"
	"./users"
	"github.com/gorilla/mux"
	"log"
	"net/http"
)

func setHandlers (r *mux.Router) {
	r.Handle("/", handlerGenericWrapper(users.Hello))
}

func handlerGenericWrapper (h http.HandlerFunc) http.Handler {
	return http.HandlerFunc( func (w http.ResponseWriter, r *http.Request) {
		log.Println("Before")
		h.ServeHTTP(w, r)
		defer log.Println("After")
	})
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