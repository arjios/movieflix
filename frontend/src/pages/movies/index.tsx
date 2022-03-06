import "./styles.css";
import Desenho from "../../components/assets/Desenho.png";

export default function Movies() {

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
          <p className="movie-title">Retorno do Rei</p>
          <p className="movie-year">2018</p>
          <p className="movie-subtitle">O olho do inimigo esta se <br /> movendo</p>
        </div>
      </div>
    </div>
  );

}
