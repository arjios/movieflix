import Navbar from "components/Navbar";
import Home from "pages/home";
import { BrowserRouter, Route, Routes } from "react-router-dom";

export default function Routers() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
      </Routes>
    </BrowserRouter>
  );
}
