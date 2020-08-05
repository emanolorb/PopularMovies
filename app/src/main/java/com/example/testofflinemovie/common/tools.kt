package com.example.testofflinemovie.common

import com.example.testofflinemovie.models.MovieModel

object tools {
    fun debug_print(string: String, title : String = ""){
        println(title.plus(" <----------------------------\n"))
        println(string)
        print("------------------------------------------->\n")
    }
    fun createTestMovieList():List<MovieModel>{
        var lista = listOf<MovieModel>(
        MovieModel(
            id=583083,
            poster_path="/8kjPY71yrktwRJ7NVl6Ttb6tl5V.jpg",
            adult=false,
            overview="Elle, que debe tomar decisiones sobre la universidad, afronta su relación a distancia con Noah, su cambiada amistad con Lee y lo que siente por un compañero de clase.",
            release_date="2020-07-24",
            genre_ids= listOf(1, 10749),
            original_title="The Kissing Booth 2",
            original_language="en",
            title="Mi primer beso 2",
            backdrop_path="/wO5QSWZPBT71gMLvrRex0bVc0V9.jpg",
            popularity=303.903,
            vote_count=2357,
            video=false,
            vote_average=8.3),
        MovieModel(id=516486,
            poster_path="/qHmGs4uAIOdPgseCgOH0eEsmTKD.jpg",
            adult=false,
            overview="Durante los primeros días de la participación de Estados Unidos en la Segunda Guerra Mundial, un convoy internacional de 37 barcos aliados, encabezado por el comandante Ernest Krause, cruza el Atlántico Norte mientras es perseguido por submarinos alemanes.",
            release_date="2020-07-10", genre_ids=listOf(1, 10749), original_title="Greyhound", original_language="en", title="Greyhound: Enemigos bajo el mar",
            backdrop_path="/xXBnM6uSTk6qqCf0SRZKXcga9Ba.jpg",
            popularity=183.9,
            vote_count=668,
            video=false,
            vote_average=7.6)
        )
        return lista
    }


}