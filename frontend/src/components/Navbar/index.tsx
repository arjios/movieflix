import ButtonBar from "components/ButtonBar";
import { Link } from "react-router-dom";

import "./styles.css";

export default function Navbar() {
  return (
    <nav className="nav-content">
      <Link to="/" className="nav-title">
        Movieflix
      </Link>
      <label className="nav-label">
        <ButtonBar />
      </label>
    </nav>
  );
}
