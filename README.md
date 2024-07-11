
# Music Library

The Music Library project is designed to enhance users' musical experiences by providing a beautifully organized library of various artists. Each artist's albums are clearly described, and the songs within each album are meticulously listed.

The backend of this application is built using Java Spring Boot, while the database is managed with PostgreSQL. The frontend is developed using React, ensuring a seamless and interactive user experience.

## Backend (Spring Boot)
- Java 21
- Maven
- PostgreSQL for DB (I got Intelij Ultimate so I have acces to a DB directly in the editor, for a better management of the DB i used DBeaver)

### Installation
- Open a terminal and write:

git clone https://github.com/timisiulia/MusicLibrary.git

- Setup for the DB

createdb musiclibrary

- Update application.properties

- Build and run the project

- The application will be available at http://localhost:8080.

### Endpoints
- Here are the routes for the project
- For Album
  GET /api/albums - Get all albums
  POST /api/albums/{artistName} -  add an album by the artist name
  PUT /api/albums/{title}/{artistName} - Update an existing album
  DELETE /api/albums/{id} - Delete an album

- For Artist
  GET /api/artists - Get all artists
  GET /api/artists/{name} - Get an artist by name
  POST /api/artists - Create a new artist
  PUT /api/artists/{name} - Update an existing artist
  DELETE /api/artists/{name} - Delete an artist

- For songs
  GET /api/songs - Get all songs
  POST /api/songs/{albumName} - Create a new song
  PUT /api/songs/{name}/{albumName} - Update an existing song
  DELETE /api/songs/{name} - Delete a song

- For Library
  GET /api/libraries - Get all libraries
  POST /api/libraries  - Create a new library
  DELETE /api/libraries/{id} - Delete a library

- For search
  GET /api/search - Makes the global search

