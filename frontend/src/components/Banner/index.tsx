import "./styles.css";
import Desenho from "../assets/Desenho.png";


export default function Banner() {
  return (
    <>
      <div className="banner-container">
        <div className="banner-title">MovieFlix</div>
        <div className="banner-subtitle">
          <p>
            Diga o que voce achou do seu <br /> filme favorito
          </p>
        </div>
        <div className="banner-picture">
          <img src={Desenho} alt="Desenho" />
        </div>
      </div>
    </>
  );
}
