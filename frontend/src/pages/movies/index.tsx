import "./styles.css";
import Desenho from "../../components/assets/Desenho.png";
import { useEffect, useState } from "react";
import { makeRequest } from "utils/request";
import { MovieResponse } from "types/Movie";
import { Link } from "react-router-dom";

export default function Movies() {

  const [movieResponse, setMovieResponse] = useState<MovieResponse>();

  useEffect(() => {
    const params = {
      page: 0,
      size: 12
    }
    makeRequest({ url: '/movies', params })
    .then((response) => setMovieResponse(response.data))
  }, []);

  return (
    <div className="movie-container">
      <nav className="base-card movie-searchbar">
        <div className="movie-box">
          <h1>Select</h1>
        </div>
      </nav>
      <div className="base-card movie-card">
        <div>
          <img className="movie-img" src={Desenho} alt="Desenho" />
        </div>
        <div className="movie-info">
          {movieResponse?.content.map(movie => (
            <Link to="movies" key={movie.id}>
              <Movies />
            </Link>
          ))}
          <p className="movie-title">Retorno do Rei</p>
          <p className="movie-year">2018</p>
          <p className="movie-subtitle">O olho do inimigo esta se <br /> movendo</p>
        </div>
      </div>
    </div>
  );
}
