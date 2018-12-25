package database

import (
	"errors"
	"github.com/boltdb/bolt"
	"log"
	"os"
)

const DEV = "dev"

type Database struct {
	connection interface{}
}

func ConfigDatabase () (Database, error) {
	env := os.Getenv("LM_API_ENV")
	if env == "" {
		return configDevDatabase()
	}

	return Database{}, errors.New("error")
}

func configDevDatabase () (Database, error) {
	log.Printf("Starting configuration for %s environment", DEV)
	conn := Database{}

	db, err := bolt.Open("league_manager.db", 0600, nil)
	if err != nil {
		log.Fatal(err)
		return Database{}, errors.New("database connection failed")
	} else {
		conn.connection = db
		return conn, nil
	}
}