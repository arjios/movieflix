import Navbar from "components/Navbar";
import Home from "pages/home";
import Movies from "pages/movies";
import { BrowserRouter, Route, Routes } from "react-router-dom";

export default function Routers() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
      </Routes>
      <Routes>
        <Route path="/movies" element={<Movies />} />
      </Routes>
    </BrowserRouter>
  );
}
