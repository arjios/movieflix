import { Link } from "react-router-dom";

import "./styles.css";

export default function Navbar() {
  return (
    <nav className="nav-content">

      <Link to="/" className="nav-title">Movieflix</Link>
    </nav>
  );
}
